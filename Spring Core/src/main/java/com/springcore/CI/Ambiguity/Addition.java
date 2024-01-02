package com.springcore.CI.Ambiguity;

public class Addition {
	private int a;
	private int b;
	public Addition(double a, double b) {
		super();
		this.a = (int)a;
		this.b = (int)b;
		System.out.println("Constructor : double , double");
	}
	public Addition(String a, String b) {
		super();
		this.a = Integer.parseInt(a);
		this.b = Integer.parseInt(b);
		System.out.println("Constructor : String , String");
	}
	public Addition(int a, int b) {
		super();
		this.a = a;
		this.b = b;
		System.out.println("Constructor : int , int");
	}
	public Addition() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Addition [a=" + a + ", b=" + b + "]";
	}
	
	public void doSum() {
		System.out.println("Sum is : " +(this.a+this.b));
	}
	
}
