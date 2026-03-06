package com.dflong.algorithm.lcr;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class lcr035 {

    public int findMinDifference(List<String> timePoints) {
        // 23:59
        if (timePoints.size() > 1440) return 0;

        Collections.sort(timePoints);

        int res = Integer.MAX_VALUE;
        int fir = getMinutes(timePoints.get(0));
        for (int i = 1; i < timePoints.size(); i++) {
            int sec = getMinutes(timePoints.get(i));
            res = Math.min(res, sec - fir);
            fir = sec;
        }

        res = Math.min(res, getMinutes(timePoints.get(0)) + 1440 - fir); // 首尾时间的时间差
        return res;
    }

    public int getMinutes(String t) {
        return ((t.charAt(0) - '0') * 10 + (t.charAt(1) - '0')) * 60 +
                (t.charAt(3) - '0') * 10 + (t.charAt(4) - '0');
    }

}
