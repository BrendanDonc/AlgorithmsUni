package Assignment;

public class BruteForceAlgorithm {

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
	
	
	
}
