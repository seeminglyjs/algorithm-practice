package com.algorithm.practice.algorithmpractice.CodeWars;

import org.junit.jupiter.api.Test;

import static org.testng.AssertJUnit.assertEquals;

public class Case_15_5kyu { //Maximum subarray sum

//    The maximum sum subarray problem consists in finding the maximum sum of a contiguous subsequence in an array or list of integers:
//
//            Max.sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
//// should be 6: {4, -1, 2, 1}
//    Easy case is when the list is made up of only positive numbers and the maximum sum is the sum of the whole array. If the list is made up of only negative numbers, return 0 instead.
//
//    Empty list is considered to have zero greatest sum. Note that the empty list or array is also a valid sublist/subarray.

    @Test
    public void testEmptyArray() throws Exception {
        assertEquals("Empty arrays should have a max of 0", 0, Max.sequence(new int[]{}));
    }

    @Test
    public void testExampleArray() throws Exception {
        assertEquals("Example array should have a max of 6", 6, Max.sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }


    public class Max {
        public static int sequence(int[] arr) {
            int nowSum = 0;
            int maxSum = 0;
            for(int i = 0; i < arr.length; i++){
                nowSum = Math.max(nowSum + arr[i], 0);
                System.out.println(nowSum);
                maxSum = Math.max(maxSum, nowSum);
            }
            return maxSum;
        }
    }


    public class Max2 { //timeout
        static int max = 0;

        public static int sequence(int[] arr) {
            if (arr.length == 0) {
                return 0;
            }
            int start = 0; int end = arr.length;
            searchMax(arr, start,end);
            return max;
        }

        public static void searchMax(int[] arr, int start, int end) {
            if (start > arr.length) return;
            if (end < 0) return;
            if (start > end) return;
            int sum = 0;
            for (int i = start; i < end; i++) {
                sum += arr[i];
            }
            if (max < sum) max = sum;
            searchMax(arr, start+1, end);
            searchMax(arr, start, end-1);
        }
    }

}
