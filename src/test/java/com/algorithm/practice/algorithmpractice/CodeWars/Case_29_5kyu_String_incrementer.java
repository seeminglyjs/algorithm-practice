package com.algorithm.practice.algorithmpractice.CodeWars;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.testng.AssertJUnit.assertEquals;

@SpringBootTest
public class Case_29_5kyu_String_incrementer { //Best travel


    public static String incrementString(String str) {
        Pattern pattern = Pattern.compile("([0-8]?)(9*)$");
        Matcher matcher = pattern.matcher(str);
        StringBuffer stringBuffer = new StringBuffer();

        if (matcher.find()) {
            String group = matcher.group();
            String replacement = String.valueOf(group.isEmpty() ? Integer.parseInt("1") : Integer.parseInt(group)+1);
            matcher.appendReplacement(stringBuffer, replacement);
        }

        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    static Set<Character> number = new HashSet<>(Arrays.asList('1','2','3','4','5','6','7','8','9'));

    public static String incrementString3(String str) {
        if(str.isBlank()) return "1";
        // 숫자가 아닌 문자열 분리
        StringBuilder textPartBuilder = new StringBuilder();
        int i = 0;

        while (i < str.length() && (!Character.isDigit(str.charAt(i)) || str.charAt(i) == '0') || checkRemainingString(str, i)) {
            textPartBuilder.append(str.charAt(i));
            i++;
        }

        // 숫자 분리
        StringBuilder numberPartBuilder = new StringBuilder();
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            numberPartBuilder.append(str.charAt(i));
            i++;
        }

        if(!numberPartBuilder.isEmpty()){
            long plusNumber = Long.parseLong(numberPartBuilder.toString()) + 1;
            System.out.println(plusNumber);
            if(numberPartBuilder.toString().length() < String.valueOf(plusNumber).length()){
                if (lastZeroCheck(textPartBuilder))textPartBuilder.setLength(textPartBuilder.length() - 1);
                textPartBuilder.append(plusNumber);
            }else{
                textPartBuilder.append(plusNumber);
            }
        }else{
            if (lastZeroCheck(textPartBuilder)) textPartBuilder.setLength(textPartBuilder.length() - 1);
            textPartBuilder.append("1");
            System.out.println(textPartBuilder.toString());
        }

        return textPartBuilder.toString(); // you code here
    }

    public static boolean checkRemainingString(String str, int startIndex){
        String restStr = str.substring(startIndex);
        for (int i = 0; i < restStr.length(); i++) if(!number.contains(restStr.charAt(i)))return  true;
        return  false;
    }
    public static boolean lastZeroCheck(StringBuilder textPartBuilder){
        return textPartBuilder.toString().charAt(textPartBuilder.toString().length() - 1) == '0';
    }



    private static void doTest(String str, String expected) {
        String actual = assertDoesNotThrow(() -> incrementString(str), "Solution thrown an unexpected exception for str=\"" + str + "\"\n\n");
        assertEquals(expected, actual, "Incorrect answer for str=\"" + str + "\"\n\n");
    }

    @Test
    public void exampleTests() {
        System.out.println(incrementString("00000000000000000000135172794491"));

//        doTest("foobar000", "foobar001");
//        doTest("foo", "foo1");
//        doTest("foobar001", "foobar002");
//        doTest("foobar99", "foobar100");
//        doTest("foobar099", "foobar100");
//        doTest("", "1");
    }
}
