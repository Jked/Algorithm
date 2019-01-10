package com.jk.chapter3;

/**
 * @author jiankang
 * @date 2018��12��29�� ����4:05:54
 * @description 
 */
public class ReverseList_07 {

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		printList(head); //��ӡ		
		head = reverseList(head);//������ת
		printList(head); //��ת���ӡ
		
		System.out.println("=======================");
		
		DoubleNode header = new DoubleNode(1);
		header.nextNode = new DoubleNode(2);
		header.nextNode.lastNode = header;
		header.nextNode.nextNode = new DoubleNode(3);
		header.nextNode.nextNode.lastNode = header.nextNode;
		header.nextNode.nextNode.nextNode = new DoubleNode(4);
		header.nextNode.nextNode.nextNode.lastNode = header.nextNode.nextNode;
		printDoubleList(header);              
		header = reverseDoubleList(header);
		printDoubleList(header);
	}

	//��ӡ˫������
	private static void printDoubleList(DoubleNode header) {
		DoubleNode end = null;
		while( header != null){
			System.out.print(header.value+" ");
			end = header;
			header = header.nextNode;
		}
		System.out.print(" | ");
		while( end != null){
			System.out.print(end.value+" ");
			end = end.lastNode;
		}
		System.out.println();
	}

	//��ӡ��������
	private static void printList(Node head) {
		while(head != null){
			System.out.print(head.value+" ");
			head = head.next;
		}
		System.out.println();
	}

	//����������ת
	private static Node reverseList(Node head) {
		Node pre = null;
		Node next = null;
		while(head != null){
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}	

	//˫��������ת
	private static DoubleNode reverseDoubleList(DoubleNode header) {
		DoubleNode pre = null;
		DoubleNode next = null;
		while(header != null){
			next = header.nextNode;
			header.nextNode = pre;
			header.lastNode = next;
			pre = header;
			header = next;
		}
		return pre;
	}
}

//�������ڵ�
class Node{
	public int value;
	public Node next;
	
	public Node(int data){
		this.value = data;
	}
}

//˫�������ڵ�
class DoubleNode{
	public int value;
	public DoubleNode nextNode;
	public DoubleNode lastNode;
	
	public DoubleNode(int data){
		this.value = data;
	}
}