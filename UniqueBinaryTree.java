package com.test.newalgo.dp;

public class UniqueBinaryTree {

    public static void main(String args[]){
        int n= 6;
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 5;

        int result = 2*arr[1];

        for(int i=3; i<n; i++){
            arr[i] = result + 2*arr[i-1];
            result+=2*arr[i-1];
        }
        System.out.println(arr[n-1]);
    }
    static  int uniqueTree(int[] arr, int n){
        if(n==1){
            return 1;
        }
        if(arr[n-1] != 0 ){
            return arr[n-1];
        }
        int result = 2 * uniqueTree(arr,n-1);
        return result;
    }


}
