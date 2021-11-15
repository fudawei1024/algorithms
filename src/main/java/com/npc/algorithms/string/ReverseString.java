package com.npc.algorithms.string;

import com.npc.algorithms.Util;

public class ReverseString {
    public static void main(String[] args) {
        char[] str = "abcdefg".toCharArray();
        Util.p(str);
        Util.pl();
        reverseString(str);
        Util.p(str);
    }

    public static void reverseString(char[] cArray) {
        if (cArray == null || cArray.length == 0) {
            return;
        }
        int index = 0;
        int length = cArray.length - 1;
        while (index < cArray.length / 2) {
            cArray[index] ^= cArray[length - index];
            cArray[length - index] ^= cArray[index];
            cArray[index] ^= cArray[length - index++];
        }
    }
}
