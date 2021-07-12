package com.wiley.demo;

import java.util.LinkedList;

class Node{
	int data;
	Node next;
	Node(int data){
		this.data=data;
		this.next=null;
	}
}

class SLList{
	Node head;
	void add(int data) {
		if(head==null) {
			head=new Node(data);
			return;
		}
		Node temp=head;
		Node newnode = new Node(data);
		while(temp.next!=null)
			temp=temp.next;
		temp.next=newnode;
	}
	void add(int index,int data) {
		if(head==null) {
			head=new Node(data);
			return;
		}
		Node temp=head;
		int count=0;
		Node newnode = new Node(data);
		while(count!=index-1) {
			temp=temp.next;
			count++;
		}
		newnode.next=temp.next;
		temp.next=newnode;
	}
	void addFirst(int data) {
		if(head==null) {
			head=new Node(data);
			return;
		}
		Node newnode = new Node(data);
		newnode.next=head;
		head=newnode;
	}
	int get(int index) {
			int count=0;
			Node temp=head;
			while(count!=index) {
				temp=temp.next;
				count++;
			}
			if(temp==null) {
				System.out.println("Illegal index");
				return -1;
			}
			return temp.data;
		}
	void remove(int index) {
		int count=0;
		Node temp=head;
		while(count!=index-1) {
			count++;
			temp=temp.next;
		}
		Node temp1=temp.next.next;
		temp.next=temp1;
	}
	void display() {
		Node temp=head;
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		System.out.println("");
	}
}

class NodeD{
	int data;
	NodeD next;
	NodeD prev;
	NodeD(int data){
		this.data=data;
		this.next=null;
		this.prev=null;
	}
}

class DLList{
	NodeD head;
	void add(int data) {
		if(head==null) {
			head=new NodeD(data);
			return;
		}
		NodeD temp=head;
		NodeD newnode = new NodeD(data);
		while(temp.next!=null)
			temp=temp.next;
		temp.next=newnode;
		newnode.prev=temp;
	}
	void add(int index,int data) {
		if(head==null) {
			head=new NodeD(data);
			return;
		}
		NodeD temp=head;
		int count=0;
		NodeD newnode = new NodeD(data);
		while(count!=index-1) {
			temp=temp.next;
			count++;
		}
		newnode.next=temp.next;
		temp.next.prev=newnode;
		newnode.prev=temp;
		temp.next=newnode;
	}
	void addFirst(int data) {
		if(head==null) {
			head=new NodeD(data);
			return;
		}
		NodeD newnode = new NodeD(data);
		newnode.next=head;
		head.prev=newnode;
		head=newnode;
	}
	int get(int index) {
		int count=0;
		NodeD temp=head;
		while(count!=index) {
			temp=temp.next;
			count++;
		}
		if(temp==null) {
			System.out.println("Illegal index");
			return -1;
		}
		return temp.data;
	}
	void remove(int index) {
		int count=0;
		NodeD temp=head;
		while(count!=index-1) {
			count++;
			temp=temp.next;
		}
		temp.next.next.prev=temp;
		temp.next=temp.next.next;
	}
	void display() {
		NodeD temp=head;
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		System.out.println("");
	}
}

public class Lists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("SLL");
		SLList list = new SLList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.display();
		list.add(1, 6);
		list.display();
		list.addFirst(10);
		list.display();
		System.out.println(list.get(2));
		list.remove(3);
		list.display();
		
		System.out.println("---------------------------------------------\nDLL");
		DLList list1 = new DLList();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		list1.display();
		list1.add(1, 6);
		list1.display();
		list1.addFirst(10);
		list1.display();
		System.out.println(list1.get(2));
		list1.remove(3);
		list1.display();
	}

}
