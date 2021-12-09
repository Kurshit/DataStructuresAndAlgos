package com.kurshit.backracking.basics.misc;

import java.util.*;

/*
    Problem Source : https://leetcode.com/problems/combination-sum-ii/
    Solution Source : https://leetcode.com/problems/combination-sum-ii/

    Problem Statement : Given a collection of candidate numbers (candidates) and a target number (target),

    find all unique combinations in candidates where the candidate numbers sum to target.

    Each number in candidates may only be used once in the combination.

    Note: The solution set must not contain duplicate combinations.

    Example 1:

    Input: candidates = [10,1,2,7,6,1,5], target = 8
    Output: [
                [1,1,6],
                [1,2,5],
                [1,7],
                [2,6]
            ]

    Example 2:

    Input: candidates = [2,5,2,1,2], target = 5
    Output:
            [
            [1,2,2],
            [5]
            ]

 */

/*
    Note : In this problem, each integer is alloweed to be taken any number of times and each subset should be unique irrespective of its order.

    Ex: for - arr {2,3,6,7} - Output : [2,2,3] is one but [2,3,2] should not be again printed.

 */

public class CombinationSumTwo {

    public static void main(String[] args) {

        int[] arr = {10, 1, 2, 7, 6, 1, 5};
        int sum = 8;

        System.out.println(printAllCombinations(arr, sum));
        System.out.println(printAllCombinationsUsingSet(arr, sum));
    }

    /*
        Approach 1 : Using backtracking and manually discarding duplicates
     */

    public static List<List<Integer>> printAllCombinations(int[] arr, int sum) {

        List<List<Integer>> resultList = new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        Arrays.sort(arr);
        printCombination(arr, sum, 0, resultList, list);

        return resultList;
    }

    private static void printCombination(int[] arr, int remain, int first, List<List<Integer>> resultList, List<Integer> list) {

        if(remain == 0) {
            resultList.add(new ArrayList(list));
            return;
        }

        if(first == arr.length || remain < 0) {
            return;
        }

        //for(int i= 0; i < arr.length; i++) - willl treat all combination as different one - ex - [2,2,3], [2,3,2]
        for(int i= first; i < arr.length; i++) {

            //condition can also be written as -

            /*
                   if(i > first && arr[i] == arr[i-1]
                        continue;
             */

            if (i == first || arr[i] != arr[i-1]) {

                list.add(arr[i]);
                printCombination(arr, remain - arr[i], i + 1, resultList, list);  // Since each integer can be considered any number of times, we are not increasmenting the i. If each integer
                // needs to appear at most one, we will increase i + 1
                list.remove((list.size() - 1));
            }
        }

    }

    /*
        Approach 2 : Using hashset  to discard the duplicates

     */

    public static List<List<Integer>> printAllCombinationsUsingSet(int[] arr, int sum) {

        Set<List<Integer>> resultSet = new HashSet<>();

        List<Integer> list = new ArrayList<>();
        Arrays.sort(arr);
        printCombinationUsingSet(arr, sum, 0, resultSet, list);

        return new ArrayList(resultSet);
    }

    private static void printCombinationUsingSet(int[] arr, int remain, int first, Set<List<Integer>> resultSet, List<Integer> list) {

        if(remain == 0) {
            resultSet.add(new ArrayList(list));
            return;
        }

        if(first == arr.length || remain < 0) {
            return;
        }

        //for(int i= 0; i < arr.length; i++) - willl treat all combination as different one - ex - [2,2,3], [2,3,2]
        for(int i= first; i < arr.length; i++) {

            //condition can also be written as -

            /*
                   if(i > first && arr[i] == arr[i-1]
                        continue;
             */

            if (i == first || arr[i] != arr[i-1]) {

                list.add(arr[i]);
                printCombinationUsingSet(arr, remain - arr[i], i + 1, resultSet, list);  // Since each integer can be considered any number of times, we are not increasmenting the i. If each integer
                // needs to appear at most one, we will increase i + 1
                list.remove((list.size() - 1));
            }
        }

    }
}
