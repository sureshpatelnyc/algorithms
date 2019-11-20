package com.test.algorithms;

import java.util.Stack;

public class LargestPlot {

	
	
	public static void main(String[] args) {
		int a[] = {11,11,10,10,10};
		long max = 0;
		Stack<Integer> stak = new Stack<Integer>();
		stak.push(0);
		for(Integer i=1;i<a.length;i++) {			
			
			if(a[stak.peek()] > a[i] ) {
			
				long currArea = 0;
				while(!stak.isEmpty()) {
					
					if(a[stak.peek()] > a[i]) {
						int top = stak.pop();
						currArea = a[top] * (i-top);
						if(currArea > max) {
							max = currArea;
						}
						
					}else {
						break;
					}
				}
				
				stak.push(i);
			}else {
				stak.push(i);
			}
		}	
		long currArea =0;
		int lastIndex = stak.peek()+1;
		int index = 0;
		long min = a[lastIndex - 1];
		long prevMaxArea = max;
		while(!stak.isEmpty()) {
			index = stak.peek();
			if(min > a[index]) {
				min = a[index];
			}
			currArea = a[stak.pop()] * (lastIndex - index);
			if(currArea > max)
				max = currArea;
					
		}
		
		if(index-1 > 0 && a[index-1] > a[lastIndex-1]) {
			//currArea = a[lastIndex-1] * a.length;
			if(prevMaxArea < currArea) {
				max = min * a.length;
			}
		}

		
		System.out.println(max);

	}

}
