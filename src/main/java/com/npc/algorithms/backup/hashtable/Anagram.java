package com.npc.algorithms.backup.hashtable;

public class Anagram {

    public static void main(String[] args) {
        System.out.println(isAnagram2("ac", "bb"));
    }

    public static boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return false;
        }

        int[] record = new int[26];
        for (char c : s.toCharArray()) {
            record[c - 'a'] ++;
        }
        for (char c : t.toCharArray()) {
            record[c - 'a'] --;
        }

        for (int i : record) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean isAnagram2(String s, String t) {
        if (s == null || t == null) {
            return false;
        }

        if (s.length() != t.length()) {
            return false;
        }

        int sum = 0;
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        for (int i=0;i< s.length() ; i++) {
            sum += (sArray[i] - 'a') - (tArray[i] - 'a');
        }

        if (sum != 0) {
            return false;
        }
        return true;
    }
}
