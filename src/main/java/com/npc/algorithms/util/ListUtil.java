package com.npc.algorithms.util;

import java.util.List;

public class ListUtil {
    public static int[] toArray(List<Integer> list) {
        if (list == null) {
            return new int[0];
        }

        int size = list.size();
        int[] intArray = new int[size];
        int index = 0;
        while (index < size) {
            intArray[index] = list.get(index++);
        }
        return intArray;
    }
}
