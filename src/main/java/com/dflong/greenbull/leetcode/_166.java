package com.dflong.greenbull.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _166 {

    public String fractionToDecimal(int numerator, int denominator) {
        long a = numerator, b = denominator;
        // 可整除
        if (a % b == 0) return String.valueOf(a / b);
        StringBuilder sb = new StringBuilder();
        // 添加 -
        if (a * b < 0) sb.append('-');

        a = Math.abs(a); b = Math.abs(b);
        // 添加整数部分
        sb.append(a/ b).append(".");

        // 添加小数部分
        a = a % b;
        Map<Long, Integer> map = new HashMap<>();
        while (a != 0) {
            map.put(a, sb.length());

            a = a * 10;
            sb.append(a / b);
            a = a % b;
            // 发现循环
            if (map.containsKey(a)) {
                int u = map.get(a);
                return String.format("%s(%s)", sb.substring(0, u), sb.substring(u));
            }
        }

        return sb.toString();
    }
}
