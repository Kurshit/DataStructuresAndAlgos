package com.kurshit.recursion.arraybased;

public class SumOfArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        System.out.println(total(arr, arr.length));
    }

    public static int total(int[] arr, int N) {
        return totalUtil(arr, N, 0);
    }

    public static int totalUtil(int[] arr, int N, int idx) {
        if(idx == N)
            return 0;

        return arr[idx] + totalUtil(arr, N, idx + 1);
    }
}
