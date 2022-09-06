package com.test.newalgo;

import java.util.Stack;

public class StockSpan {
    public static void main(String args[]){
        int[] a= {100,80,60,70,60,75,85};
        int[] b= new int[a.length];
        StockSpan stockSpan = new StockSpan();
        stockSpan.findSpan(a,b);
        for(int i=0;i<b.length; i++)
        System.out.print(b[i]+"  ");
    }
    void findSpan(int[] a, int[] b){
        Stack<Integer> st = new Stack<>();
        int p = 0;
        for(int i = 0; i<a.length; i++){
            while(!st.isEmpty() && a[i] > a[st.peek()]){
                st.pop();
            }

            if(st.isEmpty()){
                p=-1;
            }else{
                p=st.pop();
            }
            b[i] = i-p;
            st.push(i);
        }
    }

}
