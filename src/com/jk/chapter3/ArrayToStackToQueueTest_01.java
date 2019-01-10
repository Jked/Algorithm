package com.jk.chapter3;
/**
 * @author jiankang
 * @date 2019年1月5日10:08:33
 * @description 
 * 		用数组实现 栈结构
 * 		用数组实现 队列结构
 */	

//用数组实现 栈结构
class ArrayToStack {
	private Integer[] arr;
	private Integer index;  //index表示新元素要放入的位置
	
	public ArrayToStack(int initSize){
		if(initSize < 0){
			throw new IllegalArgumentException("illegal initValue!");
		}
		arr = new Integer[initSize];
		index = 0; 
	}
	
	//栈的 pop 方法，取栈顶元素
	public Integer pop(){
		if(index == 0){
			throw new IndexOutOfBoundsException("the stack is empty!");
		}
		return arr[--index];
	}
	
	//栈的 push 方法，把元素压栈
	public void push(Integer num){
		if(index == arr.length){
			throw new IndexOutOfBoundsException("the stack is full!");
		}
		arr[index++] = num;
	}
	
	//peek方法， 获取到栈顶元素的值
	public Integer peek(){
		if(index == 0){
			throw new IndexOutOfBoundsException("the stack is empty!");
		}
		return arr[index-1];
	}
}

//=====================================================================


//用数组实现 队列结构
class ArrayToQueue {
	private Integer[] arr;
	private int put,get,size;
	
	public ArrayToQueue(int initSize){
		if(initSize < 0){
			throw new IllegalArgumentException("illegal initValue!");
		}
		arr = new Integer[initSize];
		put = 0;
		get = 0;
		size = 0;
	}
	
	//push方法， 将元素入队列
	public void push(int num){
		if(size == arr.length){
			throw new IndexOutOfBoundsException("the queue is full!");
		}
		arr[put] = num;
		put = (put+1 == arr.length) ? 0 : put+1; 
		size++;
	}
	
	//poll方法，取出队列头元素
	public Integer poll(){
		if(size == 0){
			throw new IndexOutOfBoundsException("the queue is empty!");
		}		
		int index = get;
		get = (get+1 == arr.length) ? 0 : get+1;
		size--;
		return arr[index];
	}
	
	//peek方法， 获得队列头元素的值
	public Integer peek(){
		if(size == 0){
			throw new IndexOutOfBoundsException("the queue is empty!");
		}
		return arr[get];
	}
	
}

//=====================================================================

public class ArrayToStackToQueueTest_01 {
	public static void main(String[] args) {
//		ArrayToStack stack = new ArrayToStack(3);
//		stack.push(5);
//		stack.push(7);
//		System.out.println(stack.peek());
//		System.out.println(stack.pop());
//		System.out.println(stack.peek());
//		System.out.println(stack.pop());
//		System.out.println(stack.peek());
		
		ArrayToQueue queue = new ArrayToQueue(3);
		queue.push(4);
		queue.push(5);
		queue.push(6);
		queue.peek();
		queue.poll();
		System.out.println(queue.poll());
	}
}
