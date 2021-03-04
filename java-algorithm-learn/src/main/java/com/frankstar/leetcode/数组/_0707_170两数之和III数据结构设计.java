package com.frankstar.leetcode.数组;

import java.util.LinkedList;
import java.util.List;

/**
 * @author : frankstar
 * @version V1.0
 * @Project: java-improve
 * @Package com.frankstar.leetcode.数组
 * @Description: https://leetcode-cn.com/problems/two-sum-iii-data-structure-design/
 * @mail :  frankstar007@163.com
 * @date Date : 2020年07月07日 23:11
 */
public class _0707_170两数之和III数据结构设计 {

    class TwoSum {

        private List<Integer> eles;


        /** Initialize your data structure here. */
        public TwoSum() {
            eles = new LinkedList<>();
        }

        /** Add the number to an internal data structure.. */
        public void add(int number) {
            eles.add(number);
        }

        private int loadN(List<Integer> eles, int num) {
            int count = 0;
            for (Integer ele : eles) {
                if (ele == num) {
                    count++;
                }
            }

            return count;
        }

        /** Find if there exists any pair of numbers which sum is equal to the value. */
        public boolean find(int value) {
            if (eles.isEmpty()) return false;
            for (Integer ele : eles) {
                int left = value - ele;
                if (eles.contains(left)) {
                    if (left == ele) {
                        if (loadN(eles, left) < 2) {
                            continue;
                        } else {
                            return true;
                        }
                    }
                    return true;
                }
            }

            return false;
        }
    }


    public static void main(String[] args) {
        _0707_170两数之和III数据结构设计 s = new _0707_170两数之和III数据结构设计();
        TwoSum sum = s.new TwoSum();
        sum.add(0);
        boolean result = sum.find(0);
        boolean last = sum.find(7);
    }

}
