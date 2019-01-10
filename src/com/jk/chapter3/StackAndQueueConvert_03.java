package com.jk.chapter3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *@author JK
 *@date 2018��12��28�� ����8:33:43
 *@description
 *	��1�����ö���ʵ��ջ
 *		˼·��׼���������У�һ��data���У�һ��help���С�
 *			������Զֻ��data���У���Ҫ����ʱ�����ǰ�data���е�(n-1)���� ������ �� help���У�
 *			���µ���һ���� ���û����أ�  Ȼ��data���� ��  help���� �������á�
 *	��2������ջʵ�ֶ���
 *		˼·��׼������ջ�ṹ��һ�� pushStack�� һ���� popStack��
 *			������Զֻ�ŵ� pushStack�У� ���û�Ҫpoll����ʱ�����ǰ� pushStack�е�������
 *			ȫ�� ѹ�� popStack��ȥ�� Ȼ����ȡ popStack��ջ��Ԫ�� �������û���Ҫ�� Ԫ�ء�
 *		��ע�⡿
 *			�����ݵ���Ϊ�����������㣺
 *			 1) ���Ҫ����pushStack�е����� ���� һ���Եĵ��ꡣ
 *			 2) ���popStack�������ݣ���ʱ��pushStackһ�����ܵ����ݡ��������
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

//��������ʵ��һ��ջ�ṹ
class TwoQueueStack{
	//������������
	private Queue<Integer> data = null;
	private Queue<Integer> help = null;
	
	public TwoQueueStack(){
		data = new LinkedList<>();
		help = new LinkedList<>();
	}
	
	//ѹջpush
	//������Զֻ�ŵ�data����
	public void push(int num){
		data.add(num);
	}
	
	//ȡջ��Ԫ��pop
	public int pop(){
		if(data.isEmpty()){
			throw new IndexOutOfBoundsException("ջΪ��");
		}
		//data������ֻ��һ����������ȫ�������е�help������
		while(data.size() > 1){
			help.add(data.poll());
		}
		int res = data.poll();
		swap();
		return res;
	}
	
	//ȡջ��Ԫ�أ�peek
	public int peek(){
		if(data.isEmpty()){
			throw new IndexOutOfBoundsException("ջΪ��");
		}
		while(data.size() > 1){
			help.add(data.poll());
		}
		int res = data.peek();
		help.add(res);  //��data���������һ����add�� help������ȥ���ٽ������á�
		swap();
		return res;
	}

	//���� data �� help ������
	private void swap() {
		Queue<Integer> tem = data;
		data = help;
		help = tem;				
	}
}

//����ջʵ�ֶ��нṹ
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
			throw new IndexOutOfBoundsException("����Ϊ��");
		}
		dao();
		return popStack.pop();
	}
	
	//poll
	public int poll(){
		if(popStack.isEmpty() && pushStack.isEmpty()){
			throw new IndexOutOfBoundsException("����Ϊ��");
		}
		dao();
		return popStack.peek();
	}	
	
	//��������Ϊ
	private void dao() {
		//����һ: ���popStack��Ϊ�գ����ܵ�
		if(!popStack.isEmpty()){
			return;
		}
		
		//������: ���pushStackҪ���������һ�ε��⣡
		while(!pushStack.isEmpty()){
			popStack.push(pushStack.pop());
		}
	}
}