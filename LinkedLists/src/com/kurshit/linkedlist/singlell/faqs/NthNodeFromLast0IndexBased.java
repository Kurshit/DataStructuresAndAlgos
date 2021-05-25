package com.kurshit.linkedlist.singlell.faqs;

import com.kurshit.linkedlist.singlell.LinkedList.SLNode;

public class NthNodeFromLast0IndexBased {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static int getNode(SLNode head, int positionFromTail) {

		if(head == null)
			return 0;

		SLNode ptr = head;
		SLNode rptr = head;
		int count = 0;

		if(positionFromTail == 0) {
			while(ptr.next != null) {
				ptr = ptr.next;
			}

			return ptr.data;
		}

		while(count != positionFromTail) {

			ptr = ptr.next;

			if(ptr == null)
				return 0;

			count++;
		}

		
		//this should be ptr.next;
		while(ptr.next != null) {
			ptr = ptr.next;
			rptr = rptr.next;
		}

		return rptr.data;
	}
}
