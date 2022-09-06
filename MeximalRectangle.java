package com.test.newalgo;

import java.util.Stack;

public class MeximalRectangle {
    public static void main(String args[]){
        int[][] arr = {{1,0,1,0,0},{1,0,1,1,1},{1,1,1,1,1},{1,0,0,1,0}};
        Stack<Integer> st = new Stack<>();
        int maxArea  = 0;
        for(int i=0; i<arr.length; i++){
            st.clear();
            int currMax = 0;
            int j=0;
            for(; j<arr[i].length; j++){
                if(st.isEmpty() || arr[i][j] == arr[i][st.peek()]){
                    st.push(j);
                } else {
                    int tp = st.peek();
                   // st.pop();
                    currMax = Math.max(currMax, arr[i][tp] * (st.isEmpty() ? j : j-st.peek()-1));
                    st.pop();
                }
                if((i+1) < arr.length && arr[i+1][j] == 1){
                    arr[i+1][j] = arr[i][j] + 1;
                }
            }

            while(!st.isEmpty()){
                int tp = st.peek();
                st.pop();
                currMax = Math.max(currMax, arr[i][tp] * (st.isEmpty() ? j : j-st.peek()-1));
            }
            maxArea = Math.max(maxArea, currMax);

        }
        System.out.print(maxArea);
    }
}
