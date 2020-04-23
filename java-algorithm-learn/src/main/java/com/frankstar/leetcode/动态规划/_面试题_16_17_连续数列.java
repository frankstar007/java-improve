package com.frankstar.leetcode.动态规划;

/**
 * @Author :  frankstar
 * @AddTime :  2020/4/23
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/contiguous-sequence-lcci/
 */
public class _面试题_16_17_连续数列 {

	/**
	 * dp 解决
	 * @param nums
	 * @return
	 */
	public int maxSubArray(int[] nums) {
		int max = Integer.MIN_VALUE;
		int N = nums.length;
		int[] opt = new int[N];
		opt[0] = nums[0];
		for (int i=1; i<N; i++) {
			if (opt[i-1] < 0) {
				opt[i] = nums[i];
			} else {
				opt[i] = opt[i-1] + nums[i];
			}
			max = Math.max(max, opt[i]);
		}
		return max;
	}


	public int divideMaxSubArray(int[] nums) {
		return maxSub(nums,0,nums.length-1);
	}


	public static int maxSub(int[]nums,int left,int right )
	{
		//一定将左右边界最大初始化为MIN_VALUE，初始化为0的时候全为负数过不去
		int maxleftbordersum =  Integer.MIN_VALUE,maxrightbordersum = Integer.MIN_VALUE;
		int leftmaxsum = Integer.MIN_VALUE,rightmaxsum = Integer.MIN_VALUE;
		int leftbordersum = 0,rightbordersum = 0;

		int mid = left+(right-left)/2;
		if(left==right)
		{
			return nums[left];
		}
		leftmaxsum = maxSub(nums,left,mid);		//计算得到左子数组的最大值
		rightmaxsum= maxSub(nums,mid+1,right);	//计算得到右子数组的最大值

		for(int i = mid;i >= left ;i--)		//一定要从中间向两端加！！！
		{
			leftbordersum += nums[i];
			if(leftbordersum > maxleftbordersum)
				maxleftbordersum = leftbordersum;
		}

		for(int i = mid+1 ;i <= right;i++)
		{
			rightbordersum += nums[i];
			if(rightbordersum > maxrightbordersum)
				maxrightbordersum = rightbordersum;
		}
		//返回三者最大值
		return Integer.max(leftmaxsum,Integer.max(rightmaxsum,maxleftbordersum+maxrightbordersum));
	}



}
