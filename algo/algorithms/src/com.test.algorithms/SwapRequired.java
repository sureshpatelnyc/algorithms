package com.test.algorithms;

public class SwapRequired {

	public static void main(String[] args) {
		int a[]= {8,45,35,84,79,12,74,92,81,82,61,32,36,1,65,44,89,40,28,20,97,90,22,87,48,26,56,18,49,71,23,34,59,54,14,16,19,76,83,95,31,30,69,7,9,60,66,25,52,5,37,27,63,80,24,42,3,50,6,11,64,10,96,47,38,57,2,88,100,4,78,85,21,29,75,94,43,77,33,86,98,68,73,72,13,91,70,41,17,15,67,93,62,39,53,51,55,58,99,46};
		int cnt=0;
		int i =0;
		int movingIdx = 0;
		while(true) {
			if(i==a.length)
				break;
			if(a[i] != (i+1)) {
				movingIdx = a[i]-1;
				int tmp = a[movingIdx];
				a[movingIdx] = a[i];
				a[i] = tmp;
				cnt++;
			}else {
				i++;
			}
		}
		
		System.out.println(cnt);
	}

}
