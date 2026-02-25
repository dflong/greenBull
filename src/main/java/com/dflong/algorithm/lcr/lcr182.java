package com.dflong.algorithm.lcr;

public class lcr182 {

    public String dynamicPassword(String password, int target) {
        String fir = password.substring(0, target);
        String sec = password.substring(target);
        return sec + fir;
    }
}
