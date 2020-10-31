 package com.kurshit.linkedlist.singlell.faqs;

import com.kurshit.linkedlist.singlell.LinkedList;
import com.kurshit.linkedlist.singlell.LinkedList.SLNode;

public class RemoveDuplicatesSorted {
	
	public void removeDuplicatesSorted(SLNode head) {
		
		if(head == null)
			return;
		
		SLNode curr = head;
		
		while(curr != null) {
			
			SLNode temp = curr;
			
			while(temp != null && temp.data == curr.data) {
				temp = temp.next;
			}
			
			curr.next = temp;
			curr = curr.next;
		
		}
		
		
		
	}

	public static void main(String[] args) {
		
		LinkedList ll = new LinkedList();
		
		ll.createSortedDuplicateSLL();
		System.out.println("Before Deletion");		
		ll.printSL();
		
		RemoveDuplicatesSorted remove = new RemoveDuplicatesSorted();
		
		remove.removeDuplicatesSorted(ll.head);
		System.out.println("After removal");
		ll.printSL();
		
		
	}

}
