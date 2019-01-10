package com.jk.chapter2;

import java.util.Arrays;

/**
 * @author JK
 * @date 2018��12��26�� ����7:36:41
 * @description 
 * 	����һ�����飬Ҫ���ȡ�����ź������������������ֵ �� ���١�
 *  Ҫ��ʱ�临�Ӷ�Ϊ O(N)���Ҳ����÷ǻ��ڱȽϵ�����
 * 
 *     ˼·�������÷ǻ��ڱȽϵ����򣬵��ǿ��Խ��� Ͱ���� ��˼��������
 */
public class MaxGap_06 {

	public static void main(String[] args) {
		int[] arr = new int[] { 2, 7, 9, 8, 6 };
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		int res = getMaxGap(arr);
		System.out.println("����ֵΪ:" + res);
	}

	private static int getMaxGap(int[] arr) {
		if (arr.length < 2) {
			return 0;
		}

		int len = arr.length;

		// ��ȡ�����е����ֵ �� ��Сֵ
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < len; i++) {
			max = Math.max(max, arr[i]);
			min = Math.min(min, arr[i]);
		}
		// ������ֵ����Сֵ��ȣ�˵�������д����һ��Ԫ�ء�
		if (min == max) {
			return 0;
		}

		// ��������Ͱ
		boolean hasNum[] = new boolean[len + 1]; // �ж�Ͱ����û����
		int[] maxs = new int[len + 1]; // ��¼Ͱ������ֵ
		int[] mins = new int[len + 1]; // ��¼Ͱ�е���Сֵ

		int bucketNo = 0;
		// ��������
		for (int i = 0; i < len; i++) {
			// �õ�arr[i]���Ԫ��Ӧ�÷��ڼ���Ͱ��
			bucketNo = bucketNo(arr[i], len, max, min);
			// ��ʼ������Ͱ���ֵ
			maxs[bucketNo] = hasNum[bucketNo] ? Math.max(arr[i], maxs[bucketNo]) : arr[i];
			mins[bucketNo] = hasNum[bucketNo] ? Math.min(arr[i], mins[bucketNo]) : arr[i];
			hasNum[bucketNo] = true;
		}

		// ��ʼ��������ֵ
		int res = 0;
		int lastMax = maxs[0];
		for (int i = 1; i < mins.length; i++) { //ֱ�Ӵ� i = 1 ��ʼ�жϣ�Ҳ����˵�ӵ�1��Ͱ��ʼ�жϣ���Ϊ��0��Ͱ��һ����ֵ��
			if (hasNum[i]) {  //����һ��Ҫ���жϣ��������Ͱ����ֵ���Ž�����������㣻 ������жϣ�����Ͱ����ʱ�����У���һ����С��-0���������
				res = Math.max(res, (mins[i] - lastMax));
				lastMax = maxs[i];
			}
		}
		return res;
	}

	// ͨ������ó��������е�Ԫ��Ӧ�÷��ڼ���Ͱ��
	private static int bucketNo(int num, int len, int max, int min) {
		return (int) (num - min) * len / (max - min);
	}

}