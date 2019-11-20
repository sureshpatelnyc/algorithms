package com.test.algorithms;

import java.util.HashMap;
import java.util.Map;

public class QuickSort {

	static int a[] = {2, 5, 1, 4, 78};
	static void sort(int start, int end) {
		
		if(start < end) {
		
		int pIndex = partition(start, end);
			
		sort(start, pIndex-1);
		sort(pIndex+1, end);
			
		}
		
	}
	
	static int partition(int start, int end) {
		int pIndex = start;
		int pivot = a[end];
		int tmp = 0;
		for(int i=start; i<end;i++) {
			if(a[i] <= pivot) {
				tmp = a[i];
				a[i] = a[pIndex];
				a[pIndex] = tmp;
				pIndex++;
			}
		}
		tmp = a[pIndex];
		a[pIndex] = a[end];
		a[end]= tmp;
		
		return pIndex;
	}
	
	public static void main(String[] args) {
		/*
		 * sort(0,a.length-1); for(int i=0; i<a.length;i++) System.out.print("**"+a[i]);
		 */

		Map<Long, Long> tripletMap = new HashMap<>();
		tripletMap.put(1l,new Long(400));
		Long val = tripletMap.get(1l);
		val++;
		Long val1 = tripletMap.get(1l);
		System.out.println(val1);
	}

}
