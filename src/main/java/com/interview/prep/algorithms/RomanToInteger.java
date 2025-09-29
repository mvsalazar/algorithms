package com.interview.prep.algorithms;

import java.util.HashMap;
import java.util.Map;

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

    /**
     * I took this from LeetCode, it's facinating, so I wanted to study it. 
     * The idea behind it, follows the manual way of figuring out what the numeral totals to.
     * Add if the numeral is >= the one after it
     * Subtract if it’s < the one after it
     * 
     * Example: MCMXCIV
	    1.	Start with the last symbol: V = 5
	    2.	Move left:
	        •	I before V → smaller → subtract → -1
	        •	C before I → larger → add → +100
	        •  	X before C → smaller → subtract → -10
	        •	M before X → larger → add → +1000
	        •	C before M → smaller → subtract → -100
	        •	M before C → larger → add → +1000
	    3.	Total = 1000 - 100 + 1000 - 10 + 100 - 1 + 5 = 1994
     */
    public static int solution2(String s) {
        String cs = "IVXLCDM";
        int[] vs = {1, 5, 10, 50, 100, 500, 1000};
        Map<Character, Integer> d = new HashMap<>();
        for (int i = 0; i < vs.length; ++i) {
            d.put(cs.charAt(i), vs[i]);
        }
        int n = s.length();
        int ans = d.get(s.charAt(n - 1));
        for (int i = 0; i < n - 1; ++i) {
            int sign = d.get(s.charAt(i)) < d.get(s.charAt(i + 1)) ? -1 : 1;
            ans += sign * d.get(s.charAt(i));
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(solution("cdxiii"));
    }
}
