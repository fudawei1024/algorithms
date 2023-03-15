package com.npc.algorithms.手写常见数据结构;

public interface SortTable<K extends Comparable, V> {

    void put(K key, V value);

    V get(K key);

    boolean containsKey(K key);

    K floorKey(K key);

    K ceilingKey(K key);

    K firstKey();

    K lastKey();

    void remove(K key);

    int size();
}
