package com.test.algorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class StringComparator {

	public static void main(String[] args) {
		
		String[] arr = {"suresh","sureshp","ramesh","lalo","hirabhai"};
		System.out.println("Comparision: "+"s".compareTo("ss"));
		Collections.sort(Arrays.asList(arr), new Comparator<String>() {

			@Override
			public int compare(String arg0, String arg1) {
				return arg1.compareTo(arg0);
			}
			
		});

		for(int i=0; i<arr.length;i++)
			System.out.println(arr[i]);
	}

}
