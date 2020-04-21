package com.frankstar.leetcode.二叉树;

import java.util.*;

/**
 * @author : frankstar
 * @version V1.0
 * @Project: java-improve
 * @Package com.frankstar.leetcode.二叉树
 * @Description: TODO
 * @mail :  frankstar007@163.com
 * @date Date : 2020年04月21日 21:50
 */
public class _107_二叉树的层次遍历II {


    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> linkedList = new LinkedList<>();
        if (root == null) return linkedList;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> items = new ArrayList<>();
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode tmp = queue.poll();
                if (tmp.left != null) {
                    queue.add(tmp.left);
                }
                if (tmp.right != null) {
                    queue.add(tmp.right);
                }
                items.add(tmp.val);
            }


            linkedList.addLast(items);
        }


        return linkedList;
    }
}
