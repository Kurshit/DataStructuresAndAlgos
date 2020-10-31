package com.kurshit.linkedlist.singlell.faqs;

import com.kurshit.linkedlist.singlell.LinkedList;
import com.kurshit.linkedlist.singlell.LinkedList.SLNode;

public class MergeTwoSortedLL {


	public SLNode merge(SLNode head1, SLNode head2) {

		if(head1 == null)
			return head2;

		if(head2 == null)
			return head1;

		SLNode dummy = new SLNode(-1);

		SLNode ptr = dummy;

		while(head1 != null || head2 != null) {

			if(head1 == null) {
				ptr.next = head2;
				break;			
			}

			if(head2 == null) {
				ptr.next = head1;
				break;
			}

			if(head1.data > head2.data) {
				ptr.next = head2;
				head2 = head2.next;
			} else {
				ptr.next = head1;
				head1 = head1.next;
			}

			ptr = ptr.next;			

		}

		return dummy.next;

	}
	
	public SLNode mergeRecursively(SLNode head1, SLNode head2) {
		
		if(head1 == null )
			return head2;
		
		if(head2 == null)
			return head1;
		
		if(head1.data < head2.data) {
			head1.next = mergeRecursively(head1.next, head2);
			return head1;
		} 
		else
		{
			head2.next = mergeRecursively(head1, head2.next);
			return head2;
		}
		
		
		
	}

	public static void main(String[] args) {

		LinkedList list1 = new LinkedList();

		list1.createSorted1();

		LinkedList list2 = new LinkedList();

		list2.createSorted2();
		
		MergeTwoSortedLL merge = new MergeTwoSortedLL();
		
		
		SLNode result2 = merge.mergeRecursively(list1.head, list2.head);
		
		list1.printGivenList(result2);


	}

}
