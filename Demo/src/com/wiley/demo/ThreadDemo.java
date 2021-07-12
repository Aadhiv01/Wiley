package com.wiley.demo;


class ThreadDemo extends Thread {
	int a;
	boolean check = true;
	ThreadDemo(int a){
		this.a=a;
	}
	public void run(){
	    try {
	    		for(int i=a;i<=10;i++) { 
	    		System.out.println(Thread.currentThread().getName()+" - "+i);
	    		if(i==5) 
	    			Thread.yield();
	    		//Thread.sleep(500);
	    		}
	    }
	  //System.out.println("Run method invoked");	
//	    	System.out.println("Run method invoked");
	    catch(Exception e) {
	    	System.out.println(e);
	    }
	  }
	public static void main(String[] args) throws InterruptedException {
		ThreadDemo t1 = new ThreadDemo(1);
		t1.setName("Thread 1");
		//t1.setPriority(2);
		//System.out.println("-------------"+t1.getState()+"-------------");
		t1.start();
//		System.out.println("-------------"+t1.getState()+"-------------");
//		t1.sleep(100);
//		System.out.println("-------------"+t1.getState()+"-------------");
//		System.out.println("-------------"+t1.getState()+"-------------");
		ThreadDemo t2 = new ThreadDemo(1);
		t2.setName("Thread 2");
		//t2.setPriority(10);
		t2.start();
		//t2.join();
  }
 
}

