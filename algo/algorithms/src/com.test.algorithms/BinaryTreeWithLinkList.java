package com.test.algorithms;

import java.util.Scanner;

class Node{
	int data;
	Node left;
	Node right;
	
	Node(int data){
		this.data = data;
	}
	void insert(int data) {
		if(data <= this.data ) {
			if(left == null) {
				left = new Node(data);
			}else {
				left.insert(data);
			}
		}else {
			if(right == null) {
				right = new Node(data);
			}else {
				right.insert(data);
			}
		}
	}
	

	boolean contains(int val) {
		if(val == data) {
			return true;
		}else if(val < data){
			if(left == null) {
				return false;
			}else {
				return left.contains(val);
			}
		}else {
			if(right == null)
				return false;
			return right.contains(val);
		}
		
		
	}
	
	void traverse(){
		if(left != null) {
			left.traverse();
		}
		System.out.print("**"+data);
		if(right != null) {
			right.traverse();
		}
	}
	
	int height(){
		
		int lDepth = null != left? left.height(): 0;
		int rDepth = null != right? right.height() : 0;
		
		if(lDepth > rDepth) {
			return lDepth + 1;
		}else {
			return rDepth + 1;
		}
	}
}

public class BinaryTreeWithLinkList {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Node nd = new Node(scan.nextInt());
		while(true) {
			int data = scan.nextInt();
			if(data == -1) {
				break;
			}
			nd.insert(data);
		}
		
		int height = nd.height();
		System.out.println("Height: "+height);
		

	}

}
