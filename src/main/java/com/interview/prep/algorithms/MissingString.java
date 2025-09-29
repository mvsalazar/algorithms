package com.interview.prep.algorithms;

public class MissingString {
    public static String solution(String str) {
        // [3x, +, 12, =, 46]
        // [46, =, 3x, +, 12]
        String[] strings = str.split(" ");
        int total = 0;
        String operator = null;
        int constant = 0;
        int missingDigitIndex = 0;
        int efficient = 0;


        if(strings[3].equals("=")) {
            total = Integer.parseInt(strings[4]);
            operator = strings[1];
        } else if(strings[1].equals("=")) {
            total = Integer.parseInt(strings[0]);
            operator = strings[3];
        }
        
        for(int i = 0; i < strings.length; i++) {
            if(strings[i].contains("x")) {
                missingDigitIndex = i;
                if(strings[3].equals("=")) {
                    if(i == 0) {
                        constant = Integer.parseInt(strings[i + 2]);
                        efficient = i;
                        missingDigitIndex = strings[i].indexOf("x");
                    }

                    if(i == 2) {
                        constant = Integer.parseInt(strings[i - 2]);
                        efficient = i;
                        missingDigitIndex = strings[i].indexOf("x");
                    }
                    break;
                } else {
                    if(i == 2) {
                        constant = Integer.parseInt(strings[i + 2]);
                        efficient = i;
                        missingDigitIndex = strings[i].indexOf("x");
                    }

                    if(i == 4) {
                        constant = Integer.parseInt(strings[i - 2]);
                        efficient = i;
                        missingDigitIndex = strings[i].indexOf("x");
                    }
                    break;
                }
            }
        }

        switch(operator) {
            case "+":
                efficient = total - constant;
                break;
            case "-":
                efficient = total + constant;
                break;
            case "/":
                efficient = total * constant;
                break;
            case "*":
                efficient = total / constant;
                break;
        }
    
        return Character.toString(
            Integer
                .toString(efficient)
                .charAt(missingDigitIndex)
            );
    }

    public static void main(String[] args) {
        // "3x + 12 = 46"
        // "46 = 3x + 12"
        String input = "3x + 12 = 46"; // -> 4
        String input2 = "12 + 3x = 46"; // -> 4
        String input3 = "1x0 + 25 = 128"; // -> 0
        String input4 = "46 = 3x + 12"; // -> 4
        String input5 = "25 * x0 = 1000"; // -> 4



        System.out.println(solution(input));
        System.out.println(solution(input2));
        System.out.println(solution(input3));
        System.out.println(solution(input4));
        System.out.println(solution(input5));
    }
}
