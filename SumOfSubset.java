package com.test.newalgo.sorting;

public class SumOfSubset {
    public static void main(String args[]){
        int[] arr = {5,10,12,13,15,18};
        int[] output = new int[arr.length];
        SumOfSubset sumOfSubset = new SumOfSubset();
        sumOfSubset.findSubset(arr,output, 0, 0);
    }

    void findSubset(int[] arr, int[] output, int i, int sum){
        if(i>=arr.length){
            return;
        }
        if(sum == 28){
            System.out.println();
            for(int k =0; k< output.length; k++){
                if(output[k] == 1){
                    System.out.print(k+",");
                }
            }
            return;
        }
        if(sum > 28){
            return;
        }
        sum = sum + arr[i];
        output[i] = 1;
        findSubset(arr, output, ++i, sum );
        sum= sum - arr[i-1];
        output[i-1] = 0;
        findSubset(arr, output, i, sum );

    }

}
