package com.test.algorithms;

public class SwapForInversion {

	public static void main(String arg[]) {
		int[] a = {2,1,3,1,5,40,3,20,1000,8,12,1};
		int cnt = 0;
		for(int i=0; i<(a.length-1); i++) {
			
			if(a[i] > a[i+1]) {
				int tmp = a[i];
				a[i] = a[i+1];
				a[i+1] = tmp;
				cnt++;
				for(int j=i;j>0;j--) {
					if(a[j] < a[j-1]) {
						tmp = a[j];
						a[j] = a[j-1];
						a[j-1] = tmp;
						cnt++;
					}else {
						break;
					}
				}
			}
		}
		
		for(int i=0; i< a.length;i++) {
			System.out.print("**"+a[i]);
		}
		
	}

}
