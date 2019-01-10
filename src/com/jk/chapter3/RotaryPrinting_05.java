package com.jk.chapter3;

/**
 * @author JK
 * @date 2018��12��29�� ����6:40:41
 * @description ��ת��ӡ ����
 * 	˼·���ú��˼�룻
 * 		����һ�����Ͻ���������½����꣬��ȷ������һ���� ��ӡ����򣬰��� ���ң����£��������ϵ�˳��
 * 		ÿ�δ�ӡ���֮�󣬰����Ͻǵ����������½��ƶ�һλ�����½ǵ��������Ͻ��ƶ�һλ��Ȼ���ٴ�ӡ������ȷ�������������
 * 		�������δ�ӡ��ȥ...
 */
public class RotaryPrinting_05 {

	public static void main(String[] args) {
		int[][] arr = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		printInRotary(arr);
	}

	//��һ�� ��ά���� ����ת��ӡ
	public static void printInRotary(int[][] arr) {
		int tR = 0;
		int tC = 0;
		int dR = arr.length - 1;	
		int dC = arr[0].length - 1;
		while (tR <= dR && tC <= dC) {
			printEdge(arr, tR++, tC++, dR--, dC--);// ���Ǵ�ӡ��ķ���
		}
	}

	//�������ϽǺ����½����꣬��ӡ���ɵľ���� ��
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