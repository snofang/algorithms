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

public class PermutationTest {

    @Test
    void integerPermutationTest() {
        List<Integer[]> permutations = new Permutation().getPermutations(new Integer[]{1, 2, 3});
        long existingExpectedPermutationsCount = Stream.of(new Integer[]{1, 2, 3}, new Integer[]{1, 3, 2}, new Integer[]{2, 1, 3},
                new Integer[]{2, 3, 1}, new Integer[]{3, 1, 2}, new Integer[]{3, 2, 1}).
                filter(ep -> permutations.stream().filter(p -> Arrays.equals(p, ep)).findAny().isPresent())
                .count();
        assertEquals(existingExpectedPermutationsCount, permutations.size());
    }


    @Test
    void stringPermutationTest(){
        List<String> permutations = new Permutation().getPermutations("abc");

        long existingExpectedPermutationsCount = Stream.of("abc", "acb", "bac", "bca", "cab", "cba").
                filter(ep -> permutations.stream().filter(p -> p.equals(ep)).findAny().isPresent())
                .count();
        assertEquals(existingExpectedPermutationsCount, permutations.size());

    }

}
