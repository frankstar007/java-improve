package com.frankstar.leetcode.动态规划;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author : frankstar
 * @version V1.0
 * @Project: java-improve
 * @Package com.frankstar.leetcode.动态规划
 * @Description: TODO
 * @mail :  frankstar007@163.com
 * @date Date : 2020年04月16日 23:26
 */
public class _300最长上升子序列 {

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int k = nums.length;
        int max = 0;
        for (int i=0; i<k;i++) {
            if (stack.isEmpty()) {
                stack.add(nums[i]);
            } else{
                while (!stack.isEmpty()) {
                    int peek = stack.peek();
                    if (peek >= nums[i]) {
                        stack.pop();
                        continue;
                    } else{
                        stack.push(nums[i]);
                        break;
                    }
                }
                if (stack.isEmpty()) {
                    stack.push(nums[i]);
                }
            }
            max = Math.max(max, stack.size());
        }

        return max;
    }


    public int dpMaxLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int k = nums.length;
        int[] opt = new int[k];
        Arrays.fill(opt, 1);
        int max = 0;
        for (int i=0; i<nums.length; i++) {
            for (int j=0; j<i; j++) {
                if (nums[j] < nums[i]) {
                    opt[i] = Math.max(opt[i], opt[j] + 1);
                }
            }
            max = Math.max(max, opt[i]);
        }
        return max;
    }

    public int dpAndDichotomy(int[] nums) {
        int[] opt = new int[nums.length];
        int max = 0;
        for (int num : nums) {
            int i =0,j=max;
            while (i <j) {
                int m = (i+j)/2;
                if (opt[m] < num) {
                    i = m+1;
                }else {
                    max = m;
                }
            }
            opt[i] = num;
            if (max == j) {
                max++;
            }

        }
        return max;
    }
}
