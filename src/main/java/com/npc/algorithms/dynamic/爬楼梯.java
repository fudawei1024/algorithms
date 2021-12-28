package com.npc.algorithms.dynamic;

/**
 * @projectName: algorithms
 * @package: com.npc.algorithms.dynamic
 * @className: 爬楼梯
 * @author: fudawei
 * @description: TODO
 * @date: 2021/12/28 19:36
 * @version: 1.0
 */
public class 爬楼梯 {
    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }

    public static int climbStairs(int stairs) {
        if (stairs ==0) {
            return 0;
        }
        int[] d = new int[stairs + 1];
        d[0] = 1;
        d[1] = 1;
        for (int i = 2; i <= stairs; i++) {
            d[i] = d[i - 1] + d[i - 2];
        }
        return d[stairs];
    }
}
