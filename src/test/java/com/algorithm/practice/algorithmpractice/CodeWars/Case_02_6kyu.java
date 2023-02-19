package com.algorithm.practice.algorithmpractice.CodeWars;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class Case_02_6kyu { //Multiplication table

//    Your task, is to create N×N multiplication table, of size provided in parameter.
//
//    For example, when given size is 3:
//
//            1 2 3
//            2 4 6
//            3 6 9
//    For the given example, the return value should be:
//
//            [[1,2,3],[2,4,6],[3,6,9]]


    @Test
    @DisplayName("n = 3")
    void test3() {
        int[][] test = {{1,2,3},{2,4,6},{3,6,9}};
        assertArrayEquals(test,multiplicationTable(3));
    }
    @Test
    @DisplayName("n = 1")
    void test1(){
        int[][] test1 = {{1}};
        assertArrayEquals(test1, multiplicationTable(1));
    }

    public static int [][] multiplicationTable(int n){ //Multiplication table
        //return IntStream.rangeClosed(1, n).mapToObj(i -> IntStream.rangeClosed(1, n).map(j -> i * j).toArray()).toArray(int[][]::new);
        int [][] arr = new int [n][n];
        int index = 0;
        int x = 2;
        for(int i = 0; i < n; i ++){
            if(i == 0){
                for (int j = 0; j < n; j++){
                    arr[i][j] = ++index;
                }
            }else{
                for (int j = 0; j < n; j++){
                    arr[i][j] = arr[0][j] * x;
                }
                x++;//곱 ++;
            }
        }
        return arr;
    }
}
