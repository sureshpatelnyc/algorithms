package com.test.algorithms;

public class Factorial {

	int factorial(int num) {
		int fact = 0;
		if(num == 1) {
			return 1;
		}
		 fact = num * factorial(num - 1);
		return fact;
	}
	public static void main(String[] args) {
		System.out.println(new Factorial().factorial(4));

	}

}
