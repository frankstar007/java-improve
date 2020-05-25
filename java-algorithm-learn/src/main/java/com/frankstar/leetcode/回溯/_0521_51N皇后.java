package com.frankstar.leetcode.回溯;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : frankstar
 * @version V1.0
 * @Project: java-improve
 * @Package com.frankstar.leetcode.回溯
 * @Description: TODO
 * @mail :  frankstar007@163.com
 * @date Date : 2020年05月21日 22:29
 */
public class _0521_51N皇后 {

    public List<List<String>> solveNQueens(int n) {


        int[][] matrix = new int[n][n];
        List<List<String>> result = new ArrayList<>();
        Deque<String> items = new LinkedList<>();
        dfs(result, items, matrix, 0);

        return result;

    }

    private void dfs(List<List<String>> result, Deque<String> items, int[][] matrix, int index) {



    }
}
