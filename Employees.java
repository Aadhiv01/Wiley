package com.wiley.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class User{
	String id;
	String name;
	User(String id, String name){
		this.id=id;
		this.name=name;
	}
}
class Address{
	String city;
	String zipcode;
}
class Project{
	String id;
	String name;
	double budget;
	double cost;
}
public class Employees extends User{
	Address address;
	Project project;
	double salary;
	static List<User> ul = new ArrayList<User>();
	Employees(String id,String name,double salary,String city,String zipcode,String pid,String pname,double budget){
		super(id,name);
		this.address=new Address();
		this.project=new Project();
		this.salary=salary;
		this.address.city=city;
		this.address.zipcode=zipcode;
		this.project.id=pid;
		this.project.name=pname;
		this.project.budget=budget;
	}
	@Override
	public String toString() {
		return "Employee [id= " + id + ", name= " + name+", projectid= "+project.id+", project name= "+project.name+"]";
	}
	public static void main(String[] args) {
		ul.add(new User("1","Rahul"));
		ul.add(new Employees("2","Vernon",1000,"Chennai","600020","1","Google",1500));
		ul.add(new Employees("3","Joshua",2000,"Mumbai","600040","2","Wiley",3000));
		ul.add(new Employees("4","Anwar",1200,"Delhi","600060","1","Google",1500));
		ul.add(new Employees("5","Chen",800,"Banglore","600080","2","Wiley",3000));
		ul.add(new User("6","Rick"));
		List<Employees> p1 = ul.stream()
				       .filter(e -> e.getClass().equals(Employees.class))
				       .map(e->(Employees)e)
				       .filter(e->e.project.id.equals("1"))
			               .filter(e->(e.salary<=e.project.budget))
				       .collect(Collectors.toList());
		List<Employees> p2 = ul.stream()
				       .filter(e -> e.getClass().equals(Employees.class))
				       .map(e->(Employees)e)
				       .filter(e->e.project.id.equals("2"))
				       .filter(e->(e.salary<=e.project.budget))
				       .collect(Collectors.toList());
		double b1=p1.get(0).project.budget,b2=p2.get(0).project.budget;
		int sum1 = (int)p1.stream()
				  .mapToDouble(e->e.salary)
				  .reduce(0,(a, b) -> a+b);
		int sum2 = (int)p2.stream()
				  .mapToDouble(e->e.salary)
				  .reduce(0,(a, b) -> a+b);
		while(sum1>b1) {
			Collections.sort(p1,(l1,l2)->(int)(l1.salary-l2.salary));
			p1.remove(p1.get(0));
			sum1 = (int)p1.stream()
				      .mapToDouble(e->e.salary)
				      .reduce(0,(a, b) -> a+b);
		}
		while(sum2>b2) {
			Collections.sort(p2,(l1,l2)->(int)(l1.salary-l2.salary));
			p2.remove(p2.get(0));
			sum2 = (int)p2.stream()
				      .mapToDouble(e->e.salary)
				      .reduce(0,(a, b) -> a+b);
		}
		List<Employees> el = new ArrayList<>();
		el.addAll(p1);
		el.addAll(p2);
		for(Employees e:el)
			System.out.println(e);
	}
}
