package com.test.newalgo.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinDeletion {
    public static void main(String args[]){
        char[] arr = "ceabaacb".toCharArray();
        Arrays.sort(arr);
        Map<Integer, Integer> map = new HashMap<>();
        char current = arr[0];
        char prev = arr[0];
        int sum = 0;
        int delOps = 0;
        for(int i=0; i<arr.length; i++){
            current = arr[i];

            if(current != prev){

                if(map.get(sum) != null){
                    int existingFreq = map.get(sum);
                    for(; existingFreq>0; existingFreq--){
                        if(map.get(existingFreq) != null){
                            delOps++;
                        }
                    }
                }

                map.put(sum, sum);
                sum = 0;
            }
            sum++;

            prev = current;
        }
        System.out.println(delOps);
    }
}
