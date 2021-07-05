package com.wiley.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class EmpComparator implements Comparator<Employee>{
	public int compare(Employee e1,Employee e2) {
		if(e1.city.equals(e2.city))
			return e2.salary-e1.salary;
		return e1.city.compareTo(e2.city);
	}
}

public class Employee {
	String id;
	String city;
	int salary;
	Employee(String id,String city,int salary){
		this.id=id;
		this.city=city;
		this.salary=salary;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Employee> list = new ArrayList<>();
		list.add(new Employee("E1","Chennai",1000));
		list.add(new Employee("E2","Mumbai",9000));
		list.add(new Employee("E3","Banglore",2000));
		list.add(new Employee("E4","Delhi",4000));
		list.add(new Employee("E5","Chennai",4000));
		for(Employee e:list)
			System.out.println(e.id+" "+e.city+" "+e.salary);
		Collections.sort(list,new EmpComparator());
		System.out.println("..........Sorting..........");
		for(Employee e:list)
			System.out.println(e.id+" "+e.city+" "+e.salary);
	}

}
