package com.kurshit.linkedlist.singlell.faqs;

import com.kurshit.linkedlist.singlell.LinkedList;
import com.kurshit.linkedlist.singlell.LinkedList.SLNode;

public class ReverseSLL {
	
	public SLNode reverseIt(SLNode head) {
		
		if(head == null)
			return null;
		
		SLNode prev = null;
		SLNode next = null;
		
		SLNode curr = head;
		
		
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;	
			
		}
		
		head = prev;
		
		return head;
		
	}

	public static void main(String[] args) {
		
		LinkedList list = new LinkedList();
		
		list.createSampleSLL1();
		
		ReverseSLL reverse = new ReverseSLL();
		
		list.printSL();
		
		list.head = reverse.reverseIt(list.head);
		
		list.printSL();

	}

}
