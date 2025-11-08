package com.dflong.greenbull.leetcode0;

public class _649 {

    public String predictPartyVictory(String senate) {
        int n = senate.length();
        boolean[] flag = new boolean[n];

        int Rcount = 0, Dcount = 0;
        for (int i = 0; i < n; i++) {
            flag[i] = true;
            if (senate.charAt(i) == 'R') {
                Rcount ++;
            } else {
                Dcount ++;
            }
        }
        if (Rcount == 0) return "Dire";
        if (Dcount == 0) return "Radiant";
        int i = 0;
        while (true) {
            if (Rcount == 0) return "Dire";
            if (Dcount == 0) return "Radiant";
            while (!flag[i]) {
                i = (i + 1) % n;
            }
            int j = (i + 1) % n;
            while (senate.charAt(i) == senate.charAt(j) || !flag[j]) {
                j = (j + 1) % n;
            }
            flag[j] = false;
            if (senate.charAt(j) == 'R') {
                Rcount --;
            } else {
                Dcount --;
            }
            i = (i + 1) % n;
        }
    }

    public static void main(String[] args) {
        new _649().predictPartyVictory("DDRRR");
    }
}
