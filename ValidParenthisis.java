package com.test.newalgo.sorting;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthisis {
    public static void main(String args[]){
        ValidParenthisis validParenthisis = new ValidParenthisis();
        System.out.print(validParenthisis.isValid("[]{}()"));

    }
    private boolean isValid(String parenthisis){
        if(parenthisis.length()<=1){
            return false;
        }
        Stack<Character> openingSt = new Stack<>();
        char[] chars = parenthisis.toCharArray();
        Map<Character, Character> closing = new HashMap();
        closing.put(']','[');
        closing.put('}','{');
        closing.put(')','(');
        char prev = chars[0];
        int len = chars.length;
        for(char c: chars){
            if(!closing.containsKey(c)){
                openingSt.push(c);
            }else if(!openingSt.isEmpty()) {
                Character openingBracket = openingSt.pop();
                Character closingBracket = closing.get(c);
                if(null != openingBracket && closingBracket != openingBracket){
                    return false;
                }
            }else{
                return false;
            }
        }
        return openingSt.isEmpty()?true:false;    }

}
