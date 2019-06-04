package com.sp.test.util;

import java.util.Date;

public class Status {
	private String statusCode;
	private Date timeStamp;
	
	
	
	public Status() {
		super();
		this.statusCode = "SUCCESS";
		this.timeStamp = new Date();
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	
	
} 
