package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sun.net.www.content.text.Generic;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class ListAggregatorTest {
    private List<Integer> list;

    @BeforeEach
    public void helper() {
        list = Arrays.asList(1, 2, 4, 2, 5);
    }

    @Test
    public void sum() {

        ListAggregator aggregator = new ListAggregator();
        int sum = aggregator.sum(list);

        Assertions.assertEquals(14, sum);
    }

    @Test
    public void max() {

        ListAggregator aggregator = new ListAggregator();
        int max = aggregator.max(list);

        Assertions.assertEquals(5, max);
    }

    @Test
    public void max_bug_7263() {

        ListAggregator aggregator = new ListAggregator();
        int max2 = aggregator.max(Arrays.asList(-1, -4, -5));

        Assertions.assertEquals(-1, max2);
    }

    @Test
    public void min() {

        ListAggregator aggregator = new ListAggregator();
        int min = aggregator.min(list);

        Assertions.assertEquals(1, min);
    }

    @Test
    public void distinct() {

        ListAggregator aggregator = new ListAggregator();
        ListDeduplicator deduplicator = new ListDeduplicator();
        ListSorter listSorter = new ListSorter();
        int distinct = aggregator.distinct(list, deduplicator, listSorter);

        Assertions.assertEquals(4, distinct);
    }

    @Test
    public void distinct_bug_8726() {
        class StubDeduplicator implements GenericListDeduplicator {
            @Override
            public List<Integer> deduplicate(List<Integer> list, GenericListSorter listSorter){
                return Arrays.asList(1,2,4);
            }
        }
        class StubSorter implements GenericListSorter {
            @Override
            public List<Integer> sort(List<Integer> list){
                return Arrays.asList(1,2,2,4);
            }
        }
        ListAggregator aggregator = new ListAggregator();

        int distinct = aggregator.distinct(Arrays.asList(1, 2, 4, 2), new StubDeduplicator(), new StubSorter());


        Assertions.assertEquals(3, distinct);
    }
}