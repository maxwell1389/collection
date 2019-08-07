package com.github.maxwell.collection;

/**
 *
 * @param <E>
 */
public interface List<E> {
    int size();

    boolean add(E e);

    void add(int index, E element);

    E get(int index);

    boolean remove(Object o);

    E remove(int index);
}
