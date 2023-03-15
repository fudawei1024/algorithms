package com.npc.algorithms.手写常见数据结构;

import java.util.ArrayList;

public class SkipList<K extends Comparable<K>, V> {

    public static class SkipNode <K extends Comparable<K>, V> {

        public K key;
        public V value;

        public ArrayList<SkipNode<K, V>> nexts;

        public SkipNode(K key, V value) {
            this.key = key;
            this.value = value;
            nexts = new ArrayList<>();
        }
    }

    public SkipNode<K, V> root;
    public int maxLevel;

    public int size;

    @Override
    public String toString() {
        return "SkipList{" +
                "root=" + root +
                ", maxLevel=" + maxLevel +
                ", size=" + size +
                '}';
    }

    public SkipList() {
        root = new SkipNode<>(null, null);
        root.nexts.add(null);
        maxLevel = 0;
        size = 0;
    }

    public SkipNode<K, V> findByKey(K key) {
        if (key == null) {
            return null;
        }

        int level = maxLevel;
        SkipNode currentNode = root;
        while (level >= 0) {
            currentNode = findByKeyLevel(currentNode, key, level);
            level --;
        }

        return currentNode;
    }

    public SkipNode<K, V> findByKeyLevel(SkipNode<K,V> cur, K key, int level) {
        SkipNode<K, V> nextSkipNode = cur.nexts.get(level);
        while (nextSkipNode != null && nextSkipNode.key.compareTo(key) < 0) {
            cur = nextSkipNode;
            nextSkipNode = cur.nexts.get(level);
        }
        return cur;
    }

    public void put(K key, V value) {
        if (key == null) {
            return;
        }

        SkipNode<K, V> preMostNode = findByKey(key);
        SkipNode<K, V> oldNode = preMostNode.nexts.get(0);
        // 找到节点直接
        if (preMostNode != null && oldNode != null && oldNode.key.compareTo(key) == 0) {
            oldNode.value = value;
        } else {
            size ++;
            SkipNode<K, V> newSkipNode = new SkipNode<>(key, value);

            int curLevel = 0;
            while (Math.random() > 0.5) {
                curLevel ++;
            }

            while (curLevel > maxLevel) {
                maxLevel ++;
                root.nexts.add(null);
            }

            for (int i = 0; i <= curLevel; i++) {
                newSkipNode.nexts.add(null);
            }

            int level = maxLevel;
            SkipNode<K, V> preSkipNode = root;
            while (level >= 0) {
                preSkipNode = findByKeyLevel(preSkipNode, key, level);
                if (curLevel >= level) {
                    newSkipNode.nexts.set(level, preSkipNode.nexts.get(level));
                    preSkipNode.nexts.set(level, newSkipNode);
                }
                level --;
            }

        }
    }

    public V get(K key) {
        if (key == null) {
            return null;
        }

        SkipNode<K, V> preSkipNode = findByKey(key);
        if (preSkipNode == null) {
            return null;
        }
        SkipNode<K, V> curSkipNode = preSkipNode.nexts.get(0);
        if (preSkipNode != null && curSkipNode.key.compareTo(key) == 0) {
            return curSkipNode.value;
        }
        return null;
    }


    public Boolean contain(K key) {
        if (key == null) {
            return false;
        }

        SkipNode<K, V> preSkipNode = findByKey(key);
        if (preSkipNode == null) {
            return false;
        }
        SkipNode<K, V> curSkipNode = preSkipNode.nexts.get(0);
        if (curSkipNode != null && curSkipNode.key.compareTo(key) == 0) {
            return true;
        }
        return false;
    }

    public void remove(K key) {
        System.out.println(toString());

        if (!contain(key)) {
            return;
        }
        size --;

        SkipNode<K, V> preSkipNode;
        SkipNode<K, V> delSkipNode;
        int level = maxLevel;

        while (level >= 0) {
            preSkipNode = findByKeyLevel(root, key, maxLevel);
            delSkipNode = preSkipNode.nexts.get(level);
            if (delSkipNode != null && delSkipNode.key.compareTo(key) == 0) {
                preSkipNode.nexts.set(level, delSkipNode.nexts.get(level));
            }

            if (preSkipNode == root && preSkipNode.nexts.get(level) == null && level > 0) {
                maxLevel --;
                root.nexts.remove(level);
            }

            level --;
        }

    }


    public K flooKey(K key) {
        if (key == null) {
            return null;
        }

        SkipNode<K, V> preSkipNode = findByKey(key);
        SkipNode<K, V> cur = preSkipNode.nexts.get(0);
        if (preSkipNode != null && cur.key.compareTo(key) == 0) {
            return cur.key;
        }
        return preSkipNode.key;
    }

    public K firstKey(K key) {
        return root.nexts.get(0) == null ? null : root.nexts.get(0).key;
    }

    public K lastKey(K key) {
        int level = maxLevel;
        SkipNode<K, V> cur = root;

        while (level >= 0) {
            SkipNode<K, V> lastNext = cur.nexts.get(level);
            while (lastNext != null) {
                cur = lastNext;
                lastNext = cur.nexts.get(level);
            }
            level --;
        }
        return cur.key;
    }

    public int size() {
        return size;
    }


    public int levelCount(SkipNode<K, V> cur, int level) {
        int count = 0;
        SkipNode<K, V> nextNode = cur.nexts.get(level);
        while (nextNode != null) {
            count ++;
            nextNode = nextNode.nexts.get(level);
        }
        return count;
    }

    public void allCount() {
        int level = maxLevel;
        SkipNode<K, V> cur = root;
        while (level >= 0) {
            int count = levelCount(cur, level);
            System.out.println(level + " " + count);
            level --;
        }
    }
}
