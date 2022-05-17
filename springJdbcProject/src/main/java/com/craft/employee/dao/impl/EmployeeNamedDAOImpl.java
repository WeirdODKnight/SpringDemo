package com.craft.employee.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import com.craft.employee.dao.EmployeeNamedDAO;
import com.craft.employee.model.Employee;

public class EmployeeNamedDAOImpl extends NamedParameterJdbcDaoSupport  implements EmployeeNamedDAO{
	public void insert1(Employee employee) {

		String sql = "INSERT INTO EMPLOYEE "
				+ "(NAME, AGE,SALARY) VALUES (:name, :age,:salary)";

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("employeeId", employee.getEmployeeId());
		parameters.put("name", employee.getName());
		parameters.put("age", employee.getAge());
		parameters.put("salary", employee.getSalary());

		getNamedParameterJdbcTemplate().update(sql, parameters);

	}

}
