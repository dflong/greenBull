package com.dflong.greenbull.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {

    List<Integer> list = new ArrayList<>();
    int idx = 0, size = 0;

    public NestedIterator(List<NestedInteger> nestedList) {
        dfs(nestedList);
        size = list.size();
    }

    public void dfs(List<NestedInteger> nestedList) {
        for (NestedInteger integer : nestedList) {
            if (integer.isInteger()) {
                list.add(integer.getInteger());
            } else {
                dfs(integer.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return list.get(idx ++);
    }

    @Override
    public boolean hasNext() {
        return idx < size;
    }

    public interface NestedInteger {
        public boolean isInteger();
        public Integer getInteger();
        public List<NestedInteger> getList();
    }
}
