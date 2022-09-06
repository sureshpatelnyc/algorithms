package com.test.newalgo.sorting;

import java.util.Collections;
import java.util.List;

public class Triangle {
    public static void main(String args[]){

    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int sum = 0;
        for(List l: triangle) {
            Collections.sort(l);
            sum+=(Integer) l.get(0);

         }
        return sum;

    }

}
