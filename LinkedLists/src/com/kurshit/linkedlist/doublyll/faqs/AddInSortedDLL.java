package com.kurshit.linkedlist.doublyll.faqs;

import com.kurshit.linkedlist.doublyll.DLinkedList;
import com.kurshit.linkedlist.doublyll.DLinkedList.DLNode;

public class AddInSortedDLL {
	
	public void addInSortedDLL(DLNode head, int data) {
		
		DLNode newNode = new DLNode(data);
		
		if(head == null) {
			head = newNode;
			newNode.prev = head;
			return;
		}
		
		DLNode curr = head;
		
		if(head.data >= data) {
			newNode.next = head;
			newNode.next.prev = newNode;
			head = newNode;
			return;			
		}
		
		while(curr.next != null && curr.next.data < data ) {
			curr = curr.next;
		}
		
		if(curr.next != null) {
			newNode.next = curr.next;
			newNode.prev = curr;
			curr.next = newNode;			
		} else {
			curr.next = newNode;
			newNode.prev = curr;
		}
		
	}
	
	public static void main(String[] args) {
		
		DLinkedList list = new DLinkedList();
		list.createSortedDLinkedList();
		
		AddInSortedDLL s = new AddInSortedDLL();
		list.printDLL();
		s.addInSortedDLL(list.head, 5);
		s.addInSortedDLL(list.head, 45);
		list.printDLL();
		//s.addInSortedDLL(list.head, 101);
		//list.printDLL();

	}

}
