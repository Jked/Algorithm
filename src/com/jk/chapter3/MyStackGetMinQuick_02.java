package com.jk.chapter3;

import java.util.Stack;

/**
 * @author jiankang
 * @date 2018��12��17�� ����3:52:11
 * @description
 * 		���һ��ջ�ṹ�������һ����ȡջ����Сֵ�ķ�����Ҫ��÷�����ʱ�临�Ӷ��ǣ�O(1)��
 * 	����ʹ�����е�ջ�ṹ������ʵ�֡�
 * 
 *  ʹ�� java��Util�е�Stack�ṹ����ʵ�֡�
 */
public class MyStackGetMinQuick_02 {
	//��������ջ��һ������ջ�������洢���ݣ�һ����Сֵջ����ʵʱ�洢����ջ�е���Сֵ��
	private Stack<Integer> stackData;
	private Stack<Integer> stackMins;
	
	public MyStackGetMinQuick_02(){
		stackData = new Stack<Integer>();
		stackMins = new Stack<Integer>();
	}
	
	//push����
	public void push(int num){
		if(stackMins.isEmpty()){
			stackMins.push(num);
		}else if(num < this.getMin()){
			stackMins.push(num);
		}else{
			stackMins.push(stackMins.peek());
		}
		
		stackData.push(num);
	}

	//pop
	public Integer pop(){
		stackMins.pop();
		return stackData.pop();
	}

	//��ȡջ����Сֵ
	public int getMin() {
		return stackMins.peek();
	}
}