package com.sp.test.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.test.vo.Employee;
@Service
public class EmployeeService {
     @Autowired
	 private DataSource dataSource;
     
	 
	public Employee getEmployee(Integer id) {
		try {
			 Connection connection=dataSource.getConnection();
			 Statement statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery("select * from emp where id="+id);
			while(resultSet.next()) {
				Employee employee=new Employee();
				employee.setId(String.valueOf(resultSet.getInt("id")));
				employee.setName(resultSet.getString("ename"));
				employee.setAdd(resultSet.getString("eadd"));
				return employee;
			}
		}catch(SQLException se) {
				se.printStackTrace();
			}
		
		return null;
	}

	public Employee insertEmployee(Employee employee) {
		try {
			 Connection connection=dataSource.getConnection();
			 PreparedStatement pStatement=connection.prepareStatement("insert into emp values(?,?,?)");
			 pStatement.setInt(1, Integer.parseInt(employee.getId()));
			 pStatement.setString(2, employee.getName());
			 pStatement.setString(3, employee.getAdd());
			 if(pStatement.executeUpdate()>0) {
					return employee;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		
			return null;
	}

	public Employee updateEmployee(Employee employee) {
		try {
			 Connection connection=dataSource.getConnection();
			 PreparedStatement pStatement=connection.prepareStatement("update emp set ename=?,eadd=? where id=?");
			 pStatement.setString(1, employee.getName());
			 pStatement.setString(2, employee.getAdd());
			 pStatement.setInt(3, Integer.parseInt(employee.getId()));
			 if(pStatement.executeUpdate()>0) {
					return employee;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
				return null;
	}

	public String deleteEmployee(Integer id) {
		try {
			 Connection connection=dataSource.getConnection();
			 PreparedStatement pStatement=connection.prepareStatement("delete from emp where id="+id);
		      
			 if(pStatement.executeUpdate()>0) {
					return "Delete" ;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		return null;
	}

	public List<Employee> getAllEmployee() {
		try {
			 Connection connection=dataSource.getConnection();
			 Statement statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery("select * from emp");
			List<Employee> list=new ArrayList<>();
			while(resultSet.next()) {
			Employee emp=new Employee();
			emp.setId(String.valueOf(resultSet.getString("id")));
			emp.setName(resultSet.getString("ename"));
			emp.setAdd(resultSet.getString("eadd"));
				list.add(emp);
			}
			return list;
		}catch(SQLException se) {
				se.printStackTrace();
			}
		
		return null;
	}

}
