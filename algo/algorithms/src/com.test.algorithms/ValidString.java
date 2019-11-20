package com.test.algorithms;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ValidString {

	public static void main(String[] args) {
		Map<Character, Integer> map = new HashMap<>();
		char[] a = "aabbcd".toCharArray();
		for(int i=0;i<a.length;i++) {
			Integer cnt = map.get(a[i]);
			if(null != cnt) {
				map.put(a[i], ++cnt);
			}else {
				map.put(a[i], 1);
			}
		}
		
		Collection<Integer> values = map.values();
		Integer[] charSizeArr = {};
		charSizeArr = values.toArray(charSizeArr);
		Arrays.sort(charSizeArr);
		int i = 0;
		int j = charSizeArr.length-1;
		boolean isOnecharDiff = false;
		String out="";
		while(j>i) {
			if(charSizeArr[i] == charSizeArr[j]) {
				i++;j--;
				continue;
			}else if(Math.abs(charSizeArr[i] - charSizeArr[j]) == 1 && !isOnecharDiff) {
				i++;j--;
				isOnecharDiff = true;
			}else {
				out = "NO";
			}
		}
		if(!out.equals("NO"))
		out = "YES";
		
		System.out.println(out);
		

	}

}
