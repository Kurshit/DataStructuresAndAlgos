package com.kurshit.backracking.basics.riya;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {

	public static void main(String[] args) {
			int N = 3;
			System.out.println(generateParanthesis(N));
			N = 2;
			System.out.println(generateParanthesis(N));


	}

	public static List<String> generateParanthesis(int N) {

			StringBuilder ans = new StringBuilder("");
			List<String> list = new ArrayList<>();
			generateParanthesis(ans, 0, 0, N, list);
			return list;

	}

	private static void generateParanthesis(StringBuilder ans, int open, int close, int N, List<String> resultList) {

			if (ans.length() == 2 * N) {
				resultList.add(ans.toString());
			}

			if (open < N) {
				//do
				ans.append("(");
				//recurse
				generateParanthesis(ans, open + 1, close, N, resultList);
				//Undo
				ans.deleteCharAt(ans.length() - 1);
			}

			if (close < open) {
				ans.append(")");
				generateParanthesis(ans, open, close + 1, N, resultList);
				ans.deleteCharAt(ans.length() - 1);
			}

	}

}
