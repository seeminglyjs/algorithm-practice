package com.algorithm.practice.algorithmpractice.CodeWars;

public class Case_18_4kyu { //Snail Sort

//    Given an n x n array, return the array elements arranged from outermost elements to the middle element, traveling clockwise.
//
//    array = [[1,2,3],
//            [4,5,6],
//            [7,8,9]]
//    snail(array) #=> [1,2,3,6,9,8,7,4,5]
//    For better understanding, please follow the numbers of the next array consecutively:
//
//    array = [[1,2,3],
//            [8,9,4],
//            [7,6,5]]
//    snail(array) #=> [1,2,3,4,5,6,7,8,9]
//    This image will illustrate things more clearly:
//
//
//    NOTE: The idea is not sort the elements from the lowest value to the highest; the idea is to traverse the 2-d array in a clockwise snailshell pattern.
//
//            NOTE 2: The 0x0 (empty matrix) is represented as en empty array inside an array [[]].

    public class Snail {

        public static int[] snail(int[][] array) {
            if(array.length == 0) return new int [] {};
            if(array.length == 1 && array[0].length == 1) return new int [] {array[0][0]};
            int startRow = 0;
            int endRow = array.length -1;
            int startCol = 0;
            int endCol = array[0].length-1;

            int [] result = new int [array.length * array[0].length];
            int check = 0;
            int index = 0;
            while(index < result.length){
                if(check == 0){
                    for (int i = startCol; i <= endCol; i++ ){
                        result[index] = array[startRow][i];
//                     System.out.println(result[index]);
                        index++;
                    }
                    startRow++;
                    check++;
                } else if (check == 1) {
                    for (int i = startRow; i <= endRow; i++ ){
                        result[index] = array[i][endCol];
//                     System.out.println(result[index]);
                        index++;
                    }
                    endCol--;
                    check++;
                }else if (check == 2) {
                    for (int i = endCol; i >= startCol; i-- ){
                        result[index] = array[endRow][i];
//                     System.out.println(result[index]);
                        index++;
                    }
                    endRow--;
                    check++;
                }else if (check == 3) {
                    for (int i = endRow; i >= startRow; i-- ){
                        result[index] = array[i][startCol];
//                     System.out.println(result[index]);
                        index++;
                    }
                    startCol++;
                    check = 0;
                }
            }
            return result;
        }
    }
}
