package com.test.newalgo.sorting;

public class Factorial {
    public static void main(String args[]){
        Factorial factorial = new Factorial();
        int fact = factorial.factorial(6);
        System.out.println(fact);
    }

    int factorial(int n){
        if(n == 1){
            return 1;
        }
        int fact = n * factorial(n-1);
        return fact;
    }
}
