package com.kurshit.linkedlist.singlell;

public class LinkedList {

	public SLNode head;

	public static class SLNode {
		public SLNode next;
		public int data;

		public SLNode(int data) {
			this.data = data;
		}
	}

	/*
	 * Appends in the end O(n)
	 */
	public void add(int key) {

		SLNode ptr = head;

		if(ptr ==  null) {
			head = new SLNode(key);
			return;
		}	

		while(ptr.next != null) {
			ptr = ptr.next;
		}

		ptr.next = new SLNode(key);	

	}

	public int size() {

		int count = 0;

		SLNode ptr = head;

		if(ptr == null)
			return 0;

		while(ptr != null) {
			count++;
			ptr = ptr.next;
		}

		return count;

	}

	public int sizeRecursive(SLNode head) {

		if(head == null)
			return 0;

		return 1 + sizeRecursive(head.next);



	}

	public void printSL() {
		SLNode ptr = head;

		while(ptr != null)
		{
			System.out.print(ptr.data + " ");
			ptr = ptr.next;
		}

		System.out.println();

	}

	public void printGivenList(SLNode head) {

		if(head == null)
			return;

		while(head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}

		System.out.println();
	}

	public void clear() {
		head = null;
	}


	public void createSampleSLL1() {

		add(10);
		add(20);
		add(30);
		add(40);
		add(50);
		add(60);
		add(70);
		add(80);
		add(90);
		add(100);		

	}
	
	public void createSampleComponentTest() {

		add(0);
		add(1);
		add(2);
		add(3);
		
	}

	public void createOneNodeSLL() {

		add(10);


	}

	public void createTwoNodeSLL() {

		add(10);
		add(20);

	}

	public void createFifteenNodeSLL() {

		add(10);
		add(20);
		add(30);
		add(40);
		add(50);
		add(60);
		add(70);
		add(80);
		add(90);
		add(100);
		add(110);
		add(120);
		add(130);
		add(140);
		add(150);
	}

	public void createSortedDuplicateNodesList() {

		add(10);
		add(20);
		add(20);
		add(20);
		add(30);
		add(40);
		add(50);
		add(50);
		add(50);
		add(50);
		add(60);
		add(60);
		add(60);
		add(60);
		add(60);
	}

	public void createUnSortedDuplicateNodesList() {

		add(80);
		add(20);
		add(40);
		add(10);
		add(30);
		add(40);
		add(80);
		add(50);
		add(70);
		add(20);
		add(5);
		add(50);
		add(70);
		add(90);
		add(20);
	}

	public void createIntersectionList1() {

		add(1);
		add(2);
		add(3);
		add(4);
		add(6);
		add(20);
	}
	
	public void createTwoIntersectingLists(SLNode newHead) {
		add(100);
		add(200);
		head.next.next = newHead.next.next.next.next;
	}

	public void createIntersectionList2() {

		add(2);
		add(4);
		add(6);
		add(8);

	}

	public void createIntersectionList3() {

		add(10);
		add(20);
		add(30);
		add(40);
		add(50);
		add(60);
		add(80);
		add(180);
		add(280);
		add(380);
		add(480);
		add(580);
		add(680);
		
	}

	public void createIntersectionList4() {

		add(5);
		add(10);
		add(15);
		add(20);
		add(25);
		add(30);
		add(35);
		add(40);
		add(45);
		add(50);
		add(55);
		add(60);
		add(65);
		add(70);
		add(75);
		add(80);
		add(85);
		

	}

	
	public void createSevenNodeSLL() {

		add(10);
		add(20);
		add(30);
		add(40);
		add(50);
		add(60);
		add(70);

	}

	public void createFiveLoopSLL() {

		add(10);
		add(20);
		add(30);
		add(40);
		add(50);
		add(60);
		add(70);
		add(80);
		add(90);
		add(100);

		SLNode ptr = head;
		SLNode loopPtr;
		while(ptr.data != 60) {
			ptr = ptr.next;
			loopPtr = ptr;		
		}

		loopPtr = ptr;

		while(ptr.next != null) {
			ptr = ptr.next;
		}

		ptr.next = loopPtr;		

	}

	public void createSortedDuplicateSLL() {

		add(10);
		add(20);
		add(30);
		add(30);
		add(30);
		add(40);
		add(50);
		add(50);
		add(50);
		add(60);
		add(70);
		add(70);
		add(70);
		add(70);
		add(70);
	}

	public void createIntegerToAddSLL1() {
		add(7);
		add(4);
		add(5);
	}

	public void createIntegerToAddSLL2() {
		add(2);
		add(3);
		add(6);
	}

	public void createIntegerToAddSLL3() {
		add(6);
		add(1);
		add(4);
	}


	public void createSortedList1() {
		add(2);
		add(8);
		add(15);
	}


	public void createSortedList2() {
		add(4);
		add(9);
		add(13);
	}

	public void multiplyNum1() {
		add(4);
		add(9);
		add(7);
	}

	public void multiplyNum2() {
		add(1);
		add(9);		
	}

	public void createIntegerWithSize3ToAddSLL3() {
		add(9);
		add(9);
		add(9);
	}

	public void createIntegerWithSize2ToAddSLL4() {
		add(1);
		add(8);

	}

	public void createSevenLoopSLL() {

		add(10);
		add(20);
		add(30);
		add(40);
		add(50);
		add(60);
		add(70);
		add(80);
		add(90);
		add(100);

		SLNode ptr = head;
		SLNode loopPtr;
		while(ptr.data != 30) {
			ptr = ptr.next;
			loopPtr = ptr;		
		}

		loopPtr = ptr;

		while(ptr.next != null) {
			ptr = ptr.next;
		}

		ptr.next = loopPtr;		

	}

	public void createSorted1() {
		add(5);
		add(8);
		add(12);
		add(16);
	}

	public void createSorted2() {
		add(2);
		add(4);
		add(9);
		add(18);
	}

	public void createSorted3() {
		add(1);
		add(3);
		add(15);
		add(25);
	}

	public void createSorted4() {
		add(0);
		add(7);
		add(11);
		add(23);
	}
	
	public void createSorted5() {
		add(1);
		add(2);
		add(4);
		
		/*
		 *   1 --> 2 --> 4
		 */	
	}
	
	public void createSorted6() {
		add(1);
		add(3);
		add(4);
		
		/*
		 *   1 --> 3 --> 4
		 */	
	}


	public void createRandomListToSort() {

		add(80);
		add(20);
		add(30);
		add(70);
		add(90);
		add(10);
		add(50);
		add(60);
		add(100);
		add(160);
		add(120);
		add(5);

	}


}
