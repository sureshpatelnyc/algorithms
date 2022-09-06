package com.test.newalgo;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PrintOrder {

    private static Integer[] a = { 1, 1, 1 };
    private static Integer[] b = { 2, 2, 2 };
    private static Integer[] c = { 3, 3, 3 };
    private static Integer[] d = { 4, 4, 4 };

    public static void main(String[] args) throws InterruptedException {

        QueueOrder q1 = null;
        QueueOrder q2 = null;
        QueueOrder q3 = null;
        QueueOrder q4 = null;

        q1 = new QueueOrder(a);
        q2 = new QueueOrder(b);
        q3 = new QueueOrder(c);
        q4 = new QueueOrder(d);

        q1.setChild(q2);

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

        QueueOrder q = q1;

        while (!q.queue.isEmpty()) {

            synchronized (q) {
                if (!q.isPrinted) {
                    q.notify();
                    q.wait();
                }
            }
            q = q.child;
        }

        t1.join();
        t2.join();
        t3.join();
        t4.join();

    }

}

class QueueOrder implements Runnable {

    Integer[] arr;
    QueueOrder child;
    Queue<Integer> queue = new LinkedList<>();
    boolean isPrinted = false;

    QueueOrder(Integer[] arr) {
        this.arr = arr;
        queue.addAll(Arrays.asList(arr));
    }

    public QueueOrder getChild() {
        return child;
    }

    public void setChild(QueueOrder child) {
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
            synchronized (this) {
                this.notify();
            }

        }
    }
}
