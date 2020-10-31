package com.kurshit.linkedlist.singlell.faqs;

import com.kurshit.linkedlist.singlell.LinkedList;
import com.kurshit.linkedlist.singlell.LinkedList.SLNode;

public class LengthOfLoopInSLL {

	public int lengthOfLoopSLL(SLNode head) {

		if(head == null)
			return 0;

		SLNode fptr = head;
		SLNode sptr = head;

		while(fptr != null && fptr.next != null) {

			fptr = fptr.next.next;
			sptr = sptr.next;

			if(fptr == sptr) {
				SLNode temp = fptr;
				int count = 0;
				while(temp.next != fptr) {
					temp = temp.next;
					count++;
				}

				return count;
			}


		}	


		return 0;

	}

	public static void main(String[] args) {

		LinkedList ll = new LinkedList();

		ll.createSampleSLL1();

		LengthOfLoopInSLL lengthLoop = new LengthOfLoopInSLL();
		
		System.out.println(lengthLoop.lengthOfLoopSLL(ll.head));

		ll.clear();

		ll.createFiveLoopSLL();

		System.out.println(lengthLoop.lengthOfLoopSLL(ll.head));

		


	}

}
