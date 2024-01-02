package com.springcore.stereotype;

	import org.springframework.context.ApplicationContext;
	import org.springframework.context.support.ClassPathXmlApplicationContext;

	public class Test {

		public static void main(String[] args) {
			ApplicationContext con = new ClassPathXmlApplicationContext("com/springcore/stereotype/stereoconfig.xml");
			Student student = (Student) con.getBean("student");
			System.out.println(student);
			System.out.println(student.getAddress());
			System.out.println(student.getAddress().getClass().getName());
			
			/*
			 	Singleton - same hash code will get by different objects
			System.out.println(student.hashCode());
			Student student1 = (Student) con.getBean("student");
			System.out.println(student1.hashCode());
			Student student2 = (Student) con.getBean("student");
			System.out.println(student2.hashCode());
			*/
		}

	}
