package com.test.newalgo;

import java.util.ArrayList;
import java.util.List;

public class Sum3 {
    public static void main(String args[]){
        Sum3 sum3 = new Sum3();
        List<Integer> list = new ArrayList<>();
        int[] arr = {-1,0,1,2,-1,-4};
        int target = 0;
        for(int i=0;(i+2)<arr.length;i++){
            for(int j=i+1;(j+1)<arr.length;j++){
                for(int k=j+1;k<arr.length;k++){
                    if((arr[i] + arr[j] + arr[k]) == target){
                        System.out.print(arr[i] + " " + arr[j] + " " + arr[k] + "\n");
                    }
                }
            }
        }
    }
    void findSum(List<Integer> list, int target, int[] arr, int i, int j, int k){

        if((i+2)<arr.length && (j+1) < arr.length && k < arr.length ) {
            if (arr[i] + arr[j] + arr[k] == target) {
                list.add(arr[i]);
                list.add(arr[j]);
                list.add(arr[k]);
            }
            System.out.print(i + " " + j + " " + k + "\n");
            findSum(list, target, arr, i, j, ++k);
            k = j + 2;
            findSum(list, target, arr, i, ++j, k);
            j = i + 2;
            k = j + 1;
            findSum(list, target, arr, ++i, j, k);

            if(i>3){
                return;
            }

        }

    }
}
