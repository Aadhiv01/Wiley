package com.wiley.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

class Transaction{
	String acno;
	String type;
	String bank;
	double amount;
	double balance;
	
	Transaction(){
		
	}
	
	public Transaction(String acno, String type, double amount, double balance) {
		this.acno = acno;
		this.type = type;
		this.amount = amount;
		this.balance = balance;
	}

	void displayDetails(List<Transaction> tran) {
		System.out.printf("%-20s%-20s%-20s%-20s","ACCOUNT NO","TRANSACTION TYPE","AMOUNT","ACCOUNT BALANCE");
		tran.forEach(t->System.out.printf("\n%-20s%-20s%-20s%-20s",t.acno ,t.type,t.amount,t.balance));
		System.out.println("");
	}
}

public class Customer {
	String acno;
	String name;
	double balance;
	static Scanner sc = new Scanner(System.in); 
	List<Transaction> transactions;
	public Customer(String acno, String name, double balance) {
		super();
		transactions = new ArrayList<>();
		this.acno = acno;
		this.name = name;
		this.balance = balance;
	}

	public static void main(String[] args) {
		List<Customer> cust = new ArrayList<>();
		Optional<Customer> cs = null;
		cust.add(new Customer("AB12","Aadhi",8000));
		cust.add(new Customer("CD64","Chen",4000));
		cust.add(new Customer("XY85","Joshua",2500));
		cust.add(new Customer("TP49","Mark",1000));
		cust.add(new Customer("LQ05","Kevin",2800));
		System.out.println("--------------------------------WELCOME TO NRHF BANK--------------------------------");
		System.out.println("Are you a new customer?");
		if(sc.nextLine().equalsIgnoreCase("Yes")) {
		System.out.println("Enter name : ");
		String name = sc.nextLine();
		Customer c = cust.get(cust.size()-1);
		String acno = ""+(char)(c.acno.charAt(0)+1)+(char)(c.acno.charAt(1)-1)+(char)(c.acno.charAt(2)+1)+(char)(c.acno.charAt(3)-1);
		cust.add(new Customer(acno,name,1000));
		cs = Optional.of((cust.get(cust.size()-1)));
		}
		else {
			System.out.println("Enter account number :");
			String acno = sc.nextLine();
			String name = "";
			if(cust.stream().anyMatch(e->e.acno.equals(acno))) {
				name = sc.nextLine();
				if(cust.stream().filter(e->e.acno.equals(acno)).findFirst().toString().equals(name))
					cs = (cust.stream().filter(e->e.acno.equals(acno)).findFirst());
				else
					System.out.println("Incorrect Credentials");
			}
			else
				System.out.println("Incorrect Credentials");
		}
		System.out.println("Welcome "+cs.get().name.toUpperCase());
		String cont = "";
		do {
			System.out.printf("%-25s%-20s%-25s%-20s%-30s","1.Credit","2.Debit","3.Transaction History","4.Check Balance","5.Exit");
			System.out.println("");
			int op = Integer.parseInt(sc.nextLine());
			switch(op) {
				case 1:
					System.out.println("Enter amount to credit : ");
					double camount = Double.parseDouble(sc.nextLine());
					cs.get().balance+=camount;
					cs.get().transactions.add(new Transaction(cs.get().acno,"Credit",camount,cs.get().balance));
					break;
				case 2:
					System.out.println("Enter amount to debit : ");
					double damount = Double.parseDouble(sc.nextLine());
					if(cs.get().balance-damount<1000) {
						System.out.println("Check balance!!!!");
						break;
					}
					cs.get().balance-=damount;
					cs.get().transactions.add(new Transaction(cs.get().acno,"Debit",damount,cs.get().balance));
					break;
				case 3:
					System.out.println("Account holder name : "+cs.get().name.toUpperCase());
					new Transaction().displayDetails(cs.get().transactions);
					break;
				case 4:
					System.out.println("Account number : "+cs.get().acno);
					System.out.println("Account holder name : "+cs.get().name.toUpperCase());
					System.out.printf("Account Balance : %.0f\n",cs.get().balance);
					break;
				default:
					System.exit(0);
			}
			System.out.println("Do you want to continue(Y/N)?");
			cont=sc.nextLine();
		}while(cont.equalsIgnoreCase("y"));
	}

}
