package com.frankstar.leetcode.二叉树;

import com.frankstar.algorithms.BinarySearch;
import com.frankstar.leetcode.PrintObject;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author : frankstar
 * @version V1.0
 * @Project: java-improve
 * @Package com.frankstar.leetcode.二叉树
 * @Description: TODO 二叉搜索树
 * @mail :  frankstar007@163.com
 * @date Date : 2020年04月21日 23:32
 */
public class BinarySearchTree {


    public TreeNode buildTree(int val,  TreeNode root) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }

        TreeNode newNode = new TreeNode(val);
        TreeNode newR = root;
        while (newR != null) {
            if (val <= newR.val) {
                if (newR.left == null) {
                    newR.left = newNode;
                    return root;
                }
                newR = newR.left;
            }else {
                if (newR.right == null) {
                    newR.right = newNode;
                    return root;
                }
                newR = newR.right;
            }

        }

        return root;

    }


    public static void main(String[] args) {
        BinarySearchTree searchTree = new BinarySearchTree();
        List<Integer> nums = Lists.newArrayList(6,3,8,2,5,1,7);
        TreeNode root = null;
        for (Integer integer : nums) {
            root = searchTree.buildTree(integer, root);
        }

        PrintObject.printO(root);
    }
}
