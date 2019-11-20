package com.test.algorithms;

public class BinaryHeap {

	private int[] a = new int[20];
	int capacity = 0;
	public BinaryHeap() {
		// TODO Auto-generated constructor stub
	}
	
	void insert(int item) {
		if(capacity < a.length) {
			a[capacity] = item;
		}
		
		if(a[capacity] > a[(capacity-1)/2]) {
			heapify(capacity);
		}
		++capacity;
	}
	
	int search(int item, int i) {
		if(i>=capacity) {
			return (i-1)/2;
		}
		if( item == a[i]) {
			return i;
		}
		
		search(item,(2*i)+1);
		search(item,(2*i)+2);
		
		return -1;
		
	}
	
	void delete(int item) {
		int i = 0;
		
	}
	
	void heapify(int i) {
		if(a[i] > a[(i-1)/2]) {
			int tmp = a[(i-1)/2];
			a[(i-1)/2] = a[i];
			a[i] = tmp;
		}else {
			return;
		}
		heapify((i-1)/2);
	}
	public static void main(String[] args) {
		BinaryHeap bh = new BinaryHeap();
		bh.insert(1);
		bh.insert(2);
		bh.insert(4);
		bh.insert(20);
		bh.insert(100);
		bh.insert(3);
		bh.insert(50);
		bh.insert(1000);
		bh.insert(10);
		bh.insert(50);
		bh.insert(2000);
		bh.insert(70);
		
		for(int i=0;i<bh.capacity; i++)
		{
			System.out.println(bh.a[i]);
		}
		System.out.println(bh.search(3,0));

	}

}
