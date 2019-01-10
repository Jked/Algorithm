package com.jk.chapter2;

import java.util.Arrays;

/**
 *@author JK
 *@date 2018��12��9�� ����9:54:23
 *@description
 *	!!!!�����򡾺���Ҫ��
 *	1���ѽṹ��heapInsert��heapify
 *	2���ѽṹ������ͼ���
 *	3�����ֻ�ǽ����ѵĹ��̣�ʱ�临�Ӷ�ΪO(N)
 *	4�����ȼ����нṹ�����Ƕѽṹ
 *
 *	ʱ�临�Ӷȣ�
 *		O(N*logN)
 *	����ռ临�Ӷȣ�
 *		O(1)
 */
public class HeapSort_04 {

	public static void main(String[] args) {
		int[] arr = new int[] { 2, 33, 23, 15, 20, -5, 66, 7};
		System.out.println(Arrays.toString(arr));
		heapSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	//������
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

	//�����������ɴ����
	private static void heapInsert(int[] arr, int index) {
		while(arr[index] > arr[(index-1)/2]){
			swap(arr, index, (index-1)/2);
			index = (index-1) / 2;
		}
	}
	
	//����Ϊ������βԪ�ض����ҵ����飬���������ɴ����
	private static void heapify(int[] arr, int index, int heapSize) {
		int left = index*2 + 1;
		while(left < heapSize){
			int largest = (left+1) < heapSize && arr[left] < arr[left+1] ?  (left+1) : left;
			if(arr[largest] < arr[index]){ //�����Ԫ�ر�������Ԫ�ض���ֱ��break
				break;
			}
			swap(arr, index, largest); ////�����Ԫ��С������һ����Ԫ�أ�����������
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