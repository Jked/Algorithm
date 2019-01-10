package com.jk.chapter3;

import java.util.LinkedList;
import java.util.Queue;

/**
 *@author JK
 *@date 2018年12月28日 下午9:54:38
 *@description
 *	猫狗队列问题：
 *		猫 和 狗 都进队列，写出方法：
 *			pollAll():猫和狗都算上，返回最早的那一只宠物
 *			pollDog():返回最早入队的狗
 *			pollCat():返回最早入队的猫
 *
 *			isAllEmpty():整个队列是否为空
 *			isDogEmpty():队列中是否还有狗
 *			isCatEmpty():队列中是否还有猫
 */
public class DogCatQueue_04 {

	//宠物类
	public static class Pet {
		private String type;

		public Pet(String type) {
			this.type = type;
		}

		public String getPetType() {
			return this.type;
		}
	}

	//狗类
	public static class Dog extends Pet {
		public Dog() {
			super("dog");
		}
	}

	//猫类
	public static class Cat extends Pet {
		public Cat() {
			super("cat");
		}
	}
	
	//自定义一个类，队列中存储的就是这个对象
	public static class PetEnter{
		private Pet pet;
		long count = 0;
		
		public PetEnter(Pet pet, long count){
			this.pet = pet;
			this.count = count;
		}
		//得到宠物
		public Pet getPet(){
			return this.pet;
		}
		
		//得到时间戳
		public long getCount(){
			return this.count;
		}
		
		//得到宠物类型
		public String getPetType(){
			return this.pet.getPetType();
		}
	}
	
	//猫狗队列！！！！
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

