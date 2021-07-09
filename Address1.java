package com.wiley.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Address1 {
	String city;
	String zipcode;
	public Address1(String city, String zipcode) {
		super();
		this.city = city;
		this.zipcode = zipcode;
	}
	@Override
	public String toString() {
		return "Address [city=" + city + ", zipcode=" + zipcode+"]";
	}
	public static void main(String[] args) {
		List<User2> ul = new ArrayList<>();
		ul.add(new User2(2,"User2",Arrays.asList(new Address1("Delhi","110001"),new Address1("Banglore","560001"))));
		ul.add(new User2(1,"User1",Arrays.asList(new Address1("Chennai","600020"),new Address1("Banglore","560001"))));
		ul.add(new User2(3,"User3",Arrays.asList(new Address1("Chennai","600020"),new Address1("Banglore","560001"))));
		HashMap<Address1,List<User2>> hash = new HashMap<>();
		for(User2 u : ul) {
			for(Address1 ar : u.ad) {
				Optional<Address1> a = hash.keySet().stream().filter(s->s.city.equals(ar.city)).findAny();
				if(!a.isPresent()) {
					hash.put(new Address1(ar.city,ar.zipcode),new ArrayList<>());
					a=hash.keySet().stream().filter(s->s.city.equals(ar.city)).findAny();
				}
				hash.get(a.get()).add(new User2(u.id,u.name));
			}
		}
		for(Address1 a : hash.keySet().stream().filter(s->hash.get(s).size()==1).collect(Collectors.toSet()))
			hash.remove(a);
		hash.forEach((k,v)->System.out.println(k+" - "+v));
	}

}
class User2{
	int id;
	String name;
	List<Address1> ad = new ArrayList<>();
	public User2(int id, String name, List<Address1> ad) {
		super();
		this.id = id;
		this.name = name;
		this.ad = ad;
	}
	public User2(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}
}
