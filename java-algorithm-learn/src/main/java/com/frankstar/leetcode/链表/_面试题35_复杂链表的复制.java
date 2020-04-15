package com.frankstar.leetcode.链表;

import com.frankstar.leetcode.ListNode;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @Author :  frankstar
 * @AddTime :  2020/4/15
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class _面试题35_复杂链表的复制 {

	public ListNode copyRandomList(ListNode head) {
		if (head == null) return head;

		ListNode newH = new ListNode(head.val);
		ListNode l = head.next;
		ListNode q = newH;
		while (l != null) {
			ListNode next = new ListNode(l.val);
			q.next = next;
			q = next;

			l = l.next;
		}
		//一次遍历每个节点的random节点
		ListNode rl = head;
		ListNode rq = newH;

		while (rl != null) {
			if (rl.random == null) {
				rq.random = null;
			} else {
				int val = rl.random.val;
				ListNode tmp = newH;
				if (val == 0) {
					rq.random = tmp;
				}else {
					while (val> 1) {
						tmp = tmp.next;
						val--;
					}
					rq.random = tmp;
				}
			}


			rq = rq.next;
			rl = rl.next;
		}

		return newH;

	}

	public ListNode copyRandomList2(ListNode head) {
		if (head == null) return head;
		//原节点 新节点
		Map<ListNode, ListNode> map = new HashMap<>();
		ListNode tmp = head;
		while (tmp != null) {
			map.put(tmp, new ListNode(tmp.val));
			tmp = tmp.next;
		}

		tmp = head;
		while (tmp!= null) {
			map.get(tmp).next = map.get(tmp.next);
			map.get(tmp).random = map.get(tmp.random);

			tmp = tmp.next;
		}


		return map.get(head);
	}

	/**
	 * 深度优先
	 * @param head
	 * @return
	 */
	public ListNode dfsCopyRandomList(ListNode head) {
		if(head == null) return head;
		Map<ListNode, ListNode> used = new HashMap<>();

		return dfs(head, used);

	}

	private ListNode dfs(ListNode head, Map<ListNode, ListNode> used) {
		if (head == null) return head;
		if (used.containsKey(head)) return used.get(head);
		ListNode newNode = new ListNode(head.val);
		used.put(head, newNode);
		newNode.next = dfs(head.next, used);
		newNode.random = dfs(head.random, used);
		return newNode;

	}

	/**
	 * 深度优先遍历
	 * @param head
	 * @return
	 */
	public ListNode bfsCopyRandomList(ListNode head) {
		if(head == null) return head;

		return bfs(head);
	}

	private ListNode bfs(ListNode head) {
		if (head == null) return head;
		Map<ListNode, ListNode> map = new HashMap<>();
		map.put(head, new ListNode(head.val));
		Queue<ListNode> queue = new LinkedList<>();
		queue.add(head);
		while (!queue.isEmpty()) {
			int siz = queue.size();
			for (int i = 0; i < siz; i++) {
				ListNode tmp = queue.peek();
				queue.poll();
				if (tmp.next != null) {
					if (!map.containsKey(tmp.next)) {
						map.put(tmp.next, new ListNode(tmp.next.val));
						queue.add(tmp.next);
					}
					map.put(map.get(tmp).next, map.get(tmp.next));
				}

				if (tmp.random != null) {
					if (!map.containsKey(tmp.random)) {
						map.put(tmp.random, new ListNode(tmp.random.val));
						queue.add(tmp.random);
					}
					map.put(map.get(tmp).random, map.get(tmp.random));
				}
			}
		}
		return map.get(head);
	}


	public static void main(String[] args) {
		_面试题35_复杂链表的复制 s = new _面试题35_复杂链表的复制();
		ListNode head = new ListNode(7);
		head.next = new ListNode(13);
		head.random = null;

		head.next.random = new ListNode(0);

		head.next.next = new ListNode(11);
		head.next.next.random = new ListNode(4);


		head.next.next.next = new ListNode(10);
		head.next.next.next.random = new ListNode(2);


		head.next.next.next = new ListNode(1);
		head.next.next.next.random = new ListNode(0);


		ListNode newH = s.copyRandomList(head);
	}

}
