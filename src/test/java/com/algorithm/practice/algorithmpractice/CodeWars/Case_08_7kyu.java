package com.algorithm.practice.algorithmpractice.CodeWars;

import org.junit.jupiter.api.Test;

import static org.testng.AssertJUnit.assertEquals;

public class Case_08_7kyu { //Roman Numerals Encoder

//    Create a function taking a positive integer between 1 and 3999 (both included) as its parameter and returning a string containing the Roman Numeral representation of that integer.
//
//    Modern Roman numerals are written by expressing each digit separately starting with the left most digit and skipping any digit with a value of zero. In Roman numerals 1990 is rendered: 1000=M, 900=CM, 90=XC; resulting in MCMXC. 2008 is written as 2000=MM, 8=VIII; or MMVIII. 1666 uses each Roman symbol in descending order: MDCLXVI.
//
//            Example:
//
//            conversion.solution(1000); //should return "M"
//    Help:
//
//    Symbol    Value
//    I          1
//    V          5
//    X          10
//    L          50
//    C          100
//    D          500
//    M          1,000


    @Test
    public void shouldConvertToRoman() {
        assertEquals("solution(1) should equal to I", "I", solution(1));
        assertEquals("solution(4) should equal to IV", "IV", solution(4));
        assertEquals("solution(6) should equal to VI", "VI", solution(6));
        assertEquals("solution(1900) should equal to MCM", "MCM", solution(1900));
        assertEquals("solution(1700) should equal to MDCC", "MDCC", solution(1700));
        assertEquals("solution(1700) should equal to MDCC", "MDCCXC", solution(1790));
        assertEquals("solution(1700) should equal to MDCC", "MDCCXC", solution(1790));
    }

    public String solution(int n) {
        String result = "";
        while (true) {
            if (n <= 0) break;
            if (n > 1000) {
                n -= 1000;
                result += "M";
            } else if (n >= 900) {
                n-=900;
                result += "CM";
            } else if (n >= 500) {
                n-= 500;
                result += "D";
            } else if (n >= 400) {
                n-= 400;
                result += "CD";
            } else if (n >= 100) {
                n-= 100;
                result += "C";
            }else if (n >= 90) {
                n-= 90;
                result += "XC";
            }else if (n >= 50) {
                n-= 50;
                result += "L";
            }else if (n >= 40) {
                n-= 40;
                result += "XL";
            }else if (n >= 10) {
                n-= 10;
                result += "X";
            }else if (n >= 9) {
                n-= 9;
                result += "IX";
            }else if (n >= 5) {
                n-= 5;
                result += "V";
            }else if (n >= 4) {
                n-= 4;
                result += "IV";
            }else if (n >= 1) {
                n-= 1;
                result += "I";
            }
        }
        return result;
    }


//    private static TreeMap<Integer, String> MAP;
//    static {
//        MAP = new TreeMap<Integer, String>(Collections.reverseOrder());
//        MAP.put( 1, "I" );
//        MAP.put( 4, "IV" );
//        MAP.put( 5, "V" );
//        MAP.put( 9, "IX" );
//        MAP.put( 10, "X" );
//        MAP.put( 40, "XL" );
//        MAP.put( 50, "L" );
//        MAP.put( 90, "XC" );
//        MAP.put( 100, "C" );
//        MAP.put( 400, "CD" );
//        MAP.put( 500, "D" );
//        MAP.put( 900, "CM" );
//        MAP.put( 1000, "M" );
//    }
//
//    public String solution(int n) {
//        StringBuilder builder = new StringBuilder();
//        for( Map.Entry<Integer, String> entry: MAP.entrySet() ){
//            int i = entry.getKey();
//            String s = entry.getValue();
//            while( n>=i ){
//                builder.append(s);
//                n -= i;
//            }
//        }
//        return builder.toString();
//    }
}
