package com.dflong.greenbull.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _51 {

    public static void main(String[] args) {
        List<List<String>> lists = new _51().solveNQueens(4);
    }

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        this.chessBoard = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(chessBoard[i], '.');
        }
        backTracking(0);
        return res;
    }
    int n;
    char[][] chessBoard;
    List<List<String>> res = new ArrayList<>();

    // col 行, row 列
    public void backTracking(int col) {

        if (col == n) { // 到达最后一行，就找到结果
            res.add(array2List(chessBoard));
        }

        for (int row = 0; row < n; row ++) {
            if (isValid(col, row)) {
                chessBoard[col][row] = 'Q';
                backTracking(col + 1);
                chessBoard[col][row] = '.';
            }
        }
    }

    public List<String> array2List(char[][] chessBoard) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < chessBoard.length; i++) {
            list.add(new String(chessBoard[i]));
        }
        return list;
    }

    public boolean isValid(int col, int row) {
        // 检查列
            for (int i = 0; i < n; i++) {
                if (chessBoard[i][row] == 'Q') {
                    return false;
                }
            }

        // 检查45度对角线
        for (int i = col - 1, j = row + 1; i >= 0 && j <= n - 1; i --, j ++) {
            if (chessBoard[i][j] == 'Q') {
                return false;
            }
        }

        // 检查135度对角线
        for (int i = col - 1, j = row - 1; i >= 0 && j >= 0; i --, j --) {
            if (chessBoard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
