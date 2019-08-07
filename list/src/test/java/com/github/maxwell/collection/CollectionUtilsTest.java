package com.github.maxwell.collection;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class CollectionUtilsTest {

    @Test
    void testReverse() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");
        assertEquals("null > 3 > 2 > 1 > null", CollectionUtils.reverse(linkedList).toString());
    }
}