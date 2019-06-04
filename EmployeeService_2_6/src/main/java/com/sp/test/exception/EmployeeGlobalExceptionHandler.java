package com.sp.test.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sp.test.helper.EmployeeNotFoundException;
import com.sp.test.util.APIResponse;
import com.sp.test.util.ErrorInfo;
import com.sp.test.vo.Employee;

@RestControllerAdvice
public class EmployeeGlobalExceptionHandler {
	@ExceptionHandler(EmployeeNotFoundException.class)
	public APIResponse<Employee> handleUserNotFoundException(EmployeeNotFoundException ex){
		APIResponse<Employee> apiResponse=new APIResponse<Employee>();
		ErrorInfo errorInfo=new ErrorInfo();
		errorInfo.setErrorCode(ex.getErrorCode());
		errorInfo.setErrorMessage(ex.getErrorMessage());
		apiResponse.getErrorInfo().add(errorInfo);
		return apiResponse;
		
	}
	@ExceptionHandler(Exception.class)
	public APIResponse<Employee> handleException(Exception ex){
		APIResponse<Employee> apiResponse=new APIResponse<Employee>();
		ErrorInfo errorInfo=new ErrorInfo();
		errorInfo.setErrorCode("222");
		errorInfo.setErrorMessage(ex.getMessage());
		apiResponse.getErrorInfo().add(errorInfo);
		return apiResponse;
		
	}

}
