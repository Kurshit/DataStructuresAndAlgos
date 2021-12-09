package com.kurshit.recursion.arraybased;

/*
    Statement : Given an integer array a, check if sequence of all array is in order.
    I.e. check if all adjacent elements have diff of 1
 */

public class IsInSequence {
    public static void main(String[] args) {
        int[] arr = {2,3,4,5};
        System.out.println(isInSequence(arr));

        int[] arr1 = {-2,-3,-4,-5};
        System.out.println(isInSequence(arr1));

        int[] arr2 = {10, 9, 8,7,6};
        System.out.println(isInSequence(arr2));

        int[] arr3 = {2,3,4,5, 5};
        System.out.println(isInSequence(arr3));

        int[] arr4 = {2};
        System.out.println(isInSequence(arr4));
    }

    public static boolean isInSequence(int[] arr) {
        if(arr.length == 1)
            return true;
        return isInSequenceUtil(arr, arr.length, 0);
    }

//    public static boolean isInSequenceUtil(int[] arr, int N, int idx) {
//
//        if(idx == N-1)
//            return Math.abs(arr[idx] - arr[idx-1]) == 1;
//
//        return isInSequenceUtil(arr, N, idx + 1);
//    }

    public static boolean isInSequenceUtil(int[] arr, int N, int idx) {

        if(idx == N-1)
            return true;

        if(Math.abs(arr[idx] - arr[idx + 1]) != 1)
            return false;

        return isInSequenceUtil(arr, N, idx + 1);
    }
}
