package com.npc.algorithms.hashtable;

import java.util.HashSet;
import java.util.Set;

public class HappyNum {
    public static void main(String[] args) {
        System.out.println(happyNum(19));
    }

    public static boolean happyNum(int n) {
        Set<Integer> data = new HashSet<>();
        while (n != 1 && !data.contains(n)) {
            data.add(n);
            n = sumNum(n);
        }
        return n == 1;
    }

    public static int sumNum(int n) {
        int res = 0;
        while(n > 0) {
            int tmp = n % 10;
            res += tmp * tmp;
            n = n / 10;
        }
        return res;
    }
}
