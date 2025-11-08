package com.dflong.greenbull.leetcode0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class _133 {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors = Arrays.asList(node2, node4);
        node2.neighbors = Arrays.asList(node1, node3);
        node3.neighbors = Arrays.asList(node2, node4);
        node4.neighbors = Arrays.asList(node1, node3);

        _133 v = new _133();
        Node node = v.cloneGraph(node1);
        System.out.println();
    }

    HashMap<Node, Node> map = new HashMap<Node, Node>();

    public Node cloneGraph(Node treeNode1) {
        copy(treeNode1);
        newNode();

        return map.get(treeNode1);
    }

    public void newNode() {

        for (Node node : map.keySet()) {
            Node newNode = map.get(node);
            List<Node> list = new ArrayList<>();
            for (Node neighbor : node.neighbors) {
                list.add(map.get(neighbor));
            }
            newNode.neighbors = list;
        }
    }

    public void copy(Node treeNode1) {

        if (treeNode1 == null || map.containsKey(treeNode1)) {
            return;
        }

        Node newTreeNode1 = new Node(treeNode1.val);
        map.put(treeNode1, newTreeNode1);
        for (Node graphTreeNode1 : treeNode1.neighbors) {
            copy(graphTreeNode1);
        }
    }
}

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }

    public Node next;
}
