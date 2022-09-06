package com.test.newalgo;

import java.util.Stack;

public class PoisonousPlant {
    public static void main(String args[]){
        Stack<Integer> st = new Stack<>();
        int[] arr = {3,2,5,4};
        if(arr.length == 1){
            //return 0;
        }
        int cnt=0;
        for(int i=1; i< arr.length; i++ ){
            if(arr[i-1] < arr[i]){
                if(cnt < 1){
                    cnt = 1;
                }
                st.push(arr[i-1]);
            }else if(!st.isEmpty() && st.peek() > arr[i]){
                st.pop();
                cnt++;
            }
        }
        System.out.print(cnt);
    }
}
