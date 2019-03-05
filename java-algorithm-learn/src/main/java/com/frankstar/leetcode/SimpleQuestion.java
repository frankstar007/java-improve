package com.frankstar.leetcode;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author :  frankstar
 * @AddTime :  2019/2/13
 * @EMail :  yehongxing@meituan.com
 * @Project :  chapter1
 * @Desc :   leetcode中难度为简单的题目
 */
public class SimpleQuestion {

	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}


	/**
	 *  @name 两数之和
	 *  @desc 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
	    你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum(int[] nums, int target) {
		//如果数组为空 返回空
		if (nums.length < 0) {
			return null;
		}

		//List<Integer> numList = Ints.asList(nums);
		List<Integer> numList = new ArrayList<>();
		for (int i = 0; i < nums.length; i ++) {
			numList.add(nums[i]);
		}
		List<Integer> result = new ArrayList<>();

		for (int i = 0 ; i < numList.size(); i++) {
			int left = target - numList.get(i);
			if (numList.contains(left) && i != numList.indexOf(left)) {
				result.add(i);
				result.add(numList.indexOf(left));
				break;
			}
		}
		if (result.size() != 2) {
			return null;
		}
		return new int[]{result.get(0), result.get(1)};
	}


	/**
	 * @name 回文数
	 * @desc 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
	 * @param x
	 * @return
	 */
	public static boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		String s = String.valueOf(x);
		StringBuilder o = new StringBuilder();
		for (int i = s.length() - 1; i >= 0; i--) {
			o.append(s.charAt(i));
		}
		if (s.equals(o.toString())) {
			return true;
		}
		return false;
	}


	/**
	 * @name 回文链表
	 * @param head
	 * @return
	 */
	public static boolean isPalindrome(ListNode head) {
		if (head == null) {
			return true;
		}
		List<Integer> nums = new ArrayList<>();
		while (head != null) {
			nums.add(head.val);
			head = head.next;
		}
		for (int i=nums.size() - 1; i >= 0; i--) {
			if (!nums.get(i).equals(nums.get(nums.size() - 1 -i))) {
				return false;
			}
		}
		return true;

	}

	/**
	 * @name 整数反转
	 * @param x
	 * @return
	 */
	public static int reverse(int x) {
		String s = String.valueOf(x);
		if (x < 0) {
			s = s.substring(1, s.length());
		}
		StringBuilder o = new StringBuilder();
		for (int i = s.length() - 1; i >= 0; i--) {
			o.append(s.charAt(i));
		}
		if (o.toString().length() >= 10) {
			return 0;
		}
		if (x < 0) {

			return -Integer.valueOf(o.toString());
		}
		return Integer.valueOf(o.toString().trim());

	}

	/**
	 * 三角形最大之和
	 * @param A
	 * @return
	 */
	public static int largestPerimeter(int[] A) {
		if (A.length < 3){
			return 0;
		}
		//先排序
		for(int i=0; i<A.length; i++) {
			boolean flag = true;
			for (int j=i+1; j<A.length; j++) {
				if (A[j] > A[i]) {
					int tmp = A[j];
					A[j] = A[i];
					A[i] = tmp;
					flag = false;
				}
			}
			if (flag) {
				break;
			}
		}

		int k=0;
		boolean flag = true;
		for (int i = 0; i<A.length -2; i++) {
			//只要最小的两个数相加大于最大的即可
			if (A[i+1] + A[i+2]> A[i]) {
				k = i;
				flag = false;
				break;

			}
		}
		if (!flag) {
			return A[k] + A[k+1] + A[k+2];
		}
		return 0;


	}

	/**
	 * 给定两个非负整数 x 和 y，如果某一整数等于 x^i + y^j，其中整数 i >= 0 且 j >= 0，那么我们认为该整数是一个强整数。

	 返回值小于或等于 bound 的所有强整数组成的列表。

	 你可以按任何顺序返回答案。在你的回答中，每个值最多出现一次。
	 * @param x
	 * @param y
	 * @param bound
	 * @return
	 */
	public static List<Integer> powerfulIntegers(int x, int y, int bound) {
		if (bound < 2) {
			return new ArrayList<>();
		}

		int xx = (int) (Math.log(bound) / Math.log(x));
		int yy = (int) (Math.log(bound) / Math.log(y));

		Set<Integer> resultSet = new HashSet<>();
		for(int i=0; i<=xx; i++) {
			int a = (int)Math.pow(x, i);
			int bb = bound - a;
			int j = (int) (Math.log(bb) / Math.log(y));
			for(int k=0; k<=j; k++) {
				resultSet.add((int)(Math.pow(x,i) + Math.pow(y,k)));
			}
		}

		return new ArrayList<Integer>(resultSet);
	}


	/**
	 * 我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。

	 （这里，平面上两点之间的距离是欧几里德距离。）

	 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。

	 * @param points
	 * @param K
	 * @return
	 */
	public static int[][] kClosest(int[][] points, int K) {
		int[] result = new int [points.length];

		for (int i=0; i < result.length; i++) {
			result[i] = sqrt(points[i]) ;
		}
		Arrays.sort(result);
		int distK = result[K-1];

		int[][] ans = new int[K][2];
		int t = 0;
		for (int i=0; i < result.length; i++) {
			if (distK >= sqrt(points[i])) {
				ans[t++] = points[i];
			}
		}
		return ans;
	}

	public static int sqrt(int[] point) {
		return point[0]* point[0] + point[1] * point[1];
	}



	public static void main(String[] args) {
		//isPalindrome(121);
//		System.out.println(Integer.valueOf("012"));
//		int result = reverse(1534236469);
//		System.out.println(result);
//		ListNode node1 = new ListNode(1);
//		ListNode node2 = new ListNode(2);
//		//node2 = node1.next;
//		node1.next = node2;
//		System.out.println(isPalindrome(node1));
		int [] A = new int[] {3,9,2,5,2,19};
		int [] B = new int[] {653332,10,2028,58910,403781,8594,36408,249550,478,95319,1253,42,69,22501,15,295,182,13906,5311,112};
		Arrays.sort(A);
		System.out.println(Math.log(Math.pow(10, 6)) /Math.log(2));
		//System.out.println(A);
		//System.out.println(largestPerimeter(A));
		//System.out.println(largestPerimeter(B));
		System.out.println(powerfulIntegers(1,2,100));
	}
}
