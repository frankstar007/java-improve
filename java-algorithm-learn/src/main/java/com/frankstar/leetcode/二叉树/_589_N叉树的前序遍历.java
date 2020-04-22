package com.frankstar.leetcode.二叉树;

import com.frankstar.leetcode.MNode;
import com.frankstar.leetcode.PrintObject;

import java.util.*;

/**
 * @author : frankstar
 * @version V1.0
 * @Project: java-improve
 * @Package com.frankstar.leetcode.二叉树
 * @Description: TODO
 * @mail :  frankstar007@163.com
 * @date Date : 2020年04月21日 22:24
 */
public class _589_N叉树的前序遍历 {


    public List<Integer> preorder(MNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<MNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            MNode node = stack.pop();
            result.add(node.val);
            if (node.children != null) {
                Collections.reverse(node.children);
                for (MNode item : node.children) {
                    stack.add(item);
                }
            }

        }
        return result;
    }


    /**
     * 递归遍历N叉树
     * @param root
     * @return
     */
    public List<Integer> rec_preorder(MNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result);
        return result;

    }

    private void  dfs(MNode root, List<Integer> result) {
        if (root == null) return;
        result.add(root.val);
        List<MNode> children = root.children;
        if (children == null) return;
        for (MNode child : children) {
            dfs(child, result);
        }
    }


    public static void main(String[] args) {
        _589_N叉树的前序遍历 s = new _589_N叉树的前序遍历();
        MNode root = new MNode(1);
        List<MNode> children = new LinkedList<>();
        MNode c1 = new MNode(3);
        List<MNode> cc1 = new ArrayList<>();
        cc1.add(new MNode(5));
        cc1.add(new MNode(6));

        c1.children = cc1;
        children.add(c1);

        MNode c2 = new MNode(2);
        MNode c3 = new MNode(4);

        children.add(c2);
        children.add(c3);

        root.children = children;
        List<Integer> result = s.preorder(root);
        PrintObject.printO(result);
    }

}
