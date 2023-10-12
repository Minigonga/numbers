package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ListDeduplicatorTest {
    private List<Integer> helper(){
        return Arrays.asList(1,2,4,2,5);
    }
    private List<Integer> helper2(){
        return Arrays.asList(1,2,4,5);
    }
    @Test
    public void deduplicate() {
        List<Integer> list = helper();
        List<Integer> expected = helper2();

        ListDeduplicator deduplicator = new ListDeduplicator();
        List<Integer> distinct = deduplicator.deduplicate(list);

        Assertions.assertEquals(expected, distinct);
    }
}
