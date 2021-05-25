package com.kurshit.linkedlist.singlell.faqs;

import com.kurshit.linkedlist.singlell.LinkedList.SLNode;

public class ReverseSLLInGroupSizeK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public SLNode reverseK(SLNode head, int K) {
		
		SLNode curr = head;
		SLNode next = null;
		SLNode prev = null;
		
		int count = 0;
		
		while(curr != null && count != K) {			
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;
		}
		
		if(next != null) {
			head.next = reverseK(next, K);
		}
		
		
		return prev;
	}

}
