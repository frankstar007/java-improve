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
        Map<Integer, Integer> distMap = new HashMap<>();
        for (int i=0; i<nutsN; i++) {
            int dist = computeDist(tree[0], tree[1], nuts[i][0], nuts[i][1]);
            distMap.put(i, dist);
        }
        int min = Integer.MAX_VALUE;
        Map<Integer, Integer> minMap = new HashMap<>();
        for (int i=0; i<nutsN; i++) {
            int dist = computeDist(squirrel[0], squirrel[1], nuts[i][0], nuts[i][1]);
            minMap.put(dist, i);
            min = Math.min(min, dist);
        }
        int sum = min + distMap.get(minMap.get(min));
        for (Integer index : distMap.keySet()) {
            if (!minMap.get(min).equals(index)) {
                sum += 2 * distMap.get(index);
            }
        }
        return sum;
    }

    private int computeDist(int treeLeft, int treeRight, int nutLeft, int nutRight) {
        return Math.abs(treeLeft - nutLeft) + Math.abs(treeRight - nutRight);
    }


    public static void main(String[] args) {
        _0706_573松鼠模拟 s= new _0706_573松鼠模拟();
        int min = s.minDistance(5, 7, new int[]{2,2}, new int[]{4,4}, new int[][]{{3,0},{2,5}});
        System.out.println(min);
    }


}
