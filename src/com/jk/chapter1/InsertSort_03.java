package com.jk.chapter1;

import java.util.Arrays;

/**
 *@author JK
 *@date 2018��12��9�� ����6:51:07
 *@description
 *��������
 *˼·��
 *	����һ�����飬�Ȱѵ�һ�����źã��ٰ�ǰ�������źã��ٰ�ǰ�������źã��ٰ�ǰ�ĸ����źá�����������ֱ�����������ź���
 *ʱ�临�Ӷȣ�
 *		O(N^2) : ��һ�ֹ�һ�������ڶ��ֹ��������������ֹ��������������ֹ��ĸ������������Ȳ��������
 *
 *����ռ临�Ӷȣ�O(1)
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