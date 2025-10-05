package com.interview.prep.algorithms;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParantheses {
    public static boolean solution(String s) {
        Deque<Character> openBrackets = new ArrayDeque<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(c == '(' || c == '{' || c == '[') {
                openBrackets.push(s.charAt(i));
                continue;
            }
            if(c == ')' || c == '}' || c == ']') {
                if(openBrackets.isEmpty()) return false;
                char top = openBrackets.pop();

                if(
                    (c == ')' && top != '(') || 
                    (c == '}' && top != '{') || 
                    (c == ']' && top != '[')
                ) return false;

            }
        }
        return openBrackets.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(solution("{{(())}}"));
        System.out.println(solution("]]"));
        System.out.println(solution("((}))"));
        System.out.println(solution("()"));
    }
}
