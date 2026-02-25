package com.dflong.algorithm.lcr;

public class lcr181 {

    public String reverseMessage(String message) {
        message = message.trim();                               // 删除首尾空格
        int j = message.length() - 1, i = j;
        StringBuilder res = new StringBuilder();
        while (i >= 0) {
            while (i >= 0 && message.charAt(i) != ' ') i--;     // 搜索首个空格
            res.append(message.substring(i + 1, j + 1) + " ");  // 添加单词
            while (i >= 0 && message.charAt(i) == ' ') i--;     // 跳过单词间空格
            j = i;                                              // j 指向下个单词的尾字符
        }
        return res.toString().trim();
    }
}
