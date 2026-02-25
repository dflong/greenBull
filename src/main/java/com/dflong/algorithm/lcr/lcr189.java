package com.dflong.algorithm.lcr;

public class lcr189 {

    public int mechanicalAccumulator(int target) {
        return target == 0 ? 0 : target + mechanicalAccumulator(target - 1);
    }
}
