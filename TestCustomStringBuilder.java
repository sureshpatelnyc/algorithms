package com.test.newalgo.sorting;

public class TestCustomStringBuilder {
    public static void main(String args[]){
        CustomStringBuilder stringBuilder = new CustomStringBuilder();
        stringBuilder.append("Hello").append("|").append(null).append("|").append("Patel");
        System.out.println(stringBuilder.getString());
    }
}
