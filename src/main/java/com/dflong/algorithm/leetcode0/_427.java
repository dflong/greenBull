package com.dflong.algorithm.leetcode0;

public class _427 {

    public Node2 construct(int[][] grid) {
        return dfs(grid, 0, grid.length, 0, grid[0].length);
    }

    public Node2 dfs(int[][] grid, int left, int right, int high, int bottom) {
        boolean isSame = true;
        for (int i = high; i < bottom; i++) {
            for (int j = left; j < right; j++) {
                if (grid[i][j] != grid[high][left]) {
                    isSame = false;
                    break;
                }
            }
            if (!isSame) {
                break;
            }
        }

        if (isSame) {
            return new Node2(false, true);
        }

        Node2 node = new Node2(true, false);
        node.topLeft = dfs(grid, left, (left + right) / 2, high, (high + bottom) / 2);
        node.topRight = dfs(grid, (left + right) / 2, right, high, (high + bottom) / 2);
        node.bottomLeft = dfs(grid, left, (left + right) / 2, (high + bottom) / 2, bottom);
        node.bottomRight = dfs(grid,(left + right) / 2, right, (high + bottom) / 2, bottom);
        return node;
    }
}

class Node2 {
    public boolean val;
    public boolean isLeaf;
    public Node2 topLeft;
    public Node2 topRight;
    public Node2 bottomLeft;
    public Node2 bottomRight;


    public Node2() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node2(boolean val, boolean isLeaf){
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node2(boolean val, boolean isLeaf, Node2 topLeft, Node2 topRight, Node2 bottomLeft, Node2 bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
