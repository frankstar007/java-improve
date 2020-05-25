package com.frankstar.leetcode.字符串;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author : frankstar
 * @version V1.0
 * @Project: java-improve
 * @Package com.frankstar.leetcode.字符串
 * @Description: TODO
 * @mail :  frankstar007@163.com
 * @date Date : 2020年05月25日 23:02
 */
public class _0525_3无重复字符的最长子串 {

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 0) return 0;
        int max = 0;
        Deque<Character> deque = new LinkedList<>();
        for (int i=0; i<n; i++) {
            Character tmp = s.charAt(i);

            if (!deque.contains(tmp)) {
                deque.addLast(tmp);
                max = Math.max(max, deque.size());
            } else {
                while (!deque.isEmpty()) {
                    Character first = deque.pollFirst();
                    if (first == tmp) break;
                }
                deque.addLast(tmp);
            }

        }
        return max;
    }


    public int standAns(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;

    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        _0525_3无重复字符的最长子串 t = new _0525_3无重复字符的最长子串();
        t.standAns(s);
        t.lengthOfLongestSubstring(s);
    }

}
