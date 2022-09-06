package com.test.newalgo.sorting;

import java.util.Arrays;

public class RotateArray {

    public static void main(String args[]){
        Integer arr[] = {41, 73, 89, 7, 10, 1, 59, 58, 84, 77, 77, 97, 58, 1, 86, 58, 26, 10, 86};
        //Integer arr[] = {1,2,3,4,5};
        int d=4;

        if(d == arr.length || d == 0){
            return;
        }

        if(d > arr.length){
            d = args.length % d;
        }
        int i=0;
        int curVal = arr[0];
        int startIndex = 0;
        while(true){
            int nextIndex = (i-d) < 0 ? arr.length + (i-d) : (i-d);
            int prevVal = arr[nextIndex] ;
            arr[nextIndex] = curVal;
            if(arr.length%d != 0 && nextIndex == 0){
                break;
            }
            if(nextIndex == startIndex && arr.length%d == 0 ) {
                if (startIndex == (d-1)) {
                    break;
                } else {
                    startIndex += 1;
                    i = startIndex;
                    curVal = arr[startIndex];
                    continue;
                }
            }
            curVal = prevVal;
            i = nextIndex;
        }
        for(int j=0; j< arr.length; j++)
            System.out.print(arr[j]+" ");
    }
}
