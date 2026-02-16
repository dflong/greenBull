package com.dflong.algorithm.leetcode0;

import java.util.HashSet;

public class _36 {

    // [".",".",".",".",".",".","5",".","."],
    // [".",".",".",".",".",".",".",".","."],
    // [".",".",".",".",".",".",".",".","."],
    // ["9","3",".",".","2",".","4",".","."],
    // [".",".","7",".",".",".","3",".","."],
    // [".",".",".",".",".",".",".",".","."],
    // [".",".",".","3","4",".",".",".","."],
    // [".",".",".",".",".","3",".",".","."],
    // [".",".",".",".",".","5","2",".","."]]
    public boolean isValidSudoku(char[][] board) {

        HashSet<Character> set = new HashSet<Character>();

        // 先按照行检查
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (set.contains(board[i][j])) return false;
                    set.add(board[i][j]);
                }
            }
            set.clear();
        }

        // 按照列检查
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.') {
                    if (set.contains(board[j][i])) return false;
                    set.add(board[j][i]);
                }
            }
            set.clear();
        }


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[j][i] != '.') {
                    if (set.contains(board[j][i])) return false;
                    set.add(board[j][i]);
                }
            }
        }
        set.clear();


        for (int i = 0; i < 3; i++) {
            for (int j = 3; j < 6; j++) {
                if (board[j][i] != '.') {
                    if (set.contains(board[j][i])) return false;
                    set.add(board[j][i]);
                }
            }
        }
        set.clear();

        for (int i = 0; i < 3; i++) {
            for (int j = 6; j < 9; j++) {
                if (board[j][i] != '.') {
                    if (set.contains(board[j][i])) return false;
                    set.add(board[j][i]);
                }
            }
        }
        set.clear();

        for (int i = 3; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[j][i] != '.') {
                    if (set.contains(board[j][i])) return false;
                    set.add(board[j][i]);
                }
            }
        }
        set.clear();


        for (int i = 3; i < 6; i++) {
            for (int j = 3; j < 6; j++) {
                if (board[j][i] != '.') {
                    if (set.contains(board[j][i])) return false;
                    set.add(board[j][i]);
                }
            }
        }
        set.clear();

        for (int i = 3; i < 6; i++) {
            for (int j = 6; j < 9; j++) {
                if (board[j][i] != '.') {
                    if (set.contains(board[j][i])) return false;
                    set.add(board[j][i]);
                }
            }
        }
        set.clear();

        for (int i = 6; i < 9; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[j][i] != '.') {
                    if (set.contains(board[j][i])) return false;
                    set.add(board[j][i]);
                }
            }
        }
        set.clear();


        for (int i = 6; i < 9; i++) {
            for (int j = 3; j < 6; j++) {
                if (board[j][i] != '.') {
                    if (set.contains(board[j][i])) return false;
                    set.add(board[j][i]);
                }
            }
        }
        set.clear();

        for (int i = 6; i < 9; i++) {
            for (int j = 6; j < 9; j++) {
                if (board[j][i] != '.') {
                    if (set.contains(board[j][i])) return false;
                    set.add(board[j][i]);
                }
            }
        }
        set.clear();

        return true;
    }
}
