package com.kurshit.linkedlist.doublyll;

public class DLinkedList {
	
	public static class DLNode {
		
		public int data;
		public DLNode next,prev;
		
		public DLNode(int data) {
			this.data = data;
		}
		
	}
	
	public DLNode head;
	
	public void addFirst(int data) {
		DLNode newNode = new DLNode(data);
		
		if(head == null) {
			head = newNode;
			newNode.prev = head;
			return;
		}
		
		newNode.next = head;
		head.prev = newNode;
		head = newNode;		
	}
	
	public void addLast(int data) {
		DLNode newNode = new DLNode(data);
		
		if(head == null) {
			head = newNode;		
			newNode.prev = head;
			return;
		}
		
		DLNode curr = head;
		
		while(curr.next != null) {
			curr = curr.next;
		}
		
		curr.next = newNode;
		newNode.prev = curr;
	}	
	
	public void printDLL() {
		
		if(head == null)
			return;
		
		DLNode curr = head;
		
		while(curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
		
		System.out.println();
	}
	
	public void printDLL(DLNode head) {
		
		if(head == null)
			return;
		
		DLNode curr = head;
		
		while(curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
		
		System.out.println();
	}
	
	
	
	public void createSortedDLinkedList() {
		addLast(10);
		addLast(20);
		addLast(30);
		addLast(40);
		addLast(50);
		addLast(60);
		addLast(70);
		addLast(80);
		addLast(90);
		addLast(100);
	}
	
	
}
