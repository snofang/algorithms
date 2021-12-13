package com.snofang.trial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutation {

    public List<String> getPermutations(String item){
        //converting string -> Character[]
        //List<Character> values =
        Character[] valuesArray =
                item.chars().mapToObj(c -> Character.valueOf((char)c)).collect(Collectors.toList())
                .toArray(new Character[1]);
        //Character[] valuesArray = values.toArray(new Character[values.size()]);

        //getting permutations
        List<Character[]> permutations = getPermutations(valuesArray);

        return permutations.stream()
                .map(p -> Arrays.stream(p).map(String::valueOf).collect(Collectors.joining()))
                .collect(Collectors.toList());
    }

    public <T> List<T[]> getPermutations(T[] items){
        List<T[]> result = new ArrayList<>();
        int counter = calPermutationCount(items);
        int index = 0;
        do{
            result.add(items.clone());
            if(items.length > 1) {
                swap(items, index, nextIndex(items, index));
            }
            index  = nextIndex(items, index);
            counter--;
        }while(counter > 0);
        return result;
    }


    private <T> int calPermutationCount(T[] num){
        int length = num.length;
        int result = 1;
        while(length>0){
            result *= length--;
        }
        return result;
    }

    private <T> void swap(T[] items, int i, int j){
        T tmp = items[i];
        items[i] = items[j];
        items[j] = tmp;
    }

    private <T> int nextIndex(T[] items, int index){
        return ++index % items.length;
    }


}
