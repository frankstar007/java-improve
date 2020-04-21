package com.frankstar.leetcode.二叉树;

/**
 * @author : frankstar
 * @version V1.0
 * @Project: java-improve
 * @Package com.frankstar.leetcode.二叉树
 * @Description: TODO
 * @mail :  frankstar007@163.com
 * @date Date : 2020年04月21日 21:43
 */
public class _100_相同的树 {


    public boolean isSameTree(TreeNode p, TreeNode q) {
        return dfs(p, q);
    }

    private boolean dfs(TreeNode p, TreeNode q) {
        if (p==null && q==null) return true;
        if (p == null) return false;
        if (q == null) return false;
        if (p.val == q.val) {
            return dfs(p.left, q.left) && dfs(p.right, q.right);
        }

        return false;
    }
}
