package com.wiley.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ThreadDemo{
	public static void main(String[] args) throws InterruptedException {
		TDemo t = new TDemo();
		Thread t1= new Thread(t);
		Thread t2 = new Thread(t);
		t1.setName("Thread 1");
		t2.setName("Thread 2");
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.NORM_PRIORITY);
		Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
		t1.start();
		t2.start();
		Thread.sleep(5100);
		t.getIntegers().forEach(System.out::println);
  }
}
class TDemo extends Thread{
	private List<Integer> integers  = Collections.emptyList();
	int i;
	public void run(){
		integers  = new ArrayList<>();
		for(i=10;i>0;) { 
			synchronized (this) {
	    		this.integers.add(i);
			}
			i--;   	
			try {
		    	Thread.sleep(500);
		    }catch(Exception e) {
		   		System.out.println(e);
			}
	   	}
	}
    public List<Integer> getIntegers() {
        return integers;
    }
}
