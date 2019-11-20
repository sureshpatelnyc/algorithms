package com.test.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AppPurchase {

	public static void main(String[] args) {
		
		System.out.print("Enter number of potential customers: ");
		Scanner scan = new Scanner(System.in);
		Integer noOfCust = scan.nextInt();
		List<Long> budgets = new ArrayList<>(noOfCust);
		while(noOfCust != 0) {
			budgets.add(scan.nextLong());
			--noOfCust;
		}
		scan.close();
		
		Collections.sort(budgets);
		
		noOfCust = budgets.size();
		Long maxRevenue = 0l;
		for(int i=0; i<noOfCust; i++) {
			long temp = budgets.get(i) * (noOfCust - i);
			if(temp > maxRevenue) {
				maxRevenue = temp;
			}
			
		}
		
		System.out.println("Max Revenue: "+maxRevenue);
			
	}

}
