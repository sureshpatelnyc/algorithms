package com.test.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class BuildingAmazon {

	static List<Employee> mv = new ArrayList<>(50);
	static Queue<Integer> queue = new LinkedList<>();
	static Map<Integer, IndexAndCnt> bldCnt = new HashMap<>();
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			String input = scan.nextLine();
		
			if(input.equals("exit")) {
				break;
			}
				
			String[] empReq = input.split(" ");
		
			final Employee emp = new Employee(empReq[0], Integer.parseInt(empReq[1]), Integer.parseInt(empReq[2]));
			if(null != bldCnt.get(emp.getFromBld())) {
				IndexAndCnt idxAndCnt = bldCnt.get(emp.getFromBld());
				idxAndCnt.setIdx(idxAndCnt.getCnt()+1);
			}else {
				IndexAndCnt idxAndCnt = new IndexAndCnt();
				idxAndCnt.setCnt(1);
				bldCnt.put(emp.getFromBld(), idxAndCnt);
			}
			mv.add(emp);
		}
		scan.close();
		
		Collections.sort(mv, new Comparator<Employee>() {

			@Override
			public int compare(Employee arg0, Employee arg1) {
				if(null !=arg0 && null != arg1) {
					if(arg0.getFromBld() < arg1.getFromBld()) {
						return -1;
					}
					
				}
				return 0;
			}
			
			
		});
		
		List<Integer> keySet = new ArrayList<>(bldCnt.keySet());
		Collections.sort(keySet);
		Integer totalCnt = 0;
		
		for(Integer key : keySet) {
			IndexAndCnt idxCnt = bldCnt.get(key);
			idxCnt.setIdx(totalCnt);
			totalCnt = totalCnt + idxCnt.getCnt();
		}

		for(Employee emp: mv) {
			Integer toBld = emp.getToBld();
			Integer startIndex = bldCnt.get(toBld).getIdx();
			
		}
		
	}
	
	boolean checkCycle(Integer index, Integer fromBld) {
			Employee emp = mv.get(index);
			queue.offer(index);
			if(emp.getToBld().equals(fromBld)) {
				
				return true;
			}else {
				checkCycle(bldCnt.get(emp.getToBld()).getIdx(), fromBld);
			}
		
		return false;
	}

	}

class Employee{
	
	private String empName;
	private Integer fromBld;
	private Integer toBld;
	private boolean foundMatch;
	private boolean visited;
	
	public Employee(String empName, Integer fromBld, Integer toBld) {
		this.empName = empName;
		this.fromBld = fromBld;
		this.toBld = toBld;
	}
	
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Integer getFromBld() {
		return fromBld;
	}
	public void setFromBld(Integer fromBld) {
		this.fromBld = fromBld;
	}
	public Integer getToBld() {
		return toBld;
	}
	public void setToBld(Integer toBld) {
		this.toBld = toBld;
	}
	public boolean isFoundMatch() {
		return foundMatch;
	}
	public void setFoundMatch(boolean foundMatch) {
		this.foundMatch = foundMatch;
	}
	public boolean isVisited() {
		return visited;
	}
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
	
	
}

class IndexAndCnt{
	private Integer cnt;
	private Integer idx;
	public Integer getCnt() {
		return cnt;
	}
	public void setCnt(Integer cnt) {
		this.cnt = cnt;
	}
	public Integer getIdx() {
		return idx;
	}
	public void setIdx(Integer idx) {
		this.idx = idx;
	}
	
	
	
}
