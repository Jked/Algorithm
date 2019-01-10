package com.jk.chapter2;

import java.util.Arrays;

/**
 * @author JK
 * @date 2018年12月26日 上午7:36:41
 * @description 
 * 	给定一个数组，要求获取数组排好序后，相邻两数的最大差值 是 多少。
 *  要求：时间复杂度为 O(N)，且不能用非基于比较的排序。
 * 
 *     思路：不能用非基于比较的排序，但是可以借助 桶排序 的思想来做。
 */
public class MaxGap_06 {

	public static void main(String[] args) {
		int[] arr = new int[] { 2, 7, 9, 8, 6 };
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		int res = getMaxGap(arr);
		System.out.println("最大差值为:" + res);
	}

	private static int getMaxGap(int[] arr) {
		if (arr.length < 2) {
			return 0;
		}

		int len = arr.length;

		// 获取数组中的最大值 和 最小值
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < len; i++) {
			max = Math.max(max, arr[i]);
			min = Math.min(min, arr[i]);
		}
		// 如果最大值，最小值相等，说明数组中存的是一种元素。
		if (min == max) {
			return 0;
		}

		// 定义三种桶
		boolean hasNum[] = new boolean[len + 1]; // 判断桶里有没有数
		int[] maxs = new int[len + 1]; // 记录桶里的最大值
		int[] mins = new int[len + 1]; // 记录桶中的最小值

		int bucketNo = 0;
		// 遍历数组
		for (int i = 0; i < len; i++) {
			// 得到arr[i]这个元素应该放在几号桶里
			bucketNo = bucketNo(arr[i], len, max, min);
			// 开始往三种桶里放值
			maxs[bucketNo] = hasNum[bucketNo] ? Math.max(arr[i], maxs[bucketNo]) : arr[i];
			mins[bucketNo] = hasNum[bucketNo] ? Math.min(arr[i], mins[bucketNo]) : arr[i];
			hasNum[bucketNo] = true;
		}

		// 开始计算最大差值
		int res = 0;
		int lastMax = maxs[0];
		for (int i = 1; i < mins.length; i++) { //直接从 i = 1 开始判断，也就是说从第1个桶开始判断，因为第0个桶里一定有值。
			if (hasNum[i]) {  //这里一定要加判断！！！如果桶里有值，才进行下面的运算； 如果不判断，当空桶进来时，会有（后一个最小数-0）的情况。
				res = Math.max(res, (mins[i] - lastMax));
				lastMax = maxs[i];
			}
		}
		return res;
	}

	// 通过计算得出，数组中的元素应该放在几号桶里
	private static int bucketNo(int num, int len, int max, int min) {
		return (int) (num - min) * len / (max - min);
	}

}
