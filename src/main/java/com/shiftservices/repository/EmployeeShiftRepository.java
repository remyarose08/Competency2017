package com.shiftservices.repository;

import java.util.List;

import com.shiftservices.datatype.TimePeriod;
import com.shiftservices.entity.Comp2017;
import com.shiftservices.entity.ShiftEntry;

public interface EmployeeShiftRepository {

	void insertEmployeeShiftData(ShiftEntry shiftEntry) throws Exception;
	
	void updateEmployeeShiftData(ShiftEntry shiftEntry) throws Exception;
	
	List<ShiftEntry> findShiftDataForTimePeriod(TimePeriod timePeriod);
	
	List<ShiftEntry> findShiftDataForAll();
	
	boolean validateExistingShiftDataForEmployee(String employeeId, TimePeriod timePeriod);
	
	List<Comp2017> fetchBulkData();
	
}
