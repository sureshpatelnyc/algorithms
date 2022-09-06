package com.test.newalgo.dp;

public class UniquePaths {
    public static void main(String args[]){
        int m=3;
        int n=7;
        int N= m+n-2;
        int r = m-1;
        int res = 1;
        int i=1;
        for(;i<=r;i++)
            res = res*(N-r+i)/i;
       // res = res/i;
        System.out.println(res);
    }
}
