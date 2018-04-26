import Assignment.*;
import java.util.Arrays;

public class main {

    public static void main(String[] args) {

        //example list of numbers (median is 8)
        int[] test = {4,1,10,9,7,12,8,2,15};
        int[] test2 = {82, 41, 41, 37, 81, 64, 95, 61, 16, 72, 17, 8, 67, 23, 1, 0, 0, 9, 98, 45, 55, 20, 1, 7, 37};
        int[] test3 = {0, 0, 1, 1, 7, 8, 9, 16, 17, 20, 23, 37, 38, 40, 41, 45, 55, 61, 64, 67, 72, 81, 82, 95, 98};
        int[] test4 = {1, 1, 1, 1, 1, 1, 1, 1, 5, 9, 9, 9, 9, 9, 9, 9, 9};
        int[] test5 = {9, 9, 9, 9, 9, 9, 9, 9, 5, 1, 1, 1, 1, 1, 1, 1, 1}; 
        int[] test6 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int[] currentTest = test6;//Just so we only have to change it in one place

        System.out.println("Brute force median = " + BruteForceAlgorithm.BruteForceMedian(currentTest));
        System.out.println("Partition median = " + PartitionAlgorithm.Median(currentTest));


        //Verify
        Arrays.sort(currentTest);
        int median;
        if (currentTest.length % 2 == 0)
            median = ((int)currentTest[currentTest.length/2] + (int)currentTest[currentTest.length/2 - 1])/2;
        else
            median = (int) currentTest[currentTest.length/2];

        System.out.println("The actual median is: " + median);
    }

}
