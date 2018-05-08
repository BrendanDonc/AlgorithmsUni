import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

import Assignment.*;

public class MainExecution {
	
	//Set amount of runs to average
	private static int runs = 100;

	//Set max size of Array
	private static int maxSize = 10000;
	
	//Set interval of Array sizes for each run
	private static int interval = 100;
	
	//Set highest possible value
	private static int maxNum = 10000;
	
	//Set lowest possible value, must be less than maxNum
	private static int minNum = -10000;
	
	//Set filename of file to be created when run
	private static String filename = "Average.xls";


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
			double bruteAverage = 0.0;
			double partitionAverage  = 0.0;
			int[] list = new int[size];
			
			//Run the algorithm for 'runs' amount of times with different inputs
			for (int i = 0; i < runs; i++) {
				
				//Fill the array with random numbers ranging from minNum to maxNum
				RandFill.RandFillArray(list, minNum, maxNum);
				
				//Time the brute force median of the array
				double start = System.nanoTime();
				BruteForceAlgorithm.BruteForceMedian(list);
				double done = (System.nanoTime() - start)/runs;
				//Sum all the times
				bruteAverage += done;
				
				//Time the partition median of the array
				start = System.nanoTime();
				PartitionAlgorithm.Median(list);
				done = (System.nanoTime() - start)/runs;
				//Sum all the times
				partitionAverage += done;
				
				
			}
			//Average the summed times
			bruteAverage = bruteAverage / runs;
			partitionAverage = partitionAverage / runs;
			
			//Format the averages as a decimal-place Strings and store as an array
        	bruteOutput[currentRun] = df.format(bruteAverage);
        	partitionOutput[currentRun] = df.format(partitionAverage);
        	
        	//Store size as String in an array
        	outputSize[currentRun] = Integer.toString(size);
        	
        	currentRun++;
    	}
    	
    	try (PrintWriter averageOut = new PrintWriter(filename)) {
    		averageOut.println("Size\tAverage brute time taken\tAverage partition time taken");
    		for(int i = 0; i < outputSize.length; i++) {
        		averageOut.println(outputSize[i] + "\t" + bruteOutput[i] + "\t" + partitionOutput[i]);
        	}
    	}

	}

}
