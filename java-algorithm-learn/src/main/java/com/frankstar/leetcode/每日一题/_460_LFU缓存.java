package com.frankstar.leetcode.每日一题;

import com.frankstar.leetcode.ListNode;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * @Author :  frankstar
 * @AddTime :  2020/4/5
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/lfu-cache/
 */
public class _460_LFU缓存 {

	class LFUCache {

		//存储缓存的内容，Node中除了value值外，
		private Map<Integer, ListNode> cache;

		//存储每个频次对应的双向链表
		Map<Integer, LinkedHashSet<ListNode>> freqMap;

		int size;

		int capacity;

		//存储当前最小频次
		int min;

		public LFUCache(int capacity) {
			this.cache = new HashMap<>(capacity);
			freqMap = new HashMap<>();
			this.capacity = capacity;
		}

		public int get(int key) {
			ListNode node = cache.get(key);
			if (node == null) return -1;
			freqIncre(node);
			return node.val;
		}

		private void freqIncre(ListNode node) {
			int freq = node.val;
			LinkedHashSet<ListNode> set = freqMap.get(freq);
			set.remove(node);
			if (freq == min && set.size() == 0) {
				min = freq + 1;
			}
			// 加入新freq对应的链表
			node.val++;
			LinkedHashSet<ListNode> newSet = freqMap.get(freq + 1);
			if (newSet == null) {
				newSet = new LinkedHashSet<>();
				freqMap.put(freq + 1, newSet);
			}
			newSet.add(node);
		}

		void addNode(ListNode node) {
			LinkedHashSet<ListNode> set = freqMap.get(1);
			if (set == null) {
				set = new LinkedHashSet<>();
				freqMap.put(1, set);
			}
			set.add(node);
			min = 1;
		}

		ListNode removeNode() {
			LinkedHashSet<ListNode> set = freqMap.get(min);
			ListNode deadNode = set.iterator().next();
			set.remove(deadNode);
			return deadNode;
		}


		public void put(int key, int value) {
			if (capacity == 0) return;
			ListNode node = cache.get(key);
			if (node == null) {
				node = new ListNode(value);
				freqIncre(node);
			}else {
				if (size == capacity) {
					ListNode unEffective = removeNode();
					cache.remove(unEffective.val);
					size--;
				}
				ListNode lastNode = new ListNode(value);
				cache.put(key, lastNode);
				addNode(lastNode);
				size++;
			}


		}

	}


	public static void main(String[] args) {

	}
}
