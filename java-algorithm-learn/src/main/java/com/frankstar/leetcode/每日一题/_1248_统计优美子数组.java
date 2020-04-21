package com.frankstar.leetcode.每日一题;

import com.frankstar.leetcode.PrintObject;

/**
 * @Author :  frankstar
 * @AddTime :  2020/4/21
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class _1248_统计优美子数组 {


	public int numberOfSubarrays(int[] nums, int k) {

		int count = 0;
		int N = nums.length;
		int[] left =  new int[N];
		int[] right = new int[N];
		int curr = 0;
		for (int i=0; i< N-1; i++) {
			if (nums[i] % 2 != 0) {
				left[curr] = i;
				count++;
				for (int j=i+1; j<N; j++) {

					if (nums[j] % 2 != 0) {
						count++;
					}
					//如果等于k个
					if (count == k) {
						right[curr] = j;
						count=0;
						break;
					}

				}

				curr++;
			}
		}

		int result = 0;
		for (int i = 0; i<N; i++) {
			if (left[i] >= right[i]) {
				break;
			}
			int leftGap = 0;
			if (left[i] > 0)  {
				if (i == 0) {
					leftGap = left[i];
				}else {
					if (left[i] > right[i-1]) {
						leftGap = left[i] - right[i-1] -1;
					}
				}
			}

			int rightGap = 0;
			if(right[i] > 0) {
				if (right[i+1] < right[i]) {
					rightGap = N-1-right[i];
				} else {
					rightGap = right[i+1] - right[i] -1;
				}
			}


			result  += (1 + leftGap + rightGap + (leftGap * rightGap));
		}



		PrintObject.printO(left);
		PrintObject.printO(right);
		PrintObject.printO(result);
		return result;

	}


	public int standardAns(int[] nums, int k) {
		int N = nums.length;
		int[] odd = new int[N + 2];
		int ans = 0, cnt = 0;
		for (int i = 0; i < N; ++i) {
			if (nums[i] % 2 != 0) odd[++cnt] = i;
		}
		odd[0] = -1;
		odd[++cnt] = N;
		for (int i = 1; i + k <= cnt; ++i) {
			ans += (odd[i] - odd[i - 1]) * (odd[i + k] - odd[i + k - 1]);
		}
		return ans;

	}


	public int otherAns(int[] nums, int k) {
		int N = nums.length;
		int[] cnt = new int[N + 1];
		int odd = 0, ans = 0;
		cnt[0] = 1;
		for (int i = 0; i < N; ++i) {
			odd += nums[i] & 1;
			ans += odd >= k ? cnt[odd - k] : 0;
			cnt[odd] += 1;
		}
		return ans;

	}


	public static void main(String[] args) {
		_1248_统计优美子数组 s = new _1248_统计优美子数组();
		s.standardAns(new  int[]{1,1,1,1,1}, 1);
	}
}
