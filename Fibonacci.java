package com.wiley.demo;

import java.util.*;

public class Fibonacci {

	public static void main(String[] args) throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
		int n = 5;
		FiboThread ft = new FiboThread(n);
		Thread t = new Thread(ft);
		t.setName("Thread 1");
		t.setPriority(Thread.MAX_PRIORITY);
		Thread t1 = new Thread(ft);
		t.setName("Thread 2");
		t1.setPriority(Thread.MIN_PRIORITY);
		t.start();
		t1.start();
		sc.close();
//		System.out.println(ft.getSum());
//		ft.getL().forEach(System.out::println);
	}
}

class FiboThread implements Runnable{
	private int sum;
	int n;
	int x = 0;
	private List<String> l = Collections.emptyList();
	public void run() {
			//System.out.println(Thread.currentThread().getName());
			l = new ArrayList<>();
			sum=0;
			int a = 0, b = 1, c=0;
			for(int i=0;i<n;i++) {
				c=a+b;
				a=b;
				b=c;
				try {
				if(Thread.currentThread().getName().equals("Thread-1")) {
					sum+=a;
					if(i==n-1)
						System.out.println(sum);
					Thread.sleep(500);
				}
				else {
					String s = x+" + "+a+" = "+(x+a);
					x+=a;
					l.add(s);
					if(i==n-1) {
						l.forEach(System.out::println);
					}
					Thread.sleep(100);
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