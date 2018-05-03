package assignment1;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Arrays;


public class Main {
	
	//Set amount of runs to average
	private static int runs = 10000;
	
	//Set max size of Array
	private static int maxSize = 1000;
	
	//Set single size of Array
	private static int singleSize = 10;
	
	//Set highest possible value
	private static int maxNum = 100;
	
	//Set lowest possible value, must be less than maxNum
	private static int minNum = -100;
	
	//Set up names for each test
	private static enum TestType {
		AVERAGE(),
		TESTAVERAGE(),
		OPERATIONS(),
		TESTOPERATIONS();
	}
	
	//Set which test to run
	static TestType test = TestType.TESTAVERAGE;

	public static void main(String[] args) throws InterruptedException, FileNotFoundException {
		
		//Initialize variables
        int[] list;
        String[] output;
        String[] outputSize;
        int currentRun;
        double start;
        double done;
        double average;
        double opAverage;
		double operations;
		
		//Sets output number as decimal not scientific notation
		DecimalFormat df = new DecimalFormat("0");
        df.setMaximumFractionDigits(8);

        switch(test) {
        case AVERAGE:
			
        	//Initialize global variables
        	output = new String[1+(maxSize/10)];
        	outputSize = new String[1+(maxSize/10)];
        	currentRun = 0;
        	
        	for(int s = 0 ; s <= maxSize; s += 10) {
        		
				//Initialize run specific variables
				average = 0.0;
				list = new int[s];
				
				//Run the algorithm for 'runs' amount of times with different inputs
				for (int i = 0; i < runs; i++) {
					
					//Fill the array with random numbers ranging from minNum to maxNum
					Algorithm.RandFillArray(list, minNum, maxNum);
					
					//Time sorting the array
					start = System.nanoTime();
					Algorithm.NegBeforePos(list);
					done = (System.nanoTime() - start)/1000000000;
					//Add all the times together
					average += done;
					
				}
				average = average / runs;
	        	output[currentRun] = df.format(average);
	        	outputSize[currentRun] = Integer.toString(s);
	        	currentRun++;
        	}
        	
        	try (PrintWriter averageOut = new PrintWriter("Average.xls")) {
        		averageOut.println("Size\tAverage time taken");
        		for(int i = 0; i < output.length; i++) {
            		averageOut.println(outputSize[i] + "\t" + output[i]);
            	}
        	}
        	
			break;
		case TESTAVERAGE:
			//Print the initialization of a random array of specified size
			
			list = new int[singleSize];
			Algorithm.RandFillArray(list, minNum, maxNum);
			System.out.println("Initial numbers: " + Arrays.toString(list));
			
			
			//Print the transformation of the array
			
			Algorithm.NegBeforePos(list);
			System.out.println("Sorted numbers: " + Arrays.toString(list));
			
			break;
		case OPERATIONS:
			
			output = new String[1+(maxSize/10)];
        	outputSize = new String[1+(maxSize/10)];
        	currentRun = 0;
        	
        	for(int s = 0 ; s <= maxSize; s += 10) {
				opAverage = 0.0;
				operations = 0.0;
				list = new int[s];
				
				//Run the algorithm for 'runs' amount of times with different inputs
				for (int i = 0; i < runs; i++) {
					
					//Fill the array with random numbers ranging from minNum to maxNum
					Algorithm.RandFillArray(list, minNum, maxNum);
					operations = Algorithm.NegBeforePosOps(list);
					//Add number of operations to total 
					opAverage += operations;
				}
				//Average the numbr of operations
				opAverage = opAverage / runs;

				output[currentRun] = df.format(opAverage);
	        	outputSize[currentRun] = Integer.toString(s);
	        	currentRun++;
        	}
			try (PrintWriter averageOut = new PrintWriter("Operations.xls")) {
        		averageOut.println("Size\tAverage operations");
        		for(int i = 0; i < output.length; i++) {
            		averageOut.println(outputSize[i] + "\t" + output[i]);
            	}
        	}
			break;
		case TESTOPERATIONS:
			//Print the initialization of a random array of specified size
			
			list = new int[singleSize];
			Algorithm.RandFillArray(list, minNum, maxNum);
			System.out.println("Initial numbers: " + Arrays.toString(list));
			
			
			//Print the transformation of the array and how many operations were performed
			
			int ops = Algorithm.NegBeforePosOps(list);
			System.out.println("Sorted numbers: " + Arrays.toString(list));
			System.out.println("Number of swaps: " + ops);
			
			break;
		default:
			break;
			
		}

	}

}
