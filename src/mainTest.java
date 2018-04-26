import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

import Assignment.*;

public class mainTest {
	
	//Set amount of runs to average
	private static int runs = 100000;
	
	//Set max size of Array
	private static int maxSize = 10;
	
	//Set interval of Array sizes for each run
	private static int interval = 1;
	
	//Set highest possible value
	private static int maxNum = 1000000000;
	
	//Set lowest possible value, must be less than maxNum
	private static int minNum = -100000000;
	
	//Set filename of file to be created when run
	private static String filename = "Test.xls";

	
	public static void main(String[] args) throws FileNotFoundException {
		
		//Initialize global variables
		String[] bruteOutput = new String[(maxSize/interval)];
    	String[] outputSize = new String[(maxSize/interval)];
    	int currentRun = 0;
    	
    	//Sets output number as decimal not scientific notation
    	DecimalFormat df = new DecimalFormat("0");
    	df.setMaximumFractionDigits(10);
    	
    	for(int s = interval ; s <= maxSize; s += interval) {
			double bruteOpsAverage = 0.0;
			double operations = 0.0;
			int[] list = new int[s];
			
			//Run the algorithm for 'runs' amount of times with different inputs
			for (int i = 0; i < runs; i++) {
				
				//Fill the array with random numbers ranging from minNum to maxNum
				RandFill.RandFillArray(list, minNum, maxNum);
				operations = BruteForceAlgorithm.BruteForceMedianOps(list);
				//Add number of operations to total 
				bruteOpsAverage += operations;
			}
			//Average the number of operations
			bruteOpsAverage = bruteOpsAverage / runs;

			bruteOutput[currentRun] = df.format(bruteOpsAverage);
        	outputSize[currentRun] = Integer.toString(s);
        	currentRun++;
    	}
		try (PrintWriter averageOut = new PrintWriter(filename)) {
    		averageOut.println("Size\tAverage operations");
    		for(int i = 0; i < outputSize.length; i++) {
        		averageOut.println(outputSize[i] + "\t" + bruteOutput[i]);
        	}
    	}

	}

}
