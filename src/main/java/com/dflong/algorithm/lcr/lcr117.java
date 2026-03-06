package com.dflong.algorithm.lcr;

public class lcr117 {

    // t a r s
    // r a t s
    // a r t s
    // s t a r
    public int numSimilarGroups(String[] strs) {
        int m = strs.length;
        UnionSet unionSet = new UnionSet(m);

        for (int i = 0; i < m; i ++) {
            for (int j = i + 1; j < m; j ++) {
                int i1 = unionSet.find(i);
                int j1 = unionSet.find(j);
                if (i1 == j1) {
                    continue;
                }

                if (check(strs[i], strs[j])) {
                    unionSet.join(i, j); // 合并
                }
            }
        }

        int res = 0;
        for (int i = 0; i < m; i ++) {
            if (i == unionSet.find(i)) {
                res ++;
            }
        }

        return res;
    }

    boolean check(String s1, String s2) {
        int cnt = 0;
        for (int i = 0; i < s1.length(); i ++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                cnt ++;
            }
            if (cnt > 2) { // 存在俩个以上字节位置异位
                return false;
            }
        }

        return true;
    }
}


