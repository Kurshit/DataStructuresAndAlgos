package com.kurshit.linkedlist.doublyll;

public class DLinkedListSample {

	public static void main(String[] args) {
		
		DLinkedList list = new DLinkedList();
		
		list.addFirst(10);
		list.addFirst(20);
		list.addFirst(30);
		list.addFirst(40);
		
		list.printDLL();
		
		list.addLast(50);
		list.addLast(60);
		
		list.printDLL();
		
	}

}
