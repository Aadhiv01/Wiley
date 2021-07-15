package com.wiley.demo;

import java.util.Scanner;

class base{
	base() {
		this(10);
		System.out.println("Parent const");
	}
	base(int id){
		System.out.println("Parent const Id : "+id);
	}
}

public class inheritance extends base{
	
	inheritance(){
		System.out.println("Child const");
	}
	inheritance(int id){
		this();
		System.out.println("Child const Id : "+id);
	}
	public static void main(String[] args) {
		inheritance i = new inheritance(10);
	}
}
