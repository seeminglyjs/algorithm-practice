package com.algorithm.practice.algorithmpractice.programmers;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Case_17 { //호텔 대실


    @Test
    public void test(){
        String [][] arr = new String [][] {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}};
        solution(arr);
    }

    public int solution(String[][] book_time) {
        int count = 0;

        Arrays.sort(book_time, (o1, o2) -> {
            if(o1[0].equals(o2[0])) {
                return o1[1].compareTo(o2[1]);
            }else {
                return o1[0].compareTo(o2[0]);
            }
        });

        for(int i = 0; i < book_time.length; i++) {
            for(int j = 0; j < book_time[0].length; j++) {
                System.out.print(book_time[i][j] + " ");
            }
            System.out.println();
        }

        String beforeEnd = "";
        for(int i = 0; i < book_time.length; i++) {
            if(beforeEnd.equals(""))
            for (int j = 0; j < book_time[0].length; j++) {


            }
        }
        int answer = 0;
        return answer;
    }

}
