package com.wiley.demo;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;


class User1{
	String name;
	int id;
	User1(String name,int id){
		this.name=name;
		this.id=id;
	}
	public String toString() {
		return "{"+name+","+id+"}";
	}
}

public class SortingSets {

	public static void main(String[] args) {
		Set s = new TreeSet(new Type1());
		s.add(new Integer(1));
		s.add(new Integer(2));
		s.add(new User1("Adam",1));
		s.add(new User1("User",2));
		s.add(new String("Hello"));
		s.add(new String("Hi"));
		System.out.println("CASE 1");
		s.forEach(System.out::println);
		System.out.println("-------------------------------------------------------------\nCASE 2");
		Set s1 = new TreeSet(new Type2());
		s1.addAll(s);
		s1.forEach(System.out::println);
		System.out.println("-------------------------------------------------------------\nCASE 3");
		Set s2 = new TreeSet(new Type3());
		s2.addAll(s);
		s2.forEach(System.out::println);
	}
}

class Type1 implements Comparator{
	
	@Override
	public int compare(Object o1,Object o2) {
		if(o1 instanceof Integer) {
			if(o2 instanceof Integer) {
				int x = (int)o1;
				int y =  (int)o2;
				return x-y;
			}
			else if(o2 instanceof String){
				return -1;
			}
			else if(o2 instanceof User1) {
				return -1;
			}
			return 0;
		}
		else if(o1 instanceof User1) {
			if(o2 instanceof User1) {
				return ((User1)o1).id-((User1)o2).id;
			}
			else if(o2 instanceof Integer)
				return 1;
			else if(o2 instanceof String){
				return -1;
			}
			return 0;
		}
		else if(o1 instanceof String){
			if(o2 instanceof String){
	            String str1 = (String)o1;
	            String str2 = (String)o2;
	            return str1.compareTo(str2);
	        }else if(o2 instanceof Integer){
	            return 1;
	        }
	        else if(o2 instanceof User1) {
				return 1;
			}
			return 0;
		}
		return 0;
	}
}

class Type2 implements Comparator{
	
	@Override
	public int compare(Object o1,Object o2) {
		if(o1 instanceof Integer) {
			if(o2 instanceof Integer) {
				int x = (int)o1;
				int y =  (int)o2;
				return x-y;
			}
			else if(o2 instanceof String){
				return 1;
			}
			else if(o2 instanceof User1) {
				return 1;
			}
			return 0;
		}
		else if(o1 instanceof User1) {
			if(o2 instanceof User1) {
				return ((User1)o1).id-((User1)o2).id;
			}
			else if(o2 instanceof Integer)
				return -1;
			else if(o2 instanceof String){
				return 1;
			}
			return 0;
		}
		else if(o1 instanceof String){
			if(o2 instanceof String){
	            String str1 = (String)o1;
	            String str2 = (String)o2;
	            return str1.compareTo(str2);
	        }else if(o2 instanceof Integer){
	            return -1;
	        }
	        else if(o2 instanceof User1) {
				return -1;
			}
			return 0;
		}
		return 0;
	}
}

class Type3 implements Comparator{
	
	@Override
	public int compare(Object o1,Object o2) {
		String x="",y="";
		if((o1 instanceof Integer && o2 instanceof Integer)||!(o1 instanceof Integer || o2 instanceof Integer)) {
			if(o1 instanceof User1)
				x=((User1)o1).name;
			else
				x=o1.toString();
			if(o2 instanceof User1)
				y=((User1)o2).name;
			else
				y=o2.toString();
			return x.compareTo(y);	
		}
		else {
			return -1;
		}
	}
}