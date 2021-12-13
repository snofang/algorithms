package com.snofang.trial;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Permutation {

    @Test
    void doTest() {

        //three int members permutation  verification
        List<Integer[]> permutations = getPermutations(new Integer[]{1, 2, 3});
        long existingExpectedPermutationsCount = Stream.of(new Integer[]{1, 2, 3}, new Integer[]{1, 3, 2}, new Integer[]{2, 1, 3},
                new Integer[]{2, 3, 1}, new Integer[]{3, 1, 2}, new Integer[]{3, 2, 1}).
                filter(ep -> permutations.stream().filter(p -> Arrays.equals(p, ep)).findAny().isPresent())
                .count();
        assertEquals(existingExpectedPermutationsCount, permutations.size());
    }


    <T> List<T[]> getPermutations(T[] nums){
        List<T[]> result = new ArrayList<>();
        int counter = calPermutationCount(nums);
        int index = 0;
        do{
            result.add(nums.clone());
            if(nums.length > 1) {
                swap(nums, index, nextIndex(nums, index));
            }
            index  = nextIndex(nums, index);
            counter--;
        }while(counter > 0);
        return result;
    }


    <T> int calPermutationCount(T[] num){
        int length = num.length;
        int result = 1;
        while(length>0){
            result *= length--;
        }
        return result;
    }
    <T> void swap(T[] nums, int i, int j){
        T tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    <T> int nextIndex(T[] nums, int index){
        return ++index % nums.length;
    }

}
