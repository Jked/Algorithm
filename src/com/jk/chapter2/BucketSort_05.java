package com.jk.chapter2;

import java.util.Arrays;

/**
 *@author JK
 *@date 2018��12��25�� ����10:19:40
 *@description
 *	��ϰ Ͱ���� ����һ������(A)�����ø������±���������ʾ Ŀ�������е�Ԫ�أ�
 *		������Ӧ��Ԫ�ؾ���Ŀ��Ԫ�س���  �Ը����� Ϊ��С��ֵ   ���ֵĴ�����
 *		�������A���� Ͱ��
 *		�������� �� ��0��ʼ�ģ� ����Ͱ����ֻ�ʺ������� 0�������� ������
 *
 *	ʱ�临�Ӷ��ǣ�O(N) :��ΪֻҪ��һ��Ŀ������ ���ɡ�
 *	����ռ临�Ӷȣ�O(N)	����ΪҪ���ⴴ��һ�� �������顣
 */
public class BucketSort_05 {

	public static void main(String[] args) {
		int[] arr = new int[] { 2, 33, 23, 15, 20, 66, 7};
		System.out.println(Arrays.toString(arr));
		bucketSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	//Ͱ����
	private static void bucketSort(int[] arr) {
		//�ҵ������е����ֵ
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			max = Math.max(arr[i], max);
		}
		
		//����������ֵ�� ����һ��Ͱ ������Ϊ �����ֵ+1
		int[] bucket = new int[max+1];
		//��Ͱ���ֵ��Ͱ���������� Ŀ�������Ԫ��ֵ
		for (int i = 0; i < arr.length; i++) {
			bucket[arr[i]]++;
		}
		
		//��ʼ���򣬰��ո���������������˳�򣬸���������Ӧ�洢��ֵ �� ԭ���� �зš�
		int i = 0;
		for (int j = 0; j < bucket.length; j++) {
			while(bucket[j]-- > 0){
				arr[i++] = j;
			}
		}
	}

}