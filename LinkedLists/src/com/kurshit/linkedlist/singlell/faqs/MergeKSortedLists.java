package com.kurshit.linkedlist.singlell.faqs;

import java.util.PriorityQueue;
import java.util.Stack;

import com.kurshit.linkedlist.singlell.LinkedList;
import com.kurshit.linkedlist.singlell.LinkedList.SLNode;

public class MergeKSortedLists {

	/* Let n be size of each list . So mergeTwoSorted will take O(k*n) (As all lists are of same size n and there are k such lists. Otherwise it would have been - O(l+m+n+o+p..). 
	 * Thus, final TC - O(k*n). and SC : O(kn); 9Ref from Leetcode.
	 * 
	 */
	
	public SLNode mergerKSortedListsUsingStack(SLNode[] headers) {

		Stack<SLNode> stack = new Stack<>();

		for(int i=0; i < headers.length; i++) {
			stack.push(headers[i]);
		}

		while(stack.size() > 1) {

			SLNode head1 = stack.pop();
			SLNode head2 = stack.pop();

			SLNode result = mergeTheTwo(head1,  head2);

			stack.push(result);

		}

		return stack.pop();



	}
	
	/*
	 * This is supposedly Divide and Conquer appraoch and is told to take O(NlogK) TC and O(1) space:
	 * 
	 *  According to me it takes O(nk). Cuz search space does not get divided in halves any way
	 */
	
	public SLNode mergeKListsWithoutStack(SLNode[] headers) {

		int last = headers.length - 1;


		while(last !=0) {			
			int first = 0;
			headers[first] = mergeTheTwo(headers[first], headers[last]);
			last--;
		}

		return headers[0];


	}
	
	SLNode result =  null;
	
	public SLNode mergeUsingPriorityQueue(SLNode[] headers) {
		
		// we need to override compare method of Comparator to provide manual sorting
		
		PriorityQueue<SLNode> pq = new PriorityQueue<>((o1,o2) -> o1.data - o2.data);		
		
		/* Other ways of writing this - /*

		/*
		 *  Comparator<SLNode> com = (o1,o2) -> o1.data - o2.data;
		 *  PriorityQueue<SLNode> pq = new PriorityQueue<>(com);
		 */
		
		/*		PriorityQueue<SLNode> pq = new PriorityQueue<>(new Comparator<SLNode> () {

			@Override
			public int compare(SLNode o1, SLNode o2) {
				
				return o1.data - o2.data;
			}
			
		});
	   */
		
		
		for(int i=0; i< headers.length; i++) {
			pq.offer(headers[i]);
		}
		
		
		while(!pq.isEmpty()) {
			
			SLNode temp = pq.poll();
			
			if(temp.next != null) {
				pq.offer(temp.next);
			}
			
			temp.next = null;
			addLast(temp);			
			
		}
		
		return result;	
		
	}
	
	public void addLast(SLNode temp) {
		
		if(result == null) {
			result = temp;
			return;
		}
		
		SLNode ptr = result;
		while(ptr.next != null) {
			ptr = ptr.next;
		}
		
		ptr.next = temp;
	}

	public SLNode mergeTheTwo(SLNode head1, SLNode head2) {
		if(head1 == null)
			return head2;

		if(head2 == null)
			return head1;

		SLNode dummy = new SLNode(-1);

		SLNode ptr = dummy;

		while(ptr != null) {

			if(head1 == null) {
				ptr.next = head2;
				break;
			}

			if(head2 == null) {
				ptr.next = head1;
				break;
			}

			if(head1.data < head2.data) {
				ptr.next = head1;
				head1 = head1.next;
			} else {
				ptr.next = head2;
				head2 = head2.next;
			}

			ptr = ptr.next;			
		}

		return dummy.next;

	}

	public static void main(String[] args) {

		LinkedList list1 = new LinkedList();

		list1.createSorted1();

		LinkedList list2 = new LinkedList();

		list2.createSorted2();

		LinkedList list3 = new LinkedList();

		list3.createSorted3();

		LinkedList list4 = new LinkedList();

		list4.createSorted4();

		SLNode[] kLists = {list1.head, list2.head,list3.head, list4.head};

		MergeKSortedLists ksorted = new MergeKSortedLists();

		//SLNode finalList = ksorted.mergeKListsWithoutStack(kLists);
		
		SLNode finalList = ksorted.mergeUsingPriorityQueue(kLists);
		
		list1.printGivenList(finalList);

	}

}
