package com.jk.chapter3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *@author JK
 *@date 2018年12月28日 下午8:33:43
 *@description
 *	（1）仅用队列实现栈
 *		思路：准备两个队列，一个data队列，一个help队列。
 *			数据永远只进data队列，当要返回时，我们把data队列的(n-1)个数 出队列 到 help队列，
 *			留下的那一个数 给用户返回；  然后，data队列 和  help队列 交换引用。
 *	（2）仅用栈实现队列
 *		思路：准备两个栈结构，一个 pushStack， 一个是 popStack；
 *			数据永远只放到 pushStack中， 当用户要poll数据时，我们把 pushStack中的数据先
 *			全部 压入 popStack中去。 然后再取 popStack的栈顶元素 ，就是用户想要的 元素。
 *		【注意】
 *			导数据的行为必须满足两点：
 *			 1) 如果要倒，pushStack中的数据 必须 一次性的倒完。
 *			 2) 如果popStack中有数据，此时，pushStack一定不能倒数据。否则会乱
 *
 */
public class StackAndQueueConvert_03 {
	public static void main(String[] args) {
		TwoStacksQueue queue = new TwoStacksQueue();
		queue.push(4);
		queue.push(3);
		System.out.println(queue.poll());
	}

}

//两个队列实现一个栈结构
class TwoQueueStack{
	//定义两个队列
	private Queue<Integer> data = null;
	private Queue<Integer> help = null;
	
	public TwoQueueStack(){
		data = new LinkedList<>();
		help = new LinkedList<>();
	}
	
	//压栈push
	//数据永远只放到data队列
	public void push(int num){
		data.add(num);
	}
	
	//取栈顶元素pop
	public int pop(){
		if(data.isEmpty()){
			throw new IndexOutOfBoundsException("栈为空");
		}
		//data队列中只留一个数，其余全部出队列到help队列中
		while(data.size() > 1){
			help.add(data.poll());
		}
		int res = data.poll();
		swap();
		return res;
	}
	
	//取栈顶元素：peek
	public int peek(){
		if(data.isEmpty()){
			throw new IndexOutOfBoundsException("栈为空");
		}
		while(data.size() > 1){
			help.add(data.poll());
		}
		int res = data.peek();
		help.add(res);  //把data最后留的那一个再add到 help队列中去，再交换引用。
		swap();
		return res;
	}

	//交换 data 和 help 的引用
	private void swap() {
		Queue<Integer> tem = data;
		data = help;
		help = tem;				
	}
}

//两个栈实现队列结构
class TwoStacksQueue {
	private Stack<Integer> pushStack = null;
	private Stack<Integer> popStack = null;;
	
	public TwoStacksQueue(){
		pushStack = new Stack<>();
		popStack = new Stack<>();
	}
	
	//push()
	public void push(int num){
		pushStack.push(num);
		dao();
	}

	//peek()
	public int peek(){
		if(popStack.isEmpty() && pushStack.isEmpty()){
			throw new IndexOutOfBoundsException("队列为空");
		}
		dao();
		return popStack.pop();
	}
	
	//poll
	public int poll(){
		if(popStack.isEmpty() && pushStack.isEmpty()){
			throw new IndexOutOfBoundsException("队列为空");
		}
		dao();
		return popStack.peek();
	}	
	
	//倒数据行为
	private void dao() {
		//条件一: 如果popStack不为空，则不能倒
		if(!popStack.isEmpty()){
			return;
		}
		
		//条件二: 如果pushStack要倒，则必须一次倒光！
		while(!pushStack.isEmpty()){
			popStack.push(pushStack.pop());
		}
	}
}
