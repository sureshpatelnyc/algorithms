package com.test.newalgo.sorting;

import java.util.Arrays;

public class MaximumGap {
    public static void main(String args[]) {
        MaximumGap maximumGap = new MaximumGap();
        System.out.print(12.220%10);

    }
    int maxGap(int[] nums){
        Arrays.sort(nums);
        if(nums.length < 2){
            return 0;
        }
        int max = nums[1] - nums[0];
        for(int i=1;i<nums.length;i++){
            int diff = nums[i] - nums[i-1];
            if(diff > max){
                max = diff;
            }
        }
        return max;
    }
}
