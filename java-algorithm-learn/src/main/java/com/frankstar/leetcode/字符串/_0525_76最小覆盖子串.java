package com.frankstar.leetcode.字符串;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : frankstar
 * @version V1.0
 * @Project: java-improve
 * @Package com.frankstar.leetcode.字符串
 * @Description: TODO
 * @mail :  frankstar007@163.com
 * @date Date : 2020年05月25日 23:40
 */
public class _0525_76最小覆盖子串 {

    public String minWindow(String s, String t) {


        int start = 0;
        int end = s.length()-1;
        int min = s.length();
        if (t.length() > s.length()) return "";
        if (t.length() == s.length()) return t.equals(s) ? t : "";
        while (isContains(s, t)) {
            min = Math.min(min, end - start+1);

            while (!inStr(s.charAt(start), t)) {
                start++;
            }

            while (!inStr(s.charAt(end), t)) {
                end--;
            }
            if (inStr(s.charAt(start), t)) {
                String tmp = s.substring(start + 1);
                if (isContains(tmp, t)) {
                    start++;
                    continue;
                }
            }
            if (inStr(s.charAt(end), t)) {
                String tmp = s.substring(start, end);
                if (isContains(tmp, t)) {
                    end--;
                    continue;
                }
            }
            if (min == end-start+1) break;
        }

            return s.substring(start, end+1);
    }


    private boolean inStr(char charAt, String t) {
        return t.contains(String.valueOf(charAt));
    }

    private boolean isContains(String s, String t) {
        for (int i=0; i<t.length(); i++) {
            if (!s.contains(t.substring(i, i+1))) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        _0525_76最小覆盖子串 s = new _0525_76最小覆盖子串();
        String result = s.minWindow("ADOBECODEBANC", "ABC");
        System.out.println(result);
    }
}
