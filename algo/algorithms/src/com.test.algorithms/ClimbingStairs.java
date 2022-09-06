package com.test.newalgo.dp;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {
    public static void main(String args[]){
        int steps = 8;
        int arr[] = new int[2];
       arr[0] = 1;
       arr[1] = 1;
        int paths = countStairsPath(steps, arr);

        System.out.println(paths);
    }

    static int countStairsPath(int steps, int[] arr){
        for(int i=2; i<=steps; i++){
            int tmp = arr[1];
            arr[1] = arr[1] + arr[0];
            arr[0] = tmp;
        }
        return arr[1];
    }
}
