package com.frankstar.leetcode.BFS;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/30
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/word-transformer-lcci/
 */
public class _面试题_17_22_单词转换 {

	public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {

		if (wordList.size() == 0 || !wordList.contains(endWord)) return new ArrayList<>();

		List<String> result = new ArrayList<>();
		int[] nextWord = new int[wordList.size()];
		Arrays.fill(nextWord, -1);
		Queue<Integer> queue = new LinkedList<>();
		//查找最后一个单次是否存在
		for(int i = 0; i< wordList.size(); i++) {
			if (wordList.get(i).equals(endWord)) {
				nextWord[i] = i;
				queue.add(i);
			}
		}

		//建立nextWord数组
		while (!queue.isEmpty()) {
			int target = queue.poll();
			String targetStr = wordList.get(target);

			for (int i=0; i< wordList.size(); i++) {
				if (nextWord[i] == -1 &&  compareStr(wordList.get(i), targetStr) == 1) {
					nextWord[i] = target;
					queue.add(i);

				}
			}
		}


		// 查找并链接beginWord->next_word[...]->endWord
		for(int i = 0; i < wordList.size(); i++){
			if(compareStr(beginWord, wordList.get(i)) == 1 && nextWord[i] != -1){
				result.add(beginWord);
				int j = i;
				while(nextWord[j] != j){
					result.add(wordList.get(j));
					j = nextWord[j];
				}
				result.add(endWord);
				break;
			}
		}
		return result;


	}

	private int compareStr(String tmp, String target) {

		int count = 0;
		for (int i= 0; i< target.length(); i++) {
			if (tmp.charAt(i) != target.charAt(i)) {
				count += 1;
			}
		}

		return count;


	}


	public static void main(String[] args) {
		_面试题_17_22_单词转换 s = new _面试题_17_22_单词转换();
		List<String> wordList = Lists.newArrayList("hot","dot","dog","lot","log","cog");
		s.findLadders("hit", "cog", wordList);
		s.compareStr("cog", "ffg");

	}

}
