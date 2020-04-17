package com.frankstar.leetcode.每日一题;

import java.util.Stack;

/**
 * @author : frankstar
 * @version V1.0
 * @Project: java-improve
 * @Package com.frankstar.leetcode.每日一题
 * @Description: https://leetcode-cn.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/
 * @mail :  frankstar007@163.com
 * @date Date : 2020年04月01日 20:22
 */
public class _1111_有效括号的嵌套深度 {

    public int[] maxDepthAfterSplit(String seq) {
        int[] ans = new int [seq.length()];
        int idx = 0;
        for(char c: seq.toCharArray()) {
            ans[idx++] = c == '(' ? idx & 1 : ((idx + 1) & 1);
        }
        return ans;


    }


    public static void main(String[] args) {
        _1111_有效括号的嵌套深度 s = new _1111_有效括号的嵌套深度();
        String str = "(()(())())";
        s.maxDepthAfterSplit(str);
    }
}
