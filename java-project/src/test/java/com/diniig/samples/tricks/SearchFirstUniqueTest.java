package com.diniig.samples.tricks;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SearchFirstUniqueTest {

    Integer[] f = new Integer[] { 1, 2, 2, 3, 1, 4, 5 };

    @Test
    void searchFirstUnique_1() {
        List<Integer> l = new ArrayList<>();
        Collections.addAll(l, (Integer[]) f);
        int unique = 0;
        for (int i = 0; i < f.length; i++) {
            if (l.indexOf(f[i]) == l.lastIndexOf(f[i])) {
                unique = f[i];
                break;
            }
        }

        System.out.println("unique: " + unique);
    }

    @Test
    void searchFirstUnique_2() {
        List<Integer> numbers = Arrays.asList(f);
        Integer unique = numbers.stream()
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                    .entrySet()
                    .stream()
                    .filter(e -> e.getValue() == 1)
                    .findFirst().get().getKey();

        System.out.println("unique: " + unique);
    }

    @Test
    void searchFirstUnique_0() {
        LinkedHashMap<Integer, Integer> lhp = new LinkedHashMap<>();
        for (int i = 0; i < f.length; i++) {
            lhp.compute(f[i], (k, v) -> v == null ? 1 : v + 1);
        }

        Integer res = lhp.entrySet().stream().filter(t -> t.getValue() == 1).findFirst().get().getKey();
        System.out.println("res: " + res);
    }
}
