package com.npc.algorithms.util;

import com.npc.algorithms.手写常见数据结构.AVL;

public class SortedNode <K extends Comparable, V> {
    public K key;
    public V value;

    public AVL.AVLNode<K, V> left;
    public AVL.AVLNode<K, V> right;

    public V getValue() {
        return value;
    }
}
