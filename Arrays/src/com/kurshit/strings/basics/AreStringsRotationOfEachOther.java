package com.kurshit.strings.basics;

public class AreStringsRotationOfEachOther {

	public static void main(String[] args) {
		
		
		String s1 = "ABACD";
		String s2 = "CDABA"; 
		
		System.out.println(areStringsRotationsOfEachOther(s1, s2));
	
	}
	
	public static boolean areStringsRotationsOfEachOther(String str1, String str2) {
		
		if(str1.length() != str2.length()) {
			return false;
		}
		
		String temp = str1 + str1;
		
		if(temp.indexOf(str2) == -1) {
			return false;
		} else {
			return true;
		}	
		
	}

}
