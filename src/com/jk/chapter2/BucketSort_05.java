package com.jk.chapter2;

import java.util.Arrays;

/**
 *@author JK
 *@date 2018年12月25日 下午10:19:40
 *@description
 *	练习 桶排序： 创建一个数组(A)，利用该数组下标索引来表示 目标数组中的元素，
 *		索引对应的元素就是目标元素出现  以该索引 为大小的值   出现的次数。
 *		这个数组A就是 桶！
 *		由于索引 是 从0开始的， 所以桶排序只适合用来对 0——正数 来排序。
 *
 *	时间复杂度是：O(N) :因为只要过一遍目标数组 即可。
 *	额外空间复杂度：O(N)	：因为要额外创建一个 辅助数组。
 */
public class BucketSort_05 {

	public static void main(String[] args) {
		int[] arr = new int[] { 2, 33, 23, 15, 20, 66, 7};
		System.out.println(Arrays.toString(arr));
		bucketSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	//桶排序
	private static void bucketSort(int[] arr) {
		//找到数组中的最大值
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			max = Math.max(arr[i], max);
		}
		
		//根据这个最大值来 创建一个桶 ，长度为 ：最大值+1
		int[] bucket = new int[max+1];
		//往桶里放值，桶的索引就是 目标数组的元素值
		for (int i = 0; i < arr.length; i++) {
			bucket[arr[i]]++;
		}
		
		//开始排序，按照辅助数组中索引的顺序，根据索引对应存储的值 往 原数组 中放。
		int i = 0;
		for (int j = 0; j < bucket.length; j++) {
			while(bucket[j]-- > 0){
				arr[i++] = j;
			}
		}
	}

}
