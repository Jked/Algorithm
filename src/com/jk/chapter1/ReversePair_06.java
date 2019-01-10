package com.jk.chapter1;

import java.util.Arrays;

/**
 *@author JK
 *@date 2018年12月26日 下午8:50:36
 *@description
 *	问：在一个数组中，如果左边的数大于右边的数，则这两个数组成一组 逆序对，请打印一个数组中所以的 逆序对？
 *	答：
 *		利用归并排序的思想，由大到小排序，左边数组的一个数A大于 右边数组的某一个数B，则这个数A 大于 右边数组从B开始
 *	向右的所有数。
 *
 */
public class ReversePair_06 {

	static int res = 0;
	
	public static void main(String[] args) {
		int[] arr = new int[] { 2, 33, 23, 15, 20, 66, 7};
		printReverePair(arr, 0, arr.length-1);
		System.out.println("该数组共有"+res+"对逆序对");
	}

	private static void printReverePair(int[] arr, int L, int R) {
		if(L < R){
			int mid = L + (R-L>>1);
			printReverePair(arr, L, mid);
			printReverePair(arr, mid+1, R);
			merge(arr, L, R, mid);
		}
	}

	private static void merge(int[] arr, int l, int r, int mid) {
		int p1 = l;
		int p2 = mid+1;
		int[] help = new int[r-l+1];
		int i = 0;
		while(p1<=mid && p2<=r){
			if(arr[p1] > arr[p2]){
				for(int j = p2; j <= r; j++){
					res++;
					System.out.println("逆序对："+arr[p1]+"--"+arr[j]);
				}
			}
			help[i++] = arr[p1] > arr[p2] ? arr[p1++] : arr[p2++];
		}
		while(p1<=mid){
			help[i++] = arr[p1++];
		}
		while(p2<=r){
			help[i++] = arr[p2++];
		}
		for(i = 0; i<help.length; i++){
			arr[l+i] = help[i];
		}
	}
}
