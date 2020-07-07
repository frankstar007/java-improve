package com.frankstar.leetcode.数组;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : frankstar
 * @version V1.0
 * @Project: java-improve
 * @Package com.frankstar.leetcode.数组
 * @Description: https://leetcode-cn.com/problems/squirrel-simulation/
 * @mail :  frankstar007@163.com
 * @date Date : 2020年07月06日 23:01
 */
public class _0706_573松鼠模拟 {



    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {

        //1 先计算每个坚果到树的距离
        int nutsN = nuts.length;
        int sum = 0;
        for (int i=0; i<nutsN; i++) {
            int dist = computeDist(tree[0], tree[1], nuts[i][0], nuts[i][1]);
            sum += dist * 2;
        }
        int min = Integer.MAX_VALUE;
       // 2计算每个nut 与松鼠的距离
        for (int i=0; i<nutsN; i++) {
            int dist = computeDist(squirrel[0], squirrel[1], nuts[i][0], nuts[i][1]);
            int cur = sum - computeDist(tree[0], tree[1], nuts[i][0], nuts[i][1])
            + dist;
            min = Math.min(min, cur);
        }
        return min;
    }

    private int computeDist(int treeLeft, int treeRight, int nutLeft, int nutRight) {
        return Math.abs(treeLeft - nutLeft) + Math.abs(treeRight - nutRight);
    }


    public int getDistance(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }

    public int minDistanceV2(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int ans = (int) 1e9;
        int sum_dis = 0;
        for (int[] nut : nuts)
            sum_dis += getDistance(nut, tree) * 2;
        for (int[] first_nut : nuts) {
            int cur = sum_dis - getDistance(first_nut, tree) + getDistance(first_nut, squirrel);
            ans = Math.min(cur, ans);
        }
        return ans;
    }



    public static void main(String[] args) {
        _0706_573松鼠模拟 s= new _0706_573松鼠模拟();
        int min = s.minDistance(5, 7, new int[]{2,2}, new int[]{4,4}, new int[][]{{3,0},{2,5}});
        System.out.println(min);
    }


}
