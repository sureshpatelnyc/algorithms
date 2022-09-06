package com.test.newalgo;

public class LongestSequence {
    public static void main(String args[]){
        LongestSequence longestSequence = new LongestSequence();
        String s1 = "pmjghexybyrgzczy";
        String s2 = "hafcdqbgncrcbihkd";
        int[][] arr = new int[s1.length()][s2.length()];
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        System.out.println(longestSequence.LRD(a,b,0,0, arr));
    }

    int LRD(char[] a, char[] b, int i, int j, int[][] arr){
        if(i>=a.length || j>=b.length){
            return 0;
        }
        if(arr[i][j] > 0){
            return arr[i][j];
        }
        if(a[i] == b[j]){
            arr[i][j] = 1+LRD(a,b,i+1, j+1, arr);
            return arr[i][j];
        }
        return Math.max(LRD(a,b,i+1, j, arr), LRD(a,b,i, j+1,arr));

    }
}
