package com.wiley.demo;

import java.util.ArrayList;
import java.util.Scanner;

public class Strings {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String rev = new StringBuilder(s).reverse().toString();
		System.out.println((s.equals(rev))?s+" is a palindrome":s+" is not a palindrome");
//		ArrayList list = new ArrayList();
//		list.add(1);
//		list.add(2);
//		list.add(3);
//		list.add(4);
//		for(Object o :list) {
//			System.out.print(o+" ");
//			list.remove(o);
//		}
	}
}
