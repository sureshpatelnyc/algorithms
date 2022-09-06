package com.test.newalgo.string;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqueChar {
    public static void main(String args[]){
        Map<Character, Integer> map = new LinkedHashMap<>();
        char[] arr = "dddccdbba".toCharArray();
        for(int i=0; i<arr.length; i++){
            if(map.containsKey(arr[i])){
                Integer val = map.get(arr[i]);
                map.put(arr[i],0);
            }else{
                map.put(arr[i], i);
            }
        }
        int j=0;
        for(Character ch: map.keySet()){
            System.out.println(ch);
            if(map.get(ch) == 1){
                //return j;
            }
            j++;
        }
        //return -1;
    }

}
