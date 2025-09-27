package com.interview.prep.algorithms;

public class PalindromeNumber {
    public static boolean solution(int number) {
        if (number < 0) return false; // negative numbers aren't palindromes

        int original = number;
        int reversed = 0;

        while (number > 0) {
            int digit = number % 10;  
            reversed = reversed * 10 + digit; // build reversed number
            number /= 10;                     // remove last digit
        }

        return original == reversed;
    }

    public static void main(String[] args) {
        System.out.println(solution(1212121));
    }
}
