package com.interview.prep.algorithms;

import java.util.HashMap;

public class RomanToInteger {
    public static int solution(String string) {
        String[] stringArray = string.toUpperCase().split("");
        String nextString = null;
        int runningValue = 0;
        int nextValidIndex = 0;

        HashMap<String, Integer> romanToIntegerMapping = new HashMap<>();
        romanToIntegerMapping.put("I", 1);
        romanToIntegerMapping.put("IV", 4);
        romanToIntegerMapping.put("V", 5);
        romanToIntegerMapping.put("IX", 9);
        romanToIntegerMapping.put("X", 10);
        romanToIntegerMapping.put("XL", 40);
        romanToIntegerMapping.put("L", 50);
        romanToIntegerMapping.put("XC", 90);
        romanToIntegerMapping.put("C", 100);
        romanToIntegerMapping.put("CD", 400);
        romanToIntegerMapping.put("D", 500);
        romanToIntegerMapping.put("CM", 900);
        romanToIntegerMapping.put("M", 1000);

        for(int i = 0; i < stringArray.length; i++) {
            if(i != nextValidIndex) {
                continue;
            }

            if(i == stringArray.length - 1) {
                runningValue = romanToIntegerMapping.get(stringArray[i]) + runningValue;
            } else {
                nextString = stringArray[i + 1];
                String concatString = stringArray[i].concat(nextString);
                switch(concatString) {
                    case "IV":
                    case "IX":
                    case "XL":
                    case "XC":
                    case "CD":
                    case "CM":
                        runningValue = romanToIntegerMapping.getOrDefault(concatString, 0) + runningValue;
                        nextValidIndex = i + 2;
                        break;
                    default:
                        runningValue = romanToIntegerMapping.getOrDefault(stringArray[i], 0) + runningValue;
                        nextValidIndex = i + 1;
                        break;
                }
            }
        }

        return runningValue;
    }

    public static void main(String[] args) {
        System.out.println(solution("DCXXI"));
    }
}
