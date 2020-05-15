package com.frankstar.leetcode.队列;

import com.frankstar.leetcode.PrintObject;
import org.apache.ibatis.annotations.Param;

import java.util.*;

/**
 * @author : frankstar
 * @version V1.0
 * @Project: java-improve
 * @Package com.frankstar.leetcode.队列
 * @Description: TODO
 * @mail :  frankstar007@163.com
 * @date Date : 2020年05月14日 22:23
 */
public class _0514_面试题59I滑动窗口的最大值 {


    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums.length == 0 && k==0) return new int[]{};

        Stack<Integer> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();

        for (int i=0; i<nums.length; i++) {

            int size = stack.size();
            if (size < k ) {
                stack.add(nums[i]);
                continue;
            }
            int max = Integer.MIN_VALUE;
            while (!stack.isEmpty()) {
                max = stack.peek() > max ? stack.peek() : max;
                stack.pop();
                i--;
            }
            result.add(max);

        }
        int max = Integer.MIN_VALUE;
        while (!stack.isEmpty()) {
            max = stack.peek() > max ? stack.peek() : max;
            stack.pop();
        }
        result.add(max);


        int len = result.size();
        int[] arr = new int[len];
        int i= 0;
        for (Integer item : result) {
            arr[i++] = item;
        }
        return arr;
    }


    public static void main(String[] args) {
        _0514_面试题59I滑动窗口的最大值 s = new _0514_面试题59I滑动窗口的最大值();
        int[] arr = new int[]{1,3,-1,-3,5,3,6,7};
        int[] result = s.maxSlidingWindow(arr, 3);
        PrintObject.printO(result);
    }


}
