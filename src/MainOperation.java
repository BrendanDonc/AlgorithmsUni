import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

import Assignment.*;

public class MainOperation {
	
	//Set amount of runs to average
	private static int runs = 100;
	
	//Set max size of Array
	private static int maxSize = 5000;
	
	//Set interval of Array sizes for each run
	private static int interval = 100;

	//Set highest possible value
	private static int maxNum = 10000;

	//Set lowest possible value, must be less than maxNum
	private static int minNum = -10000;
	
	//Set filename of file to be created when run
	private static String filename = "Operations.xls";

	
	public static void main(String[] args) throws FileNotFoundException {
		
		//Initialize global variables
		String[] bruteOutput = new String[(maxSize/interval)];
		String[] partitionOutput = new String[(maxSize/interval)];
    	String[] outputSize = new String[(maxSize/interval)];
    	int currentRun = 0;
    	
    	//Sets output number as decimal not scientific notation
    	DecimalFormat df = new DecimalFormat("0");
    	df.setMaximumFractionDigits(10);
    	
    	for(int size = interval ; size <= maxSize; size += interval) {
    		
    		//Initialize run specific variables
			double bruteOpsAverage = 0.0;
			double partitionOpsAverage = 0.0;
			double operations = 0.0;
			int[] list = new int[size];
			
			//Run the algorithm for 'runs' amount of times with different inputs
			for (int i = 0; i < runs; i++) {
				
				//Fill the array with random numbers ranging from minNum to maxNum
				RandFill.RandFillArray(list, minNum, maxNum);

				operations = BruteForceAlgorithm.BruteForceMedianOps(list);
				//Add number of operations to total
				bruteOpsAverage += operations;

				operations = PartitionAlgorithm.MedianOps(list);
				//Add number of operations to total
				partitionOpsAverage += operations;
			}
			//Average the number of operations
			bruteOpsAverage = bruteOpsAverage / runs;
			partitionOpsAverage = partitionOpsAverage / runs;
			
			//Format everything as a String for output
			bruteOutput[currentRun] = df.format(bruteOpsAverage);
			partitionOutput[currentRun] = df.format(partitionOpsAverage);
        	outputSize[currentRun] = Integer.toString(size);
        	currentRun++;
    	}
		try (PrintWriter averageOut = new PrintWriter(filename)) {
    		averageOut.println("Size\tBrute Force Average operations\tPartition Average Operations");
    		for(int i = 0; i < outputSize.length; i++) {
        		averageOut.println(outputSize[i] + "\t" + bruteOutput[i] + "\t" + partitionOutput[i]);

        	}
    	}

	}

}
