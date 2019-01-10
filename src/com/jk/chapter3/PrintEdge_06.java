package com.jk.chapter3;
/**
 *@author JK
 *@date 2019年1月5日 下午10:59:08
 *@description
 *	90°打印正方形
 */
public class PrintEdge_06 {

	public static void main(String[] args) {
		int[][] arr = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		int lR = 0;
		int lC = 0;
		int rR = arr.length - 1;
		int rC = arr[0].length - 1;
		while(lR < rR/* && lC < rC*/){ //因为是旋转打印，所以只能是正方形，所以判断条件有一个就够了
			printEdge(arr, lR++, lC++, rR--, rC--);
		}
		printRotatedEdge(arr);
	}

	private static void printRotatedEdge(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}

	private static void printEdge(int[][] arr, int a, int b, int c, int d) {
		int tem = 0;
		int times = d - b;
		for (int i = 0; i != times; i++) {
			tem = arr[a][b+i];
			arr[a][b+i] = arr[c-i][b];
			arr[c-i][b] = arr[c][d-i];
			arr[c][d-i] = arr[a+i][d];
			arr[a+i][d] = tem;
		}
	}

}
