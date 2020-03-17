package com.frankstar.leetcode.哈希表;

import java.util.Arrays;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/13
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/explore/learn/card/hash-table/203/design-a-hash-table/800/
 */
public class 设计哈希映射 {

	class MyHashMap {

		private int[] hashmap;

		/** Initialize your data structure here. */
		public MyHashMap() {
			hashmap = new int[10000];
			Arrays.fill(hashmap, -1);
		}

		/** value will always be non-negative. */
		public void put(int key, int value) {
			hashmap[key] = value;
		}

		/** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
		public int get(int key) {
			return hashmap[key];
		}

		/** Removes the mapping of the specified value key if this map contains a mapping for the key */
		public void remove(int key) {
			hashmap[key] = -1;
		}
	}
}
