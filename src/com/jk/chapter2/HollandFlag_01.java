package com.jk.chapter2;

import java.util.Arrays;

/**
 *@author JK
 *@date 2018年12月2日 下午10:37:01
 *@description
 *	荷兰国旗问题
 *		给定一个数组和一个数num，把比num小的数组中的数放数组左边，比num大的放数组右边，等于num的放中间
 *	要求：
 *		时间复杂度: O(N)
 *		额外空间复杂度: O(1)
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
	 * 这里需要提到是：java中有8大基本类型，3大引用类型。
	 * 引用类型为： 类、接口、数组。
	 * 
	 * 数组new出来之后，是在堆内存中存在的，所有new出来的都在堆里面且有一个地址。
	 * 执行swap方法的过程是这样的：
	 * 		首先，swap方法被压进栈中，并给形参（局部变量）分配了内存空间，在调用swap方法时，第一个数组
	 * 类型的参数接收了一个arr，其实是一个地址，所以形参arr就指向了堆中的数组对象，所以改变形参中的arr元素位置，
	 * 就是改变调用swap方法的方法中的数组元素的位置。
	 */
	private static void swap(int[] arr, int i, int cur) {
		int tem = arr[i];
		arr[i] = arr[cur];
		arr[cur] = tem;
	}

}
