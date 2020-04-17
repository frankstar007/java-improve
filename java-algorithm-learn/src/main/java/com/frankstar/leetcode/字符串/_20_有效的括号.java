package com.frankstar.leetcode.字符串;

import java.util.Stack;

/**
 * @author : frankstar
 * @version V1.0
 * @Project: java-improve
 * @Package com.frankstar.leetcode.字符串
 * @Description: https://leetcode-cn.com/problems/valid-parentheses/
 * @mail :  frankstar007@163.com
 * @date Date : 2020年04月01日 21:23
 */
public class _20_有效的括号 {

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack();
        for (int i=0; i<s.length(); i++) {
            char  tmp = s.charAt(i);
            if (tmp == '(' || tmp == '{' || tmp == '[') {
                stack.push(tmp);
            } else {

                Character c = stack.pop();


                if (tmp == ')') {
                    if (c == null || c != '(') return false;
                } else if (tmp == '}') {
                    if (c == null || c != '{') return false;
                }else if (tmp == ']') {
                    if (c == null || c != '[') return false;
                }

            }


        }
        return stack.isEmpty();

    }

    public static void main(String[] args) {
        _20_有效的括号 s = new _20_有效的括号();
        boolean result = s.isValid("()[]{}");
        System.out.println(result);
    }
}
