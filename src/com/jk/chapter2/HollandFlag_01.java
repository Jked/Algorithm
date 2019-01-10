package com.jk.chapter2;

import java.util.Arrays;

/**
 *@author JK
 *@date 2018��12��2�� ����10:37:01
 *@description
 *	������������
 *		����һ�������һ����num���ѱ�numС�������е�����������ߣ���num��ķ������ұߣ�����num�ķ��м�
 *	Ҫ��
 *		ʱ�临�Ӷ�: O(N)
 *		����ռ临�Ӷ�: O(1)
 */
public class HollandFlag_01 {

	public static void main(String[] args) {
		int[] arr = new int[]{2,33,23,15,20,-5,66};
		System.out.println(Arrays.toString(arr));
		getHollandFlagShape(arr,0,arr.length-1,20);
		System.out.println(Arrays.toString(arr));		
	}

	private static void getHollandFlagShape(int[] arr, int l, int r, int num) {
		int cur = l;
		int less = l-1;
		int more = r+1;
		while(cur < more){
			if(arr[cur] < num) {
				swap(arr, ++less, cur++);
			}else if(arr[cur] > num){
				swap(arr, --more, cur);
			}else{
				cur++;
			}
		}
	}

	/**
	 * ������Ҫ�ᵽ�ǣ�java����8��������ͣ�3���������͡�
	 * ��������Ϊ�� �ࡢ�ӿڡ����顣
	 * 
	 * ����new����֮�����ڶ��ڴ��д��ڵģ�����new�����Ķ��ڶ���������һ����ַ��
	 * ִ��swap�����Ĺ����������ģ�
	 * 		���ȣ�swap������ѹ��ջ�У������βΣ��ֲ��������������ڴ�ռ䣬�ڵ���swap����ʱ����һ������
	 * ���͵Ĳ���������һ��arr����ʵ��һ����ַ�������β�arr��ָ���˶��е�����������Ըı��β��е�arrԪ��λ�ã�
	 * ���Ǹı����swap�����ķ����е�����Ԫ�ص�λ�á�
	 */
	private static void swap(int[] arr, int i, int cur) {
		int tem = arr[i];
		arr[i] = arr[cur];
		arr[cur] = tem;
	}

}