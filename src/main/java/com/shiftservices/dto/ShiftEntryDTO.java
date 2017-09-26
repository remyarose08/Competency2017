package com.shiftservices.dto;

import java.io.Serializable;

import com.shiftservices.datatype.Grade;
import com.shiftservices.datatype.ShiftType;
import com.shiftservices.datatype.TimePeriod;

public class ShiftEntryDTO implements Serializable {

	private static final long serialVersionUID = -7801004644878276347L;

	private String employeeId;
	private String employeeName;

	private Grade grade;
	private ShiftType shiftType;
	private TimePeriod timePeriod;

	private long noOfShiftDays;
	private long noOfOnCallWeekdays;
	private long noOfOnCallWeekends;
	
	private long totalShiftAllowanceAmount;
	private long totalOnCallAllowanceAmount;
	private long totalAllowance;
	
	public ShiftEntryDTO(String employeeId, String employeeName, Grade grade,
			ShiftType shiftType, TimePeriod timePeriod, long noOfShiftDays,
			long noOfOnCallWeekdays, long noOfOnCallWeekends) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.grade = grade;
		this.shiftType = shiftType;
		this.timePeriod = timePeriod;
		this.noOfShiftDays = noOfShiftDays;
		this.noOfOnCallWeekdays = noOfOnCallWeekdays;
		this.noOfOnCallWeekends = noOfOnCallWeekends;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public ShiftType getShiftType() {
		return shiftType;
	}

	public void setShiftType(ShiftType shiftType) {
		this.shiftType = shiftType;
	}

	public TimePeriod getTimePeriod() {
		return timePeriod;
	}

	public void setTimePeriod(TimePeriod timePeriod) {
		this.timePeriod = timePeriod;
	}

	public long getNoOfShiftDays() {
		return noOfShiftDays;
	}

	public void setNoOfShiftDays(long noOfShiftDays) {
		this.noOfShiftDays = noOfShiftDays;
	}

	public long getNoOfOnCallWeekdays() {
		return noOfOnCallWeekdays;
	}

	public void setNoOfOnCallWeekdays(long noOfOnCallWeekdays) {
		this.noOfOnCallWeekdays = noOfOnCallWeekdays;
	}

	public long getNoOfOnCallWeekends() {
		return noOfOnCallWeekends;
	}

	public void setNoOfOnCallWeekends(long noOfOnCallWeekends) {
		this.noOfOnCallWeekends = noOfOnCallWeekends;
	}

	public long getTotalShiftAllowanceAmount() {
		return totalShiftAllowanceAmount;
	}

	public void setTotalShiftAllowanceAmount(long totalShiftAllowanceAmount) {
		this.totalShiftAllowanceAmount = totalShiftAllowanceAmount;
	}

	public long getTotalOnCallAllowanceAmount() {
		return totalOnCallAllowanceAmount;
	}

	public void setTotalOnCallAllowanceAmount(long totalOnCallAllowanceAmount) {
		this.totalOnCallAllowanceAmount = totalOnCallAllowanceAmount;
	}

	public long getTotalAllowance() {
		return totalAllowance;
	}

	public void setTotalAllowance(long totalAllowance) {
		this.totalAllowance = totalAllowance;
	}
	
}
