package com.frankstar.leetcode.哈希表;

import java.util.LinkedList;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/13
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/explore/learn/card/hash-table/203/design-a-hash-table/799/
 */
public class 设计哈希集合 {

	private Bucket[] bucketArray;
	private int keyRange;

	/** Initialize your data structure here. */
	public 设计哈希集合() {
		this.keyRange = 769;
		this.bucketArray = new Bucket[this.keyRange];
		for (int i = 0; i < this.keyRange; ++i)
			this.bucketArray[i] = new Bucket();
	}

	protected int _hash(int key) {
		return (key % this.keyRange);
	}

	public void add(int key) {
		int bucketIndex = this._hash(key);
		this.bucketArray[bucketIndex].insert(key);
	}

	public void remove(int key) {
		int bucketIndex = this._hash(key);
		this.bucketArray[bucketIndex].delete(key);
	}

	/** Returns true if this set contains the specified element */
	public boolean contains(int key) {
		int bucketIndex = this._hash(key);
		return this.bucketArray[bucketIndex].exists(key);
	}
}


class Bucket {
	private LinkedList<Integer> container;

	public Bucket() {
		container = new LinkedList<Integer>();
	}

	public void insert(Integer key) {
		int index = this.container.indexOf(key);
		if (index == -1) {
			this.container.addFirst(key);
		}
	}

	public void delete(Integer key) {
		this.container.remove(key);
	}

	public boolean exists(Integer key) {
		int index = this.container.indexOf(key);
		return (index != -1);
	}


	public static void main(String[] args) {
		设计哈希集合 s = new 设计哈希集合();
		s.add(1);
		s.add(2);
		s.contains(3);
		System.out.println(s);
	}
}
