package com.sp.test.helper;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.test.service.EmployeeService;
import com.sp.test.util.APIResponse;
import com.sp.test.util.ErrorInfo;
import com.sp.test.util.Status;
import com.sp.test.vo.Employee;
@Service
public class EmployeeHelper {
    @Autowired
	private EmployeeService employeeService;
	
	public APIResponse<Employee> getEmployee(Integer id) {
		 APIResponse<Employee> apiResponse=new APIResponse<>();
		 Employee employee=employeeService.getEmployee(id);
		 if(employee==null)
			 throw new EmployeeNotFoundException("111","Employee id"+id+" not found");
		 apiResponse.setPayLoad(employee);
		 apiResponse.setStatus(new Status());
		return apiResponse;
	}
	
	@SuppressWarnings("unchecked")
	public APIResponse<Employee> insertEmployee(Employee employee) {
		 APIResponse<Employee> apiResponse=new APIResponse<>();
		 if(employee.getId().length()<3) {
			 setErrorInfo(apiResponse,"1000","Invalid Id");
		 }
		 if(employee.getName().length()<2) {
			 setErrorInfo(apiResponse,"1001","Invalid Name");
		 }
		 if(!apiResponse.getErrorInfo().isEmpty()) {
			 return apiResponse;
		 }
		 Employee newemployee=employeeService.insertEmployee(employee);
		 if(newemployee==null)
			 throw new EmployeeNotFoundException("333","Employee Creation failed");
		 apiResponse.setPayLoad(employee);
		 apiResponse.setStatus(new Status());
		return apiResponse;
	}

	private void setErrorInfo(APIResponse<Employee> apiResponse,String errorCode,String errorMessage) {
		ErrorInfo error = new ErrorInfo();
		 error.setErrorCode(errorCode);
		 error.setErrorMessage(errorMessage);
		 apiResponse.getStatus().setStatusCode("ERROR");
		 apiResponse.getErrorInfo().add(error);
	}
	@SuppressWarnings("unchecked")
	public APIResponse<Employee> updateEmployee(Employee employee) {
		 APIResponse<Employee> apiResponse=new APIResponse<>();
		 if(employee.getId().length()<3) {
			 setErrorInfo(apiResponse,"1000","Invalid Id");
		 }
		 if(employee.getName().length()<2) {
			 setErrorInfo(apiResponse,"1001","Invalid Name");
		 }
		 if(!apiResponse.getErrorInfo().isEmpty()) {
			 return apiResponse;
		 }
		 Employee newemployee=employeeService.updateEmployee(employee);
		 if(newemployee==null)
			 throw new EmployeeNotFoundException("444","Employee updation failed");
		 apiResponse.setPayLoad(employee);
		 apiResponse.setStatus(new Status());
		return apiResponse;

	}

	public APIResponse<Employee> deleteEmployee(Integer id) {
		APIResponse<Employee> apiResponse=new APIResponse<>();
		 String newemployee=employeeService.deleteEmployee(id);
		 if(newemployee==null)
			 throw new EmployeeNotFoundException("555","Employee with "+ id+" delete failed");
		 //apiResponse.setPayLoad(null);
		 apiResponse.setStatus(new Status());
		return apiResponse;

	}

	public APIResponse<Employee> getAllEmployee() {
		APIResponse<Employee> apiResponse=new APIResponse<>();
		List<Employee> employee=new ArrayList<>();
		  employee=(List<Employee>) employeeService.getAllEmployee();
		// System.out.println(employee);
		//return employee;
		 apiResponse.setPayLoad(employee);
		 apiResponse.setStatus(new Status());
		return apiResponse;
			
		
	}
}
