package com.test.algorithms;

import java.util.Arrays;

public class GreedyFlourist {
    public static void main(String args[]){
        int[] a = {2,5,6,1,30,40,6,9};
        int k = 2;
        int prev = 0;
        int totalCost = 0;
        int m = 0;
        Arrays.sort(a);
        for(int i=a.length-1;i>=0;){
            m = i;
            for(int j=0;j<k && i>=0;j++){
                totalCost = totalCost + a[m-j] * (prev + 1);
                i--;
            }
            prev += 1;
        }
        System.out.print(totalCost);
    }
}
