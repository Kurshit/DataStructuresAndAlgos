package com.kurshit.recursion.arraybased;

/*
    Statement : Find maximum in an array using recursion
 */

public class MaximumInArray {

    public static void main(String[] args) {

        int[] arr = {1, 10, 9, 5, 7, 50, -1};
        MaximumInArray max = new MaximumInArray();
        System.out.println(max.getMax(arr));
        System.out.println(max.getMaxWithoutVar(arr));
        System.out.println();
        int[] arr1 = {71, 10, 9, 5, 7, 50, -1};
        System.out.println(max.getMax(arr1));
        System.out.println(max.getMaxWithoutVar(arr1));
        System.out.println();
        int[] arr2 = {71, 10, 9, 5, 7, 50, 81};
        System.out.println(max.getMax(arr2));
        System.out.println(max.getMaxWithoutVar(arr2));
        System.out.println();
        int[] arr3 = {71, 10, 9, 105, 7, 50, -1};
        System.out.println(max.getMax(arr3));
        System.out.println(max.getMaxWithoutVar(arr3));
        System.out.println();
        int[] arr4 = {71, 1, 9, 5, 7, 50, 71};
        System.out.println(max.getMax(arr4));
        System.out.println(max.getMaxWithoutVar(arr4));
        System.out.println();

    }

    int max;

    /*
           Approach 1 : Using extra var max
     */
    public int getMax(int[] arr) {
        max = Integer.MIN_VALUE;
        getMaxUtil(arr, arr.length, 0);
        return max;
    }

    private void getMaxUtil(int[] arr, int N, int idx) {

        if (idx == N)
            return;

        max = Math.max(max, arr[idx]);

        getMaxUtil(arr, N, idx + 1);
    }


    /*
        Approach 2 : Without using extra var
     */

    public int getMaxWithoutVar(int[] arr) {
        return getMaxWithoutVar(arr, arr.length, 0);
    }

    public int getMaxWithoutVar(int[] arr, int N, int idx) {

        if (idx == N-1)
            return arr[idx];

        return Math.max(arr[idx], getMaxWithoutVar(arr, N, idx + 1));
    }
}
