package com.frankstar.leetcode.数组;

/**
 * @author : frankstar
 * @version V1.0
 * @Project: java-improve
 * @Package com.frankstar.leetcode.数组
 * @Description: TODO
 * @mail :  frankstar007@163.com
 * @date Date : 2020年05月08日 22:03
 */
public class _0508_4寻找两个正序数组的中位数 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int N = nums1.length;

        int M = nums2.length;

        int[] arrays = new int[N+M];

        int aStart = 0;
        int bStart = 0;
        int j = 0;
        while (aStart < N && bStart <M) {
            if (nums1[aStart] <= nums2[bStart]) {
                arrays[j++] = nums1[aStart++];
            } else{
                arrays[j++] = nums2[bStart++];
            }
        }

        while (bStart < M) {
            arrays[j++] = nums2[bStart++];
        }

        while (aStart < N) {
            arrays[j++] = nums1[aStart++];
        }

        //偶数
        int len = M + N;
        if (len % 2 == 0) {
            return (arrays[len/2] + arrays[len/2 - 1]) * 1.0 /2;
        } else {
            return arrays[len/2] * 1.0;
        }


    }
}
