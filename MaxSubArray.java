package com.test.newalgo.subarray;

public class MaxSubArray {
    public static void main(String args[]){
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int sum = 0;
        int max = nums[0];

        for (int i=0; i<nums.length; i++){
             sum = Math.max(nums[i], sum+nums[i]);
             if(max < sum){
                 max = sum;
             }
        }
        System.out.println(max);
    }
}
