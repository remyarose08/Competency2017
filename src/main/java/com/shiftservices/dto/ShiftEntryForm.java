package com.shiftservices.dto;

import java.io.Serializable;

import javax.ws.rs.FormParam;

import com.shiftservices.datatype.Grade;
import com.shiftservices.datatype.ShiftType;
import com.shiftservices.datatype.TimePeriod;

public class ShiftEntryForm implements Serializable {

	private static final long serialVersionUID = -7801004644878276347L;

	@FormParam("employeeId")
	private String employeeId;
	
	@FormParam("employeeName")
	private String employeeName;

	@FormParam("grade")
	private Grade grade;
	
	@FormParam("shiftType")
	private ShiftType shiftType;
	
	@FormParam("timePeriod")
	private TimePeriod timePeriod;

	@FormParam("noOfShiftDays")
	private long noOfShiftDays;
	
	@FormParam("noOfOnCallWeekdays")
	private long noOfOnCallWeekdays;
	
	@FormParam("noOfOnCallWeekends")
	private long noOfOnCallWeekends;

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

}
