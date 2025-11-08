package com.dflong.greenbull.leetcode0;

public class _2024 {

    // TTFFTTF
    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(maxConsecutiveAnswers1(answerKey, k, 'T'), maxConsecutiveAnswers1(answerKey, k, 'F'));
    }

    public int maxConsecutiveAnswers1(String answerKey, int k, char c) {
        int max = 0;
        int l = 0, r = 0;
        int sum = 0, n = answerKey.length();
        while (r < n) {
            if (answerKey.charAt(r) == c) {
                sum ++;
            }
            while (sum > k) {
                max = Math.max(max, r - l);
                if (answerKey.charAt(l) == c) {
                    sum --;
                }
                l ++;
            }
            r++;
        }

       return Math.max(max, r - l);
    }
}
