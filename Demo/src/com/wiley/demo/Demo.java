package com.wiley.demo;

import java.util.*;

public class Demo {
	static byte k=0;
	static byte dis=0;
	String name;
	String designation;
	int age;
	int salary;
	String id;
	static List<Demo> d = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) { 
		do {
			System.out.println("1.Create 2.Display 3.Raise Salary 4.Delete 5.Exit");
			int ch = sc.nextInt();
			sc.nextLine();
			String cont="y";
			switch(ch) {
			case 1:
				if(k>=10) {
					System.out.println("Cannot add anymore employees!!!!");
					break;
				}
				do {
					d.add(new Demo());
					System.out.println("Enter name : ");
					String nm=sc.nextLine();
					if(nm.split(" ").length<=2)
						d.get(k).name=nm;
					else {
						System.out.println("Incorrect Name!!!!");
						d.remove(d.size()-1);
						continue;
					}
					System.out.println("Enter designation(P/M/T) : ");
					String ds = sc.nextLine();
					if(ds.equalsIgnoreCase("P")||ds.equalsIgnoreCase("M")||ds.equalsIgnoreCase("T"))
						d.get(k).designation=ds;
					else {
						System.out.println("Incorrect Designation!!!!");
						d.remove(d.size()-1);
						continue;
					}
					System.out.println("Enter age : ");
					int age = Integer.parseInt(sc.nextLine());
					if(age>=18 && age<61)
						d.get(k).age=age;
					else {
						System.out.println("Incorrect age!!!!");
						d.remove(d.size()-1);
						continue;
					}
					if(d.get(k).designation.equals("P"))
						d.get(k).salary=30000;
					else if(d.get(k).designation.equals("M"))
						d.get(k).salary=35000;
					else if(d.get(k).designation.equals("T"))
						d.get(k).salary=25000;
					d.get(k).id="Wil0"+(k+1);
				System.out.println("do you want to continue to enter details(y/n)?");
				cont = sc.nextLine();
				k++;
				}while(k<10 && cont.equalsIgnoreCase("y"));
				break;
			case 2:
				if(k==0) {
					System.out.println("Enter details first!!!!");			
				}
				System.out.println("Employee\t\tName\t\tDesignation\t\tAge\t\tSalary");
				for(int i=0;i<k;i++)
					System.out.println(d.get(i).id+"\t\t\t"+d.get(i).name+"\t\t"+d.get(i).designation+"\t\t\t"+d.get(i).age+"\t\t"+d.get(i).salary);
				dis++;
				break;
			case 3:
				if(dis==0 || k==0) {
					System.out.println("Enter and display details first to raise salary!!!!");
					break;
				}
				System.out.println("Enter employee id to raise salary from "+k+" employees : ");
				int cid = Integer.parseInt(sc.nextLine());
				if(cid>k) {
					System.out.println("Invalid ID!!!!");
					break;
				}
				System.out.println("Enter percentage of salary increase");
				int amt = Integer.parseInt(sc.nextLine());
				if(amt>30) {
					System.out.println("Please enter proper percenatge for salary increase!!!!");
					break;
				}
				d.get(cid-1).salary+=(d.get(cid-1).salary*amt/100);
				break;
			case 4:
				System.out.println("Enter employee id to delete from "+k+" employees");
				int id = Integer.parseInt(sc.nextLine());
				if(id>k || id<1) {
					System.out.println("Invalid ID!!!!");
					break;
				}
				d.remove(id-1);
				k--;
				break;
			case 5:
				break;
			}
			System.out.println("\nDo you want to continue to the main menu?(Y/N) ");
			String cont1 = sc.nextLine();
			if(!cont1.equalsIgnoreCase("y"))
				break;
		}while(true);
		sc.close();
	}
}
