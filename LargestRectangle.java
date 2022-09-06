package com.test.newalgo.sorting;

import java.util.Stack;

public class LargestRectangle {
    public static void main(String args[]){

        Stack<Integer> st = new Stack<>();
        int arr[] = {10,2,4,4,3};
        int max = 0;
        int i=0;
        for(;i<arr.length; i++){
            if(st.isEmpty() || arr[i] >= arr[st.peek()]){
                st.push(i);
            }else{
                    int top = st.pop();
                    int area = st.isEmpty()? arr[top]*i : arr[top]*(i-st.peek()-1);
                    max = Math.max(max, area);
                    st.push(i);
            }
        }

        while(!st.isEmpty()){
            int top = st.pop();
            int area = st.isEmpty()? arr[top]*i : arr[top]*(i-st.peek()-1);
            max = Math.max(max, area);
        }

        System.out.println(max);

    }
}
