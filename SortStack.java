package com.test.newalgo;

import java.util.Stack;

public class SortStack {
    public static void main(String args[]){
        Stack<Integer> s1 = new Stack<>();
        s1.push(5);
        s1.push(1);
        s1.push(0);
        s1.push(10);
        Stack<Integer> st = doSort(s1);
    }
   static Stack<Integer> doSort(Stack<Integer> s1){
        Stack<Integer> s2 = new Stack<>();
        while(!s1.isEmpty()){
            int tmp = s1.pop();
            while(!s2.isEmpty() && s2.peek() > tmp){
                s1.push(s2.pop());
            }
            s2.push(tmp);
        }
        return s2;
    }
}
