package com.test.newalgo;

import java.util.*;

public class MaxSlideWindow {
    public static void main(String args[]){
        int k = 3;
        //int[] arr = {1,3,-1,-3,5,3,6,7};
        //int[] arr = {9,10,9,-7,-4,-8,2,-6};
        int[] arr = {1,3,-1,-3,5,3,6,7};
        //int[] arr = {7,2,4};
        Queue<WindowData> queue = new PriorityQueue<>(k, new Comparator<WindowData>() {
            @Override
            public int compare(WindowData o1, WindowData o2) {
                return o2.getData().compareTo(o1.getData());
            }
        });
        //int[] arr = {1,3,1,2,0,5};
        int[] arr1= new int[arr.length-(k-1)];
        int max = arr[0];
        int maxIndex = 0;
        for(int i=0;i<k; i++){
            if(max < arr[i]){
                max = arr[i];
                maxIndex = i;

            }
            queue.offer(new WindowData(arr[i], i));
        }
        arr1[0] = max;
        int j=1;
        for(int i=k;i<arr.length;i++) {
            queue.offer(new WindowData(arr[i], i));
            WindowData windowData = null;
            while (!queue.isEmpty()) {
                windowData = queue.peek();
                if (windowData.getIndex() < (i - (k - 1))) {
                    queue.poll();
                    continue;
                }
                break;
            }
            arr1[j++] = windowData.getData();
        }


        for(int m=0;m<arr1.length;m++){
            System.out.print(arr1[m]+" ");
        }
        //return arr1;
    }


}
class WindowData{
    private Integer data;
    private int index;
    public WindowData(Integer data, int index){
        this.data = data;
        this.index = index;
    }

    public Integer getData() {
        return data;
    }

    public int getIndex() {
        return index;
    }
}
