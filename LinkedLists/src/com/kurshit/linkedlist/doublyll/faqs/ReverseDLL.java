package com.kurshit.linkedlist.doublyll.faqs;

import com.kurshit.linkedlist.doublyll.DLinkedList;
import com.kurshit.linkedlist.doublyll.DLinkedList.DLNode;

public class ReverseDLL {
	
	 DLNode reverse(DLNode head) {

	        if(head == null)
	            return null;
	        
	        DLNode curr = head;
	        DLNode prev = null;

	        while(curr != null) {
	            prev = curr.prev;
	            curr.prev = curr.next;
	            curr.next = prev; 
	            
	            curr = curr.prev;          

	        }
	        
	        if(prev != null)
	        	head = prev.prev;
	        
	        return head;
	    }


	public static void main(String[] args) {
		
		DLinkedList dll = new DLinkedList();
		
		dll.createSortedDLinkedList();
		
		ReverseDLL r = new ReverseDLL();
		DLNode head = r.reverse(dll.head);
		dll.printDLL(head);
		

	}
	
}
