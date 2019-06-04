package com.sp.test.vo;

public class Employee {
	
    private String id;
	
    private String name;
	
    private String add;
	public String getId() {
		return id;
	}
	public Employee() {
		super();
	}
	
	public Employee(String id, String name, String add) {
		super();
		this.id = id;
		this.name = name;
		this.add = add;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", add=" + add + "]";
	}
    
	
    
}
