package com.npc.algorithms.string;

/**
 * @projectName: algorithms
 * @package: com.npc.algorithms.string
 * @className: KMP
 * @author: fudawei
 * @description: TODO
 * @date: 2021/11/17 11:05
 * @version: 1.0
 */
public class KMP {
    public static void main(String[] args) {
        String s = "1234567890";
        String t = "4560";
        System.out.println(getStr(s, t));
    }

    public static int getStr(String s, String t) {
        if (s == null || t == null) {
            return -1;
        }
        if (t.length() == 0) {
            return 0;
        }

        int[] next = new int[t.length()];
        next(next, t);
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != t.charAt(j)) {
                j = next[j - 1];
            }

            if (s.charAt(i) == t.charAt(j)) {
                j ++;
            }
            if (j == t.length()) {
                return (i - t.length() + 1);
            }
        }
        return -1;
    }

    public static void next(int[] next, String pattern) {
        if (pattern == null || pattern.length() == 0) {
            return;
        }

        int j = 0;
        for (int i = 1; i < pattern.length(); i++) {
            if (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = next[j - 1];
            }

            if (pattern.charAt(i) == pattern.charAt(j)) {
                j ++;
            }
            next[i] = j;
        }
    }
}
