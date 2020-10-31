package com.kurshit.linkedlist.singlell.faqs;

import com.kurshit.linkedlist.singlell.LinkedList;
import com.kurshit.linkedlist.singlell.LinkedList.SLNode;

public class UnionOfSLLSorted {

	public SLNode union(SLNode h1, SLNode h2) {

		if(h1 == null || h2 == null)
			return null;

		SLNode res = new SLNode(-1);
		SLNode ptr = res;

		while(h1 != null || h2 != null) {

			if(h1 == null) {
				ptr.next = h2;
				break;			
			}

			if(h2 == null) {
				ptr.next = h1;
				break;
			}

			if(h1.data > h2.data) {
				ptr.next = h2;
				h2 = h2.next;
			} else if(h1.data < h2.data){
				ptr.next = h1;
				h1 = h1.next;
			} else {
				ptr.next = h1;
				h1 = h1.next;
				h2 = h2.next;
			}

			ptr = ptr.next;			

		}

		return res.next;




	}

	public static void main(String[] args) {


		LinkedList list1 = new LinkedList();

		list1.createIntersectionList1();

		//h1 -  1  2  3  4  6  20
		//h2 -  2 4 6 8
		//Res - 2 4 6

		LinkedList list2 = new LinkedList();

		list2.createIntersectionList2();

		UnionOfSLLSorted uni = new UnionOfSLLSorted();

		SLNode res = uni.union(list1.head, list2.head);

		list1.printGivenList(res);

		list1.clear();
		list2.clear();

		list1.createIntersectionList3();
		list2.createIntersectionList4();
		res = uni.union(list1.head, list2.head);
		list1.printGivenList(res);




	}

}
