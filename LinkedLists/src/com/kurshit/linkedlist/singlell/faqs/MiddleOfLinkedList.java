package com.kurshit.linkedlist.singlell.faqs;

import com.kurshit.linkedlist.singlell.LinkedList;
import com.kurshit.linkedlist.singlell.LinkedList.SLNode;

public class MiddleOfLinkedList {

	public SLNode middleOfSLL(SLNode head) {

		SLNode slowPtr = head;
		SLNode fastPtr = head;

		if(slowPtr == null)
			return null;

		if(slowPtr.next == null)
			return slowPtr;

		while(fastPtr.next != null && fastPtr.next.next != null) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
		}

		return slowPtr;
	}

	public SLNode middleOfSLLRecursively(SLNode head) {

		return middleOfSLLRecursively(head, new MaxCount(),0);

	}
	
	

	public SLNode middleOfSLLRecursively(SLNode head, MaxCount max, int count) {

		if(head == null)
			return null;
		count= count + 1;
		max.maxCount = count;
		SLNode result =middleOfSLLRecursively(head.next, max, count);
		
		if(result != null)
			return result;
		
		if(count == (max.maxCount/2)+1)
			return head;
		else {
			return null;
		}
	}


	public static void main(String[] args) {

		LinkedList ll = new LinkedList();

		ll.createSampleSLL1();

		MiddleOfLinkedList mid = new MiddleOfLinkedList();

		SLNode result = mid.middleOfSLL(ll.head);
		if(result != null)
			System.out.println(result.data);

		ll.clear();

		ll.createOneNodeSLL();

		result = mid.middleOfSLL(ll.head);

		if(result != null)
			System.out.println(result.data);

		ll.clear();

		ll.createTwoNodeSLL();

		result = mid.middleOfSLL(ll.head);

		if(result != null)
			System.out.println(result.data);

		ll.clear();

		ll.createSevenNodeSLL();

		result = mid.middleOfSLL(ll.head);

		if(result != null)
			System.out.println(result.data);
		
		result = mid.middleOfSLLRecursively(ll.head);

		if(result != null)
			System.out.println("Recursively : " + result.data);
		
		
		


	}

}

class MaxCount {
	int maxCount;
}