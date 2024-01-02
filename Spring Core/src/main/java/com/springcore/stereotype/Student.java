package com.springcore.stereotype;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component("obj") --> for change the object reference from student to obj ...
@Component
//@Scope("prototype") --> using this annotation we get prototype so by every object we get difference hash-code ...
public class Student {
	@Value("Shivam Barekar")
	private String studentName ;
	@Value("Kuchana Complex")
	private String city ;
	@Value("#{temp}")
	private List<String> address ;
	
	public List<String> getAddress() {
		return address;
	}
	public void setAddress(List<String> address) {
		this.address = address;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Student [ Student Name = " + studentName + " , City = " + city +" , Address = "+ address + " ]";
	}
	
}
