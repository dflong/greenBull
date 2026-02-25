package com.dflong.algorithm.lcr;

public class lcr120 {

    public int findRepeatDocument(int[] documents) {
        // 2, 5, 3, 0, 5, 0
        int i = 0;
        while (i < documents.length) {
            if(documents[i] == i) {
                i ++;
                continue; // 当前位置与值相等
            }

            if (documents[documents[i]] == documents[i]) {
                return documents[i]; // 存在重复值
            }

            int temp = documents[i];
            documents[i] = documents[temp];
            documents[temp] = temp;
        }

        return - 1;
    }
}
