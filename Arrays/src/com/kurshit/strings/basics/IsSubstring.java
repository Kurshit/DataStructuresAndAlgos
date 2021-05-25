package com.kurshit.strings.basics;

public class IsSubstring {

	public static void main(String[] args) {
		String str = "olalalaolao";
		String target = "lalao";
		System.out.println(substring(str, target));
		str.indexOf("ch");

	}
	
	//The solution is flawed
	
	public static int substring(String str, String target) {

		int t = 0;
		int len = str.length();
		int i;

		for (i = 0; i < len; i++) {
			if (t == target.length())
				break;
			if (str.charAt(i) == target.charAt(t))
				t++;
			else
				t = 0;
		}

		return t < target.length() ? -1 : i - t;
	}
}
