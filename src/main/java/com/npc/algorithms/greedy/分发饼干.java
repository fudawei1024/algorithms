package com.npc.algorithms.greedy;

import com.npc.algorithms.util.Util;

import java.util.Arrays;

public class 分发饼干 {

    public static void main(String[] args) {
        int c = new 分发饼干().findContentChildren(new int[]{2,3,5}, new int[]{2,3,4});
        Util.p(c);
    }
    public int findContentChildren(int[] g, int[] s) {
        if (g == null || s == null || g.length ==0 || s.length == 0) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int index = s.length - 1;
        int count = 0;
        for (int i = g.length - 1; i >= 0; i--) {
            if (g[i] <= s[index] && index >= 0) {
                index --;
                count ++;
            }
        }
        return count;
    }
}
