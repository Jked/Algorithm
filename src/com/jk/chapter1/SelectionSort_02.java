package com.jk.chapter1;

import java.util.Arrays;

/**
 *@author JK
 *@date 2018年12月9日 下午7:01:50
 *@description
 *	选择排序
 * 思路：
 *	在整个数组中找到一个最小的数放在第一个位置，再从第二个位置开始找一个最小的数放在第二个位置；
 *  再从第三个位置开始找一个最小的数放在第三个位置，依次下去。。。。。。。
 *  
 * 时间复杂度是：O(N^2)
 * 额外空间复杂度：O(1)
 */
public class SelectionSort_02 {

	public static void main(String[] args) {
		int[] arr = new int[] { 2, 33, 23, 15, 20, -5, 66, 96, 0};
		System.out.println(Arrays.toString(arr));
		selectSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void selectSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int minIndex = i; //把每轮比较出来的最小数的索引记录下来
			for (int j = i; j < arr.length-1; j++) {
				minIndex = arr[j+1] < arr[minIndex] ? j+1 : minIndex;
			}
			swap(arr, i, minIndex);//把最小数和当前最头上的那个数交换
		}
	}

	private static void swap(int[] arr, int i, int minIndex) {
		int tem = arr[i];
		arr[i] = arr[minIndex];
		arr[minIndex] = tem;
	}

}
