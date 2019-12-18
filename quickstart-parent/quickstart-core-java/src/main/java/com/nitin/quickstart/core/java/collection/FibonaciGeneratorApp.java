package com.nitin.quickstart.core.java.collection;

import java.util.Iterator;

public class FibonaciGeneratorApp {
	public static void main(String[] args) {
		FibonaciGenerator fibonacciGenerator = new FibonaciGenerator();
		for (int i = 0; i < 10; i++) {
			System.out.println(fibonacciGenerator.next());
		}
		
		for (Integer n : new IterableFibonaci(18)) {
			System.out.println(n);
		}
	}
}

class FibonaciGenerator implements Generator<Integer> {

	private int count = 0;
	
	@Override
	public Integer next() {
		return fib(count++);
	}
	
	private int fib(int n) {
		if (n < 2) return 1;
		
		return fib(n-2) + fib(n-1);
	}
	
}

class IterableFibonaci extends FibonaciGenerator implements Iterable<Integer> {

	private int size;
	
	public IterableFibonaci(int size) {
		this.size = size;
	}

	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {

			@Override
			public boolean hasNext() {
				return size > 0;
			}

			@Override
			public Integer next() {
				size--;
				return IterableFibonaci.this.next();
			}
		};
	}
	
}
