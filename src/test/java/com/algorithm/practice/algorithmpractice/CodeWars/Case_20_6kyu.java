package com.algorithm.practice.algorithmpractice.CodeWars;

public class Case_20_6kyu { //Stop gninnipS My sdroW!

//    Write a function that takes in a string of one or more words, and returns the same string, but with all five or more letter words reversed (Just like the name of this Kata). Strings passed in will consist of only letters and spaces. Spaces will be included only when more than one word is present.
//
//    Examples:
//
//    spinWords( "Hey fellow warriors" ) => returns "Hey wollef sroirraw"
//    spinWords( "This is a test") => returns "This is a test"
//    spinWords( "This is another test" )=> returns "This is rehtona test"

    public class SpinWords {

        public String spinWords(String sentence) {
            if(sentence.equals("")) return "";
            String [] arr = sentence.split(" ");
            StringBuilder result = new StringBuilder();
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < arr.length; i++){
                if(arr[i].length() >=5){
                    result.append(sb.append(arr[i]).reverse());
                    sb = new StringBuilder();
                } else if (arr[i].equals(" ")) {
                    result.append(" ");
                }else result.append(arr[i]);
                if(i != arr.length -1) result.append(" ");
            }
            return result.toString();
        }
    }
}
