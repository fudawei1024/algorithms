package com.npc.algorithms.手写常见数据结构.test;

import com.npc.algorithms.util.TreeShow;
import com.npc.algorithms.手写常见数据结构.AVL;
import com.npc.algorithms.手写常见数据结构.SkipList;

public class AVLTest {
    public static void main(String[] args) {
        AVL<Integer, Integer> avl = new AVL<>();

        for (int i = 0; i < 64; i++) {
            avl.put( i + 1, i + 1);
        }

        new TreeShow(avl.root).print();
    }
}
