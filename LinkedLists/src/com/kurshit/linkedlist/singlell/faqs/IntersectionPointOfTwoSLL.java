package com.kurshit.linkedlist.singlell.faqs;

import com.kurshit.linkedlist.singlell.LinkedList;
import com.kurshit.linkedlist.singlell.LinkedList.SLNode;

public class IntersectionPointOfTwoSLL {

	static int findMergeNode(SLNode head1, SLNode head2) {

		int h1Size = getSize(head1);
		int h2Size = getSize(head2);
		int result = 0;
		if (h2Size > h1Size) {
			result = findMergedNodeUtil(head2, head1, h2Size - h1Size);
		} else {
			result = findMergedNodeUtil(head1, head2, h1Size - h2Size);
		}
		return result;
	}

	public static int findMergedNodeUtil(SLNode h1, SLNode h2, int d) {

		int count = 0;

		while (count != d) {
			h1 = h1.next;
			count++;
		}

		while (h1 != h2) {
			h1 = h1.next;
			h2 = h2.next;
		}

		return h1.data;
	}

	public static int getSize(SLNode h1) {

		int count = 0;

		while (h1 != null) {
			h1 = h1.next;
			count++;
		}

		return count;
	}

	public static void main(String[] args) {

		LinkedList l1 = new LinkedList();

		l1.createIntersectionList1();
		LinkedList l2 = new LinkedList();
		l2.createTwoIntersectingLists(l1.head);

		System.out.println(findMergeNode(l1.head, l2.head));

	}

}
