package com.kurshit.recursion.strings;

/*
    Statment: Given a string s, check if it is palindrome
 */

public class CheckPalindrome {
    public static void main(String[] args) {

        String s = "NITIN";
        System.out.println(isPalindrome(s));

        s = "NITIIN";
        System.out.println(isPalindrome(s));

    }

    public static boolean isPalindrome(String s) {
        return isPalindromeUtil(s, 0, s.length()-1);
    }

    public static boolean isPalindromeUtil(String s, int i, int j) {
        if(i >= j) {
            return true;
        }

        if(s.charAt(i) != s.charAt(j))
            return false;

        return isPalindromeUtil(s, i + 1, j-1);
    }
}
