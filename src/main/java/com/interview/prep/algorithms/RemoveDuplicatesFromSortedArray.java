package com.interview.prep.algorithms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.*;

public class RemoveDuplicatesFromSortedArray {
    public static int[] solution(int[] array) {
        Set<Integer> integerSet = new LinkedHashSet<>();

        for(int i = 0; i < array.length; i++) {
            integerSet.add(array[i]);
        }

        return integerSet
            .stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }

    public static int[] solution2(int[] array) {
        int k = 1;
        for(int i = 1; i < array.length; i++){
            if(array[i] != array[k - 1]) {
                array[k] = array[i];
                k++;
            }
        }
        System.out.println(k);
        return Arrays.copyOf(array, k);
    }

    public static void main(String[] args) {
        int[] input = new int[]{1,2,3,3,4,5,6,6,7,8};
        int[] sol = solution2(input);
        System.out.println(Arrays.toString(sol));
    }
}
