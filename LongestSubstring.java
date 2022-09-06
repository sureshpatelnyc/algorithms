package com.test.newalgo.sorting;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {
    public static void main(String args[]){
        LongestSubstring lb = new LongestSubstring();
        System.out.println(lb.getLongestSubString("pwwkeww"));
    }

    Integer getLongestSubString(String s){

        if(s.length() <= 1){
            return s.length();
        }

        char[] arr = s.toCharArray();
        int currFromIndex = 0;
        int currToIndex = 0;
        int prevFromIndex = 0;
        int prevToIndex = 0;
        int prevLen = 0;
        int currLen = 0;
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        for(; i<arr.length; i++){

            if(!map.containsKey(arr[i])){
               map.put(arr[i], i);
               currToIndex++;
               currLen++;
           }else{
                currFromIndex = map.get(arr[i]);
               prevToIndex = prevToIndex == 0 ? i : prevToIndex;
               prevLen = prevToIndex - prevFromIndex;
                currLen = i - currFromIndex;

                if(currLen > prevLen){
                   prevFromIndex = currFromIndex;
                   prevToIndex = i;
               }


               map.put(arr[i], i);

           }

        }
        if(prevLen == 0){
            return currToIndex - currFromIndex;
        }
        return currLen > prevLen ? currLen : prevLen;
    }
}
