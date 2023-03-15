package com.npc.algorithms.util;

import com.npc.algorithms.手写常见数据结构.AVL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeShow {

    AVL.AVLNode root;

    private static final String BASE_EMPTY_LINK = "\t";

    private static final String BASE_LINE_LINK = "____";

    private static final String V_LINE = "|";

    private final Map<AVL.AVLNode ,IndexAndLen> nodesCoo = new HashMap<>();

    public TreeShow(AVL.AVLNode root){
        this.root  = root;
    }

    public void print(){
        calculateCoordinate();
        List<AVL.AVLNode> nodes = new ArrayList<>();
        nodes.add(root);
        printRow(nodes);
    }

    class IndexAndLen{
        private int index;//index坐标
        private int length;//数字长度

        public IndexAndLen(int index,int length){
            this.index = index;
            this.length = length;
        }
    }

    void calculateCoordinate(){
        List<AVL.AVLNode> nodes = new ArrayList<>();
        midOrder(root, nodes);
        if(nodes.isEmpty())return;
        int offset = 0;
        for (int i = 0; i < nodes.size(); i++) {
            AVL.AVLNode node = nodes.get(i);
            int len = numberLength(node);
            nodesCoo.put(node,new IndexAndLen(i+offset,len));
            offset+=len;
        }
    }

    void midOrder(AVL.AVLNode cur,List<AVL.AVLNode> list){
        if(cur == null)return;
        midOrder(cur.left,list);
        list.add(cur);
        midOrder(cur.right,list);
    }

    int numberLength(AVL.AVLNode node){
        if(node  == null)
            return 0;
        else
            return node.getValue().toString().length()/4;
    }

    class PrintRowNodes{
        private static final String INIT="";
        /**
         * 数据头顶上的竖线行
         */
        StringBuilder vLineInDataHead = new StringBuilder(INIT);
        /**
         * 数据行
         */
        StringBuilder dataLine= new StringBuilder(INIT);
        /**
         * 连接子节点的线段行
         */
        StringBuilder linkSonLine=new StringBuilder(INIT);
        /**
         *
         * 前一个节点
         */
        AVL.AVLNode prev;
        /**
         *
         * 连接子节点线段之间计算相邻线段距离时的上一个线段的右节点；
         */
        AVL.AVLNode lastRight;

        @Override
        public String toString() {
            return vLineInDataHead.toString()+ "\n"
                    + dataLine.toString()+"\n"
                    +linkSonLine.toString();
        }
    }

    void printRow(List<AVL.AVLNode> nodes){
        if(nodes.size()==0)return;
        List<AVL.AVLNode> children  = new ArrayList<>();
        PrintRowNodes printNode  = new PrintRowNodes();
        for (AVL.AVLNode node : nodes) {
            printNode(node,printNode,children);
        }
        System.out.println(printNode);
        printRow(children);
    }


    void  printNode(AVL.AVLNode node,PrintRowNodes printNode,List<AVL.AVLNode> children){
        String VLineEmpty = nodeEmpty(nodeDistance(node,printNode.prev,0));
        String numberEmpty= nodeEmpty(nodeDistance(node,printNode.prev,prevLength(printNode.prev)));
        printNode.vLineInDataHead.append(VLineEmpty + V_LINE);
        printNode.dataLine .append( numberEmpty +value(node));
        if(node.left == null && node.right == null){
            printNode.prev = node;
            return;
        }
        String linkSon = linkSonLine(node,children);
        String sonLineEmpty = nodeEmpty(nodeDistance(leftNode(node),printNode.lastRight,0));
        printNode.linkSonLine.append( sonLineEmpty +linkSon);
        printNode.prev=node;
        printNode.lastRight = lastRight(node);
    }

    String linkSonLine(AVL.AVLNode cur,List<AVL.AVLNode> children){
        AVL.AVLNode left  = cur.left;
        AVL.AVLNode right = cur.right;
        String leftLinkSonLine ="";
        String rightLinkSonLine="";
        if(left != null){
            children.add(left);
            leftLinkSonLine=linkSonNodeLine(nodeDistance(cur,left,0));
        }
        if(right != null){
            children.add(right);
            rightLinkSonLine=linkSonNodeLine(nodeDistance(right,cur,0));
        }
        return leftLinkSonLine + V_LINE + rightLinkSonLine;
    }

    int prevLength(AVL.AVLNode node){
        return node == null ? 0: nodesCoo.get(node).length;
    }

    AVL.AVLNode lastRight(AVL.AVLNode prev){
        if(prev == null)
            return null;
        else
            return prev.right == null ? prev:prev.right;
    }

    AVL.AVLNode leftNode(AVL.AVLNode node){
        return node.left != null ? node.left : node;
    }

    int nodeIndex(AVL.AVLNode node){
        return node == null ? 0 : nodesCoo.get(node).index;
    }

    int nodeDistance(AVL.AVLNode cur,AVL.AVLNode prev,int prevNumLen){
        return nodeIndex(cur) - nodeIndex(prev)-prevNumLen;
    }

    String linkLine(int dis,String linkStr){
        String str="";
        for (int i = 0; i <dis ; i++) {
            str+=linkStr;
        }
        return str;
    }


    String nodeEmpty(int dis){
        return linkLine(dis,BASE_EMPTY_LINK);
    }

    String linkSonNodeLine(int dis){
        return linkLine(dis,BASE_LINE_LINK);
    }

    String value(AVL.AVLNode node ){
       return node.getValue().toString();//打印黑色
    }
}
