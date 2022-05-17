package com.craft.autoWiringDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {
	public static void main(String[] args) {
		
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	System.out.println("*** Example Using byName autowiring mode ***");
	Employee emp = context.getBean("employeeByName", Employee.class);
	emp.setEid(101);
	emp.setEname("Craft Knowledge");
	emp.showEployeeDetails();

	System.out.println("\n*** Example Using byType autowiring mode ***");
	Employee emp1 = context.getBean("employeeByType", Employee.class);
	emp1.setEid(102);
	emp1.setEname("Craft Knowledge");
	emp1.showEployeeDetails();

	System.out.println("\n*** Example Using constructor autowiring mode ***");
	Employee emp2 = context.getBean("employeeConstructor", Employee.class);
	emp2.setEid(103);
	emp2.setEname("Craft Knowledge");
	emp2.showEployeeDetails();

	System.out.println("\n*** Example Using @Autowire annotation on property ***");
	EmployeeBean employeeBean = context.getBean(EmployeeBean.class);
	employeeBean.setEid(104);
	employeeBean.setEname("Craft Knowledge");
	employeeBean.showEployeeDetails();
}
}