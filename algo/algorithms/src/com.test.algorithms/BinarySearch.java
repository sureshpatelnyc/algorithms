package com.test.newalgo.search;

public class BinarySearch {
    public static void main(String[] args){
        BinarySearch binarySearch = new BinarySearch();
        int[] nums = {5,8,8,7,9,10};
        int target = 8;
        int index = binarySearch.targetIndex(nums,0, nums.length, target);
        int startIndex = index;
        int endIndex = index;
        int k=index-1;
        for(; k>=0; k--){
            if(nums[k] == target){
                startIndex = k;
                continue;
            }
            break;
        }
        int j=index+1;
        for(;j<nums.length; j++){
            if(nums[j] == target){
                endIndex = j;
                continue;
            }
            break;
        }

    }


    public int targetIndex(int[] nums, int start, int end, int target){
        int index = -1;
        if(end > start){

            int mid = (start+end)/2;
            if(nums[mid] == target){
                return mid;
            }
            index = targetIndex(nums, start, mid, target);
            if(index != -1){
                return index;
            }
            index = targetIndex(nums, mid+1, end, target);
            if(index != -1){
                return index;
            }
        }
        return -1;
    }
}
