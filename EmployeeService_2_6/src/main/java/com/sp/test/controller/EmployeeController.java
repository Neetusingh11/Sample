package com.sp.test.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sp.test.helper.EmployeeHelper;
import com.sp.test.util.APIResponse;
import com.sp.test.vo.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
	private EmployeeHelper employeeHelper;
	
    @GetMapping("/employee/{id}")
    public APIResponse<Employee> getEmployee(@PathVariable Integer id){
    	return employeeHelper.getEmployee(id);
    }
    
    @PostMapping("/employee")
    public APIResponse<Employee> insertEmployee( @RequestBody Employee employee){
         return employeeHelper.insertEmployee(employee);	
    }
     @PutMapping("/employee")
    public APIResponse<Employee> updateEmployee(@RequestBody Employee employee){
    	return employeeHelper.updateEmployee(employee);
    }
     @DeleteMapping("/employee/{id}")
     public APIResponse<Employee> deleteEmployee(@PathVariable Integer id){
     	return employeeHelper.deleteEmployee(id);
     }
     @GetMapping("/allEmployee")
     public APIResponse<Employee> getAllEmployee(){
     	return employeeHelper.getAllEmployee();
     }
}
