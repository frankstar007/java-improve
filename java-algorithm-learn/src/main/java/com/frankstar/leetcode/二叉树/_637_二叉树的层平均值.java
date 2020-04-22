package com.frankstar.leetcode.二叉树;

import com.frankstar.leetcode.PrintObject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author : frankstar
 * @version V1.0
 * @Project: java-improve
 * @Package com.frankstar.leetcode.二叉树
 * @Description: TODO
 * @mail :  frankstar007@163.com
 * @date Date : 2020年04月21日 22:02
 * https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/
 */
public class _637_二叉树的层平均值 {

    public List<Double> averageOfLevels(TreeNode root) {

        List<Double> list = new ArrayList<>();
        //1.先计算一下层高
        int level = dfs(root);

        if (root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            long sum =0;
            for (int i=0;i<size; i++) {
                TreeNode tmp = queue.poll();
                sum += tmp.val;
                if (tmp.left != null) {
                    queue.add(tmp.left);
                }
                if (tmp.right != null) {
                    queue.add(tmp.right);
                }
            }
            list.add(sum * 1.0 / size);
        }
        return list;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(dfs(root.left), dfs(root.right));
    }


    public static void main(String[] args) {
        _637_二叉树的层平均值 s = new _637_二叉树的层平均值();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(11);
        int val = s.dfs(root);
        PrintObject.printO(val);
    }

}
