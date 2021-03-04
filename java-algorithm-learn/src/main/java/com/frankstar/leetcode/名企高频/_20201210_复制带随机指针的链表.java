package com.frankstar.leetcode.名企高频;

import com.frankstar.leetcode.名企高频.basic.Node;

/**
 * @Author :  frankstar
 * @AddTime :  2020/12/10
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。

			要求返回这个链表的 深拷贝。 

			我们用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：

			val：一个表示 Node.val 的整数。
			random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。

 */
public class _20201210_复制带随机指针的链表 {


	public Node copyRandomList(Node head) {
		if (head == null) return null;

		Node tmp = head;
		Node newH = new Node(tmp.val);
		Node p = newH;
		while (tmp != null) {

		}
		return null;
	}
}
