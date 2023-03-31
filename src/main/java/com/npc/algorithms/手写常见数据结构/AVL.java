package com.npc.algorithms.手写常见数据结构;

import com.npc.algorithms.util.SortedNode;
import com.npc.algorithms.util.TreeShow;

public class AVL<K extends Comparable, V>  implements SortTable<K, V> {

    @Override
    public void put(K key, V value) {
        if (key == null) return;

        AVLNode<K, V> oldNode = findByKey(key);

        if (oldNode != null && oldNode.key.compareTo(key) == 0) {
            oldNode.value = value;
            return;
        } else {
            this.root = this.add(root, key, value);
            size ++;
        }
    }

    private AVLNode<K, V> add(AVLNode<K,V> cur, K key, V value) {
        if (cur == null) {
            AVLNode newNode = new AVLNode(key, value);
            newNode.hight = 1;
            return newNode;
        } else {
            //  插入
            if (key.compareTo(cur.key) > 0) {
                cur.right = add(cur.right, key, value);
            } else {
                cur.left = add(cur.left, key, value);
            }
            updateHight(cur);
            return maintain(cur);
        }
    }


    private AVLNode<K,V> maintain(AVLNode<K,V> cur) {
        if (cur == null) {
            return cur;
        }


        int leftHight = cur.left == null ? 0 : cur.left.hight;
        int rightHight = cur.right == null ? 0 : cur.right.hight;

        if (Math.abs(leftHight - rightHight) <= 1) {
            return cur;
        }

        if (leftHight > rightHight) {
            //L
            int leftLeftHight = cur.left != null && cur.left.left != null ? cur.left.left.hight : 0;
            int leftRightHight = cur.left != null && cur.left.right != null ? cur.left.right.hight : 0;
            if (leftLeftHight >= leftRightHight) {
                //LL
                cur = rightRotate(cur);
            } else {
                // LR
                cur.left = leftRotate(cur);
                cur = rightRotate(cur);
            }

        } else {
            // LR
            //L
            int rightRightHight = cur.right != null && cur.right.right != null ? cur.right.right.hight : 0;
            int rightLeftHight = cur.right != null && cur.right.left != null ? cur.right.left.hight : 0;
            if (rightRightHight >= rightLeftHight) {
                //LL
                cur = leftRotate(cur);
            } else {
                // LR
                cur.right = rightRotate(cur);
                cur = leftRotate(cur);
            }
        }
        return cur;
    }

    private AVLNode<K,V> rightRotate(AVLNode<K,V> cur) {
        AVLNode<K, V> left =  cur.left;
        cur.left = left.right;
        left.right = cur;

        updateHight(cur);
        updateHight(left);

        return left;
    }

    private AVLNode<K, V> leftRotate(AVLNode<K,V> cur) {
        AVLNode<K, V> right =  cur.right;
        cur.right = right.left;
        right.left = cur;

        updateHight(cur);
        updateHight(right);

        return right;
    }

    private void updateHight(AVLNode<K,V> cur) {
        if (cur == null) return;

        cur.hight = Math.max(cur.left == null ? 0 : cur.left.hight, cur.right == null ? 0 : cur.right.hight) + 1;
    }

    @Override
    public V get(K key) {
        AVLNode<K, V> result = findByKey(key);
        return result == null ? null : result.getValue();
    }



    public AVLNode<K, V> findByKey(K key) {
        if (key == null) return null;

        AVLNode<K, V> cur = root;

        while (cur != null) {
            if (key.compareTo(cur.key) == 0) {
                return cur;
            } else if (key.compareTo(cur.key) > 0) {
                cur = cur.right;
            } else if (key.compareTo(cur.key) <0) {
                cur = cur.left;
            }
        }

        return null;
    }

    @Override
    public boolean containsKey(K key) {
        if (key == null) {
            return false;
        }

        AVLNode<K, V> cur = findByKey(key);
        if (cur != null && cur.key.compareTo(key) == 0) {
            return true;
        }
        return false;

    }

    @Override
    public K floorKey(K key) {
        return null;
    }

    @Override
    public K ceilingKey(K key) {
        return null;
    }

    @Override
    public K firstKey() {
        return null;
    }

    @Override
    public K lastKey() {
        return null;
    }

    @Override
    public void remove(K key) {
        AVLNode<K, V> node = findByKey(key);
        if (node == null) {
            return;
        }


    }

    @Override
    public int size() {
        return 0;
    }

    public static class AVLNode<K extends Comparable, V> extends SortedNode<K, V> {

        public int hight;

        public AVLNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public AVLNode<K, V> root;
    public int size;

    public AVL() {
        root = null;
        size = 0;
    }
}
