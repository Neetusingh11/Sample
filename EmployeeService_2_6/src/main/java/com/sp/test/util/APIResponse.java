package com.sp.test.util;

import java.util.ArrayList;
import java.util.List;

import com.sp.test.vo.Employee;

public class APIResponse<T> {
  public APIResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
private Status status = new Status();
  private T payLoad;
  private List errorInfo=new ArrayList();
public Status getStatus() {
	return status;
}
public void setStatus(Status status) {
	this.status = status;
}
public T getPayLoad() {
	return payLoad;
}
public void setPayLoad(T payLoad) {
	this.payLoad = payLoad;
}
public List getErrorInfo() {
	return errorInfo;
}
public void setErrorInfo(List errorInfo) {
	this.errorInfo = errorInfo;
}
public void setPayLoad(List<Employee> employee) {
     this.payLoad=(T) employee;
	
}
    
  
}
