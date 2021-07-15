package com.wiley.demo;

public class Encapsulation {
	private int id;
	private String name;
	Encapsulation(int id,String name){
		this.id=id;
		this.name=name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public static void main(String[] args) {
		Encapsulation e = new Encapsulation(10,"lmno");
		System.out.println("Id : "+e.getId()+"\nName : "+e.getName());
		e.setId(40);
		e.setName("abcd");
		System.out.println("Id : "+e.getId()+"\nName : "+e.getName());
	}
}
