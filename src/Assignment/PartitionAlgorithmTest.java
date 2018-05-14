package Assignment;

import org.junit.Before;
import org.junit.Test;

import static Assignment.PartitionAlgorithm.Median;
import static Assignment.PartitionAlgorithm.Select;
import static Assignment.PartitionAlgorithm.Partition;
import static Assignment.PartitionAlgorithm.swap;

import static org.junit.jupiter.api.Assertions.*;

public class PartitionAlgorithmTest {

    @Before
    public void initialize(){


    }

    //Naming convention : MethodName_StateUnderTest_ExpectedBehaviour

    @Test
    public void Median_SortedLengthEven_ReturnsCorrectVal(){
        int [] array = new int[] { 1 , 2, 3, 4, 5, 6, 7, 8 };
        int median = Median(array);
        assertEquals(5, median);
    }

    @Test
    public void Median_SortedLengthOdd_ReturnsCorrectVal(){
        int [] array = new int[] { 1 , 2, 3, 4, 5, 6, 7, 8, 9};
        int median = Median(array);
        assertEquals(5, median);
    }

    @Test
    public void Median_UnsortedLengthEven_ReturnsCorrectVal(){
        int [] array = new int[] { 4, 2, 1, 3, 6, 5, 8, 7};
        int median = Median(array);
        assertEquals(5, median);
    }

    @Test
    public void Median_UnsortedLengthOdd_ReturnsCorrectVal(){
        int [] array = new int[] { 7, 2, 5, 1, 8, 4, 3, 6, 9};
        int median = Median(array);
        assertEquals(5, median);
    }

    @Test
    public void Median_AllSameElementLengthEven_ReturnsCorrectVal(){
        int [] array = new int[] { 5, 5, 5, 5 };
        int median = Median(array);
        assertEquals(5, median);
    }

    @Test
    public void Median_AllSameElementLengthOdd_ReturnsCorrectVal(){
        int [] array = new int[] { 5, 5, 5, 5, 5 };
        int median = Median(array);
        assertEquals(5, median);
    }

    @Test
    public void Median_ParitalSameElement_ReturnsCorrectVal(){
        int [] array = new int[] { 5, 5, 1, 2, 5 };
        int median = Median(array);
        assertEquals(5, median);
    }

    @Test
    public void Median_SizeLow_ReturnOnlyElement(){
        int [] array = new int[] { 1 };
        int median = Median(array);
        assertEquals(1, median);
    }

    @Test
    public void Select_FirstPivotIsMedian_ReturnsPivotAsMedian(){
        int [] array = new int[] { 3, 1, 2, 4, 5 };
        int median = Select(array, 0, 2, 4);
        assertEquals(3, median);
    }

    @Test
    public void Partition_ArrayFull_ReturnsCorrectPivotLoc(){
        int [] array = new int[] { 3, 1, 2, 4, 5 };
        int pivot_loc = Partition(array, 0, 4);
        assertEquals(2, pivot_loc);
    }

    @Test
    public void Partition_ArraySliceUpper_ReturnsCorrectPivotLoc(){
        int [] array = new int[] { 3, 1, 2, 4, 5 };
        int pivot_loc = Partition(array, 0, 2);
        assertEquals(2, pivot_loc);
    }

    @Test
    public void Partition_ArraySliceLower_ReturnsCorrectPivotLoc(){
        int [] array = new int[] { 3, 1, 3, 2, 5 };
        int pivot_loc = Partition(array, 2, 4);
        assertEquals(3, pivot_loc);
    }

    @Test
    public void Partition_PivotIsFirstElement_ReturnsCorrectPivotLoc(){
        int [] array = new int[] { 1, 6, 5, 4, 3, 2 };
        int pivot_loc = Partition(array, 0, 5);
        assertEquals(0, pivot_loc);
    }

    @Test
    public void Partition_PivotIsLastElement_ReturnsCorrectPivotLoc(){
        int [] array = new int[] { 6, 1, 2, 3, 4, 5 };
        int pivot_loc = Partition(array, 0, 5);
        assertEquals(5, pivot_loc);
    }

    @Test
    public void Swap_TwoElementExchange_ReturnsSwappedArray(){
        int [] array = new int[] { 3, 2, 1 };
        int [] expected_array = new int[] { 1, 2, 3 };
        swap(array, 0, 2);
        for(int i = 0; i < 3; i++){
            assertEquals(expected_array[i], array[i]);
        }
    }
}