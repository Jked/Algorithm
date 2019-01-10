package com.jk.chapter3;

/**
 * @author jiankang
 * @date 2018年12月29日 下午4:05:54
 * @description 
 */
public class ReverseList_07 {

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		printList(head); //打印		
		head = reverseList(head);//链表反转
		printList(head); //反转后打印
		
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

	//打印双向链表
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

	//打印单向链表
	private static void printList(Node head) {
		while(head != null){
			System.out.print(head.value+" ");
			head = head.next;
		}
		System.out.println();
	}

	//单向链表反转
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

	//双向链表反转
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

//单链表节点
class Node{
	public int value;
	public Node next;
	
	public Node(int data){
		this.value = data;
	}
}

//双向链表节点
class DoubleNode{
	public int value;
	public DoubleNode nextNode;
	public DoubleNode lastNode;
	
	public DoubleNode(int data){
		this.value = data;
	}
}