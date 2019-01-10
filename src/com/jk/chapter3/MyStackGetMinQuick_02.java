package com.jk.chapter3;

import java.util.Stack;

/**
 * @author jiankang
 * @date 2018年12月17日 下午3:52:11
 * @description
 * 		设计一个栈结构，并设计一个获取栈中最小值的方法，要求该方法的时间复杂度是：O(1)的
 * 	可以使用现有的栈结构来帮助实现。
 * 
 *  使用 java中Util中的Stack结构帮助实现。
 */
public class MyStackGetMinQuick_02 {
	//定义两个栈：一个数据栈，用来存储数据；一个最小值栈，来实时存储数据栈中的最小值；
	private Stack<Integer> stackData;
	private Stack<Integer> stackMins;
	
	public MyStackGetMinQuick_02(){
		stackData = new Stack<Integer>();
		stackMins = new Stack<Integer>();
	}
	
	//push方法
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

	//获取栈中最小值
	public int getMin() {
		return stackMins.peek();
	}
}
