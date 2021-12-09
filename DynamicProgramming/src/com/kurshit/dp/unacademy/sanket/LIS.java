package com.kurshit.dp.unacademy.sanket;

import java.util.Arrays;

public class LIS {

    public static void main(String[] args) {

        int[] arr = {3, 10, 2, 1, 20};

        System.out.println(getMaxLIS(arr, arr.length));
    }

    public static int getMaxLIS(int[] arr, int N) {

        int[] LIS = new int[N+1];

        Arrays.fill(LIS,1);

        for(int i = 1; i < N; i++) {
            for(int j = 0; j < i; j++) {
                if(arr[i] > arr[j] && LIS[j] + 1 > LIS[i]) {
                    LIS[i] = LIS[j] + 1;
                }
            }
        }

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < N; i++) {
            max = Math.max(LIS[i], max);
        }

        return max;

    }


}
