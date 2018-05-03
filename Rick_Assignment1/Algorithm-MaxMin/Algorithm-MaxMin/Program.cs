using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data.OleDb;
using System.Data;
using System.Diagnostics;
using System.IO;

///-----------------------------------------------------------------------------------------------------------///
///   Namespace:      Algorithm_MaxMin                                                                        ///
///   Class:          Program                                                                                 ///
///   Description:    V2 - Methods to develop and analyse the MaxMin2 algorithm developed by Berman and Paul  ///
///   Author:         Rick Mccasker - n9449949                                                                ///
///-----------------------------------------------------------------------------------------------------------///
namespace Algorithm_MaxMin
{
    public class Program
    {
        const int NUM_OF_TESTS = 100;
        const int MAX_ARRAY_SIZE = 10000;

        static void Main(string[] args) {
            //Iterate over different array sizes
            for(int array_size = 100; array_size <= MAX_ARRAY_SIZE; array_size += 100)
            {
                int[] average_arr_basic = new int[NUM_OF_TESTS]; 
                int[] average_arr_timer = new int[NUM_OF_TESTS];
                //Complete more than one test and take the average for better results
                for (int test_num = 0; test_num < NUM_OF_TESTS; test_num++)
                {
                    int[] random_set = SetGenerator(array_size);
                    average_arr_basic[test_num] = MaxMinBasicCounter(random_set);
                    average_arr_timer[test_num] = Int32.Parse(MaxMinTimer(random_set));

                }
                UpdateExcel(array_size, average_arr_basic.Sum()/NUM_OF_TESTS, average_arr_timer.Sum()/NUM_OF_TESTS);
            }
        }

        /*
         * Method Name: UpdateExcel
         * Description: Update cells in the excel document named 'test.xlsx' contained within the solution base directory
                        with recorded results of both the operations performed and the time elapsed.
         * Inputs:      int array_size - The size of the array and the row ID to be updated.
                        int basic_counter - The total operations performed by the algorithm.
                        int timer_counter - The total time elapsed for said operations to be performed.
         * Outputs:     n/a
         * Notes:       n/a
         */
        static void UpdateExcel(int array_size, int basic_counter, int timer_counter) {
            string current_directory = Path.GetFullPath(Path.Combine(AppContext.BaseDirectory, "..\\..\\..\\"));
            string file_name = current_directory + "test.xlsx";
            string connection_string = String.Format(@"Provider=Microsoft.ACE.OLEDB.12.0;" +
                                                    "Data Source={0};Extended Properties='Excel 12.0;HDR=YES;IMEX=0'", file_name);
            string sql_command = String.Format("update [Sheet1$] set basic_counter={1}, timer_counter={2} where array_size={0}", array_size, basic_counter, timer_counter);
            
            OleDbConnection my_connection;
            OleDbCommand my_command = new OleDbCommand();
            string sql = null;
            my_connection = new OleDbConnection(connection_string);
            my_connection.Open();
            my_command.Connection = my_connection;
            sql = sql_command;
            my_command.CommandText = sql;
            my_command.ExecuteNonQuery();
            my_connection.Close();
            my_connection.Dispose();
        }

        
        /*
         * Method Name: SetGenerator
         * Description: Creates an array, populates it with random numbers within -10000 and 10000 then returns.
         * Inputs:      The desired size of the array, defaults to 10.
         * Outputs:     An array of size 'arr_size' populated with random numbers.
         * Notes:       Set bounds as -10000 and 10000 simply because it satisfied testing.
         */
        static int[] SetGenerator(int arr_size) {
            int[] arr = new int[arr_size];
            int lower_bound = -10000;
            int upper_bound = 10000;
            Random random_num = new Random(Guid.NewGuid().GetHashCode());

            for (int i = 0; i < arr_size; i++)
            {
                arr[i] = random_num.Next(lower_bound, upper_bound);
            }
            return arr;
        }

        /*
         * Method Name: MaxMin
         * Description: The base edition of the program. It serves to be a mostly unaltered version of the code
                        that is the most faithful to the original algorithm. 
         * Input:       An array larger than size 0
         * Output:      n/a
         * Notes:       In most cases it should have not reason to be run as it is incapable of returning any values or altering 
                        any global vars.
         */
        public static void MaxMin(int[] input_arr) {
            int max_val = input_arr[0];
            int min_val = input_arr[0];
            int arr_length = input_arr.Count();

            for (int i = 0; i < arr_length; i++)
            {
                if (input_arr[i] > max_val)
                {
                    max_val = input_arr[i];
                }
                else
                {
                    if (input_arr[i] < min_val)
                    {
                        min_val = input_arr[i];
                    }
                }
            }
        }



        /*
         * Method Name: MaxMinTimer
         * Description: A version of the base program that is capable of recording execution time from start to finish.
         * Input:       An array larger than size 0
         * Output:      A recording of execution time in milliseconds.
         * Notes:       Should only be run to check execution time.
         */
        public static String MaxMinTimer(int[] input_arr) {
            Stopwatch watch = Stopwatch.StartNew();
            int max_val = input_arr[0];
            int min_val = input_arr[0];
            int arr_length = input_arr.Count();

            for (int i = 0; i < arr_length; i++)
            {
                if (input_arr[i] > max_val)
                {
                    max_val = input_arr[i];
                }
                else
                {
                    if (input_arr[i] < min_val)
                    {
                        min_val = input_arr[i];
                    }
                }
            }
            watch.Stop();
            String timer = watch.Elapsed.ToString();
            timer = timer.Remove(0, 9);
            return timer;
        }

        /*
         * Method Name: MaxMinBasicCounter
         * Description: A version of the program that counts every time that a comparison is made and therefore track the number
         *              of basic operations run.
         * Input:       An array larger than size 0
         * Output:      An int representing basic operations counted.
         * Notes:       Should only be run to check basic operation count.
         */
        static int MaxMinBasicCounter(int[] input_arr) {
            int basic_counter = 0;
            int max_val = input_arr[0];
            int min_val = input_arr[0];
            int arr_length = input_arr.Count();

            for (int i = 0; i < arr_length; i++)
            {
                
                basic_counter++;
                if (input_arr[i] > max_val)
                {
                    max_val = input_arr[i];
                }
                else
                {
                    basic_counter++;
                    if (input_arr[i] < min_val)
                    {
                        min_val = input_arr[i];
                    }
                }
            }
            return basic_counter;
        }

        /*
        * Method Name: MaxMinTest
        * Description: A version of the program that simply returns an array. Used to test program and prove it works.
        * Input:       An array larger than size 0
        * Output:      An array with 2 elements where element 0 represents max and element 1 represents min
        * Notes:       Should not have a reason to be run outside of the testing suite.
        */
        public static int[] MaxMinTest(int[] input_arr) {
            int max_val = input_arr[0];
            int min_val = input_arr[0];
            int arr_length = input_arr.Count();

            for (int i = 0; i < arr_length; i++)
            {
                if (input_arr[i] > max_val)
                {
                    max_val = input_arr[i];
                }
                else
                {
                    if (input_arr[i] < min_val)
                    {
                        min_val = input_arr[i];
                    }
                }
            }
            int[] vals = new int[] { max_val, min_val };
            return vals;
        }
    }
}

