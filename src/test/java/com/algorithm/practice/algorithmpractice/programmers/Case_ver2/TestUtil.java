package com.algorithm.practice.algorithmpractice.programmers.Case_ver2;

public class TestUtil {

    public static <T> void printArr(T[] obj){
        if(obj != null){
            for(int i=0; i<obj.length; i++){
                System.out.print(obj[i] + " | ");
            }
        }
    }
}
