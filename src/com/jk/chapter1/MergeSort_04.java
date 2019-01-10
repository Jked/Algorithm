package com.jk.chapter1;

import java.util.Arrays;

/**
 * @author JK
 * @date 2018年12月9日 下午5:04:46
 * @description 
 * 		归并排序 把一个数组分成两份，左边排好，右边排好，再把左右两边统一排好
 * 		归并排序时间函数
 * 			T(N) = 2T(N/2) + O(N)
 * 		由master公式：
 * 			归并排序的时间复杂度是：O(N*logN)
 * 
 * 		额外空间复杂度：O(N) ， 外排序，用到了辅助数组help[]
 */
public class MergeSort_04 {

	public static void main(String[] args) {
		int[] arr = new int[] { 2, 33, 23, 15, 20, -5, 66, 96, 0};
		System.out.println(Arrays.toString(arr));
		mergeSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	private static void mergeSort(int[] arr, int L, int R) {
		if (L < R) {
			int mid = L + (R - L >> 1);
			mergeSort(arr, L, mid);
			mergeSort(arr, mid+1, R);
			merge(arr, L, R, mid);
		}
	}

	private static void merge(int[] arr, int l, int r, int mid) {
		int p1 = l;
		int p2 = mid+1;
		int[] help = new int[r-l+1];
		int i = 0;
		while(p1 <= mid && p2 <= r){//****注意这里是  <= 符号!!!
			help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
		}
		while(p1 <= mid){
			help[i++] = arr[p1++];
		}
		while(p2 <= r){
			help[i++] = arr[p2++];
		}
		for (i = 0; i < help.length; i++) {
			arr[l + i] = help[i]; //****注意这里是 arr[l + i]
		}
	}

}
