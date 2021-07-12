package com.wiley.demo;


class ThreadDemo extends Thread {
	public void run(){
	    try {
	    		for(int i=10;i>=0;i--) { 
	    		if(Thread.currentThread().getName().equals("Thread 1")) {
	    			if(i%2==1)
	    				continue;
	    		}
	    		else {
	    			if(i%2==0)
	    				continue;
	    		}
	    		System.out.println(Thread.currentThread().getName()+" - "+i);
	    		Thread.sleep(1000);
	    		}
	    }
	    catch(Exception e) {
	    	System.out.println(e);
	    }
	  }
	public static void main(String[] args) throws InterruptedException {
		ThreadDemo t1 = new ThreadDemo();
		t1.setName("Thread 1");
		t1.start();
		ThreadDemo t2 = new ThreadDemo();
		t2.setName("Thread 2");
		t2.start();
  }
}