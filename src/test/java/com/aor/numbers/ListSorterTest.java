package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ListSorterTest {
    private List<Integer> helper(){
        return Arrays.asList(3,2,6,1,4,5,7);
    }
    private List<Integer> helper2(){
        return Arrays.asList(1,2,3,4,5,6,7);
    }
    @Test
    public void sort() {
        List<Integer> list = helper();
        List<Integer> expected = helper2();

        ListSorter sorter = new ListSorter();
        List<Integer> sorted = sorter.sort(list);

        Assertions.assertEquals(expected, sorted);
    }
}
