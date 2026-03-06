package com.dflong.algorithm.lcr;

import java.util.*;

public class lcr115 {

    public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
        // nums = [1,2,3], sequences = [[1,2],[1,3]]
        // 参考_210 拓扑排序，线性展开，寻找入度为0的点，如果同一时刻入读为0的点大于1，则存在多条路径
        int n = nums.length + 1;
        int[] inDegree = new int[n]; // 入度
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int[] sequence : sequences) {
            int prev = sequence[0];
            for (int i = 1; i < sequence.length; i++) {
                int cur = sequence[i];
                inDegree[cur]++;

                // k : 入度 v: 指向k的点
                List<Integer> list = map.getOrDefault(prev, new ArrayList<>());
                list.add(cur);
                map.put(prev, list);

                prev = cur;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            if (queue.size() > 1) return false;

            Integer inDegreeNode = queue.poll();
            List<Integer> list = map.get(inDegreeNode);
            if (list == null) continue;
            for (Integer i : list) {
                inDegree[i] --;
                if (inDegree[i] == 0) {
                    queue.add(i);
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        new lcr115().sequenceReconstruction(new int[]{4,1,5,2,6,3}, new int[][]{{5,2,6,3},{4,1,5,2}});
    }
}
