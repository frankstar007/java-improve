package com.frankstar.leetcode.DFS;

import com.frankstar.leetcode.二叉树.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @Author :  frankstar
 * @AddTime :  2020/5/9
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree/
 */
public class _0509_863二叉树中所有距离为K的结点 {


	public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
		//先建立当前节点 与父节点的映射关系
		Map<TreeNode, TreeNode> parent = new HashMap<>();
		dfsParent(root, null, parent);

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(null);
		queue.add(target);

		Set<TreeNode> visited = new HashSet<>();
		visited.add(target);
		visited.add(null);

		int dist = 0;
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node == null) {
				if (dist == K) {
					List<Integer> ans = new ArrayList<>();
					for (TreeNode n : queue) {
						ans.add(n.val);
					}
					return ans;
				}
				queue.offer(null);
				dist++;
			} else {
				if (!visited.contains(node.left)) {
					visited.add(node.left);
					queue.offer(node.left);
				}
				if (!visited.contains(node.right)) {
					visited.add(node.right);
					queue.offer(node.right);
				}
				TreeNode par = parent.get(node);
				if (!visited.contains(par)) {
					visited.add(par);
					queue.offer(par);
				}
			}
		}

		return new ArrayList<>();
	}

	private void dfsParent(TreeNode root, TreeNode parent,
		Map<TreeNode, TreeNode> treeNodeTreeNodeMap) {
		if (root == null) return;
		treeNodeTreeNodeMap.put(root, parent);
		dfsParent(root.left, root, treeNodeTreeNodeMap);
		dfsParent(root.right, root, treeNodeTreeNodeMap);
	}



}
