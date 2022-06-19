package com.npc.algorithms.backup.array2.array;

/**
 * @className: T4_长度最小的子数组
 * @author: fudawei
 *
 * 给定一个正整数 n，生成一个包含 1 到 $n^2$ 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * 示例:
 * 输入: 3 输出: [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5 ] ]
 *
 * #
 *
 * @date: 2022/2/10 20:04
 * @version: 1.0
 */
public class T5_螺旋矩阵II {
    public static void main(String[] args) {
        int[][] array = generateMatrix2(20);

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                    System.out.print(" " + suit(array[i][j]));
                System.out.print("     ");
            }
            System.out.println();
            System.out.println();
        }
    }

    public static String suit(int value) {
        if (value < 10) {
            return "000" + String.valueOf(value);
        } else if (value < 100 && value >= 10) {
            return "00" + String.valueOf(value);
        } if (value < 1000 && value >= 100) {
            return "0" + String.valueOf(value);
        }
        return String.valueOf(value);
    }

    public static int[][] generateMatrix2(int n) {
        int[][] matrix = new int[n][n];
        int count = 0;
        int offset = 1;
        int loop = n / 2;
        int startX = 0;
        int startY = 0;
        int mid = n / 2;
        while (loop > 0) {
            int i = startX;
            int j = startY;

            // 从左到右
            for (; j < startX + n - offset; ++j) {
                matrix[i][j] = ++ count;
            }
            // 从上到下
            for (; i < startY + n - offset; ++i) {
                matrix[i][j] = ++ count;
            }
            // 从右到左
            for (; j > startX; --j) {
                matrix[i][j] = ++ count;
            }
            // 从下到上
            for (; i > startY; --i) {
                matrix[i][j] = ++ count;
            }

            startX++;
            startY++;
            loop--;
            offset += 2;
        }
        if (n % 2 == 1) {
            matrix[mid][mid] = ++ count;
        }
        return matrix;
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
}
