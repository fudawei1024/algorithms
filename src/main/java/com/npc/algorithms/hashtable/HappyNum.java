package com.npc.algorithms.hashtable;

import java.util.HashSet;
import java.util.Set;

public class HappyNum {
    public static void main(String[] args) {
        System.out.println(isHappyNum(19));
    }

    public static boolean isHappyNum(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = sum(n);
        }
        return n == 1;
    }

    public static int sum(int n) {
        int sum = 0;
        while (n > 0) {
            int tmp = n % 10;
            sum += tmp * tmp;
            n = n / 10;
        }
        return sum;
    }

}
