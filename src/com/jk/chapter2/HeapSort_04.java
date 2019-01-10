package com.jk.chapter2;

import java.util.Arrays;

/**
 *@author JK
 *@date 2018年12月9日 下午9:54:23
 *@description
 *	!!!!堆排序【很重要】
 *	1，堆结构的heapInsert与heapify
 *	2，堆结构的增大和减少
 *	3，如果只是建立堆的过程，时间复杂度为O(N)
 *	4，优先级队列结构，就是堆结构
 *
 *	时间复杂度：
 *		O(N*logN)
 *	额外空间复杂度：
 *		O(1)
 */
public class HeapSort_04 {

	public static void main(String[] args) {
		int[] arr = new int[] { 2, 33, 23, 15, 20, -5, 66, 7};
		System.out.println(Arrays.toString(arr));
		heapSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	//堆排序
	private static void heapSort(int[] arr) {
		if(arr.length < 2 || arr == null){
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			heapInsert(arr, i);
		}
		int heapSize = arr.length;
		swap(arr, 0, --heapSize);
		while(heapSize > 0){
			heapify(arr, 0, heapSize);
			swap(arr, 0, --heapSize);
		}
	}

	//将整个数组变成大根堆
	private static void heapInsert(int[] arr, int index) {
		while(arr[index] > arr[(index-1)/2]){
			swap(arr, index, (index-1)/2);
			index = (index-1) / 2;
		}
	}
	
	//把因为交换首尾元素而变乱的数组，重新整理成大根堆
	private static void heapify(int[] arr, int index, int heapSize) {
		int left = index*2 + 1;
		while(left < heapSize){
			int largest = (left+1) < heapSize && arr[left] < arr[left+1] ?  (left+1) : left;
			if(arr[largest] < arr[index]){ //如果根元素比两个子元素都大，直接break
				break;
			}
			swap(arr, index, largest); ////如果根元素小于其中一个子元素，交换两个数
			index = largest;
			left = index*2 + 1;
		}
	}
	
	private static void swap(int[] arr, int l, int r) {
		int tem = arr[l];
		arr[l] = arr[r];
		arr[r] = tem;
	}

}
