package com.thinkinginjava.collection;

public class BasicGeneratorApp {

	public static void main(String[] args) {
		Generator<Counter> generator = BasicGenerator.create(Counter.class);
		
		for (int i = 0; i < 10; i++) {
			System.out.println(generator.next());
		}
	}
	
	
}

class BasicGenerator<T> implements Generator<T> {
	
	private Class<T> type;
	
	BasicGenerator(Class<T> type) {
		this.type = type;
	}

	@Override
	public T next() {
		T result = null;
		try {
			result = type.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	static <T> Generator<T> create(Class<T> type) {
		return new BasicGenerator<T>(type);
	}
}

class Counter {
	private static int count;
	private final int id = count++;
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + " " + id;
	}
}
