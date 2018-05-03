using Microsoft.VisualStudio.TestTools.UnitTesting;
using Algorithm_MaxMin;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Algorithm_MaxMin.Tests {
    [TestClass()]
    public class ProgramTests {

        //Ensure correct max value is found with a basic array
        [TestMethod()]
        public void MaxTest() {
            int[] input_array = new int[] { 1, 2, 3, 4, 5 };
            int[] vals = Algorithm_MaxMin.Program.MaxMinTest(input_array);
            Assert.AreEqual(input_array.Max(), vals[0]);
        }

        //Ensure correct min value is found with a basic array
        [TestMethod()]
        public void MinTest() {
            int[] input_array = new int[] { 1, 2, 3, 4, 5 };
            int[] vals = Algorithm_MaxMin.Program.MaxMinTest(input_array);
            Assert.AreEqual(input_array.Min(), vals[1]);
        }

        //Ensure correct max & min value are found with a jumbled array
        [TestMethod()]
        public void JumbleTest() {
            int[] input_array = new int[] { 2, 5, 4, 1, 3 };
            int[] vals = Algorithm_MaxMin.Program.MaxMinTest(input_array);
            Assert.AreEqual(input_array.Max(), vals[0]);
            Assert.AreEqual(input_array.Min(), vals[1]);
        }

        //Ensure correct max/min values are found when duplicates exist in a jumbled array
        [TestMethod()]
        public void NotDistinctArrayTest() {
            int[] input_array = new int[] { 1, 2, 1, 3, 1, 2, 1 };
            int[] vals = Algorithm_MaxMin.Program.MaxMinTest(input_array);
            Assert.AreEqual(input_array.Max(), vals[0]);
            Assert.AreEqual(input_array.Min(), vals[1]);
        }

        //Ensure correct min/max values are found in an n=1 array
        [TestMethod()]
        public void ArrayLengthOneTest() {
            int[] input_array = new int[] { 1 };
            int[] vals = Algorithm_MaxMin.Program.MaxMinTest(input_array);
            Assert.AreEqual(input_array.Max(), vals[0]);
            Assert.AreEqual(input_array.Min(), vals[1]);
        }

        //Ensure that correct min/max values are found if they are the same
        [TestMethod()]
        public void SameMinMaxTest() {
            int[] input_array = new int[] { 1, 1, 1, 1, 1 };
            int[] vals = Algorithm_MaxMin.Program.MaxMinTest(input_array);
            Assert.AreEqual(input_array.Max(), vals[0]);
            Assert.AreEqual(input_array.Min(), vals[1]);
        }

        //Check with arbitary lower and upper bound values
        [TestMethod()]
        public void BoundsTest() {
            int[] input_array = new int[] { -10000, 10000, 5000, 2000, 3000, -2843 };
            int[] vals = Algorithm_MaxMin.Program.MaxMinTest(input_array);
            Assert.AreEqual(input_array.Max(), vals[0]);
            Assert.AreEqual(input_array.Min(), vals[1]);
        }
    }
}