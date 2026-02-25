package com.dflong.algorithm.lcr;

import java.util.Arrays;

public class lcr164 {

    public String crackPassword(int[] password) {
        String[] strs = new String[password.length];
        for (int i = 0; i < password.length; i++) {
            strs[i] = String.valueOf(password[i]);
        }

        Arrays.sort(strs, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            sb.append(strs[i]);
        }
        return sb.toString();
    }
}
