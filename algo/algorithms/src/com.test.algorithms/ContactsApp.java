package com.test.algorithms;

import java.util.Scanner;

public class ContactsApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int i = Integer.parseInt(scan.nextLine());
		int outputIdx = 0;
		int j = 0;
		int[] output = new int[i];
		
		ContactNode nd = new ContactNode(0);
		
		for (; j < i; j++) {
			String operation = scan.nextLine();
			String[] ops = operation.split(" ");
			String op = ops[0];
			char[] arr = ops[1].toCharArray();
			
			ContactNode node = nd;
			int index = 0;
			if(op.contentEquals("add")) {
				
				for(char ch: arr) {
					nd.insert((int)ch, index++);
									}
			}
			if(op.equals("find")){
				for(char ch: arr) {
					node = node.find((int)ch, index++);
					if(null == node)
						break;
				}
				if(null != node) {
					if((arr.length -1) == node.idx)
					output[outputIdx++] = node.cnt;
				}
			}
			

		}
		
		for(int m=0; m<output.length; m++)
			System.out.println(output[m]);

		scan.close();

	}

}

class ContactNode {

	ContactNode left;
	ContactNode right;
	int ch = 0;
	int cnt = 1;
	int idx = -1;
	
	ContactNode(int ch) {
		this.ch = ch;
	}

	public ContactNode getLeft() {
		return left;
	}

	public void setLeft(ContactNode left) {
		this.left = left;
	}

	public ContactNode getRight() {
		return right;
	}

	public void setRight(ContactNode right) {
		this.right = right;
	}

	public int getCh() {
		return ch;
	}

	public void setCh(int ch) {
		this.ch = ch;
	}

	ContactNode find(int ch, int index) {
		if(this.ch == ch && this.idx == index) {
			return this;
		}
		else if(ch <= this.ch) {
			if(this.left == null) {
				return null;
			}else {
				return left.find(ch, index);
			}
		}else {
			if(this.right == null) {
				return null;
			}else {
				return right.find(ch, index);
			}
		}
	
	}
	
	void insert(int c, int index) {
		if (c <= this.ch) {
			if (left == null) {
				left = new ContactNode(c);
				left.idx = index;
			} else {
				
				if(index == left.idx && left.ch == c) {
					left.cnt = (left.cnt + 1);
				}
				left.insert(c, index);
			}
		} else {
			if (right == null) {
				right = new ContactNode(c);
				right.idx = index;
		
			} else {				
				if(index == right.idx && right.ch == c) {
					right.cnt = (right.cnt +1 );
				}
				right.insert(c, index);
			}
		}
		

	}

}
