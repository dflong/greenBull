package com.dflong.greenbull.leetcode;

import java.util.*;

public class _355 {

    public static void main(String[] args) {
        Twitter twitter = new _355().new Twitter();
        twitter.postTweet(1, 5);
        twitter.getNewsFeed(1);
        twitter.postTweet(2, 6);
        twitter.getNewsFeed(2);
        twitter.follow(1, 2);
        twitter.getNewsFeed(1);
    }


    class TwitterText{
        int tweetId;
        int timeId;

        public TwitterText(int tweetId, int timeId) {
            this.tweetId = tweetId;
            this.timeId = timeId;
        }
    }

    class Twitter {

        // 关注
        Map<Integer, Set<Integer>> followMap = new HashMap<>();
        // 用户发布推文
        Map<Integer, List<TwitterText>> newsMap = new HashMap<>();
        // 时间自增id
        int timeId = 1;
        public Twitter() {

        }

        public void postTweet(int userId, int tweetId) {
            if (!newsMap.containsKey(userId)) {
                newsMap.put(userId, new ArrayList<>());
            }
            newsMap.get(userId).add(new TwitterText(tweetId, timeId ++));
        }

        public List<Integer> getNewsFeed(int userId) {
            // 获取最多10条推文
            PriorityQueue<TwitterText> pq = new PriorityQueue<>((o1, o2) -> o2.timeId - o1.timeId);
            // 自身推文
            List<TwitterText> news = newsMap.get(userId);
            if (news != null) {
                int min = Math.min(10, news.size());
                for (int i = 0; i < min; i ++) {
                    pq.add(news.get(news.size() - 1 - i));
                }
            }
            // 关注的人
            Set<Integer> followees = followMap.get(userId);
            if (followees != null) {
                for (int followee : followees) {
                    List<TwitterText> news1 = newsMap.get(followee);
                    if (news1 != null) {
                        int min = Math.min(10, news1.size());
                        for (int i = 0; i < min; i ++) {
                            pq.add(news1.get(news1.size() - 1 - i));
                        }
                    }
                }
            }

            List<Integer> res = new ArrayList<>();
            int min = Math.min(10, pq.size());
            for (int i = 0; i < min ; i ++) {
                res.add(pq.poll().tweetId);
            }
            return res;
        }

        public void follow(int followerId, int followeeId) {
            Set<Integer> orDefault = followMap.getOrDefault(followerId, new HashSet<>());
            orDefault.add(followeeId);
            followMap.put(followerId, orDefault);
        }

        public void unfollow(int followerId, int followeeId) {
            Set<Integer> integers = followMap.get(followerId);
            if (integers != null) {
                integers.remove(followeeId);
            }
        }
    }
}
