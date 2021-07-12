package com.wiley.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Map {
	public static void main(String[] args) throws ClassNotFoundException {
		//Scanner sc = new Scanner(System.in);
		HashMap<String,Integer> hm = new HashMap<>();
		hm.put("ab", 1);
		hm.put("cd", 2); 
		hm.put("ef", 3);
		hm.put("gh", 4);
		System.out.println(hm);
		System.out.println("____________________________\n");
		List<String> ks  = new ArrayList<>(hm.keySet());
		//Collections.sort(ks,(l1,l2)->hm.get(l2)-hm.get(l1));
		for(int i=0;i<ks.size()-1;i++)
			for(int j=0;j<ks.size()-1-i;j++)
				if(hm.get(ks.get(j))>hm.get(ks.get(j+1))) {
					String t = ks.get(j);
					ks.set(j, ks.get(j+1));
					ks.set(j+1, t);
				}
		for(String s : ks)
			System.out.println(s+" : "+hm.get(s));
		
		//Class.forName("name");
		
	}
}
