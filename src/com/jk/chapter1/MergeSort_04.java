package com.jk.chapter1;

import java.util.Arrays;

/**
 * @author JK
 * @date 2018��12��9�� ����5:04:46
 * @description 
 * 		�鲢���� ��һ������ֳ����ݣ�����źã��ұ��źã��ٰ���������ͳһ�ź�
 * 		�鲢����ʱ�亯��
 * 			T(N) = 2T(N/2) + O(N)
 * 		��master��ʽ��
 * 			�鲢�����ʱ�临�Ӷ��ǣ�O(N*logN)
 * 
 * 		����ռ临�Ӷȣ�O(N) �� �������õ��˸�������help[]
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
		while(p1 <= mid && p2 <= r){//****ע��������  <= ����!!!
			help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
		}
		while(p1 <= mid){
			help[i++] = arr[p1++];
		}
		while(p2 <= r){
			help[i++] = arr[p2++];
		}
		for (i = 0; i < help.length; i++) {
			arr[l + i] = help[i]; //****ע�������� arr[l + i]
		}
	}

}