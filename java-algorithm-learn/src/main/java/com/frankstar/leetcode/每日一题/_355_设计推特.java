package com.frankstar.leetcode.每日一题;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

/**
 * @Author :  frankstar
 * @AddTime :  2020/4/13
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/design-twitter/
 */
public class _355_设计推特 {

	class Twitter {


		/**
		 * 被follow的人id， follow的集合
		 */
		private Map<Integer, List<Integer>> userFollowIds;

		/**
		 * 原始用户发表的推特
		 */
		private Map<Integer, List<Integer>> userTwitter;


		/**
		 * 用户所有的推特列表
		 */
		private Map<Integer, List<Integer>> twitters;

		/** Initialize your data structure here. */
		public Twitter() {
			this.twitters = new LinkedHashMap<>();
			this.userFollowIds = new HashMap<>();
			this.userTwitter = new HashMap<>();

		}

		/** Compose a new tweet. */
		public void postTweet(int userId, int tweetId) {
			//原始列表中应该存在
			List<Integer> ts = userTwitter.get(userId);
			if (ts == null || ts.size() == 0) {
				ts = new ArrayList<>();
			}
			ts.add(tweetId);
			twitters.put(userId, ts);

			//该用户的直接关注者 也需要新增这条内容
			List<Integer> followers = userFollowIds.get(userId);
			if (followers == null || followers.size() == 0) {
				return;
			}
			//直接处理每个直接关注用户的内容
			processFollowers(followers, tweetId);
		}

		private void processFollowers(List<Integer> followers, int tweetId) {
			followers.forEach(
				follower -> processFollower(follower, tweetId)
			);
		}

		private void processFollower(Integer follower, int tweetId) {
			List<Integer> users = userFollowIds.get(follower);
			if (users == null || users.size() == 0) {
				Stack<Integer> stack = new Stack<>();
				stack.add(tweetId);
				twitters.put(follower, stack);
				return;
			}
			users.forEach(
				user -> processFollower(users.get(user), tweetId)
			);

		}

		/** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
		public List<Integer> getNewsFeed(int userId) {
			List<Integer> ts = twitters.get(userId);
			List<Integer> result = new ArrayList<>();
			if (ts == null || ts.size() == 0){
				return result;
			}
			int size = ts.size();
			for (int k = size - 1; k>=0; k--) {
				result.add(ts.get(k));
			}
			return result;
		}

		/** Follower follows a followee. If the operation is invalid, it should be a no-op. */
		public void follow(int followerId, int followeeId) {
			List<Integer> followers = userFollowIds.get(followeeId);
			if (followers == null || followers.size() == 0) {
				followers = new ArrayList<>();
			}
			followers.add(followerId);
			userFollowIds.put(followeeId, followers);
		}

		/** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
		public void unfollow(int followerId, int followeeId) {
			List<Integer> followers = userFollowIds.get(followeeId);
			if (followers == null || followers.size() == 0) return;
			// 需要遍历 把他们的twitteId 删除


		}
	}


	/**
	 * 用户 id 和推文（单链表）的对应关系
	 */
	private Map<Integer, Tweet> twitter;

	/**
	 * 用户 id 和他关注的用户列表的对应关系
	 */
	private Map<Integer, Set<Integer>> followings;

	/**
	 * 全局使用的时间戳字段，用户每发布一条推文之前 + 1
	 */
	private static int timestamp = 0;

	/**
	 * 合并 k 组推文使用的数据结构（可以在方法里创建使用），声明成全局变量非必需，视个人情况使用
	 */
	private static PriorityQueue<Tweet> maxHeap;

	/**
	 * Initialize your data structure here.
	 */
//	public Twitter() {
//		followings = new HashMap<>();
//		twitter = new HashMap<>();
//		maxHeap = new PriorityQueue<>((o1, o2) -> -o1.timestamp + o2.timestamp);
//	}

	/**
	 * Compose a new tweet.
	 */
	public void postTweet(int userId, int tweetId) {
		timestamp++;
		if (twitter.containsKey(userId)) {
			Tweet oldHead = twitter.get(userId);
			Tweet newHead = new Tweet(tweetId, timestamp);
			newHead.next = oldHead;
			twitter.put(userId, newHead);
		} else {
			twitter.put(userId, new Tweet(tweetId, timestamp));
		}
	}

	/**
	 * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
	 */
	public List<Integer> getNewsFeed(int userId) {
		// 由于是全局使用的，使用之前需要清空
		maxHeap.clear();

		// 如果自己发了推文也要算上
		if (twitter.containsKey(userId)) {
			maxHeap.offer(twitter.get(userId));
		}

		Set<Integer> followingList = followings.get(userId);
		if (followingList != null && followingList.size() > 0) {
			for (Integer followingId : followingList) {
				Tweet tweet = twitter.get(followingId);
				if (tweet != null) {
					maxHeap.offer(tweet);
				}
			}
		}

		List<Integer> res = new ArrayList<>(10);
		int count = 0;
		while (!maxHeap.isEmpty() && count < 10) {
			Tweet head = maxHeap.poll();
			res.add(head.id);

			// 这里最好的操作应该是 replace，但是 Java 没有提供
			if (head.next != null) {
				maxHeap.offer(head.next);
			}
			count++;
		}
		return res;
	}


	/**
	 * Follower follows a followee. If the operation is invalid, it should be a no-op.
	 *
	 * @param followerId 发起关注者 id
	 * @param followeeId 被关注者 id
	 */
	public void follow(int followerId, int followeeId) {
		// 被关注人不能是自己
		if (followeeId == followerId) {
			return;
		}

		// 获取我自己的关注列表
		Set<Integer> followingList = followings.get(followerId);
		if (followingList == null) {
			Set<Integer> init = new HashSet<>();
			init.add(followeeId);
			followings.put(followerId, init);
		} else {
			if (followingList.contains(followeeId)) {
				return;
			}
			followingList.add(followeeId);
		}
	}


	/**
	 * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
	 *
	 * @param followerId 发起取消关注的人的 id
	 * @param followeeId 被取消关注的人的 id
	 */
	public void unfollow(int followerId, int followeeId) {
		if (followeeId == followerId) {
			return;
		}

		// 获取我自己的关注列表
		Set<Integer> followingList = followings.get(followerId);

		if (followingList == null) {
			return;
		}
		// 这里删除之前无需做判断，因为查找是否存在以后，就可以删除，反正删除之前都要查找
		followingList.remove(followeeId);
	}

	/**
	 * 推文类，是一个单链表（结点视角）
	 */
	private class Tweet {
		/**
		 * 推文 id
		 */
		private int id;

		/**
		 * 发推文的时间戳
		 */
		private int timestamp;
		private Tweet next;

		public Tweet(int id, int timestamp) {
			this.id = id;
			this.timestamp = timestamp;
		}
	}


}
