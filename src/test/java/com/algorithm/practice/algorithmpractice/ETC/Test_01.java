package com.algorithm.practice.algorithmpractice.ETC;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

public class Test_01 {

    @Test
    public void test(){
        String[] arr = {"1","1","1","1","1","3","0","5","5","1231","432423","931"};
        orderAsc(arr);
        for (String str: arr
        ) {
            System.out.print(str + " / ");
        }
        System.out.println();
        orderDesc(arr);
        for (String str: arr
             ) {
            System.out.print(str + " / ");
        }
    }
    public String [] orderAsc(String[] arr) {
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return (a+b).compareTo(b+a);
            }
        });
        return arr;
    }
    public String [] orderDesc(String[] arr) {
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return (b+a).compareTo(a+b);
            }
        });
        return arr;
    }
}
