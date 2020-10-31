package com.kurshit.linkedlist.singlell;

public class SingleLinkedListSample {

	public static void main(String[] args) {
		
		LinkedList ll = new LinkedList();
		
		ll.add(10);
		ll.add(20);
		ll.add(30);
		ll.add(40);
		ll.add(50);
		ll.add(60);
		ll.add(70);
		ll.add(80);
		ll.add(90);
		ll.add(100);		
		
		ll.printSL();
		
		System.out.println("\nSize :" +ll.size());
		
		System.out.println("Size iteratively: " + ll.sizeRecursive(ll.head));
	}

}
