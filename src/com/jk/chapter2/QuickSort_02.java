package com.jk.chapter2;

import java.util.Arrays;

/**
 * @author JK
 * @date 2018��12��4�� ����9:18:47
 * @description 
 * 		�����������
 * 		�߼� �ͺ��������������ơ�
 * ƽ��ʱ�临�Ӷȣ�
 * 		O(N*logN)
 * ƽ������ռ临�Ӷȣ�
 * 		O(logN): ����ռ���������¼ ��������ÿ�ε� ���ֵ� ��
 */
public class QuickSort_02 {

	public static void main(String[] args) {
		int[] arr = new int[] { 2, 33, 23, 15, 20, -5, 66 };
		System.out.println(Arrays.toString(arr));
		quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	private static void quickSort(int[] arr, int L, int R) {
		if (L < R) {
			swap(arr, L+(int)(Math.random()*(R-L+1)), R);
			int[] p = partition(arr, L, R);
			quickSort(arr, L, p[0] - 1);
			quickSort(arr, p[1] + 1, R);
		}
	}

	private static int[] partition(int[] arr, int l, int r) {
		int less = l - 1;
		int more = r;
		while (l < more) {
			if (arr[l] < arr[r]) {
				swap(arr, ++less, l++);
			} else if (arr[l] > arr[r]) {
				swap(arr, --more, l);
			} else {
				l++;
			}
		}
		swap(arr, more, r);
		return new int[] { less + 1, more };
	}

	private static void swap(int[] arr, int l, int r) {
		int tem = arr[l];
		arr[l] = arr[r];
		arr[r] = tem;
	}

}