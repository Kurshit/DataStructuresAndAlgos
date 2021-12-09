package com.kurshit.backracking.basics.misc;

import java.util.ArrayList;
import java.util.List;

/*
    Problem Source : https://leetcode.com/problems/combination-sum/
    Solution Source : https://leetcode.com/problems/combination-sum/

    Problem Statement : Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

        The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

        It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

    Input: candidates = [2,3,6,7], target = 7
    Output: [[2,2,3],[7]]
    Explanation:
    2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
    7 is a candidate, and 7 = 7.
    These are the only two combinations.

    Input: candidates = [2,3,5], target = 8
    Output: [[2,2,2,2],[2,3,3],[3,5]]

 */

/*
    Note :
        1. In this problem, each integer is alloweed to be taken any number of times and each subset should be unique irrespective of its order.

        Ex: for - arr {2,3,6,7} - Output : [2,2,3] is one but [2,3,2] should not be again printed.

        2. Given array is of distinct integers. Hence no duplicates
 */

public class CombinationSumOne {

    public static void main(String[] args) {

        int[] arr = {2, 3, 6, 7};
        int sum = 7;

        System.out.println(printAllCombinations(arr, sum));
    }

    public static List<List<Integer>> printAllCombinations(int[] arr, int sum) {

        List<List<Integer>> resultList = new ArrayList<>();

        List<Integer> list = new ArrayList<>();

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

            list.add(arr[i]);
            printCombination(arr, remain - arr[i], i, resultList, list);  // Since each integer can be considered any number of times, we are not increasmenting the i. If each integer
            // needs to appear at most one, we will increase i + 1
            list.remove((list.size() - 1));
        }


    }
}
