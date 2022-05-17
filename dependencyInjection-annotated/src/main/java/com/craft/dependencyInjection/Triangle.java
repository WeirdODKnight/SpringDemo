package com.craft.dependencyInjection;

import org.springframework.stereotype.Component;

@Component
public class Triangle implements Shape{
	 public void drawShape() {
	        System.out.println("Triangle is drawn.");
	    }
	}
