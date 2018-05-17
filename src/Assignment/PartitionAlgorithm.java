package Assignment;

public class PartitionAlgorithm {
    //Using the quicksort partition method, find the median from an array of numbers
    public static int Median(int[] array){
        if(array.length == 1){
            return array[0];
        }
        else{
            return Select(array, 0, (int) Math.floor(array.length/2), array.length-1);
        }
    }//end Median

    public static int Select(int[] array, int min, int median_index, int max){
        int pos = Partition(array, min, max);

        if(pos == median_index){
            return array[pos];
        }
        if(pos > median_index){
            return Select(array, min, median_index, pos-1);
        }
        if(pos < median_index){
            return Select(array, pos+1, median_index, max);
        }
        return 0;
    }//end Select

    public static int Partition(int[] array, int min, int max){
        int pivot_val = array[min];
        int pivot_loc = min;
        for(int j = min + 1; j <= max; j++){
            if(array[j] < pivot_val){
                pivot_loc++;
                array = swap(array, pivot_loc, j);
            }
        }
        array = swap(array, min, pivot_loc);

        return pivot_loc;
    }//end Partition

    public static int[] swap(int[] array, int a, int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
        return array;
    }//end swap




//-------------------------------------
    //Record the total number of basic operations run for the 'Median' function
    public static int op_counter;
    public static int MedianOps(int[] array){
        op_counter = 0;
        if(array.length == 1){
            return op_counter;
        }
        else{
            SelectOps(array, 0, (int) Math.floor(array.length/2), array.length-1);
            return op_counter;
        }
    }//end Median

    public static int SelectOps(int[] array, int min, int median_index, int max){
        int pos = PartitionOps(array, min, max);
        if(pos == median_index){
            return array[pos];
        }
        if(pos > median_index){
            return SelectOps(array, min, median_index, pos-1);
        }
        if(pos < median_index){
            return SelectOps(array, pos+1, median_index, max);
        }
        return 0;
    }//end Select

    public static int PartitionOps(int[] array, int min, int max){
        int pivot_val = array[min];
        int pivot_loc = min;
        for(int j = min + 1; j <= max; j++){
            op_counter += 1;
            if(array[j] < pivot_val){
                pivot_loc++;
                array = swap(array, pivot_loc, j);
            }
        }
        array = swap(array, min, pivot_loc);
        return pivot_loc;
    }//end Partition
}
