package com.kurshit.arrays.sortingalgos;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
 
class QuickSortClass extends RecursiveAction {
 
    private int[] arr;
    private int left;
    private int right;
 
    public QuickSortClass(int[] arr){
        this.arr=arr;
        this.left = 0;
        this.right = arr.length - 1;
    }
 
    public QuickSortClass(int[] arr, int left, int right){
        this.arr = arr;
        this.left = left;
        this.right = right;
    }
 
    @Override
    protected void compute() {
        if (left < right){
            int pivotIndex = left + ((right - left)/2);
 
            pivotIndex = partition(pivotIndex);
 
            invokeAll(new QuickSortClass(arr, left, pivotIndex-1),
                      new QuickSortClass(arr, pivotIndex+1, right));
        }
 
    }
 
    private int partition(int pivotIndex){
        int pivotValue = arr[pivotIndex];
 
        swap(pivotIndex, right);
 
        int storeIndex = left;
        for (int i=left; i<right; i++){
            if (arr[i] < pivotValue){
                swap(i, storeIndex);
                storeIndex++;
            }
        }
 
        swap(storeIndex, right);
 
        return storeIndex;
    }
 
    private void swap(int i, int j){
        if (i != j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}

public class QuickSortParallel {
	public static void main(String[] args) {
        final int SIZE = 10000;
 
        int[] arr = {10,1,85,20,90,46,50,78,120,6};
 
        QuickSortClass quickSort = new QuickSortClass(arr);
 
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(quickSort);
        
        for(int i : arr) {
        	System.out.print(i + " ");
        }
    }
}

