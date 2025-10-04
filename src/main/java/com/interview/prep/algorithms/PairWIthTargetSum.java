package com.interview.prep.algorithms;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an array of numbers sorted in ascending order and a target sum, 
 * find a pair in the array whose sum is equal to the given target.
 * Write a function to return the indices of the two numbers (i.e. the pair) 
 * such that they add up to the given target. If no such pair exists return [-1, -1].
 * 
 * Example 1:
 * Input: [1, 2, 3, 4, 6], target=6
 * Output: [1, 3]
 * Explanation: The numbers at index 1 and 3 add up to 6: 2+4=6
*/
public class PairWIthTargetSum {

    // This solution only works if the constraints don't include negative numbers, for example:
    // {-1,-2,-3,-4,-5} - in this case there will be an IndexOutBounds exception, because adding 
    // two negatives will always be less than the target and at one point the left will be greater
    // than the length of the array, throwing the exception. See solution 2 for the correct approach.
    public static int[] solution(int[] input, int target) {
        // We use the two pointer solution on this problem
        int left = 0;
        int right = input.length - 1;

        for(int i = 0; i < input.length; i++) {
            if(input[left] + input[right] == target) {
                return new int[]{left, right};
            }

            if(input[left] + input[right] < target) {
                left++;
            }

            if(input[left] + input[right] > target) {
                right--;
            }
        }

        return new int[]{-1, -1};
    }

    public static int[] solution2(int[] input, int target) {
        HashMap<Integer, Integer> seen = new HashMap<>();
        for(int i = 0; i < input.length; i++) {
            int diff = target - input[i];

            if(seen.containsKey(diff)) {
                return new int[]{seen.get(diff), i};
            }

            seen.put(input[i], i);
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] solution = solution2(new int[]{-1,-2,-3,-4,-5}, -6);
        System.out.println(Arrays.toString(solution));
    }
}
