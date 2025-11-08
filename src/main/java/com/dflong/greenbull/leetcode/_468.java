package com.dflong.greenbull.leetcode;

public class _468 {

    public static void main(String[] args) {
        new _468().validIPAddress("12..33.4");
    }

    public String validIPAddress(String queryIP) {
        if (queryIP.startsWith("\\.") || queryIP.startsWith(":") ||
        queryIP.endsWith("\\.") || queryIP.endsWith(":")) {
            return "Neither";
        }

        String[] split = queryIP.split("\\.");
        if (split.length == 4) {
            boolean ipv4 = checkIPv4(split);
            if (ipv4) return "IPv4";
        }
        split = queryIP.split(":");
        if (split.length == 8) {
            boolean ipv6 = checkIPv6(split);
            if (ipv6) return "IPv6";
        }
        return "Neither";
    }

    // 0 <= x <= 255，不能有前导0
    private boolean checkIPv4(String[] strs) {
        for (String s : strs) {
            if (s.isEmpty()) return false;
            // 前导0
            if (s.length() == 1 && s.charAt(0) == '0') return false;
            int num = 0;
            for (int j = 0; j < s.length(); j ++) {
                char c = s.charAt(j);
                if (c < '0' || c > '9') return false;
                num = num * 10 + (s.charAt(j) - '0');
                if (num > 255) return false;
            }
        }
        return true;
    }

    // 十六位进制
    private boolean checkIPv6(String[] strs) {
        for (String s : strs) {
            if (s.isEmpty()) return false;
            if (s.length() > 4) return false;
            for (char c : s.toCharArray()) {
                if ((c >= '0' && c <= '9') ||
                        (c >= 'a' && c <= 'f') ||
                        (c >= 'A' && c <= 'F')) {
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
