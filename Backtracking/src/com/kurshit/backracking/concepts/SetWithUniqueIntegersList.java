package com.kurshit.backracking.concepts;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetWithUniqueIntegersList {

    public static void main(String[] args) {
        List<Integer> l1 = Arrays.asList(1,2,3);
        List<Integer> l2 = Arrays.asList(1,2,3,4 );
        List<Integer> l3 = Arrays.asList(1,2,4);
        List<Integer> l4 = Arrays.asList(1,2,4);
        List<Integer> l5 = Arrays.asList(1,2,3);


        Set<List<Integer>> set = new HashSet<>();

        set.add(l1);
        set.add(l2);
        set.add(l3);
        set.add(l4);
        set.add(l5);

        System.out.println(set);
    }
}
