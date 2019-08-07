package com.github.maxwell.collection;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class LinkedListTest {

    @Test
    void testGetFirst() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("1");
        linkedList.add("2");
        assertEquals("1", linkedList.getFirst());
    }

    @Test
    void testGetLast() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");
        assertEquals("3", linkedList.getLast());
    }

    @Test
    void testSize() {
        List<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        assertEquals(3, ((LinkedList<Integer>) linkedList).size);
    }

    @Test
    void testAdd() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");
        for (int i = 0; i < linkedList.size; i++) {
            assertEquals(String.valueOf(i + 1), linkedList.get(i));
        }
    }

    @Test
    void testGet() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("1");
        assertEquals("1", linkedList.get(0));
    }

    @Test
    void testGetFirstNode() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("1");
        linkedList.add("2");
        assertEquals("1", linkedList.getFirstNode().element);
    }

    @Test
    void testGetLastNode() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("1");
        linkedList.add("2");
        assertEquals("2", linkedList.getLastNode().element);
    }

    @Test
    public void testToString() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");
        assertEquals("null > 1 > 2 > 3 > null", linkedList.toString());
    }
}