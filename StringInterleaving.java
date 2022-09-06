package com.test.newalgo.sorting;

public class StringInterleaving {
    public static void main(String args[]){

    }
    boolean isInterleaving(String s1, String s2, String s3){
        char[] arr1 =  s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        char[] arr3 = s3.toCharArray();
        int len1 = arr1.length;
        int len2 = arr2.length;
        int len3 = arr3.length;
        if((len1+len2) < len3) {
            return false;
        }
        if(len1 == 0 && len2 == 0 && len3>0)
        {
            return false;
        }

        int i = 0;
        int j = 0;
        int k = 0;

        for(char c: arr3){

        }

        return false;
    }
}
