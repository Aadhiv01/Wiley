package com.wiley.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

class USER4{
	int id;
	String name;
	List<Proj> pl;
	public USER4(int id, String name, List<Proj> pl) {
		
		this.id = id;
		this.name = name;
		this.pl = pl;
	}
	public USER4(int id, String name) {
		
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}
	
}

class Proj{
	int id;
	String name;
	public Proj(int id, String name) {
		
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + "]";
	}
	
}

public class ThreadUser {
	static List<USER4> ul = Arrays.asList((new USER4(2,"User2",Arrays.asList(new Proj(1,"PR1"),new Proj(2,"PR2")))),(new USER4(1,"User1",Arrays.asList(new Proj(1,"PR1"),new Proj(2,"PR2")))),(new USER4(3,"User3",Arrays.asList(new Proj(2,"PR2"),new Proj(5,"PR5")))));
	public static void main(String[] args) {
		UserThread ut = new UserThread(3);
		Thread t1 = new Thread(ut);
		Thread t2 = new Thread(ut);
		t1.setName("Thread 1");
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setName("Thread 2");
		t2.setPriority(Thread.MIN_PRIORITY);
		t1.start();
		t2.start();
	}

}
class UserThread implements Runnable{
	int n;
	int x = 0;
	List<USER4> ul = new ArrayList<>();
	HashMap<Proj,List<USER4>> hash = new HashMap<>();
	Scanner sc = new Scanner(System.in);
	UserThread(int n){
		this.n=n;
	}
	public void run() {
		for(int i=0;i<n;i++) {
			if(Thread.currentThread().getName().equals("Thread 1")) {
				ul.add(ThreadUser.ul.get(x));
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			else {
					for(Proj pr : ul.get(x).pl) {
						Optional<Proj> a = hash.keySet().stream().filter(s->s.name.equals(pr.name)).findAny();
						if(!a.isPresent()) {
							hash.put(new Proj(pr.id,pr.name),new ArrayList<>());
							a=hash.keySet().stream().filter(s->s.name.equals(pr.name)).findAny();
						}
						final int z = x;
						Optional<USER4> b = hash.get(a.get()).stream().filter(s->s.name.equals(ul.get(z).name)).findAny();
						if(!b.isPresent())
							hash.get(a.get()).add(new USER4(ul.get(x).id,ul.get(x).name));
					}
				
				if(i==n-1)
					hash.forEach((k,v)->System.out.println(k+" - "+v));
				try {
					x++;
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
