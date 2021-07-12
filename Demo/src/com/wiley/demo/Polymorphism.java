package com.wiley.demo;

import java.util.*;

public class Polymorphism {
	int add(int a, int b) {
		return a+b;
	}
	int add(int a, byte b, short c) {
		System.out.println("Mix three");
		return a+b+c;
	}
	int add(int a,int b,int c) {
		System.out.println("Int three");
		return a+b+c;
	}
	
	double add(int a, float b, double c) {
		return (double)a+b+c;
	}
	public static void main(String[] args) {
		//Scanner sc = new Scanner(System.in);
		Polymorphism p = new Polymorphism();
		System.out.println(p.add(2,4));
		System.out.println(p.add(2,4,(short)6));
		System.out.println(p.add(20,4,8l));
		System.out.println(p.add(2,4.2f,8.6));
	}
}
