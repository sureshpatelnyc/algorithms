package com.test.algorithms;

public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = {1,50,4,32,200,-1};
		
		
		for(int i=0; i<(arr.length-1); i++) {
			for(int j=(i+1);j<arr.length;j++) {
				if(arr[j] < arr[i] ) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
		for(int i=0; i<arr.length;i++)
			System.out.print("**"+arr[i]);

	}

}
