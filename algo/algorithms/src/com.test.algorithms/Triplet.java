package com.test.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Triplet {

	public static void main(String[] args) {
		
		List<Long> list = new ArrayList<>();
		Long[] a = {1237l,1237l,1237l,1237l,1237l};
		list.addAll(Arrays.asList(a));
		
		int r=1;
		Map<Long, Long> tripletMap = new HashMap<>();
		
		Long key = 0l;
		Long prevKey = 0l;
		Long cnt = 0l;
		
		for(Long num: list) {
			key = num/(r*r);
			Long currVal = tripletMap.get(num);
			if(currVal != null) {
				currVal = currVal + 1;
				tripletMap.put(num, currVal);
			}else {
				tripletMap.put(num, 1l);
			}
			
			
			if(tripletMap.containsKey(num/r) && tripletMap.containsKey(key)) {
				Long val1 = tripletMap.get(num/r);
				Long val2 = tripletMap.get(key);
				cnt = cnt + (val1*val2);
			}
			prevKey = key;
			if(key != prevKey) {
				//tripletMap.put(key,0l);
			}
		}
		
		System.out.println(cnt);

	}

}
