package mypack;

import java.util.Scanner;
import java.util.HashSet;

public class AnimalObserverChallenge {
	public static void main(String[] args) {
		Scanner scanner;
		HashSet<Animal> animals;
		String animalName;
		String animalType;
		char canFly = 0;
		
		scanner = new Scanner(System.in);
		animals = new HashSet<>();
		
		System.out.print("enter the name of the animal >> ");
		animalName = scanner.next().trim();
		scanner.nextLine();
		System.out.println();
		System.out.println("Animal Types\nType 1: General animal\nType 2: Bird\nType 3: Penguin");
		System.out.print("enter the type (number) of an animal >> ");
		int input = scanner.nextInt();
		if(input == 1) {
			animalType = "animal";
		}else if(input == 2) {
			animalType = "bird";
		}else{
			animalType = "penguin";
		}
		System.out.println();
		if(animalType.equalsIgnoreCase("bird")) {
			System.out.print("can it fly (yes or no)? ");
			canFly = scanner.next().trim().toLowerCase().charAt(0);
			scanner.nextLine();
			System.out.println();
			switch(canFly) {
				case 'n':
					Bird bird = new Bird(animalName,false);
					bird.setType(animalType);
					animals.add(bird);
					Zookeeper.greetAnimal();
					bird.speak();
					break;
				case 'y':
					bird = new Bird(animalName,true);
					bird.setType(animalType);
					animals.add(bird);
					Zookeeper.greetAnimal();
					bird.speak();
					break;
			}
		}else if(animalType.equalsIgnoreCase("penguin")) {
			Penguin penguin = new Penguin(animalName);
			penguin.setType(animalType);
			animals.add(penguin);
			Zookeeper.greetAnimal("Penguin!");
			penguin.speak();
		}else {
			Animal animal = new Animal(animalName);
			animals.add(animal);
			Zookeeper.greetAnimal("Animal!");
			animal.speak();
		}
		
		for(Animal animal : animals) {
			if(animal.getType().equalsIgnoreCase("bird")) {
				switch(canFly){
					case 'y':
						Bird bird = Bird.parseBird(animal);
						bird.setCanFly(true);
						bird.walk();
						break;
					case 'n':
						Bird.parseBird(animal).walk();
						break;
				}
			}
			if(animal.getType().equalsIgnoreCase("penguin")) {
				Penguin.parsePenguin(animal).walk();
			}
			System.out.println(animal);
		}
		scanner.close();
	}
}


class Animal{
	private String type = "ANIMAL";
	private String name;
	
	public Animal(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public String getType() {return type;}
	public void setType(String type){
		this.type = type;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void speak() {
		System.out.println("animal speaking!");
	}
	public boolean equals(Animal animal) {
		return this.name.equals(animal.getName());
	}
	public String toString() {
		return this.getName();
	}
}


class Bird extends Animal implements Walkable{
	private String name;
	private boolean canFly;
	
	public Bird(String name, boolean canFly) {
		super(name);
		this.canFly = canFly;
		this.name = name;
	}
	
	public void printName() {
		System.out.println("parent name: "+super.getName()+" child name: "+this.name);
	}
	public void walk() {
		System.out.println("Bird walking!");
	}
	public void speak() {
		System.out.println("Bird speaking!");
	}
	public static Bird parseBird(Animal bird) {
		return new Bird(bird.getName(),false);
	}
	public boolean getCanFly() {
		return canFly;
	}
	public void setCanFly(boolean canFly) {
		this.canFly = canFly;
	}
	public String toString() {
		return String.format("name : %s\ncan fly: %b",name,canFly);
	}
	
}


class Penguin extends Animal implements Walkable{
	public Penguin(String name) {
		super(name);
	}
	public void walk() {
		System.out.println("Penguin walking!");
	}
	public void speak() {
		System.out.println("Penguin speaking!");
	}
	public static Penguin parsePenguin(Animal penguin) {
		return new Penguin(penguin.getName());
	}
	public String toString() {
		return String.format("Penguin name: %s",getName());
	}
}


class Zookeeper {
	static public void greetAnimal() {
		System.out.println("Hello Bird!");
	}
	static public void greetAnimal(String animal) {
		System.out.println("Hello "+animal);
	}
}


interface Walkable {
	void walk();
}