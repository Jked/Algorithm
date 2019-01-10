package com.jk.chapter1;

import java.util.Arrays;

/**
 *@author JK
 *@date 2018��12��9�� ����7:01:50
 *@description
 *	ѡ������
 * ˼·��
 *	�������������ҵ�һ����С�������ڵ�һ��λ�ã��ٴӵڶ���λ�ÿ�ʼ��һ����С�������ڵڶ���λ�ã�
 *  �ٴӵ�����λ�ÿ�ʼ��һ����С�������ڵ�����λ�ã�������ȥ��������������
 *  
 * ʱ�临�Ӷ��ǣ�O(N^2)
 * ����ռ临�Ӷȣ�O(1)
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
			int minIndex = i; //��ÿ�ֱȽϳ�������С����������¼����
			for (int j = i; j < arr.length-1; j++) {
				minIndex = arr[j+1] < arr[minIndex] ? j+1 : minIndex;
			}
			swap(arr, i, minIndex);//����С���͵�ǰ��ͷ�ϵ��Ǹ�������
		}
	}

	private static void swap(int[] arr, int i, int minIndex) {
		int tem = arr[i];
		arr[i] = arr[minIndex];
		arr[minIndex] = tem;
	}

}