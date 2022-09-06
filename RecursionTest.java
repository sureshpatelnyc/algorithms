package com.test.newalgo.dp;

public class RecursionTest {
    public static void main(String args[]){
        RecursionTest recursionTest =new RecursionTest();
        System.out.println(recursionTest.test(5));
    }

    int test(int n){
        if(n==1){
            return 1;
        }
        return n*test(n-1);


    }
}
