package com.craft.employee.dao;

import com.craft.employee.model.Employee;

public interface EmployeeDAO 
	{
		public void insert(Employee employee);
		public Employee findByEmployeeId(int employeeId);
	}