package com.github.maxwell.collection;

/**
 * 双向链表
 *
 * @param <E>
 *
 * @author Maxwell Created on 2019/07/10
 */
public class LinkedList<E> implements List<E>, Deque<E> {
    int size = 0;

    Node<E> first;

    Node<E> last;

    /**
     * 构造一个空链表
     */
    public LinkedList() {
    }

    @Override
    public E getFirst() {
        Node<E> fnode = first;
        if (fnode == null)
            throw new NoSuchElementException();
        return fnode.element;
    }

    @Override
    public E getLast() {
        Node<E> lnode = last;
        if (lnode == null)
            throw new NoSuchElementException();
        return lnode.element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(E e) {
        addToLast(e);
        return true;
    }

    @Override
    public void add(int index, E element) {
        //TODO 题目需求无需此操作，暂不实现
    }

    @Override
    public E get(int index) {
        checkElementIndex(index);
        return indexNode(index).element;
    }

    @Override
    public boolean remove(Object o) {
        //TODO 题目需求无需此操作，暂不实现
        return false;
    }

    @Override
    public E remove(int index) {
        //TODO 题目需求无需此操作，暂不实现
        return null;
    }

    public Node<E> getFirstNode() {
        return size == 0 ? null : indexNode(0);
    }

    public Node<E> getLastNode() {
        return size == 0 ? null : indexNode(size - 1);
    }

    void setFirstNode(Node<E> first) {
        this.first = first;
    }

    void setLastNode(Node<E> last) {
        this.last = last;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("null > ");
        Node<E> node = first;
        while (node != null) {
            stringBuilder.append(node.element);
            stringBuilder.append(" > ");
            node = node.next;
        }
        stringBuilder.append("null");
        return stringBuilder.toString();
    }

    private void addToLast(E e) {
        Node<E> lnode = last;
        Node<E> newNode = new Node<>(lnode, e, null);
        last = newNode;
        if (lnode == null)
            first = newNode;
        else
            lnode.next = newNode;
        size++;
    }

    /**
     * 根据节点位置查找节点，为提高性能，执行一次二分查找
     *
     * @param index
     * @return
     */
    private Node<E> indexNode(int index) {
        checkElementIndex(index);
        if (index < (size >> 1)) { //节点前半部分查找
            Node<E> tmp = first;
            for (int i = 0; i < index; i++)
                tmp = tmp.next;
            return tmp;
        } else {
            Node<E> tmp = last;
            for (int i = size - 1; i > index; i--)
                tmp = tmp.prev;
            return tmp;
        }
    }

    private void checkElementIndex(int index) {
        boolean b = (index >= 0 && index < size);
        if (!b)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    /**
     * 内部数据结构
     *
     * @param <E>
     */
    static class Node<E> {
        E element;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }

}
