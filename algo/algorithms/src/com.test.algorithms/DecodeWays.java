package com.test.newalgo.dp;

public class DecodeWays {
    public static void main(String args[]){
        char[] arr = "11106".toCharArray();
        int[] mem = new int[arr.length];

        for(int i=0; i<mem.length; i++){
            mem[i] = -1;
        }
        int result = decode(arr,arr.length, mem);
        System.out.print(result);

    }
    static int decode(char[] arr, int k, int[] memo){
        int pos = arr.length-k;

        if(k==0){
            return 1;
        }

        if(arr[pos] == '0')
            return 0;

        if(memo[pos] != -1){
            return memo[pos];
        }

        int result = decode(arr,k-1, memo);

        if(k >=2 && (int) arr[k-2] < 51 && arr[k-1] < 55)
            result+= decode(arr, k-2, memo);
        memo[k-1] = result;
        return result;
    }
}
