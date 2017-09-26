package com.shiftservices.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Comp2017 implements Serializable {

	private static final long serialVersionUID = -6472961951967057543L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "EMPLOYEE_ID")
	private String employeeId;

	@Column(name = "EMPLOYEE_NAME")
	private String employeeName;
	
	@Column(name = "QDB")
    private String qdb;
	
	@Column(name = "SHIFT_TYPE")
    private String shiftType;
	
	@Column(name = "TIMEPERIOD")
    private String timePeriod;
	
	@Column(name = "NO_OF_SHIFTDAYS")
    private long noOfShiftDays;
	
	@Column(name = "NO_OF_OC_WEEKDAYS")
    private long noOfOnCallWeekdays;
	
	@Column(name = "NO_OF_OC_WEEKENDS")
    private long noOfOnCallWeekends;
   
	@Column(name = "GRADE")
    private String grade;
   
	@Column(name = "SKILL")
    private long skill;
	
	@Column(name = "TECHNOLOGY_TYPE")
    private String technologyType;
	
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

    public String getQdb() {
        return qdb;
    }

    public void setQdb(String qdb) {
        this.qdb = qdb;
    }

    public String getShiftType() {
        return shiftType;
    }

    public void setShiftType(String shiftType) {
        this.shiftType = shiftType;
    }

    public String getTimePeriod() {
        return timePeriod;
    }

    public void setTimePeriod(String timePeriod) {
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public long getSkill() {
        return skill;
    }

    public void setSkill(long skill) {
        this.skill = skill;
    }

    public String getTechnologyType() {
        return technologyType;
    }

    public void setTechnologyType(String technologyType) {
        this.technologyType = technologyType;
    }
	
}
