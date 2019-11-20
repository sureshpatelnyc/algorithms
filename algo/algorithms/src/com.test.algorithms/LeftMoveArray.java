package com.test.algorithms;

public class LeftMoveArray {

	void moveLeft(int[] arr, int currIdx,  int move, int len, int movingElement, int startIdx) {
		
		int nextIdx = currIdx - move;
		if(nextIdx < 0) {
			nextIdx = len + nextIdx;
		}
		int tmp = arr[nextIdx];
		if(nextIdx == startIdx) {
			arr[startIdx] = movingElement;
			if(len%move == 0 && (startIdx+1) < move) {
				startIdx = startIdx + 1;
				tmp = arr[startIdx];
				moveLeft(arr, startIdx, move, len, tmp, startIdx);
				
			}
			return;
			
		}
		
		arr[nextIdx] = movingElement;
		moveLeft(arr, nextIdx, move, len, tmp, startIdx);
		
		
		
		//return;
		
		
	}
	
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
		int move = 3;
		LeftMoveArray lfm = new LeftMoveArray();
		if(move > arr.length) {
			move = move % arr.length;
		}
		
		if(move != 0 || arr.length > 1) {
			lfm.moveLeft(arr, 0, move, arr.length, arr[0],0);
		}
		for(int i=0;i<arr.length; i++)
			System.out.print("**"+arr[i]);
			

	}

}
