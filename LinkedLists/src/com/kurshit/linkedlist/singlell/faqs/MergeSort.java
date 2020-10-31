package com.kurshit.linkedlist.singlell.faqs;

import com.kurshit.linkedlist.singlell.LinkedList;
import com.kurshit.linkedlist.singlell.LinkedList.SLNode;

public class MergeSort {
	
	public SLNode sort(SLNode head) {
		
		if(head == null || head.next == null)
			return head;
		
		SLNode middle = getMiddle(head);
		
		SLNode middleNext = middle.next;
		
		middle.next = null;
		
		SLNode left = sort(head);
		SLNode right = sort(middleNext);
		
		SLNode result = mergeSortedPair(left, right);
		
		return result;
		
		
	}
	
	public SLNode getMiddle(SLNode head) {
		
		if(head == null)
			return null;
		
		SLNode sptr = head;
		SLNode fptr = head;
		
		while(fptr.next != null && fptr.next.next != null) {
			
			sptr = sptr.next;
			fptr = fptr.next.next;
		}
		
		return sptr;
	}
	
	public SLNode mergeSortedPair(SLNode h1, SLNode h2) {
		
		if(h1 == null)
			return h2;
		
		if(h2 == null)
			return h1;
		
		SLNode dummy = new SLNode(-1);
		
		SLNode ptr = dummy;
		
		while(true) {
			
			if(h1 ==  null) {
				ptr.next = h2;
				break;
			}
			
			if(h2 == null) {
				ptr.next = h1;
				break;
			}
			
			if(h1.data <= h2.data) {
				ptr.next = h1;
				h1 = h1.next;
			} else {
				
				ptr.next = h2;
				h2 = h2.next;
			}
			
			ptr = ptr.next;
			
		}
		
		return dummy.next;	
		
	}

	public static void main(String[] args) {
		
		LinkedList list = new LinkedList();
		
		list.createRandomListToSort();
		
		MergeSort mergeSort = new MergeSort();
		
		SLNode head = mergeSort.sort(list.head);
		
		list.printGivenList(head);

	}

}
