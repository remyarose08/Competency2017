package com.shiftservices.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.shiftservices.datatype.Grade;
import com.shiftservices.datatype.ShiftType;
import com.shiftservices.datatype.TechnologyType;
import com.shiftservices.datatype.TimePeriod;
import com.shiftservices.dto.Comp2017DTO;
import com.shiftservices.dto.ShiftEntryDTO;
import com.shiftservices.entity.Comp2017;
import com.shiftservices.locator.ApplicationContextUtils;
import com.shiftservices.repository.EmployeeShiftRepository;
import com.shiftservices.service.ShiftDataService;
import com.shiftservices.translator.ShiftEntryDTOEntityTranslator;
import com.shiftservices.util.ShiftDataExcelWriter;
import com.shiftservices.util.SysLogger;

public class ShiftDataServiceImpl implements ShiftDataService {

	public String fetchAllShiftTypes() {

		String enumAsString = null;

		try {
			enumAsString = new ObjectMapper().writeValueAsString(ShiftType
					.values());
			SysLogger.logMethod("fetchAllShiftTypes", enumAsString);
		} catch (JsonGenerationException e) {
			SysLogger.logException("fetchAllShiftTypes", e);
			e.printStackTrace();
		} catch (JsonMappingException e) {
			SysLogger.logException("fetchAllShiftTypes", e);
			e.printStackTrace();
		} catch (IOException e) {
			SysLogger.logException("fetchAllShiftTypes", e);
			e.printStackTrace();
		}

		return enumAsString;
	}

	public Grade[] fetchAllGrade() {
		return Grade.values();
	}
	
	 public TechnologyType[] fetchAllTechnologyType() {
	        return TechnologyType.values();
	    }

	public TimePeriod[] fetchAllTimePeriods() {
		return TimePeriod.values();
	}

	public boolean submitShiftData(ShiftEntryDTO shiftEntryDto) {
		try {
			
			if (getRepository().validateExistingShiftDataForEmployee(shiftEntryDto.getEmployeeId(),shiftEntryDto.getTimePeriod())) {
				getRepository().insertEmployeeShiftData(ShiftEntryDTOEntityTranslator.translateDTO2Entity(shiftEntryDto));
			} else {
				SysLogger.logMethod("submitShiftData", "The value for employeeId="+shiftEntryDto.getEmployeeId()+ " and Time Period="+shiftEntryDto.getTimePeriod() +" already exists!!");
				return false;
			}
		} catch (Exception e) {
			SysLogger.logException("submitShiftData", e); // Consume the exception here.
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public File exportShiftData2Excel() {
		return ShiftDataExcelWriter.write("c:\\Temp\\excel-file.xls", fetchShiftDataForAll());
	}
	
	public List<ShiftEntryDTO> fetchShiftDataForTimePeriod(TimePeriod timePeriod) {
		return ShiftEntryDTOEntityTranslator.translateEntity2DTO(getRepository().findShiftDataForTimePeriod(timePeriod));
	}
	
	public List<ShiftEntryDTO> fetchShiftDataForAll() {
		return ShiftEntryDTOEntityTranslator.translateEntity2DTO(getRepository().findShiftDataForAll());
	}
	
	public EmployeeShiftRepository getRepository() {
		return (EmployeeShiftRepository) ApplicationContextUtils.getApplicationContext().getBean("employeeShiftRepository");
	}

    public List<Comp2017DTO> fetchBulkData() {
        return ShiftEntryDTOEntityTranslator.translateEntity2DTOComp2017(getRepository().fetchBulkData());
    }

   

}
