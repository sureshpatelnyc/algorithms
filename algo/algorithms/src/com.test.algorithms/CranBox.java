package com.test.algorithms;

import java.util.Scanner;

public class CranBox {

	public static void main(String[] args) {
		System.out.print("Enter number of stack and max boxes: ");
		Scanner scan = new Scanner(System.in);
		String input1 = scan.nextLine();
		String[] noOfStackAndBox = input1.split(" ");
		
		int noOfStack = new Integer(noOfStackAndBox[0]);
		int noOfBoxesinEachStack = new Integer(noOfStackAndBox[1]);
		
		Integer[][] stackAndBox = new Integer[noOfStack][noOfBoxesinEachStack+1]; 
		String[] noOfBoxes = scan.nextLine().split(" ");
		
		int row = 0;
		int boxIndex = 0;
		int totalBoxesInStack = 0;
		
		for(int i=0; i<noOfBoxes.length; i++) {
			

			int box = Integer.parseInt(noOfBoxes[i]);
			stackAndBox[row][++boxIndex] = box;
			totalBoxesInStack++;

			if((i+1) % noOfBoxesinEachStack == 0) {
				stackAndBox[row][0] = totalBoxesInStack;	
				row = row +1;
				totalBoxesInStack = 0;
				boxIndex = 0;
			}
		
		}
		stackAndBox[row][0] = totalBoxesInStack;


		String input2 = scan.nextLine();
		String[] commands = input2.split(" ");
		
		int stackPos = 0;
		boolean doesCrainholds = false; 
		int cranHoldingValue = 0;
		
		for(int cmd=0 ; cmd<commands.length; cmd++) {
			int command = Integer.parseInt(commands[cmd]);
			switch(command) {
			case 1:
				if(stackPos > 0) {
					--stackPos;
				}
				break;
			case 2:
				if(stackPos != (noOfStack-1)) {
					++stackPos;
				}
				break;
			case 3:
				if(!doesCrainholds && null != stackAndBox[stackPos][0] && stackAndBox[stackPos][0] > 0) {
					cranHoldingValue = stackAndBox[stackPos][stackAndBox[stackPos][0]];
					stackAndBox[stackPos][stackAndBox[stackPos][0]] = null;
					doesCrainholds = true;
					stackAndBox[stackPos][0]  = stackAndBox[stackPos][0] - 1;
					
				}
				break;
			case 4:
				if((doesCrainholds && null == stackAndBox[stackPos][0]) ||(doesCrainholds && null != stackAndBox[stackPos][0]  && stackAndBox[stackPos][0]  < noOfBoxesinEachStack ) ) {
					if(null == stackAndBox[stackPos][0]) {
						stackAndBox[stackPos][1] = cranHoldingValue;
						stackAndBox[stackPos][0] = 1;
					}else {
						stackAndBox[stackPos][stackAndBox[stackPos][0]+1] = cranHoldingValue;
						stackAndBox[stackPos][0] = stackAndBox[stackPos][0] + 1; 
					}
					doesCrainholds = false;
				}
				
			}
			
		}
		
		for(int stack=0; stack<noOfStack; stack++ ) {
			if(stackAndBox[stack][0] == null) {
				continue;
			}
				
			for(int box=stackAndBox[stack][0]; box>0; box--) {
				System.out.print(" "+stackAndBox[stack][box]);
				
			}
		}
		
	}

}
