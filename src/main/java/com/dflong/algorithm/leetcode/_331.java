package com.dflong.algorithm.leetcode;

public class _331 {

    public static void main(String[] args) {
        new _331().isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#");
    }

    public boolean isValidSerialization(String preorder) {
        int n = preorder.length();
        int cnt = 1; // 防止起点误判

        for (int i = 0; i < n; i ++) {
            if (cnt == 0) return false;
            if (preorder.charAt(i) == '#') {
                cnt --;
            } else if (preorder.charAt(i) == ',') {

            } else {
                // 数字可能是多位
                while (i < n && preorder.charAt(i) != ',') {
                    i ++;
                }
                i --;
                cnt --;
                cnt += 2;
            }
        }

        return cnt == 0;
    }
}
