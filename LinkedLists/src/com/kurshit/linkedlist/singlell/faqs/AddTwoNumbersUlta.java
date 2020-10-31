package com.kurshit.linkedlist.singlell.faqs;

import com.kurshit.linkedlist.singlell.LinkedList;
import com.kurshit.linkedlist.singlell.LinkedList.SLNode;

/*
 *  Addtwo integers represented by SLL :
 *  
 *   Input: List1: 5->6->3  // represents number 365
 *   List2: 8->4->2 //  represents number 248
 *	 Output: Resultant list: 3->1->6  // represents number 613
 *
 *
 *	 Input: List1: 7->5->9->4->6  // represents number 64957
 *   List2: 8->4 //  represents number 48
 *	 Output: Resultant list: 5->0->0->5->6  // represents number 65005
 *  
 *    O(m+n)
 *  
 */

public class AddTwoNumbersUlta {


	SLNode res;

	public SLNode addTwoUlteNumbers(SLNode h1, SLNode h2) {
		
		if(h1 == null)
			return h2;
		
		if(h2 == null)
			return h1;
		
		int carry = 0;
		
		while(h1 != null || h2 != null) {
			
			int first = h1 != null? h1.data : 0;
			
			int second = h2 != null ? h2.data :0;
			
			int sum = carry + first + second;
			
			if(sum >= 10)
				carry = 1;
			else 
				carry = 0;
			
			sum = sum % 10;
			
			addLast(sum);
			
			if(h1 != null)
				h1 = h1.next;
			
			if(h2 != null)
				h2 = h2.next;
			
			
		}
		
		if(carry > 0) {
			addLast(carry);
		}
		
		return res;
	}
	
	public void addLast(int sum) {
		
		SLNode ptr = res;
		
		if(res == null) {
			res = new SLNode(sum);
			return;
		}
		
		while(ptr.next != null) {
			ptr = ptr.next;
		}
		
		ptr.next = new SLNode(sum);		
		
	}

	
	public static void main(String[] args) {

		LinkedList sll1 = new LinkedList();

		sll1.createIntegerToAddSLL1();

		LinkedList sll2 = new LinkedList();

		sll2.createIntegerToAddSLL2();

		AddTwoNumbersUlta add = new AddTwoNumbersUlta();

		SLNode result = add.addTwoUlteNumbers(sll1.head, sll2.head);

		sll1.printGivenList(result);

	}

}
