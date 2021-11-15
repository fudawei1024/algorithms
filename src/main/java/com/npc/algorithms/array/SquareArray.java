package com.npc.algorithms.array;

public class SquareArray {

    public static void main(String[] args) {
       int[] array = new int[] {-9,-7, -2,0, 8,10,30};
        //int[] array = new int[] {-9,8};

        print(array);
        print(square(array));
    }

    public static int[] square2(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        int[] result = new int[array.length];
        int left = 0, right = array.length - 1;
        int index = array.length - 1;
        while(left <= right && index >= 0) {
            if (array[left] * array[left] > array[right] * array[right]) {
                result[index--] = array[left] * array[left++];
            } else {
                result[index--] = array[right] * array[right--];
            }
        }
        return result;
    }

    public static int[] square(int[] array) {
        if (array == null) return array;

        int[] result = new int[array.length];
        int  index=array.length - 1,left = 0, right = array.length - 1;
        while (left <= right && index >=0) {
            if (array[left] * array[left] < array[right] * array[right]) {
                result[index--] = array[right] * array[right--];
            } else {
                result[index--] = array[left] * array[left++];
            }
        }
        return result;
    }

    public static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            System.out.print(" ");
        }
        System.out.println();
    }
}
