package com.npc.algorithms.array;

/**
 * @projectName: algorithms
 * @package: com.npc.algorithms
 * @className: Greedy
 * @author: fudawei
 * @description: TODO
 * @date: 2021/9/30 17:54
 * @version: 1.0
 */
public class Greedy {
    int getMinCoinCountHelper(int total, int[] values, int valueCount) {
        int rest = total;
        int count = 0;

        for (int i = 0; i < valueCount; i++) {
            int currentCount = rest / values[i];
            rest = rest - values[i] * currentCount;
            count += currentCount;
            if (rest == 0) {
                return count;
            }
        }

        return -1;
    }

    int getMinCoinCount() {
        int[] values = { 6, 3, 1}; // 硬币面值
        int total = 11; // 总价
        return getMinCoinCountHelper(total, values, values.length); // 输出结果
    }

    public static void main(String[] args) {
        System.out.println(new Greedy().getMinCoinCount());
    }
}
