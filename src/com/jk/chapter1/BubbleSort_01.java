package com.jk.chapter1;

import java.util.Arrays;

/**
 *@author JK
 *@date 2018年12月9日 下午7:14:06
 *@description
 *	冒泡排序
 *	
 *	时间复杂度：O(N^2)
 *	额外空间复杂度：O(1)
 */
public class BubbleSort_01 {

	public static void main(String[] args) {
		int[] arr = new int[] { 2, 33, 23, 15, 20, -5, 66, 96, 0};
		System.out.println(Arrays.toString(arr));
		bubbleSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length-i-1; j++) {
				if(arr[j] > arr[j+1]){
					swap(arr, j, j+1);
				}
			}
		}
	}
	private static void swap(int[] arr, int l, int r) {
		int tem = arr[l];
		arr[l] = arr[r];
		arr[r] = tem;
	}

}
