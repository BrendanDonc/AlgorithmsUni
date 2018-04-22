package Assignment;

import java.util.Random;

public class RandFill {
	//Fills an array with random numbers between minNum and maxNum
	
	static Random randNum = new Random();

	public static int[] RandFillArray(int[] list, int minNum, int maxNum) {
		for(int j = 0; j < list.length; j++) {
			list[j] = (randNum.nextInt((maxNum - minNum + 1)) + minNum);
		}
		return list;
	}

}
