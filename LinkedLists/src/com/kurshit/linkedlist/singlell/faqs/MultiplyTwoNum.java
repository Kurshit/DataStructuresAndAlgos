package com.kurshit.linkedlist.singlell.faqs;

import com.kurshit.linkedlist.singlell.LinkedList;
import com.kurshit.linkedlist.singlell.LinkedList.SLNode;

public class MultiplyTwoNum {

	public int multiply(SLNode h1, SLNode h2) {

		if(h1 == null && h2 == null)
			return 0;

		int num1 = 0;
		int num2 = 0;


		while(h1 != null || h2 != null) {

			if(h1 != null) {
				num1 = num1 * 10 + h1.data;
				h1 = h1.next;
			}
			
			if(h2 != null) {
				num2 = num2 * 10 + h2.data;
				h2 = h2.next;
			}

		}

		
		return num1 * num2;	
	}

	public static void main(String[] args) {

		LinkedList list1 = new LinkedList();

		list1.multiplyNum1();

		LinkedList list2 = new LinkedList();

		list2.multiplyNum2();

		// 497 * 19 = 9443

		MultiplyTwoNum mul = new MultiplyTwoNum();

		System.out.println(mul.multiply(list1.head, list2.head));
	}

}
