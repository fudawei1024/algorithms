package com.npc.algorithms.手写常见数据结构.test;

import com.npc.algorithms.手写常见数据结构.SkipList;

public class SkipTest {
    public static void main(String[] args) {
        SkipList<Integer, Integer> skipList = new SkipList();

        for (int i = 0; i< 1000;i ++) {
            skipList.put(i + 1, i + 1);
        }

        skipList.allCount();
    }

}
