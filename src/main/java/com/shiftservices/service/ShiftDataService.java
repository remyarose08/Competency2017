package com.shiftservices.service;

import java.io.File;
import java.util.List;

import com.shiftservices.datatype.Grade;
import com.shiftservices.datatype.TechnologyType;
import com.shiftservices.datatype.TimePeriod;
import com.shiftservices.dto.Comp2017DTO;
import com.shiftservices.dto.ShiftEntryDTO;
import com.shiftservices.entity.Comp2017;

public interface ShiftDataService {

	String fetchAllShiftTypes();

	Grade[] fetchAllGrade();
	
	TechnologyType[] fetchAllTechnologyType();

	TimePeriod[] fetchAllTimePeriods();
	
	boolean submitShiftData(ShiftEntryDTO shiftEntryDto);

	List<ShiftEntryDTO> fetchShiftDataForTimePeriod(TimePeriod timePeriod);
	
	List<ShiftEntryDTO> fetchShiftDataForAll();
	
	File exportShiftData2Excel();
	
	List<Comp2017DTO> fetchBulkData();
	
	

}
