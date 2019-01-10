package com.jk.chapter1;

import java.util.Arrays;

/**
 *@author JK
 *@date 2018年12月9日 下午7:17:28
 *@description
 *	小和问题：
 *		对于一个数组，从左到右，把某个数的左侧所有比它小的数相加求和，则这个和就称为该数的 小和。
 *  把整个数组所有的数的小和相加，就是这个数组的小和。
 *  
 *思路：小和问题可以使用归并排序来快速实现。
 *	使用归并排序来实现小和问题，可以把求小和的思路转换一下，我们可以求出一个数的右侧所有比它大的数的个数。
 *	假设该数是3， 右侧比它大的个数为n，则在求小和的过程中，该数会被计算n次，也就是说从3这数上产生的小和
 *	为：n*3
 *
 *	求出所有数比它大的个数，用 个数 X 这个数 = 该数身上产生的小和
 *	把所有数身上产生的小和相加，就是整个数组的小和。
 *
 *为什么小和问题可以使用归并排序来快速实现？
 *	归并排序是把数组分成左右两部分，如果右侧部分的第一个数比左侧部分的第一个数(假设是3)大，
 *	那么只需要把右侧部分的个数 * 3，就是3这个数的小和了。因为右侧已经排好序了，如果右侧第一个数都比3大，
 *	则说明整个右侧部分都比3大。
 */
public class XiaoHe_05 {

	public static void main(String[] args) {
		int[] arr = new int[] {1, 2, 3, 4};
		int sum = getXiaoHe(arr, 0, arr.length-1);
		System.out.println("该数组的小和为："+sum);
	}

	private static int getXiaoHe(int[] arr, int L, int R) {
		if(L < R){
			int mid = L + (R - L >> 1);
			return getXiaoHe(arr, L, mid) + getXiaoHe(arr, mid+1, R) + merge(arr, L, R, mid);
		}
		return 0;
	}

	private static int merge(int[] arr, int l, int r, int mid) {
		int p1 = l;
		int p2 = mid+1;
		int[] help = new int[r-l+1];
		int i = 0;
		int sum = 0; //存储小和
		while(p1<=mid && p2<=r){
			if(arr[p1] < arr[p2])
				sum += arr[p1] * (r - p2 + 1);
			help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
		}
		while(p1 <= mid){
			help[i++] = arr[p1++];
		}
		while(p2 <= r){
			help[i++] = arr[p2++];
		}
		for(i=0; i<help.length; i++){
			arr[l+i] = help[i];
		}
		return sum;
	}

}
