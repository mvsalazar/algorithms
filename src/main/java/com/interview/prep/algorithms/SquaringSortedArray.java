package com.interview.prep.algorithms;

import java.util.*;;

/**
 * Given a sorted array, create a new array containing squares of all the 
 * numbers of the input array in the sorted order.
 * 
 * Example:
 * Input: [-2, -1, 0, 2, 3]
 * Output: [0, 1, 4, 4, 9]
 */
public class SquaringSortedArray {
    public static int[] solution(int[] arr) {
        int[] squaredArray = new int[arr.length]; 

        for(int i = 0; i < arr.length; i++){
            // Alternatively we use int squareValue = arr[i] * arr[i];
            int squaredValue = (int) Math.pow(arr[i], 2); 
            squaredArray[i] = squaredValue;
        }
        Arrays.sort(squaredArray);

        return squaredArray;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-2, -1, 0, 2, 3};
        int[] result = solution(arr);

        System.out.println(Arrays.toString(result));
    }
}
