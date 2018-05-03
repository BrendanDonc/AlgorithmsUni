package Assignment;

public class PartitionAlgorithm {
    public static int Median(int[] array){
        //Exit early if array only contains one element
        if(array.length == 1){
            return array[0];
        }
        else{
            return Select(array, 0, (int) Math.floor(array.length/2), array.length-1);
        }
    }//end Median

    //Recursively run until the median index matches as expected
    public static int Select(int[] array, int min, int median_index, int max){

        //Try to assign pos the median index from a partially sorted array
        int pos = Partition(array, min, max);

        //If the median index is as expected
        if(pos == median_index){
            return array[pos];
        }
        //Reduce array slice from top if correct index exists below
        if(pos > median_index){
            //System.out.println(pos + " compares to > " + median_index);
            return Select(array, min, median_index, pos-1);
        }
        //Reduce array slice from bottom if correct index exists above
        if(pos < median_index){
            //System.out.println(pos + " compares to <" + median_index);
            return Select(array, pos+1, median_index, max);
        }
        return 0;
    }//end Select

    public static int Partition(int[] array, int min, int max){
        //Record first val in array slice and position


        int pivot_val = array[min]; //Pivot point to be used
        int pivot_loc = min;
        //Iterate over slice excluding first val
        for(int j = min + 1; j <= max; j++){
            //Check if the current val index is less that the recorded pivot point
            if(array[j] < pivot_val){
                pivot_loc++; //Iterate pivot loc to match movement
                array = swap(array, pivot_loc, j);
            }
        }
        array = swap(array, min, pivot_loc);
        System.out.println("Start");
        for(int z = min; z < max; z++){
            System.out.print(array[z] + " , ");
        }
        System.out.println("End");

        return pivot_loc;
    }//end Partition

    public static int[] swap(int[] array, int a, int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
        return array;
    }//end swap




//-------------------------------------
    public static int op_counter;
    public static int MedianOps(int[] array){
        //Exit early if array only contains one element
        op_counter = 0;
        if(array.length == 1){
            return op_counter;
        }
        else{
            SelectOps(array, 0, (int) Math.floor(array.length/2), array.length-1);

            //System.out.println(op_counter);
            return op_counter;
        }
    }//end Median

    //Recursively run until the median index matches as expected
    public static int SelectOps(int[] array, int min, int median_index, int max){
        //Try to assign pos the median index from a partially sorted array
        int pos = PartitionOps(array, min, max);
        //If the median index is as expected
        if(pos == median_index){
            return array[pos];
        }
        //Reduce array slice from top if correct index exists below
        if(pos > median_index){
            //System.out.println(pos + " compares to > " + median_index);
            return SelectOps(array, min, median_index, pos-1);
        }
        //Reduce array slice from bottom if correct index exists above
        if(pos < median_index){
            //System.out.println(pos + " compares to <" + median_index);
            return SelectOps(array, pos+1, median_index, max);
        }
        return 0;
    }//end Select

    public static int PartitionOps(int[] array, int min, int max){
        //Record first val in array slice and position
        int pivot_val = array[min]; //Pivot point to be used
        int pivot_loc = min;
        //Iterate over slice excluding first val
        for(int j = min + 1; j <= max; j++){
            //Check if the current val index is less that the recorded pivot point
            op_counter++;
            if(array[j] < pivot_val){
                pivot_loc++; //Iterate pivot loc to match movement
                array = swapOps(array, pivot_loc, j); //dont need array equals prolly, delete this
            }
        }
        array = swapOps(array, min, pivot_loc);
        return pivot_loc;
    }//end Partition

    public static int[] swapOps(int[] array, int a, int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
        return array;
    }//end swap
}
