package com.kurshit.linkedlist.singlell.faqs;

import com.kurshit.linkedlist.singlell.LinkedList;
import com.kurshit.linkedlist.singlell.LinkedList.SLNode;

public class LoopInSLL {

	
	
	public boolean hasLoop(SLNode head) {

		if(head == null)
			return false;

		SLNode fptr = head;
		SLNode sptr = head;

		while(fptr != null && fptr.next != null) {

			fptr = fptr.next.next;
			sptr = sptr.next;

			if(fptr == sptr)
				return true;

		}

		return false;	

	}

	/*
	 *  Looped node is 60 -- 
	 *  
	 *   10 -> 20 -> 30 -> 40 -> 50 -> 60 ->  70 -> 
	 *   								^			80 
	 *   								|		    |
	 *   							   100	 <-	   90
	 *   
	 *  
	 */

	/*
	 * Following method would not return first node in loop. It returns any node that may be part of this loop
	 */

	public SLNode loopedNode(SLNode head) {

		if(head == null)
			return null;

		SLNode fptr = head;
		SLNode sptr = head;

		while(fptr != null && fptr.next != null) {

			fptr = fptr.next.next;
			sptr = sptr.next;

			if(fptr == sptr)
				return fptr;

		}

		return null;

	}
	
	public int noOfNodesInLoop(SLNode head) {
		
		if(head == null)
			return 0;
		
		SLNode sptr = head;
		SLNode fptr = head;
		int count = 0;
		while(fptr != null && fptr.next != null) {
			
			sptr = sptr.next;
			fptr = fptr.next.next;
			
			if(fptr == sptr ) {
				
				SLNode temp = sptr;
				
				while(sptr.next != temp) {
					count++;
					sptr = sptr.next;
				}
				
				return count + 1;
			}
			
			
		}
		
		return count;
		
	}
	
	/*
	 * Following method would return first node in loop. The relation of moving slowPtr and fastPtr to detect a loop is such that, 
	 * When loop is detected, fptr would always be as far from first node in loop as head of original linked list. 
	 * Thus, after detecting loop, set sptr = head and increase ftpr and sptr by one till they both meet. The point where they meet is first node in loop.
	 * 
	 */

	public SLNode firstLoopedNode(SLNode head) {

		if(head == null)
			return null;

		SLNode fptr = head;
		SLNode sptr = head;
		boolean hasLoop = false;

		while(fptr != null && fptr.next != null) {

			fptr = fptr.next.next;
			sptr = sptr.next;

			if(fptr == sptr) {
				hasLoop = true;
				break;
			}

		}
		
		if(hasLoop) {
			
			sptr = head;
			
			while(sptr != fptr) {
				sptr = sptr.next;
				fptr = fptr.next;
			}
			
			return sptr;
			
		}
		
		return null;
		

	}
	
	/*
	 * Following method will use code to find first node in loop. Using that logic, stop the ptr right before first node is detected. 
	 * Set that fptr = null
	 */
	
	public void removeLoop(SLNode head) {

		if(head == null)
			return;

		SLNode fptr = head;
		SLNode sptr = head;
		boolean hasLoop = false;

		while(fptr != null && fptr.next != null) {

			fptr = fptr.next.next;
			sptr = sptr.next;

			if(fptr == sptr) {
				hasLoop = true;
				break;
			}

		}
		
		if(hasLoop) {
			
			sptr = head;
			
			while(sptr.next != fptr.next) {
				sptr = sptr.next;
				fptr = fptr.next;
			}
			
			fptr.next = null;		
			
		}	
		

	}

	public static void main(String[] args) {

		LinkedList ll = new LinkedList();

		ll.createSampleSLL1();

		LoopInSLL loop = new LoopInSLL();

		System.out.println(loop.hasLoop(ll.head));

		ll.clear();

		ll.createFiveLoopSLL();

		System.out.println(loop.hasLoop(ll.head));

		System.out.println(loop.loopedNode(ll.head).data);
		
		System.out.println("No of nodes in Five Looped LL :" + loop.noOfNodesInLoop(ll.head));
		
		System.out.println("First looped node : " +loop.firstLoopedNode(ll.head).data);
		
		
		
		
		loop.removeLoop(ll.head);
		
		System.out.println("After removal of loop :");
		ll.printSL();
		
		ll.clear();
		
		ll.createSevenLoopSLL();
		
		System.out.println();
		
		System.out.println("----------------------------------------------");
		
		System.out.println(loop.hasLoop(ll.head));

		System.out.println(loop.loopedNode(ll.head).data);
		
		System.out.println("First looped node : " +loop.firstLoopedNode(ll.head).data);

	
		
		

	}

}
