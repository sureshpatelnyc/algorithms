package com.test.algorithms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PrintInOrder1 {

	private static Integer[] a = { 1, 1, 1 };
	private static Integer[] b = { 2, 2, 2 };
	private static Integer[] c = { 3, 3, 3 };
	private static Integer[] d = { 4, 4, 4 };

	public static void main(String[] args) throws InterruptedException {

		QueueOrder1 q1 = null;
		QueueOrder1 q2 = null;
		QueueOrder1 q3 = null;
		QueueOrder1 q4 = null;

		q1 = new QueueOrder1(a);
		q2 = new QueueOrder1(b);
		q3 = new QueueOrder1(c);
		q4 = new QueueOrder1(d);

		q1.setChild(q2);
		q1.isPrinted = true;

		q2.setChild(q3);

		q3.setChild(q4);
		
		q4.setChild(q1);

		Thread t1 = new Thread(q1);
		Thread t2 = new Thread(q2);
		Thread t3 = new Thread(q3);
		Thread t4 = new Thread(q4);
		
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();

		

		t1.join();
		t2.join();
		t3.join();
		t4.join();

	}

}

class QueueOrder1 implements Runnable {

	Integer[] arr;
	QueueOrder1 child;
	Queue<Integer> queue = new LinkedList<>();
	boolean isPrinted = false;

	QueueOrder1(Integer[] arr) {
		this.arr = arr;
		queue.addAll(Arrays.asList(arr));
	}

	public QueueOrder1 getChild() {
		return child;
	}

	public void setChild(QueueOrder1 child) {
		this.child = child;
	}

	public void run() {

		while (!this.queue.isEmpty()) {

			synchronized (this) {
				if (!this.isPrinted) {
					try {
						this.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} 
			}

			System.out.print("**" + this.queue.poll());
			this.isPrinted = false;
			synchronized (this.child) {
				if(!this.child.isPrinted) {
					this.child.notify();
				}
			}

		}
	}
}