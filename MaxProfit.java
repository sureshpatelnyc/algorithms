package com.test.newalgo;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaxProfit {
    public static void main(String args[]){
        int[] prices = {3,3,5,0,0,3,1,4};

        Queue<Integer> minQueue = new PriorityQueue<>(2);
        Queue<Integer> maxQueue = new PriorityQueue<>(2, new MyComparator());

    for (int i=0; i<prices.length;i++)  {
        minQueue.offer(prices[i]);
        maxQueue.offer(prices[i]);
    }
        System.out.println(minQueue.peek()+", "+maxQueue.peek());
    }
}

 class MyComparator implements Comparator<Integer>
{
    public int compare( Integer x, Integer y )
    {
        return y - x;
    }
}