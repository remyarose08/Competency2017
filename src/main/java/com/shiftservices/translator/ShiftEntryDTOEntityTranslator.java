package com.shiftservices.translator;

import java.util.ArrayList;
import java.util.List;

import com.shiftservices.dto.Comp2017DTO;
import com.shiftservices.dto.ShiftEntryDTO;
import com.shiftservices.entity.Comp2017;
import com.shiftservices.entity.ShiftEntry;

public final class ShiftEntryDTOEntityTranslator {

	public static ShiftEntry translateDTO2Entity(ShiftEntryDTO dto) {
		ShiftEntry entity = new ShiftEntry();

		entity.setEmployeeId(dto.getEmployeeId());
		entity.setEmployeeName(dto.getEmployeeName());

		entity.setGrade(dto.getGrade());
		entity.setTimePeriod(dto.getTimePeriod());
		entity.setShiftType(dto.getShiftType());

		entity.setNoOfShiftDays(dto.getNoOfShiftDays());
		entity.setNoOfOnCallWeekdays(dto.getNoOfOnCallWeekdays());
		entity.setNoOfOnCallWeekends(dto.getNoOfOnCallWeekends());

		return entity;
	}
	
	
    public static Comp2017 translateDTO2EntityComp2017(Comp2017DTO dto) {
        Comp2017 entity = new Comp2017();

        entity.setEmployeeId(dto.getEmployeeId());
        entity.setEmployeeName(dto.getEmployeeName());
        entity.setQdb(dto.getQdb());
        entity.setShiftType(dto.getShiftType());
        entity.setTimePeriod(dto.getTimePeriod());

        return entity;
    }

	public static ShiftEntryDTO translateEntity2DTO(ShiftEntry entity) {
		ShiftEntryDTO dto = new ShiftEntryDTO(entity.getEmployeeId(),
				entity.getEmployeeName(), entity.getGrade(),
				entity.getShiftType(), entity.getTimePeriod(),
				entity.getNoOfShiftDays(), entity.getNoOfOnCallWeekdays(),
				entity.getNoOfOnCallWeekends());
		
				// LOGIC: Calculations of Allowances.
				dto.setTotalShiftAllowanceAmount(entity.getTotalShiftAllowanceAmount());
				dto.setTotalOnCallAllowanceAmount(entity.getTotalOnCallAllowanceAmount());
				dto.setTotalAllowance(entity.getTotalAllowance());

		return dto;
	}
	
	
	   public static Comp2017DTO translateEntity2DTOComp2017(Comp2017 comp2017) {
	        Comp2017DTO dto = new Comp2017DTO(comp2017.getEmployeeId(),
	                                          comp2017.getEmployeeName(), comp2017.getQdb(),comp2017.getShiftType(), comp2017.getTimePeriod(),
	                                          comp2017.getNoOfShiftDays(), comp2017.getNoOfOnCallWeekdays(), comp2017.getNoOfOnCallWeekends(),comp2017.getGrade(),
	                                          comp2017.getSkill(),
	                                          comp2017.getTechnologyType());
	        return dto;
	    }


	public static List<ShiftEntryDTO> translateEntity2DTO(List<ShiftEntry> entities) {

		List<ShiftEntryDTO> dtos = new ArrayList<ShiftEntryDTO>();
		for (ShiftEntry entity : entities) {
			dtos.add(translateEntity2DTO(entity));
		}
		return dtos;
	}
	
	public static List<Comp2017DTO> translateEntity2DTOComp2017(List<Comp2017> entities) {

        List<Comp2017DTO> dtos = new ArrayList<Comp2017DTO>();
        for (Comp2017 entity : entities) {
            dtos.add(translateEntity2DTOComp2017(entity));
        }
        return dtos;
    }

}
