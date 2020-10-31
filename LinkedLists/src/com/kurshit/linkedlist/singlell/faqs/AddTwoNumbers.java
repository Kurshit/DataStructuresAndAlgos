package com.kurshit.linkedlist.singlell.faqs;

import com.kurshit.linkedlist.singlell.LinkedList;
import com.kurshit.linkedlist.singlell.LinkedList.SLNode;

public class AddTwoNumbers {

	SLNode result; 
	int carry;	
	
	public void addFirst(int key) {
		
		SLNode newNode = new SLNode(key);
		
		SLNode ptr = result;
		if(ptr == null) {
			result = newNode;
			return;
		}
		
		newNode.next = result;
		result = newNode;			
	}

	// Adds two linked lists of same size represented by 
	// head1 and head2 and returns head of the resultant 
	// linked list. Carry is propagated while returning 
	// from the recursion 
	void addSameSize(SLNode head1, SLNode head2) 
	{ 
		// Since the function assumes linked lists are of 
		// same size, check any of the two head pointers 
		if (head1 == null) 
			return; 

		// Recursively add remaining nodes and get the carry 
		addSameSize(head1.next, head2.next); 

		// add digits of current nodes and propagated carry 
		int sum = head1.data + head2.data + carry; 
		carry = sum / 10; 
		sum = sum % 10; 

		// Push this to result list 
		addFirst(sum); 

	} 

	SLNode cur; 

	// This function is called after the smaller list is 
	// added to the bigger lists's sublist of same size. 
	// Once the right sublist is added, the carry must be 
	// added to the left side of larger list to get the 
	// final result. 
	void propogatecarry(SLNode head1) 
	{ 
		// If diff. number of nodes are not traversed, add carry 
		if (head1 != cur) 
		{ 
			propogatecarry(head1.next); 
			int sum = carry + head1.data; 
			carry = sum / 10; 
			sum %= 10; 

			// add this node to the front of the result 
			addFirst(sum); 
		} 
	} 

	int getSize(SLNode head) 
	{ 
		int count = 0; 
		while (head != null) 
		{ 
			count++; 
			head = head.next; 
		} 
		return count; 
	} 

	// The main function that adds two linked lists 
	// represented by head1 and head2. The sum of two 
	// lists is stored in a list referred by result 
	SLNode addTwoNumbers(SLNode head1, SLNode head2) 
	{ 
		// first list is empty 
		if (head1 == null) 
		{ 
			return result = head2;			 
		} 

		// first list is empty 
		if (head2 == null) 
		{
			return result = head1;			 
		} 

		int size1 = getSize(head1); 
		int size2 = getSize(head2); 

		// Add same size lists 
		if (size1 == size2) 
		{ 
			addSameSize(head1, head2); 
		} 
		else
		{ 
			// First list should always be larger than second list. 
			// If not, swap pointers 
			if (size1 < size2) 
			{ 
				SLNode temp = head1; 
				head1 = head2; 
				head2 = temp; 
			} 
			int diff = Math.abs(size1 - size2); 

			// move diff. number of nodes in first list 
			SLNode temp = head1; 
			while (diff-- >= 0) 
			{ 
				cur = temp; 
				temp = temp.next; 
			} 

			// get addition of same size lists 
			addSameSize(cur, head2); 

			// get addition of remaining first list and carry 
			propogatecarry(head1); 
		} 
		// if some carry is still there, add a new node to 
		// the front of the result list. e.g. 999 and 87 
		if (carry > 0) 
			addFirst(carry);
		
		return result;

	} 

	// Driver program to test above functions 
	public static void main(String args[]) 
	{ 
		AddTwoNumbers addThem = new AddTwoNumbers(); 
		
		LinkedList head1 = new LinkedList();
		LinkedList head2 = new LinkedList();
		
		// 999 + 18 = 1017
		
		head1.createIntegerWithSize3ToAddSLL3();
		head2.createIntegerWithSize2ToAddSLL4();
		
				
		SLNode result = addThem.addTwoNumbers(head1.head, head2.head); 

		head1.printGivenList(result); 
	} 
}
