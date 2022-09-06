package com.test.newalgo;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalanceBracket {
    public static void main(String args[]){
        Stack<Character> st = new Stack();
        char[] arr = "{[()]}".toCharArray();
        Map<Character, Character> map = new HashMap<>();
        map.put(']','[');
        map.put('}','{');
        map.put(')','(');

        for(char ch: arr){

            if(map.containsKey(ch) && !st.isEmpty()){
                if(st.peek() != map.get(ch)){
                    System.out.print( "NO");
                    return;
                }
                st.pop();
            } else {

                st.push(ch);
            }
        }
        System.out.print( "YES");
    }
}
