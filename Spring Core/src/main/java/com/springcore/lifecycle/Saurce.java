package com.springcore.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Saurce {
	private double price;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Saurce(double price) {
		super();
		this.price = price;
	}

	public Saurce() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Saurce [price=" + price + "]";
	}
	
	@PostConstruct
	public void start() {
		System.out.println("Starting Method : Init");
	}
	
	@PreDestroy
	public void end() {
		System.out.println("Ending Method : Destroy");
	}
	
}
