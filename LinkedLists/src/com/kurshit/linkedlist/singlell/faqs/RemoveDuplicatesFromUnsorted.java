package com.kurshit.linkedlist.singlell.faqs;

import java.util.HashSet;

import com.kurshit.linkedlist.singlell.LinkedList;
import com.kurshit.linkedlist.singlell.LinkedList.SLNode;

public class RemoveDuplicatesFromUnsorted {

	public SLNode removeDuplicateUsingHash(SLNode head) {
		
		if(head == null)
			return null;
		
		SLNode curr =head;
		
		HashSet<Integer> set = new HashSet<>();
		SLNode prev = null;
		while(curr != null) {
			
			int value = curr.data;
			
			if(set.contains(value)) {
				prev.next = curr.next;
			} 
			else {
				set.add(value);
				prev = curr;
			}
			
			curr = curr.next;
			
		}
		
		
		return head;
	}
	
	public static void main(String[] args) {
		
		LinkedList list = new LinkedList();
		
		list.createUnSortedDuplicateNodesList();
		list.printGivenList(list.head);
		RemoveDuplicatesFromUnsorted unsorted =new RemoveDuplicatesFromUnsorted();
		
		SLNode result = unsorted.removeDuplicateUsingHash(list.head);
		System.out.println();
		list.printGivenList(result);
		

	}

}
