package com.test.algorithms;

public class InsertionSort {

	public static void main(String[] args) {
		int[] a = { 1, 50, 4, 32, 200,-1,3,36,2000,500,0,-100 };

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < i; j++) {
				int temp = a[j];
				if ( a[i] < a[j]) {
					a[j] = a[i];
					a[i] = temp;
					break;
				}
			}
			System.out.println("");
			for (int k = 0; k < a.length; k++)
				System.out.print("**" + a[k]);
		}
		System.out.println("");
		for (int i = 0; i < a.length; i++)
			System.out.print("**" + a[i]);
	}

}
