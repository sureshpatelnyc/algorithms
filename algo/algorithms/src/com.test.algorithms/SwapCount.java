package com.test.algorithms;

public class SwapCount {

	static long sort( int middle, int endIndex, int[] a) {
		long cnt = 0;
		if(middle > 0 || middle < endIndex)  {
			if(a[middle] > a[endIndex]) {
				int tmp = a[middle];
				a[middle] = a[endIndex];
				a[endIndex] = tmp;
				cnt++;
				cnt = cnt + sort(0, middle, a);
			} else if(a[middle] < a[endIndex])  {
				cnt =  cnt + sort(middle, middle +(endIndex-middle)/2, a);
			}else {
				return cnt;
			}
			
		}else if(endIndex > 0 && a[endIndex] < a[endIndex - 1]) {
			
			cnt = cnt + sort(0, endIndex, a);
		}
		return cnt;
	}
	
	public static void main(String[] args) {
		int[] a = {3,4,6,10,45,67,8,90,110,100};
		long cnt = 0;
		for(int i=0; i<a.length-1; i++) {
			for(int j=i+1;j<a.length; j++) {
				if(a[i] > a[j]) {
					//cnt++;
					cnt =  cnt + sort(j/2,j, a);
				}
			}
		}
		System.out.println(++cnt);
	}

}
