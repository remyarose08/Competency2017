package com.shiftservices.dto;

import java.io.Serializable;

public class Comp2017DTO implements Serializable {

	private static final long serialVersionUID = -7801004644878276347L;

	private String employeeId;
	private String employeeName;
	
    private String qdb;
    private long noOfShiftDays;
    private long noOfOnCallWeekdays;
    private long noOfOnCallWeekends;
   
    private String grade;
    private String shiftType;
    private String timePeriod;

    private long skill;
    private String technologyType;
    
    public Comp2017DTO(String employeeId, String employeeName, String qdb, String shiftType, String timePeriod,
            long noOfShiftDays,long noOfOnCallWeekdays, long noOfOnCallWeekends,String grade, long skill,
            String technologyType) {
        super();
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.qdb = qdb;
        this.shiftType = shiftType;
        this.timePeriod = timePeriod;
        this.grade = grade;
        this.noOfOnCallWeekdays = noOfOnCallWeekdays;
        this.noOfOnCallWeekends = noOfOnCallWeekends;
        this.noOfShiftDays = noOfShiftDays;
        this.skill = skill;
        this.technologyType = technologyType;
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

    public String getQdb() {
        return qdb;
    }

    public void setQdb(String qdb) {
        this.qdb = qdb;
    }

    

    public static long getSerialversionuid() {
        return serialVersionUID;
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
