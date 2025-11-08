package com.dflong.greenbull.leetcode0;

public class _12 {

    public static void main(String[] args) {
        int num = 3749;

        System.out.println(3749 % 10);
        System.out.println(3749 / 10 * 10);

        System.out.println(intToRoman(1994));
    }

    public static String intToRoman(int num) {

        String res = "";
        int numIndex = 1; // 1 是个位 2是十位 3是百位

        while (num > 0) {
            int x = num % 10; // 个位数

            if (x > 0) {
                if (numIndex == 1) { // 个位
                    if (x == 4) {
                        res = "IV" + res;
                    } else if (x == 9) {
                        res = "IX" + res;
                    } else if(x > 5) {
                        String s = "V";
                        for (int i = 0; i < x - 5; i++) {
                            s += "I";
                        }
                        res = s + res;
                    } else if(x == 5) {
                        String s = "V";
                        res = s + res;
                    }
                    else {
                        String s = "";
                        for (int i = 0; i < x; i++) {
                            s += "I";
                        }
                        res = s + res;
                    }
                } else if (numIndex == 2) { // 十位
                    if (x == 4) {
                        res = "XL" + res;
                    } else if (x == 9) {
                        res = "XC" + res;
                    } else if (x > 5) {
                        String s = "L";
                        for (int i = 0; i < x - 5; i++) {
                            s += "X";
                        }
                        res = s + res;
                    } else if (x == 5) {
                        String s = "L";
                        res = s + res;
                    }
                    else {
                        String s = "";
                        for (int i = 0; i < x; i++) {
                            s += "X";
                        }
                        res = s + res;
                    }
                } else if (numIndex == 3) { // 百位
                    if (x == 4) {
                        res = "CD" + res;
                    } else if (x == 9) {
                        res = "CM" + res;
                    } else if (x > 5) {
                        String s = "D";
                        for (int i = 0; i < x - 5; i++) {
                            s += "C";
                        }
                        res = s + res;
                    } else if (x == 5) {
                        String s = "D";
                        res = s + res;
                    } else {
                        String s = "";
                        for (int i = 0; i < x; i++) {
                            s += "C";
                        }
                        res = s + res;
                    }
                } else if (numIndex == 4) { // 千位
                    String s = "";
                    for (int i = 0; i < x; i++) {
                        s += "M";
                    }
                    res = s + res;
                }
            }

            numIndex ++;
            num = num / 10;
        }

        return res;
    }
}
