package com.kurshit.graphs.directed.connectivity;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
 * Problem Source : https://www.geeksforgeeks.org/word-ladder-length-of-shortest-chain-to-reach-a-target-word/
 * Problem : Given a dictionary, and two words ‘start’ and ‘target’ (both of same length). 
 * Find length of the smallest chain from ‘start’ to ‘target’ if it exists, such that adjacent words in the chain only differ by 
 * one character and each word in the chain is a valid word i.e., it exists in the dictionary. 
 * It may be assumed that the ‘target’ word exists in dictionary and length of all dictionary words is same.
 * 
 *  Input: Dictionary = {POON, PLEE, SAME, POIE, PLEA, PLIE, POIN}
       start = TOON
       target = PLEA
		Output: 7
		TOON - POON - POIN - POIE - PLIE - PLEE - PLEA

		Input: Dictionary = {ABCD, EBAD, EBCD, XYZA}
		       Start = ABCV
		       End = EBAD
		Output: 4
		ABCV - ABCD - EBCD - EBAD
 */

public class WordLadder {

	public static void main(String[] args) {

		String start = "toon";
		String target = "plea";

		Set<String> D = new HashSet<>();
		D.add("poon");
		D.add("plee");
		D.add("same");
		D.add("poie");
		D.add("plea");
		D.add("plie");
		D.add("poin");

		System.out.println(getChainLength(start, target, D));

		start = "hit";
		target= "cog";
		D = new HashSet<>();
		D.add("hot");
		D.add("dot");
		D.add("dog");
		D.add("lot");
		D.add("log");
		D.add("cog");

		System.out.println(getChainLength(start, target, D));


	}

	/*
	 * Solution Approach : BFS
	 * 
	 * Start from the given start word.
		Push the word in the queue
		Run a loop until the queue is empty
		Traverse all words that adjacent (differ by one character) to it and push the word in a queue (for BFS)
		Keep doing so until we find the target word or we have traversed all words.
	 */

	public static int getChainLength(String start, String target, Set<String> D) {


		if(!D.contains(target))
			return 0;

		if(start.equals(target))
			return 0;

		Queue<String> queue = new LinkedList<>();

		queue.offer(start);
		int level = 0;

		while(!queue.isEmpty()) {

			level++;
			int sizeQ = queue.size();
			for(int i=0; i < sizeQ; i++) {
				
				char[] word = queue.poll().toCharArray();
				
				for(int pos = 0; pos < word.length; pos++) {

					char originalChar = word[pos];

					for(char c = 'a'; c <= 'z'; c++) {

						word[pos] = c;

						if(String.valueOf(word).equals(target))
							return level + 1;

						if(!D.contains(String.valueOf(word))) {
							continue;
						}

						D.remove(String.valueOf(word));
						queue.offer(String.valueOf(word));
					}

					word[pos] = originalChar;
				}
			}
		}

		return 0;
	}


}
