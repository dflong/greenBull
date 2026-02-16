package com.dflong.algorithm.leetcode0;
import java.util.*;

public class _332 {

    public static void main(String[] args) {
        new _332().findItinerary(Arrays.asList(Arrays.asList("MUC","LHR"),Arrays.asList("JFK","MUC"),Arrays.asList("SFO","SJC"),Arrays.asList("LHR","SFO")));
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        Collections.sort(tickets, (a, b) -> a.get(1).compareTo(b.get(1)));
        this.tickets = tickets;
        used = new boolean[tickets.size()];
        list.add("JFK");
        dfs();
        return res;
    }

    List<String> res = new LinkedList<>();
    LinkedList<String> list = new LinkedList<>();
    List<List<String>> tickets;
    boolean[] used;
    public boolean dfs(){
        for (int i = 0; i < tickets.size(); i++) {
            if (list.size() == tickets.size() + 1) {
                res = new LinkedList<>(list);
                return true;
            }

            if (!used[i] && Objects.equals(list.get(list.size() - 1), tickets.get(i).get(0))) {
                list.add(tickets.get(i).get(1));
                used[i] = true;
                if (dfs()) return true;
                list.removeLast();
                used[i] = false;
            }
        }
        return false;
    }
}
