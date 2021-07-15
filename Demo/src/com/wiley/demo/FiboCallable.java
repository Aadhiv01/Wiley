package com.wiley.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FiboCallable {

	public static void main(String[] args) throws InterruptedException {
		FiboCall fc = new FiboCall(5);
		ExecutorService service = Executors.newSingleThreadExecutor();
		Future<List<String>> list = service.submit(fc);
		Thread.sleep(10);
		if(list.isDone()) {
			try {
				list.get().forEach(System.out::println);
				System.out.println("The sum is : "+fc.getSum());
			} catch (InterruptedException | ExecutionException ex) {
				ex.printStackTrace();
			}
		}
	}

}

class FiboCall implements Callable<List<String>>{
	List<String> fl = new ArrayList<>();
	private int n;
	private int sum = 0;
	@Override
	public List<String> call() throws Exception {
		int a=0,b=1,c=0;
		for(int i=0;i<n;i++) {
			c=a+b;
			a=b;
			b=c;
			sum+=a;
			String s = (sum-a)+" + "+a+" = "+(sum);
			fl.add(s);
		}
		return fl;
	}
	FiboCall(int n){
		this.n=n;
	}
	public int getSum() {
		return sum;
	}
	
}