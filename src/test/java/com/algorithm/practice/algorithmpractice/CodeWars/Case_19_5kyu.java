package com.algorithm.practice.algorithmpractice.CodeWars;

import org.junit.jupiter.api.Test;

import static org.testng.AssertJUnit.assertEquals;

public class Case_19_5kyu { //Simple Pig Latin
//    Move the first letter of each word to the end of it, then add "ay" to the end of the word. Leave punctuation marks untouched.
//
//    Examples
//    pigIt('Pig latin is cool'); // igPay atinlay siay oolcay
//    pigIt('Hello world !');     // elloHay orldway !

    @Test
    public void FixedTests() {
        assertEquals("igPay atinlay siay oolcay", PigLatin.pigIt("Pig latin is cool"));
        assertEquals("hisTay siay ymay tringsay", PigLatin.pigIt("This is my string"));
        System.out.println( PigLatin.pigIt("<...tora o mores ![]>"));
    }

    public class PigLatin {
        public static String pigIt(String str) {
            if(str == null || str.equals("")) return "";
            String ay = "ay";
            StringBuilder sbResult = new StringBuilder();
            String [] arr = str.split(" ");
            for(int i = 0; i < arr.length; i++){
                if(i !=0) sbResult.append(" ");
                if(arr[i].length() > 1){
                    sbResult.append(arr[i].substring(1));//rest word
                    sbResult.append(arr[i].charAt(0));//first word
                    if((sbResult.charAt(sbResult.length()-1) >= 65 &&  sbResult.charAt(sbResult.length()-1) <= 90)
                            || (sbResult.charAt(sbResult.length()-1) >= 97 &&  sbResult.charAt(sbResult.length()-1) <= 122))sbResult.append(ay);
                }else if(arr[i].length() == 1){
                    sbResult.append(arr[i]);
                    if((sbResult.charAt(sbResult.length()-1) >= 65 &&  sbResult.charAt(sbResult.length()-1) <= 90)
                            || (sbResult.charAt(sbResult.length()-1) >= 97 &&  sbResult.charAt(sbResult.length()-1) <= 122))sbResult.append(ay);
                }
            }
            return sbResult.toString();
        }
    }

    public class PigLatin2 {
        public static String pigIt(String str) {
            return str.replaceAll("(\\w)(\\w*)", "$2$1ay");
        }
    }
}
