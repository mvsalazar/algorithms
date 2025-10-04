package com.interview.prep.algorithms;

import java.util.Arrays;

public class AddValuesToArray {
    public static int[] solution(int[] arr, int value, int index) {
        for(int i = arr.length - 1; i > index - 1; i--){
            arr[i + 1] = arr[i];
            System.out.println(i);
        }

        arr[index] = value;
        return arr;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1,2,3,4,6,7,8,9,10};
        solution(input, 5, 4);
    }
}
