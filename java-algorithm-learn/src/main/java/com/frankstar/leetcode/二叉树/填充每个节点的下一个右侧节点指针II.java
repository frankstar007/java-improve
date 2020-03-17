package com.frankstar.leetcode.二叉树;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/13
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/explore/learn/card/data-structure-binary-tree/4/conclusion/18/
 */
public class 填充每个节点的下一个右侧节点指针II {

	public Node connect(Node root) {
		 if (root == null) return root;

		 //node直接走到root的右兄弟处，根节点时直接为null
		 Node tmp = root.next;

		 //找到root的右兄弟 中从左往右第一个不为空的孩子节点，如果没有则找下一个右兄弟，直到右兄弟没有
		 while (tmp != null) {

		 	if (tmp.left != null) {
				tmp = tmp.left;
				break;
			}
			if (tmp.right != null) {
		 		tmp = tmp.right;
		 		break;
			}
			tmp = tmp.next;
		 }
		 //如果左孩子不为空，就找一个伴侣节点，向右看第一个不为空的孩子
		if (root.left != null) {
		 	root.left.next = (root.right == null) ? tmp : root.right;
		}
		 if(root.right != null) {
		 	root.right.next = tmp;
		 }

		 //先扫描右孩子再扫描左孩子
		 connect(root.right);
		 connect(root.left);

		 return root;
	}
}
