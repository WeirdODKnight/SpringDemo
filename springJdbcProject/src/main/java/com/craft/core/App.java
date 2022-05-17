package com.craft.core;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.craft.employee.dao.EmpDao;
import com.craft.employee.dao.EmployeeDAO;
import com.craft.employee.dao.EmployeeNamedDAO;
import com.craft.employee.model.Employee;

public class App {
	public static void main(String[] args)
	{
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"Spring-Module.xml");

		EmployeeDAO employeeDAO = (EmployeeDAO) context
				.getBean("employeeDAO");
		Employee employee1 = new Employee(887, "Peter", 28, 80000);
		employeeDAO.insert(employee1);

		Employee employee2 = employeeDAO.findByEmployeeId(1);
		System.out.println(employee2);
		
		EmpDao dao=(EmpDao)context.getBean("edao");
		int status=dao.saveEmployee(new Employee("bahiru", 13, 7000));
		System.out.println(status);
		
		int status1=dao.updateEmployee(new Employee(9,"Sonoo",15, 11));
		System.out.println(status1);
		
		
		Employee e=new Employee();
		e.setEmployeeId(9);
		int status3=dao.deleteEmployee(e);
		System.out.println(status3);

		EmpDao dao1=(EmpDao)context.getBean("edao");
		dao1.saveEmployeeByPreparedStatement(new Employee("chaltex", 12, 1111));
		
       List<Employee> list=dao.getAllEmployees();
		
		for(Employee e1:list)
			System.out.println(e1);
		
List<Employee> list1=dao.getAllEmployeesRowMapper();
		
		for(Employee e2:list1)
			System.out.println(e2);
		EmployeeNamedDAO employeeDAO1 = (EmployeeNamedDAO)context
				.getBean("employeeNamedDAO");
		Employee employee = new Employee("Peter", 28, 80000);
		employeeDAO1.insert1(employee);
		System.out.println("Employee record inserted successfully.");

	}   
}