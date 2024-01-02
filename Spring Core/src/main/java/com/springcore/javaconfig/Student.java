package com.springcore.javaconfig;

import org.springframework.stereotype.Component;

@Component("firststudent")
public class Student {
	public void study() {
		System.out.println("Student is reading Book ...");
	}
}
