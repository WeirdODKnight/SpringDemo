package com.craft.dependencyInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		
		 ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

	        Shape shape = (Shape) applicationContext.getBean("shape");
	        shape.drawShape();
	    }
	}
