package com.algorithm.practice.algorithmpractice.CodeWars;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.testng.AssertJUnit.assertEquals;

public class Case_04_6kyu { //Binary Addition
    @ParameterizedTest(name = "a = {1}, b = {2}")
    @CsvSource(textBlock = """
                   10,    1,   1
                    1,    0,   1
                    1,    1,   0
                  100,    2,   2
               111111,   51,  12
    """)
    @DisplayName("Sample tests")
    void sampleTests(String expected, int a, int b) {
        assertEquals(expected, binaryAddition(a, b));
    }

    public static String binaryAddition(int a, int b){
        return Integer.toBinaryString(a+b);
    }
}
