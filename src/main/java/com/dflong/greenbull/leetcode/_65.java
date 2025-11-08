package com.dflong.greenbull.leetcode;

public class _65 {

    public static void main(String[] args) {
        new _65().isNumber("+.8");
    }

    // 判断是否是数字
    public boolean isNumber(String s) {
       if (s == null || s.isEmpty()) return false;

       boolean numSeen = false, dotSeen = false, eSeen = false;
       char[] charArray = s.toCharArray();

       for (int i = 0; i < charArray.length; i ++) {
           if (charArray[i] >= '0' && charArray[i] <= '9') {
               numSeen = true;
           } else if (charArray[i] == '.') {
               if (dotSeen || eSeen) {
                   return false;
               }
               dotSeen = true;
           } else if (charArray[i] == 'e' || charArray[i] == 'E') {
               if (eSeen || !numSeen) {
                   return false;
               }
               numSeen = false;
               eSeen = true;
           } else if (charArray[i] == '+' || charArray[i] == '-') {
               if (i != 0 && charArray[i - 1] != 'e' && charArray[i - 1] != 'E') {
                   return false;
               }
           } else {
               return false;
           }

       }

        return numSeen;
    }
}
