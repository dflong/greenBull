package com.dflong.greenbull.leetcode;

import java.util.*;

public class _332 {

    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(Arrays.asList("MUC", "LHR"));
        tickets.add(Arrays.asList("JFK", "MUC"));
        tickets.add(Arrays.asList("SFO", "SJC"));
        tickets.add(Arrays.asList("LHR", "SFO"));

        new _332().findItinerary(tickets);
    }

    Map<String, PriorityQueue<String>> ticketsMap = new HashMap<>();
    List<String> res = new ArrayList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        // 建图
        for (List<String> ticket : tickets) {
            String src = ticket.get(0);
            String dest = ticket.get(1);
            if (!ticketsMap.containsKey(src)) {
                ticketsMap.put(src, new PriorityQueue<>());
            }
            ticketsMap.get(src).add(dest);
        }
        dfs("JFK");
        Collections.reverse(res);
        return res;
    }

    public void dfs(String ticket) {
        while (ticketsMap.containsKey(ticket) && ticketsMap.get(ticket).size() > 0) {
            String poll = ticketsMap.get(ticket).poll();// 走过一次
            dfs(poll);
        }
        res.add(ticket);
    }
}
