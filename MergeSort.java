package com.test.newalgo.sorting;

public class MergeSort {
    private int[] a = {50,5,40,20,0, -1,34,99};
    public static void main(String args[]){
        System.out.println("Testing Merge Sort");
    }

    void mergeSort(int l, int h){
        if(l<h) {
            int mid = (l + h) / 2;
            mergeSort(l, mid);
            mergeSort((mid + 1), h);
        }
    }


}
