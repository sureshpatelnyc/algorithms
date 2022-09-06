package com.test.newalgo.sorting;

public class LexicographicalOrder {
    public static void main(String args[]){
        LexicographicalOrder lexicographicalOrder = new LexicographicalOrder();
        int[] num = {3,2,9,1};
        lexicographicalOrder.printLexicographicalOrder(num);
        for(int i=0;i< num.length; i++)
            System.out.println(num[i]);
    }

    private void printLexicographicalOrder(int arr[]){
        int i = arr.length-1;
        for(; i>0; i--){
            if(arr[i-1] < arr[i]){
                break;
            }
        }
        int j=arr.length-1;
        for(; j>=0 && i>0; j--){

            if(arr[i-1] < arr[j]){
                break;
            }
        }

        if(i>0) {
            int tmp = arr[i-1];
            arr[i-1] = arr[j];
            arr[j] = tmp;
        }
        j=arr.length-1;
        while(i<j){
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;

        }


    }

}
