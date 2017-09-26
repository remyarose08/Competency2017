package com.shiftservices.dto;

import java.io.Serializable;

import javax.persistence.Column;

import com.shiftservices.datatype.Grade;
import com.shiftservices.datatype.ShiftType;
import com.shiftservices.datatype.TimePeriod;

public class Comp2017DTO implements Serializable {

	private static final long serialVersionUID = -7801004644878276347L;

	private String employeeId;
	private String employeeName;
	
    private String qdb;
   
    private String shiftType;
   
    private String timePeriod;
		
    public Comp2017DTO(String employeeId, String employeeName, String qdb, String shiftType, String timePeriod) {
        super();
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.qdb = qdb;
        this.shiftType = shiftType;
        this.timePeriod = timePeriod;
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

	
}
