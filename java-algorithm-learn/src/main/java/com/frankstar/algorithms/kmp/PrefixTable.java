package com.frankstar.algorithms.kmp;

/**
 * @author : frankstar
 * @version V1.0
 * @Project: java-improve
 * @Package com.frankstar.algorithms.kmp
 * @Description:  kmp 算法 pattern子串的最长公共前缀
 * @mail :  frankstar007@163.com
 * @date Date : 2020年03月31日 21:57
 */
public class PrefixTable {


    /**
     * 计算某个模式串的最长公共子串值
     * @param pattern
     * @return
     */
    public int[] prefixTable(String pattern) {
        int[] nextVal = new int[pattern.length()];
        nextVal[0] = -1;
        for (int i= 1; i<nextVal.length; i++) {

        }

        return nextVal;

    }
}
