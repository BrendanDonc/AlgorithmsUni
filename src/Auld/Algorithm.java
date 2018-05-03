package Auld;

import java.util.Random;

public class Algorithm {
	
	static Random randNum = new Random();
	
	public static void NegBeforePos(int[] list){

		int j = list.length - 1;
		int i = 0;
		
		
		while(i < j) {
			if (list[i] < 0) {
				i++;
			}
			
			else {
				int temp = list[i];
				list[i] = list[j];
				list[j] = temp;
				j--;
			}
		}
	}
	
	public static int NegBeforePosOps(int[] list){

		int j = list.length - 1;
		int i = 0;
		int numOperations = 0;
		
		
		while(i < j) {
			if (list[i] < 0) {
				i++;
			}
			else {
				int temp = list[i];				
				list[i] = list[j];				
				list[j] = temp;
				numOperations++; //For swap operation
				j--;
			}
		}
		return numOperations;
	}
	
	
	public static int[] RandFillArray(int[] list, int minNum, int maxNum) {
		for(int j = 0; j < list.length; j++) {
			list[j] = (randNum.nextInt((maxNum - minNum + 1)) + minNum);
		}
		return list;
	}

}
