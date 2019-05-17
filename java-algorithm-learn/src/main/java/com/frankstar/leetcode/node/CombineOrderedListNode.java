package com.frankstar.leetcode.node;

/**
 * @author : frankstar
 * @version V1.0
 * @Project: java-improve
 * @Package com.frankstar.leetcode.node
 * @Description: 合并两个有序链表
 * @mail :  frankstar007@163.com
 * @date Date : 2019年05月06日 23:11
 */
public class CombineOrderedListNode {

    public static ListNode mergeTwoLists(ListNode node1, ListNode node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        ListNode p1 = node1;
        int size1 = 1;
        while (p1.next != null) {
            size1++;
            p1 = p1.next;
        }
        System.out.println(size1);

        ListNode p2 = node2;
        int size2 = 1;
        while (p2.next != null) {
            size2++;
            p2 = p2.next;
        }
        System.out.println(size2);

        ListNode tmp = new ListNode(0);
        ListNode result = tmp;
        if (size1 > size2) {
            boolean flag = false;
            while (node1.next != null) {
                int value = 0;
                if (node2 != null) {
                    value = node1.val+ node2.val;
                    if (flag) {
                        value = value + 1;
                    }
                    if (value >= 10) {
                        flag = true;
                    }
                    value = value >= 10 ? value%10 : value;
                } else {
                    value = node1.val;
                    if (flag) {
                        value = node1.val + 1;
                    }
                    if (value >= 10) {
                        flag = true;
                    }
                }


                ListNode node = new ListNode(value);
                tmp.next = node;
                tmp = tmp.next;
                node1 = node1.next;
                if (node2 != null) {
                    node2 = node2.next;
                }
            }
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(5);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(9);

        ListNode node2 = new ListNode(2);
        node2.next = new ListNode(6);
        node2.next.next = new ListNode(3);

        System.out.println(mergeTwoLists(node1, node2));
    }
}
