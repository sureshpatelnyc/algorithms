package com.test.newalgo.sorting;

import java.util.*;

public class LongestValidParenthisis {

    public static void main(String args[]) {


        int maxLen = getValidIndex(")()())()()(");

        System.out.println(maxLen);

    }

   static int getValidIndex(String s){
       Stack<Integer> st = new Stack<>();
       char[] arr = s.toCharArray();
       if(arr.length<1){
           return 0;
       }
       int maxLen = 0;
       for (int i = 0; i < arr.length; i++) {
           if(arr[i] == ')'){
               if(!st.isEmpty() && arr[st.peek()]=='('){
                   maxLen+=2;
                   st.pop();
               }else{
                   st.push(i);
               }
           }else{
               st.push(i);
           }
       }
       if(st.empty()){
           return maxLen;
       }



       int prevIndex = arr.length-1;
       int currIndex = st.peek();
       maxLen = prevIndex - currIndex;
       while(!st.isEmpty()){
           currIndex = st.peek();
           int currLen = prevIndex-currIndex;
           if(currLen > maxLen){
               maxLen = currLen;
           }
           prevIndex = currIndex;
           st.pop();
       }

       if(maxLen%2 !=0){
           maxLen-=1;
       }

       if(currIndex%2 !=0){
           currIndex-=1;
       }

       return maxLen>currIndex? maxLen :currIndex;
    }
}
