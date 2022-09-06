package com.test.newalgo;

public class Fibonacci {
    public static void main(String args[]) {
        int arr[] = new int[5];
        int m=fib(5, arr);
        System.out.print(m);
    }

    static int fib(int n, int[] arr) {

        if (n == 1 ) {
            return 1;
        }
        if(n == 0){
            return 0;
        }

        if (n<arr.length && arr[n] != 0) {
            return arr[n];
        }
        int k = fib(n-1, arr);
        int j = fib(n - 2, arr);
        if(n < arr.length) {
            arr[n] = k + j;
        }
        return 0;
    }


}
