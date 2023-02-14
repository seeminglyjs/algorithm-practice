package com.algorithm.practice.algorithmpractice.doItAlgorithm;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Test003 {//구간합 구하기
    //참고 백준 11659
    @Test
    public void test11659() throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int totalData = Integer.parseInt(st.nextToken());
        int question = Integer.parseInt(st.nextToken());

        int [] arr = new int[totalData+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= arr.length; i++){
            arr[i] = arr[i-1]+Integer.parseInt(st.nextToken());
        }

        for(int j = 0; j < question; j++){
            st = new StringTokenizer(br.readLine());
            int start, end;
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            System.out.println(end - start-1);
        }


    }
}
