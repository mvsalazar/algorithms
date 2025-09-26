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
    /**
     * Brute force approach with time complexity O(n log n)
     */
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

    /**
     * More efficient with single pass an time complexity of O(n)
     */
    public static int[] solution2(int[] arr) {
        // We can use two pointers
        int n = arr.length;
        int [] squares = new int[n];
        int highestSquareIndex = n - 1;
        int left = 0;
        int right = n - 1;

        while(left <= right) {
            int leftSquare = arr[left] * arr[left];
            int rightSquare = arr[right] * arr[right];

            if(leftSquare > rightSquare) {
                squares[highestSquareIndex--] = leftSquare;
                left++;
            } else {
                squares[highestSquareIndex--] = rightSquare;
                right--;
            }           
        }

        return squares;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-2, -1, 0, 2, 3};
        int[] result = solution(arr);
        int[] result2 = solution2(arr);

        System.out.println(Arrays.toString(result));
        System.out.println();
        System.out.println(Arrays.toString(result2));

        // [0, 1, 4, 4, 9]
        //
        // [0, 1, 4, 4, 9]
    }
}