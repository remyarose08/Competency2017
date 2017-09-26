package com.shiftservices.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.shiftservices.datatype.Grade;
import com.shiftservices.datatype.ShiftType;
import com.shiftservices.datatype.TimePeriod;

@Entity
public class ShiftEntry implements Serializable {

	private static final long serialVersionUID = -6472961951967057543L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "EMPLOYEE_ID")
	private String employeeId;

	@Column(name = "EMPLOYEE_NAME")
	private String employeeName;

	@Enumerated(EnumType.STRING)
	@Column(name = "GRADE")
	private Grade grade;

	@Enumerated(EnumType.STRING)
	@Column(name = "SHIFT_TYPE")
	private ShiftType shiftType;

	@Enumerated(EnumType.STRING)
	@Column(name = "TIMEPERIOD")
	private TimePeriod timePeriod;

	@Column(name = "NO_OF_SHIFTDAYS")
	private long noOfShiftDays;

	@Column(name = "NO_OF_OC_WEEKDAYS")
	private long noOfOnCallWeekdays;

	@Column(name = "NO_OF_OC_WEEKENDS")
	private long noOfOnCallWeekends;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	/**
	 * Logic: calculates the Total shift allowance amount based on SHIFT TYPE and no of shift days.
	 * @return shift allowance amount.
	 */
	public long getTotalShiftAllowanceAmount() {
		return noOfShiftDays * shiftType.getAmount();
	}

	/**
	 * Logic: calculates the Total on-call allowance amount based on ON-CALL TYPE and no of on-call days.
	 * @return on call allowance amount.
	 */
	public long getTotalOnCallAllowanceAmount() {
		return noOfOnCallWeekdays * ShiftType.ON_CALL_WEEKDAYS.getAmount()
				+ noOfOnCallWeekends * ShiftType.ON_CALL_WEEKENDS.getAmount();
	}

	/**
	 * Logic: calculates the Total on-call allowance amount and Total shift allowance amount.
	 * @return total allowance amount.
	 */
	public long getTotalAllowance() {
		return getTotalShiftAllowanceAmount() + getTotalOnCallAllowanceAmount();
	}

}
