package com.spandiar;

import java.util.Arrays;

/*
 * You are given an array (which will have a length of at least 3, but could be very large) 
 * containing integers. The array is either entirely comprised of odd integers or entirely 
 * comprised of even integers except for a single integer N. 
 * Write a method that takes the array as an argument and returns this "outlier" N.
 * */

public class Main {
	
	static int EVENCOUNTER = 0; 
	static int ODDCOUNTER = 0; 

	public static void main(String[] args) {
		
//		int[] item = new int[] {2, 4, 0, 100, 4, 11, 2602, 36};
//		int[] item = new int[] {3, 5, 1, 101, 5, 12, 2603, 37};
		int[] item = new int[] {2, 6, 8, 200, 700, 1, 84, 10, 4};
		int outliner = findOutliner(item);
		
		System.out.println("Outliner is: " + outliner);

	}

	private static int findOutliner(int[] item) {
		
		boolean evenDataSource = false;
		int result = 0;
		Arrays.sort(item);
		
		for(int i = 0; i < 3; i++) {
			if(item[i] % 2 == 0) {
				EVENCOUNTER++;
				if(EVENCOUNTER == 2) {
					evenDataSource = true;
				}
			} else {
				ODDCOUNTER++;
				if(ODDCOUNTER == 2) {
					evenDataSource = false;
				}
			}
		}
		
		if(evenDataSource) {
			result =  findOddOutliner(item);
		} else {
			result =  findEvenOutliner(item);
		}
		
		System.out.println("Result is: " + result);
		return result;
	}

	private static int findOddOutliner(int[] item) {
		
		for(int value : item) {
			if(value % 2 != 0) {
				return value;
			}
		}
		
		return 0;
	}

	private static int findEvenOutliner(int[] item) {
		
		for(int value : item) {
			if(value % 2 == 0) {
				return value;
			}
		}
		
		return 0;
	}

}
