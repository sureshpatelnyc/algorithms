package com.test.newalgo;

public class MeanOfArray {
    public static void main(String args[]) {


    }

    int findMean() {
        int i = 0;
        int j = 0;
        int[] a = {};
        int[] b = {};
        if (a.length == 0 && b.length > 0) {
            if (b.length == 1) {
                return b[0];
            } else if (b.length == 2) {
                return (b[0] + b[1]) / 2;
            }
            int rem = b.length % 2;
            int div = b.length / 2;
            return rem == 0 ? (b[div - 1] + b[div]) / 2 : b[div];
        }

        if (b.length == 0 && a.length > 0) {
            if (a.length == 1) {
                return a[0];
            } else if (a.length == 2) {
                return (a[0] + a[1]) / 2;
            }
            int rem = a.length % 2;
            int div = a.length / 2;
            return rem == 0 ? (a[div - 1] + a[div]) / 2 : a[div];
        }

        boolean canContinue = true;
        int aLen = a.length;
        int bLen = b.length;

        while (i < aLen && j < bLen) {
            if (a[i] >= a[j]) {
                j++;
            } else {
                i++;
            }

        }


        return 0;
}
}
