package com.kurshit.arrays.binarysearch.median;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianInStreamOfIntegers {

	private Queue<Integer> minHeap, maxHeap;


	public MedianInStreamOfIntegers() {
		minHeap = new PriorityQueue<>();
		maxHeap = new PriorityQueue<>(Collections.reverseOrder());

	}

	void add(int num) {
		
		
		if(maxHeap.isEmpty() || num < maxHeap.peek()) {
			maxHeap.offer(num);
		} else {
			minHeap.offer(num);
		}
		
		if(maxHeap.size() > minHeap.size() + 1) {
			minHeap.offer(maxHeap.poll());
		} else if(minHeap.size() > maxHeap.size() + 1) {
			maxHeap.offer(minHeap.poll());
		}
		
		
		
//		if (!minHeap.isEmpty() && num < minHeap.peek()) {
//			
//			maxHeap.offer(num);
//			if (maxHeap.size() > minHeap.size() + 1) {
//				minHeap.offer(maxHeap.poll());
//			}
//		} else {
//		
//			minHeap.offer(num);
//			if (minHeap.size() > maxHeap.size() + 1) {
//				maxHeap.offer(minHeap.poll());
//			}
//		}
	}

	double getMedian() {
		
		int median;
		
		if (maxHeap.size() > minHeap.size() ) {
			median = maxHeap.peek();
		} else if (minHeap.size() > maxHeap.size()) {
			median = minHeap.peek();
		} else {
			median = (minHeap.peek() + maxHeap.peek()) / 2; 
		}
		return median;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
