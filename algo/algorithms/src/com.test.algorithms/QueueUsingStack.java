package com.test.algorithms;

import java.util.Stack;

public class QueueUsingStack {

	Stack<Integer> st1 = new Stack<>();
	Stack<Integer> st2 = new Stack<>();

	void enque(int i) {
		st1.push(i);
	}

	int dequeue() {
		if (st2.isEmpty()) {
			while(!st1.isEmpty()) {
				st2.push(st1.pop());
			}
		}
			
		return st2.pop();
	}

	void print() {
		if (st2.isEmpty()) {
			while(!st1.isEmpty()) {
				st2.push(st1.pop());
			}
		}
			
		System.out.print(st2.peek());

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
