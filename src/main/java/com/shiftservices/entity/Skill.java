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
import com.shiftservices.datatype.TechnologyType;
import com.shiftservices.datatype.TimePeriod;

@Entity
public class Skill implements Serializable {

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

	public String getQdb() {
        return qdb;
    }

    public void setQdb(String qdb) {
        this.qdb = qdb;
    }

    @Enumerated(EnumType.STRING)
	@Column(name = "GRADE")
	private Grade grade;

	@Enumerated(EnumType.STRING)
	@Column(name = "TECHNOLOGY_TYPE")
	private TechnologyType technologyType;

	@Column(name = "SKILL")
	private long skill;

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

    public TechnologyType getTechnologyType() {
        return technologyType;
    }

    public void setTechnologyType(TechnologyType technologyType) {
        this.technologyType = technologyType;
    }

    public long getSkill() {
        return skill;
    }

    public void setSkill(long skill) {
        this.skill = skill;
    }


}
