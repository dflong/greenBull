package com.dflong.algorithm.lcr;

public class lcr139 {

    public int[] trainingPlan(int[] actions) {
        // 2,16,3,5,13,1,16,1,12,18,11,8,11,11,5,1]
        int i = 0, j = 0;
        while (j < actions.length) {
            if (actions[j] % 2 == 1) {
                int temp = actions[j];
                actions[j] = actions[i];
                actions[i] = temp;
                j ++;
                i ++;
            } else {
                j ++;
            }
        }

        return actions;
    }
}
