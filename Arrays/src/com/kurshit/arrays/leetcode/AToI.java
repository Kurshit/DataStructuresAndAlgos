package com.kurshit.arrays.leetcode;

public class AToI {

	public int convertAToI(String str) {
		if (str == null || str.length() < 1)
			return 0;

		// trim white spaces
		str = str.trim();
		
		if(str.length() < 1) 
            return 0;
		
		char flag = '+';

		// check negative or positive
		int i = 0;
		if (str.charAt(0) == '-') {
			flag = '-';
			i++;
		} else if (str.charAt(0) == '+') {
			i++;
		}
		// use double to store result
		double result = 0;

		/*
		 *  We need to minus '0' from character. If we do not do it, it takes ascii value of it - str.charAt(i)
		 * 	
		 *  Example : result = 10 + '9'; // ---> 10 + 57 = 67 will be the result. Hence, to manage it, 0 is substracted i.e. 48 is subtracted from ascii
		 *  
		 *  ASCII : 
		 *  	0-9  : 48-57
		 *  	A-Z  : 65-90
		 *      a-z  : 97-122
		 *  	
		 * 		
		 */		
		
		while (i < str.length()  && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
			result = result * 10 + (str.charAt(i) - '0'); 
			i++;
		}

		if (flag == '-')
			result = -result;

		// handle max and min
		if (result > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;

		if (result < Integer.MIN_VALUE)
			return Integer.MIN_VALUE;

		return (int) result;
	}



	public static void main(String[] args) {
		
		AToI atoi = new AToI();
		String test = "    -15";
		
		System.out.println(atoi.convertAToI(test));
		test = "abcd 15";
		System.out.println(atoi.convertAToI(test));
		test = "15  abcja 17";
		System.out.println(atoi.convertAToI(test));
		test = "20 30";
		System.out.println(atoi.convertAToI(test));
		test = "15+24";
		System.out.println(atoi.convertAToI(test));
		test = "abcd 15";
		System.out.println(atoi.convertAToI(null));
		
		
		
	}

}
