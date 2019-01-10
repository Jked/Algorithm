package com.jk.chapter3;

/**
 * @author JK
 * @date 2018年12月29日 上午6:40:41
 * @description 旋转打印 矩阵
 * 	思路：用宏观思想；
 * 		给定一个左上角坐标和右下角坐标，能确定下来一个框； 打印这个框，按照 先右，再下，再左，再上的顺序；
 * 		每次打印完框之后，把左上角的坐标向右下角移动一位，右下角的数朝左上角移动一位；然后再打印新坐标确定下来的这个框；
 * 		这样依次打印下去...
 */
public class RotaryPrinting_05 {

	public static void main(String[] args) {
		int[][] arr = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		printInRotary(arr);
	}

	//传一个 二维数组 ，旋转打印
	public static void printInRotary(int[][] arr) {
		int tR = 0;
		int tC = 0;
		int dR = arr.length - 1;	
		int dC = arr[0].length - 1;
		while (tR <= dR && tC <= dC) {
			printEdge(arr, tR++, tC++, dR--, dC--);// 这是打印框的方法
		}
	}

	//给定左上角和右下角坐标，打印构成的矩阵的 框
	private static void printEdge(int[][] arr, int tR, int tC, int dR, int dC) {
		if(tR == dR){
			while(tC <= dC){
				System.out.println(arr[tR][tC++]+"");
			}
		}else if(tC == dC){
			while(tR <= dR){
				System.out.println(arr[tR++][tC]+"");
			}
		}else{
			int curR = tR;
			int curC = tC;
			while(curC < dC){
				System.out.println(arr[tR][curC++]+"");
			}
			while(curR < dR){
				System.out.println(arr[curR++][dC]+"");
			}
			while(curC > tC){
				System.out.println(arr[dR][curC--]+"");
			}
			while(curR > tR){
				System.out.println(arr[curR--][tC]+"");
			}
		}
	}
}
