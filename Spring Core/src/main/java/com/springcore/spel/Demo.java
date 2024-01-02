package com.springcore.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Demo {
	@Value("#{30}")
	private int x ;
	@Value("#{20}")
	private int y ;
	@Value("#{T(java.lang.Math).sqrt(625)}")
	private double z ;
	@Value("#{T(java.lang.Math).E}")
	private double e ;
	@Value("#{T(java.lang.Math).PI}")
	private double pi ;
	@Value("#{new java.lang.String('Shivam Raju Barekar')}")
	private String name ;
	@Value("#{8>3}")
	private boolean isActive ;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPi() {
		return pi;
	}
	public void setPi(double pi) {
		this.pi = pi;
	}
	public double getE() {
		return e;
	}
	public void setE(double e) {
		this.e = e;
	}
	public double getZ() {
		return z;
	}
	public void setZ(double z) {
		this.z = z;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	@Override
	public String toString() {
		return "Demo [x=" + x + ", y=" + y + ", z=" + z + ", e=" + e + ", pi=" + pi + ", name=" + name + ", isActive="
				+ isActive + "]";
	}
	
}
