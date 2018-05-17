package Assignment;

public class BruteForceAlgorithm {
	//Return a median from an array of numbers by iterating through every result with each possible pivot
	public static int BruteForceMedian(int[] list) {
		int k = (int) Math.ceil(list.length/2.0);
		
		for(int i = 0; i < list.length; i++) {
			int numSmaller = 0;
			int numEqual = 0;
			
			for(int j = 0; j < list.length; j++) {
				
				if(list[j] < list[i]) {
					numSmaller++;
				}
				else if(list[j] == list[i]) {
					numEqual++;
				}				
			}			
			if(numSmaller < k && k <= (numSmaller + numEqual)) {
				return list[i];
			}			
		}		
		//in case of no median found return 0
		return 0;
	} //end BruteForceMedian

	//Return the basic operation count for the 'BruteForceMedian' function
	public static int BruteForceMedianOps(int[] list) {
		int k = (int) Math.ceil(list.length/2.0);
		int ops = 0;
		
		for(int i = 0; i < list.length; i++) {
			int numSmaller = 0;
			int numEqual = 0;
			
			for(int j = 0; j < list.length; j++) {
				
				//add the two possible operations that occur when if statement fails
				ops = ops + 2;
				
				if(list[j] < list[i]) {
					numSmaller++;
					
					//remove the one operation that didn't occur since if statement passed
					ops = ops - 1;
				}
				else if(list[j] == list[i]) {
					numEqual++;
				}				
			}			
			if(numSmaller < k && k <= (numSmaller + numEqual)) {
				return ops;
			}			
		}		
		//in case of no median found return 0
		return ops;
	} //end BruteForceMedianOps
	
}
