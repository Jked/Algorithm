package com.jk.chapter1;

import java.util.Arrays;

/**
 *@author JK
 *@date 2018年12月9日 下午6:51:07
 *@description
 *插入排序
 *思路：
 *	对于一个数组，先把第一个数排好，再把前两个数排好，再把前三个数排好，再把前四个数排好。。。。。。直至整个数组排好序
 *时间复杂度：
 *		O(N^2) : 第一轮过一个数，第二轮过两个数，第三轮过三个数，第四轮过四个数。。。。等差数列求和
 *
 *额外空间复杂度：O(1)
 */
public class InsertSort_03 {

	public static void main(String[] args) {
		int[] arr = new int[] { 2, 33, 23, 15, 20, -5, 66, 96, 0};
		System.out.println(Arrays.toString(arr));
		insertSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void insertSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			for(int j = i; j > 0 && arr[j-1] > arr[j]; j--){
				swap(arr, j, j-1);
			}
		}
	}

	private static void swap(int[] arr, int j, int i) {
		int tem = arr[j];
		arr[j] = arr[i];
		arr[i] = tem;
	}

}
