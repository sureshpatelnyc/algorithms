package com.test.newalgo.sorting;


public class CustomStringBuilder
{
    private StringBuilder stringBuilder = new StringBuilder();

    CustomStringBuilder append(String s){
        if(null == s){
            stringBuilder.append("");
            return this;
        }
        stringBuilder.append(s);
        return this;
    }

    String getString(){
        return stringBuilder.toString();
    }
}
