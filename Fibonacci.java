package com.wiley.demo;

import java.util.*;

public class Fibonacci {
	Fibonacci f = new Fibonacci();
	public static void main(String[] args) throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
		int n = 8;
		FiboThread ft = new FiboThread(n);
		Thread t = new Thread(ft);
		Thread t1 = new Thread(ft);
		t.setName("Thread 1");
		t.setPriority(10);
		t.setName("Thread 2");
		t1.setPriority(10);
		t.start();
		t1.start();
//		System.out.println(ft.getSum());
//		ft.getL().forEach(System.out::println);
		sc.close();
	}
}

class FiboThread implements Runnable{
	private int sum = 0;
	private int n;
	int k = 0;
	int a = 0;
	int b = 1;
	int c = 0;
	private List<String> l = Collections.emptyList();
	public void run() {
			l = new ArrayList<>();
			while(true) {
				if(l.size()==n)
					break;
				try {
					if(Thread.currentThread().getName().equals("Thread-1")) {
						if(l.size()==k) {
							c=a+b;
							a=b;
							b=c;
							sum+=a;
							k+=1;
						}
						Thread.sleep(50);
					}
					else {
						if(l.size()==k-1) {
							String s = (sum-a)+" + "+a+" = "+(sum);
							l.add(s);
							if(l.size()==n) {
								System.out.println(sum);
								l.forEach(System.out::println);
							}
						}
						Thread.sleep(50);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();}
			}

	}
	FiboThread(int n){
		this.n=n;
	}
	public int getSum() {
		return sum;
	}
	public List<String> getL() {
		return l;
	}
}
