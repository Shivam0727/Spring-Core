package com.springcore.CI;

public class Person {
	private String name;
	private int personId;
	private Certificate certificate;
	public Person(String name, int personId, Certificate certificate) {
		super();
		this.name = name;
		this.personId = personId;
		this.certificate = certificate;
	}
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", personId=" + personId + ", certificate=" + certificate + "]";
	}
	
	
}
