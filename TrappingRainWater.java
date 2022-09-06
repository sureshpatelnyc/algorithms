package com.test.newalgo.sorting;

public class TrappingRainWater {
    public static void main(String args[]){
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        //int[] arr1 = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] arr1 = {9,8,2,6};
        int[] arr2 = {0,7,1,4,6};
        int[] arr3 = {5,4,1,2};
        int[] arr4 = {2,0, 2};
        int[] arr5 = {0,7,1,4,6};
        int[] arr6 = {0,1,2,0,3,0,1,2,0,0,4,2,1,2,5,0,1,2,0,2};
        int[] arr7 = {9,6,8,8,5,6,3};
        int[] arr8 = {9,8,9,5,8,8,8,0,4};
        int[] arr9 = {7,9,8,5,0,0,4,2,7,6,0,8,1,2,3};
        int[] arr10 = {3,9,8,1,1,4,1,5,1,4,1,1,2};
        int[] arr11 = {1,9,8,7,5,6,0,7,1,1};


        System.out.println(trappingRainWater.trap(arr1));
        System.out.println(trappingRainWater.trap(arr2));
        System.out.println(trappingRainWater.trap(arr3));
        System.out.println(trappingRainWater.trap(arr4));

        System.out.println(trappingRainWater.trap(arr5));
        System.out.println(trappingRainWater.trap(arr6));
        System.out.println(trappingRainWater.trap(arr7));
        System.out.println(trappingRainWater.trap(arr8));
        System.out.println(trappingRainWater.trap(arr9));
        System.out.println(trappingRainWater.trap(arr10));

        System.out.print(trappingRainWater.trap(arr11));
    }

    int trap(int[] arr){
        int min=0;
        int max=0;
        int curr=0;
        int lastIndex=0;
        int runningMax=0;
        int running=0;
        int currMin = 0;
        for(int i=0; i< arr.length; i++){
            running+=arr[i];
            if(arr[i] < min ) {
                int currMax = ((i-lastIndex)*arr[i]) - running;
                currMin = (arr[i] - arr[i-1]) > 0 ? (arr[i] - arr[i-1]) :0;
                if(currMax > runningMax && currMax > currMin){
                    runningMax = currMax;
                    currMin = 0;
                }
            }


            if(min - arr[i] > 0){
                curr+=(min-arr[i]);
            }
            if( arr[i] > min){
                min = arr[i];
            }
            if(arr[i] >= min){
                max+=curr;
                curr = 0;
                min = arr[i];
                lastIndex=i;
                running = 0;
                runningMax=0;

            }
      }
        return max + runningMax +currMin;
    }
}
