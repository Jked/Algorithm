package com.jk.chapter3;

import java.util.LinkedList;
import java.util.Queue;

/**
 *@author JK
 *@date 2018��12��28�� ����9:54:38
 *@description
 *	è���������⣺
 *		è �� �� �������У�д��������
 *			pollAll():è�͹������ϣ������������һֻ����
 *			pollDog():����������ӵĹ�
 *			pollCat():����������ӵ�è
 *
 *			isAllEmpty():���������Ƿ�Ϊ��
 *			isDogEmpty():�������Ƿ��й�
 *			isCatEmpty():�������Ƿ���è
 */
public class DogCatQueue_04 {

	//������
	public static class Pet {
		private String type;

		public Pet(String type) {
			this.type = type;
		}

		public String getPetType() {
			return this.type;
		}
	}

	//����
	public static class Dog extends Pet {
		public Dog() {
			super("dog");
		}
	}

	//è��
	public static class Cat extends Pet {
		public Cat() {
			super("cat");
		}
	}
	
	//�Զ���һ���࣬�����д洢�ľ����������
	public static class PetEnter{
		private Pet pet;
		long count = 0;
		
		public PetEnter(Pet pet, long count){
			this.pet = pet;
			this.count = count;
		}
		//�õ�����
		public Pet getPet(){
			return this.pet;
		}
		
		//�õ�ʱ���
		public long getCount(){
			return this.count;
		}
		
		//�õ���������
		public String getPetType(){
			return this.pet.getPetType();
		}
	}
	
	//è�����У�������
	public static class Dog_Cat_Queue {
		private Queue<PetEnter> dogQueue;
		private Queue<PetEnter> catQueue;
		private long count = 0;
		
		public Dog_Cat_Queue(){
			dogQueue = new LinkedList<>();
			catQueue = new LinkedList<>();
		}
		
		//push
		public void push(Pet pet){
			if(pet.getPetType() == "dog"){
				dogQueue.add(new PetEnter(pet, count++));
			}else if(pet.getPetType() == "cat"){
				catQueue.add(new PetEnter(pet, count++));
			}else{
				throw new RuntimeException("err, not dog or cat");
			}
		}
		
		//pollDog
		public Dog pollDog(){
			if(dogQueue.isEmpty()){
				throw new RuntimeException("Dog queue is empty!");
			}
			return (Dog) dogQueue.poll().getPet();
		}
		
		//pollCat
		public Cat pollCat(){
			if(catQueue.isEmpty()){
				throw new RuntimeException("Cat queue is empty!");
			}
			return (Cat) catQueue.poll().getPet();
		}
		
		//pollAll
		public Pet pollAll(){
			if(!catQueue.isEmpty() && !dogQueue.isEmpty()){
				return catQueue.peek().getCount() > dogQueue.peek().getCount() ? dogQueue.poll().getPet() : catQueue.poll().getPet();  
			}else if(!catQueue.isEmpty()){
				return catQueue.poll().getPet();  
			}else if(!dogQueue.isEmpty()){
				return dogQueue.poll().getPet();
			}
			throw new RuntimeException("the queue is empty!");
		}
		
		public boolean isDogEmpty(){
			return dogQueue.isEmpty();
		}
		
		public boolean isCatEmpty(){
			return catQueue.isEmpty();
		}
		
		public boolean isAllEmpty(){
			return (dogQueue.isEmpty() && catQueue.isEmpty());
		}
	}
	
	public static void main(String[] args) {
		Dog_Cat_Queue test = new Dog_Cat_Queue();

		Pet dog1 = new Dog();
		Pet cat1 = new Cat();
		Pet dog2 = new Dog();
		Pet cat2 = new Cat();
		Pet dog3 = new Dog();
		Pet cat3 = new Cat();

		test.push(dog1);
		test.push(cat1);
		test.push(dog2);
		test.push(cat2);
		test.push(dog3);
		test.push(cat3);
          
		test.push(dog1);
		test.push(cat1);
		test.push(dog2);
		test.push(cat2);
		test.push(dog3);
		test.push(cat3);
            
		test.push(dog1);
		test.push(cat1);
		test.push(dog2);
		test.push(cat2);
		test.push(dog3);
		test.push(cat3);
		while (!test.isDogEmpty()) {
			System.out.println(test.pollDog().getPetType());
		}
		while (!test.isAllEmpty()) {
			System.out.println(test.pollAll().getPetType());
		}		
	}

}
