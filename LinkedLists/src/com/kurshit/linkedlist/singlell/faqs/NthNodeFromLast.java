package com.kurshit.linkedlist.singlell.faqs;

import com.kurshit.linkedlist.singlell.LinkedList;
import com.kurshit.linkedlist.singlell.LinkedList.SLNode;

public class NthNodeFromLast {
	
	public SLNode findNthFromLast(SLNode head ,int n) {
		
		SLNode ptr = head;
		SLNode nptr = head;
		
		if(ptr == null)
			return null;
		
		int count = 0;
		
		while(count != n && ptr != null ) {
			ptr = ptr.next;		
			count++;
		}
		
		if(ptr == null) {
			System.out.println("Out of bounds");
			return null;
		}
		
		while(ptr != null) {
			nptr = nptr.next;
			ptr = ptr.next;
		}
		
		return nptr;
		
		
	}
	
	public static int count = 0;
	
	public SLNode findNthFromLastRecursively(SLNode head, int n) {
		
		if(head == null) {
			return null;
		}
		
		SLNode result = findNthFromLastRecursively(head.next, n);
		
		if(result != null)
			return result;
		count++;
		if(count == n)
			return head;
		
		
		
		return null;
			
		
	}

	public static void main(String[] args) {	
		
		LinkedList ll = new LinkedList();
		
		ll.createSampleSLL1();
		
		NthNodeFromLast nth = new NthNodeFromLast();
		int n = 6; 
		SLNode result = nth.findNthFromLast(ll.head, n);
		
		if(result != null)
			System.out.println(result.data);
		
		result = nth.findNthFromLastRecursively(ll.head, n);
		if(result != null)
			System.out.println(result.data);

	}

}
