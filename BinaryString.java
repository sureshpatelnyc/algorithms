package com.test.newalgo.dp;

public class BinaryString {
    public static void main(String args[]){
        int[] a=new int[5];
        BinaryString bs =new BinaryString();
        bs.generateStr(5, a);
    }
    void generateStr(int n, int[] a){
        if(n<1){
            System.out.println();
            for(int i=0;i<a.length; i++)
            System.out.print(a[i]);
            return;
        }
        a[n-1]=0;
        generateStr(n-1, a);
        System.out.println("\n"+n);
        a[n-1]=1;
        generateStr(n-1, a);

    }
}
