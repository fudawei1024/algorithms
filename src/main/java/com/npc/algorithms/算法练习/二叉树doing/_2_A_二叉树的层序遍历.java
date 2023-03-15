package com.npc.algorithms.算法练习.二叉树doing;

import com.npc.algorithms.backup.tree.TreeNode;
import com.npc.algorithms.util.TreeOperation;
import com.npc.algorithms.util.Util;
import org.junit.Test;

import java.util.*;

/**
 * @author fudawei
 * @date 2022年07月19日 17:58
 * @desc
 */
public class _2_A_二叉树的层序遍历 {

    @Test
    public void testSearch() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);


        TreeOperation.show(root);

        Util.p("层序遍历1：");
        Util.p(levelOrder(root));

        Util.p("层序遍历2：");
        List<List<Integer>> resList = new ArrayList<>();
        levelOrder2(root, resList, 0);
        Util.p(resList);
    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>  resList = new ArrayList<>();

        Deque<TreeNode> deque = new LinkedList<>();
        if (root == null) return resList;
        deque.push(root);
        while (!deque.isEmpty()) {
            List<Integer> item = new ArrayList<>();
            int count = deque.size();
            while (count-- > 0) {
                TreeNode node = deque.poll();
                item.add(node.value);
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
            resList.add(item);
        }
        return resList;
    }

    public void levelOrder2(TreeNode cur, List<List<Integer>> resList, int depth) {
        if (cur == null) return ;
        depth++;

        if (resList.size() < depth) {
            //当层级增加时，list的Item也增加，利用list的索引值进行层级界定
            List<Integer> item = new ArrayList<>();
            resList.add(item);
        }
        resList.get(depth - 1).add(cur.value);
        levelOrder2(cur.left,resList, depth);
        levelOrder2(cur.right,resList, depth);
    }
}
