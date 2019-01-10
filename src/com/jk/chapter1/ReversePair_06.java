package com.jk.chapter1;

import java.util.Arrays;

/**
 *@author JK
 *@date 2018��12��26�� ����8:50:36
 *@description
 *	�ʣ���һ�������У������ߵ��������ұߵ������������������һ�� ����ԣ����ӡһ�����������Ե� ����ԣ�
 *	��
 *		���ù鲢�����˼�룬�ɴ�С������������һ����A���� �ұ������ĳһ����B���������A ���� �ұ������B��ʼ
 *	���ҵ���������
 *
 */
public class ReversePair_06 {

	static int res = 0;
	
	public static void main(String[] args) {
		int[] arr = new int[] { 2, 33, 23, 15, 20, 66, 7};
		printReverePair(arr, 0, arr.length-1);
		System.out.println("�����鹲��"+res+"�������");
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
					System.out.println("����ԣ�"+arr[p1]+"--"+arr[j]);
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