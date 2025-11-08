package com.dflong.greenbull.leetcode;

import java.util.*;

public class _327 {
    public static void main(String[] args) {
        new _327().countRangeSum(new int[]{-2,0,1,-1}, 1, 4);
    }

//    int m;
//    int[] tr = new int[100010 * 3];
//    int lowbit(int x) {
//        return x & -x;
//    }
//    void add(int x, int v) {
//        for (int i = x; i <= m; i += lowbit(i)) tr[i] += v;
//    }
//    int query(int x) {
//        int ans = 0;
//        for (int i = x; i > 0; i -= lowbit(i)) ans += tr[i];
//        return ans;
//    }
//    public int countRangeSum(int[] nums, int lower, int upper) {
//        Set<Long> set = new HashSet<>();
//        long s = 0;
//        set.add(s);
//        for (int i : nums) {
//            s += i;
//            set.add(s);
//            set.add(s - lower);
//            set.add(s - upper);
//        }
//        List<Long> list = new ArrayList<>(set);
//        Collections.sort(list);
//        Map<Long, Integer> map = new HashMap<>();
//        for (long x : list) map.put(x, ++m);
//        tr = new int[m + 1];
//        s = 0;
//        int ans = 0;
//        add(map.get(s), 1);
//        for (int i : nums) {
//            s += i;
//            int a = map.get(s - lower), b = map.get(s - upper) - 1;
//            ans += query(a) - query(b);
//            add(map.get(s), 1);
//        }
//        // 3 0, 8 3, 7, 2
//        return ans;
//    }



    public int countRangeSum(int[] nums, int lower, int upper) {
        Set<Long> set = new HashSet<>();

        long sum = 0;
        set.add(sum);
        for (int num : nums) {
            sum += num;
            set.add(sum);
            set.add(sum - upper);
            set.add(sum - lower);
        }

        List<Long> list = new ArrayList<>(set);
        Collections.sort(list);

        Map<Long, Integer> map = new HashMap<>();
        for (Long integer : list) { // 已排序
            map.put(integer,  ++ n);
        }

        arr = new int[n + 1];
        // [0, 0, 0, 1, 1, 0, 0, 0, 1],
        // [0, 0, 1, 1, 2, 0, 0, 0, 2],
        // [0, 0, 1, 1, 2, 0, 1, 0, 3],
        // [0, 0, 1, 1, 2, 1, 2, 0, 4]

        int ans = 0;
        sum = 0;
        add(map.get(sum), 1);
        for (int i : nums) {
            sum += i;
            int a = map.get(sum - lower), b = map.get(sum - upper) - 1; // map已存放了元素在树状数组的idx
            ans += query(a) - query(b);
            add(map.get(sum), 1); // 更新 + 1表示比他大的多一个
        }
        return ans;
    }

    int n;
    int[] arr;

    public int lowBit(int x) {
        return x & (-x);
    }

    public void add(int idx, int x) {
        for(int i = idx; i <= n; i += lowBit(i)) {
            arr[i] = arr[i] + x;
        }
    }


    public int query(int idx) {
        int res = 0;
        for(int i = idx; i > 0; i -= lowBit(i)) {
            res += arr[i];
        }

        return res;
    }

}
