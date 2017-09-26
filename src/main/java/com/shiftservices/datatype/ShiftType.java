package com.shiftservices.datatype;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.shiftservices.rest.serializers.ShiftTypeEnumSerializer;

@JsonSerialize(using = ShiftTypeEnumSerializer.class)

public enum ShiftType {

	SHIFT1("SHIFT1", "11.00 AM - 03.59 PM", "08.30 PM - 1.29 AM", 275L), SHIFT2("SHIFT2", "04.00 AM - 08.59 PM", "01.30 AM - 05.29 AM", 300L), SHIFT3(
			"SHIFT3", "08.59 PM - 12.59 AM", "05.30 AM - 09.29 AM", 325L), SHIFT4("SHIFT4", "01.00 AM - 06.59 AM", "09.30 AM - 03.30 PM", 325L), ON_CALL_WEEKDAYS(
			"ON_CALL_WEEKDAYS", "", "", 350L), ON_CALL_WEEKENDS(
			"ON_CALL_WEEKENDS", "", "", 550L);

	private String name;
	private String loginTime;
	private String logoutTime;
	private long amount;
	

	private ShiftType(String name, String loginTime, String logoutTime,
			long amount) {
		this.name = name;
		this.loginTime = loginTime;
		this.logoutTime = logoutTime;
		this.amount = amount;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}


	public String getLogoutTime() {
		return logoutTime;
	}

	public void setLogoutTime(String logoutTime) {
		this.logoutTime = logoutTime;
	}


	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	
	@Override
	public String toString() {
		return "[" + "name=" + name + "amount=" + amount + "loginTime="
				+ loginTime + "logoutTime=" + logoutTime + "]";
	}

}
