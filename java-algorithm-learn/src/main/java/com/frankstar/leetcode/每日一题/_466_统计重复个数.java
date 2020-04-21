package com.frankstar.leetcode.每日一题;

/**
 * @author : frankstar
 * @version V1.0
 * @Project: java-improve
 * @Package com.frankstar.leetcode.每日一题
 * @Description: TODO
 * @mail :  frankstar007@163.com
 * @date Date : 2020年04月19日 21:18
 */
public class _466_统计重复个数 {

    /**
     * @param s1 由 n 个连接的字符串 s 组成字符串 S，记作 S = [s,n]。例如，["abc",3]=“abcabcabc”。
     *
     * 如果我们可以从 s2 中删除某些字符使其变为 s1，则称字符串 s1 可以从字符串 s2 获得。例如，根据定义，"abc" 可以从 “abdbec” 获得，但不能从 “acbbe” 获得。
     *
     * 现在给你两个非空字符串 s1 和 s2（每个最多 100 个字符长）和两个整数 0 ≤ n1 ≤ 106 和 1 ≤ n2 ≤ 106。现在考虑字符串 S1 和 S2，其中 S1=[s1,n1] 、S2=[s2,n2] 。
     *
     * 请你找出一个可以满足使[S2,M] 从 S1 获得的最大整数 M 。
     *
     *  
     * @param n1
     * @param s2
     * @param n2
     * @return
     */
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        //动态规划，求s2,从第一个开始到第n个开始，分别能走多少圈，结尾是哪个
        int result = 0;

        if(n1 == 0 || n2 == 0){
            return result;
        }
        int s1Length = s1.length();
        int s2Length = s2.length();

        int[][] dp = new int[s2Length][2];//第i个字符开始和s1匹配，是s2能在单次s1的长度中出现的次数，以及下一次匹配s2开始的字符
        int begin = 0;
        int tmpResult = 0;
        //计算dp的值
        for(int i = 0 ; i < s2Length; i++){
            begin = i;tmpResult = 0;
            for(int j = 0 ; j < s1Length; j++){
                if(s1.charAt(j) == s2.charAt(begin)){
                    begin++;
                }
                if(begin == s2Length){
                    begin = 0;
                    tmpResult++;
                }
            }
            dp[i][0] = tmpResult;
            dp[i][1] = begin;
        }

        result = 0;
        begin = 0;
        //计算s2出现的总次数
        for(int i = 0 ; i < n1; i++){
            result += dp[begin][0];
            begin = dp[begin][1];
        }
        result = result/n2;

        return result;

    }


    public static void main(String[] args) {
        _466_统计重复个数 s = new _466_统计重复个数();
        int result = s.getMaxRepetitions("abdcsf", 223, "df", 23);
        System.out.println(result);
    }
}
