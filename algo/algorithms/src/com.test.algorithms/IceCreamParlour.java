package com.test.algorithms;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class IceCreamParlour {
    public static void main(String args[]){
        int[] a = {4, 3, 2, 5, 7};
        int k = 8;
        int[] ret = new int[2];
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for(int i=0;i<a.length;i++){
            if(map.containsKey(a[i])){
                continue;
            }else{
                map.put(a[i] , i+1);
            }
        }
        for(Integer money : map.keySet()){
            int firstId = money;
            ret[0] = map.get(firstId);
            if(firstId > k){
                continue;
            }else if(firstId == (k-firstId)){
                int secondIdx = -1;
                boolean found = false;
                for(int j=ret[0];j<a.length;j++){
                    if(a[j] == firstId){
                        ret[1] = j+1;
                        found = true;
                        break;
                    }
                }
                if(found) {
                    break;
                }
            }else if(map.containsKey(k-firstId)){
                ret[1] = map.get(k-firstId);
                break;
            }
        }

        System.out.println(ret[0]+"--"+ret[1]);

    }
}
