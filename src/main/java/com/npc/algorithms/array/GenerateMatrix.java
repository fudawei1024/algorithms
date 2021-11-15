package com.npc.algorithms.array;

public class GenerateMatrix {

    public static void main(String[] args) {
        int[][] array = generateMatrix(5);

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i][j] < 10) {
                    System.out.print( " " + array[i][j]);
                } else {
                    System.out.print(array[i][j]);

                }

                System.out.print("     ");
            }
            System.out.println();
            System.out.println();
        }
    }

    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int loop = n / 2;
        int startX = 0;
        int startY = 0;
        int count = 0;
        int offset = 1;
        int mid = n /2;
        while (loop > 0) {
            int i = startX;
            int j = startY;

            // 从左到右
            for (; j<startY + n - offset; ++j) {
                res[i][j] = ++count;
            }
            for (; i<startX + n - offset; ++i) {
                res[i][j] = ++count;
            }

            // 从左到右
            for (; j > startY; --j) {
                res[i][j] = ++count;
            }

            // 从左到右
            for (; i > startX; --i) {
                res[i][j] = ++count;
            }

            startX += 1;
            startY += 1;
            --loop;
            offset += 2;
        }

        if (n % 2 == 1) {
            res[mid][mid] = ++count;
        }

        return res;
    }

    public static int[][] generateMatrix1(int n) {
        int[][] res = new int[n][n];

        // 循环次数
        int loop = n / 2;

        // 定义每次循环起始位置
        int startX = 0;
        int startY = 0;

        // 定义偏移量
        int offset = 1;

        // 定义填充数字
        int count = 1;

        // 定义中间位置
        int mid = n / 2;
        while (loop > 0) {
            int i = startX;
            int j = startY;

            // 模拟上侧从左到右
            for (; j<startY + n -offset; ++j) {
                res[startX][j] = count++;
            }

            // 模拟右侧从上到下
            for (; i<startX + n -offset; ++i) {
                res[i][j] = count++;
            }

            // 模拟下侧从右到左
            for (; j > startY; j--) {
                res[i][j] = count++;
            }

            // 模拟左侧从下到上
            for (; i > startX; i--) {
                res[i][j] = count++;
            }

            loop--;

            startX += 1;
            startY += 1;

            offset += 2;
        }

        if (n % 2 == 1) {
            res[mid][mid] = count;
        }

        return res;
    }
}
