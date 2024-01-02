package com.springcore.CI.Ambiguity;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/CI/Ambiguity/ciconfig.xml");
		Addition obj = (Addition) context.getBean("ambiguity");
		obj.doSum();
		System.out.println(obj);
		
	}
}
