package com.test.algorithms;

import java.util.Collections;
import java.util.Iterator;
import java.util.SortedMap;
import java.util.Stack;
import java.util.TreeMap;

public class MinMaxRiddle {
	static int[] solve(int[] arr) {
		int[] lefts = buildLefts(arr);
		int[] rights = buildRights(arr);

		SortedMap<Integer, Integer> numberToLength = new TreeMap<>(Collections.reverseOrder());
		for (int i = 0; i < arr.length; i++) {
			numberToLength.put(arr[i], Math.max(numberToLength.getOrDefault(arr[i], -1), lefts[i] + rights[i] + 1));
		}

		Iterator<Integer> iter = numberToLength.keySet().iterator();
		int number = iter.next();
		int[] result = new int[arr.length];
		for (int i = 0; i < result.length; i++) {
			while (numberToLength.get(number) <= i) {
				number = iter.next();
			}

			result[i] = number;
		}
		return result;
	}

	static int[] buildLefts(int[] arr) {
		int[] lefts = new int[arr.length];

		Stack<Integer> indices = new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			while (!indices.empty() && arr[i] <= arr[indices.peek()]) {
				indices.pop();
			}

			lefts[i] = i - (indices.empty() ? -1 : indices.peek()) - 1;
			indices.push(i);
		}

		return lefts;
	}

	static int[] buildRights(int[] arr) {
		int[] rights = new int[arr.length];

		Stack<Integer> indices = new Stack<>();
		for (int i = arr.length - 1; i >= 0; i--) {
			while (!indices.empty() && arr[i] <= arr[indices.peek()]) {
				indices.pop();
			}

			rights[i] = (indices.empty() ? arr.length : indices.peek()) - i - 1;
			indices.push(i);
		}

		return rights;
	}
	public static void main(String[] args) {
		int[] a = {1,2,3,5,1,13,3};
		a= solve(a);
System.out.println("");
	}

}
