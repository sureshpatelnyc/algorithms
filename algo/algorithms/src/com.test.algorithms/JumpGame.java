package com.test.newalgo.dp;

public class JumpGame {
    public static void main(String[] args){
        int[] nums = {3,2,1,0,4};
        boolean canReach = false;
        int sum=0;
        if(nums.length == 1){
            return ;
        }

        for (int i=0; i<(nums.length-1); i++){
            sum = Math.max(sum, i+nums[i]);
            if(sum <= i){
                break;
            }
            if(sum >= (nums.length-1)){
                canReach = true;
                break;
            }
        }

        System.out.println(canReach);

    }
}
