package com.jk.chapter1;

import java.util.Arrays;

/**
 *@author JK
 *@date 2018��12��9�� ����7:17:28
 *@description
 *	С�����⣺
 *		����һ�����飬�����ң���ĳ������������б���С���������ͣ�������;ͳ�Ϊ������ С�͡�
 *  �������������е�����С����ӣ�������������С�͡�
 *  
 *˼·��С���������ʹ�ù鲢����������ʵ�֡�
 *	ʹ�ù鲢������ʵ��С�����⣬���԰���С�͵�˼·ת��һ�£����ǿ������һ�������Ҳ����б���������ĸ�����
 *	���������3�� �Ҳ������ĸ���Ϊn��������С�͵Ĺ����У������ᱻ����n�Σ�Ҳ����˵��3�����ϲ�����С��
 *	Ϊ��n*3
 *
 *	���������������ĸ������� ���� X ����� = �������ϲ�����С��
 *	�����������ϲ�����С����ӣ��������������С�͡�
 *
 *ΪʲôС���������ʹ�ù鲢����������ʵ�֣�
 *	�鲢�����ǰ�����ֳ����������֣�����Ҳಿ�ֵĵ�һ��������ಿ�ֵĵ�һ����(������3)��
 *	��ôֻ��Ҫ���Ҳಿ�ֵĸ��� * 3������3�������С���ˡ���Ϊ�Ҳ��Ѿ��ź����ˣ�����Ҳ��һ��������3��
 *	��˵�������Ҳಿ�ֶ���3��
 */
public class XiaoHe_05 {

	public static void main(String[] args) {
		int[] arr = new int[] {1, 2, 3, 4};
		int sum = getXiaoHe(arr, 0, arr.length-1);
		System.out.println("�������С��Ϊ��"+sum);
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
		int sum = 0; //�洢С��
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