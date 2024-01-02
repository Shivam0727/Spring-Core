package com.SpringCore.Standalone.Collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext con = new ClassPathXmlApplicationContext("standaloneconfig.xml");
		Person person1 = (Person) con.getBean("person1");
		System.out.println(person1);
		System.out.println(person1.getProperties());
		System.out.println(person1.getFriends().getClass().getName());
		System.out.println(person1.getFeestructure().getClass().getName());
	}

}
