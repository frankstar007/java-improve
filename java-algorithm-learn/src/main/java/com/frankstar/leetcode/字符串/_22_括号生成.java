package com.frankstar.leetcode.字符串;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : frankstar
 * @version V1.0
 * @Project: java-improve
 * @Package com.frankstar.leetcode.字符串
 * @Description: https://leetcode-cn.com/problems/generate-parentheses/
 * @mail :  frankstar007@163.com
 * @date Date : 2020年04月01日 22:26
 */
public class _22_括号生成 {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    private void backtrack(List<String> ans, String cur, int open, int close, int n) {
        if (cur.length() == n * 2) {
            ans.add(cur);
            return;
        }
        if (open < n)
            backtrack(ans, cur+"(", open+1, close, n);
        if (close < open)
            backtrack(ans, cur+")", open, close+1, n);


    }
}
