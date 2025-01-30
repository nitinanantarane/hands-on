package com.nitin.quickstart.core.java.collection;

import java.util.Iterator;
import java.util.Random;

public class CoffeeGeneratorApp {

	public static void main(String[] args) {
		System.out.println("Generate coffee with default constructor >>>>>>");
		CoffeeGenerator coffeeGenerator = new CoffeeGenerator();
		for (int i = 0; i < 10; i++) {
			System.out.println(coffeeGenerator.next());
		}
		
		System.out.println("Generate coffee with iterator >>>>>>>>>>>>>>");
		for (Coffee coffee : new CoffeeGenerator(5)) {
			System.out.println(coffee);
		}
	}
	
	
}

class Coffee {
	private static int count;
	private final int id = count++;
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + "(" + id + ")";
	}
}

class Mocha extends Coffee {}
class Capachino extends Coffee {}
class Americano extends Coffee {}
class Brew extends Coffee {}
class Nesscafe extends Coffee {}
class Lipton extends Coffee {}

class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {
	
	@SuppressWarnings("rawtypes")
	private Class coffeeTypes[] = {Mocha.class, Americano.class, Brew.class, Nesscafe.class, Lipton.class,
			Capachino.class};
	private Random random = new Random(47);
	private int size;
	
	public CoffeeGenerator() {}
	
	public CoffeeGenerator(int size) {
		this.size = size;
	}
	
	
	@Override
	public Iterator<Coffee> iterator() {
		return new CoffeeIterator();
	}

	@Override
	public Coffee next() {
		Coffee coffee = null;
		try {
			coffee = (Coffee) coffeeTypes[random.nextInt(coffeeTypes.length)].newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return coffee;
	}
	
	class CoffeeIterator implements Iterator<Coffee> {
		
		int count = size;
		
		@Override
		public boolean hasNext() {
			return count > 0;
		}

		@Override
		public Coffee next() {
			count--;
			return CoffeeGenerator.this.next();
		}
		
	}
}

