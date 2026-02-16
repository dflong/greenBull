package com.dflong.algorithm.lcr;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

public class lcr063 {

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        reentrantLock.lock();
        if (reentrantLock.isLocked()) {
        }
        reentrantLock.unlock();
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> set = new HashSet<String>(dictionary);
        List<String> chars = new ArrayList<>();
        for (String word : sentence.split(" ")) {
            boolean found = false;
            for (int i = 0; i < word.length(); i ++) {
                String subStr = word.substring(0, i + 1);
                if (set.contains(subStr)) {
                    chars.add(subStr);
                    found = true;
                    break;
                }
            }
            if (!found) chars.add(word);
        }
        return String.join(" ", chars);
    }
}
