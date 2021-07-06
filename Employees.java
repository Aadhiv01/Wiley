package com.wiley.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
	static double sum(List<Employees> l) {
		double sum=0;
		for(Employees e:l) {
			sum+=e.salary;
		}
		return sum;
	}
	@Override
	public String toString() {
		return "Employee [id= " + id + ", name= " + name+", projectid= "+project.id+", project name= "+project.name+"]";
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ul.add(new User("1","Rahul"));
		ul.add(new Employees("2","Vernon",1000,"Chennai","600020","1","Google",1500));
		ul.add(new Employees("3","Joshua",2000,"Mumbai","600040","2","Wiley",3000));
		ul.add(new Employees("4","Anwar",1200,"Delhi","600060","1","Google",1500));
		ul.add(new Employees("5","Joshua",800,"Banglore","600080","2","Wiley",3000));
		ul.add(new User("6","Rick"));
		List<Employees> el = new ArrayList<>();
		List<Employees> p1 = new ArrayList<>();
		List<Employees> p2 = new ArrayList<>();
		double b1=0,b2=0;
		for(User u : ul) 
			if(u.getClass().equals(Employees.class)) {
				Employees e = (Employees)u;
				if(e.salary>e.project.budget)
					continue;
				if(e.project.id.equals("1")) {
					p1.add(e);
					b1=e.project.budget;
				}
				else {
					p2.add(e);
					b2=e.project.budget;
				}
			}
		while(sum(p1)>b1) {
			Collections.sort(p1,(l1,l2)->(int)(l1.salary-l2.salary));
			p1.remove(p1.get(0));
		}
		while(sum(p1)>b2) {
			Collections.sort(p1,(l1,l2)->(int)(l1.salary-l2.salary));
			p1.remove(p2.get(0));
		}
		el.addAll(p1);
		el.addAll(p2);
		for(Employees e:el)
			System.out.println(e);
	}
}
