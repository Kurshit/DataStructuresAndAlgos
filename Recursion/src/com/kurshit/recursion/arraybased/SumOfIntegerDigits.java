package com.kurshit.recursion.arraybased;

public class SumOfIntegerDigits {
    public static void main(String[] args) {
        int N = 123456;
        System.out.println(total(N));
    }

    public static int total(int N) {

        if(N <= 0)
            return 0;

        return N % 10 + total(N/10);

    }
}
