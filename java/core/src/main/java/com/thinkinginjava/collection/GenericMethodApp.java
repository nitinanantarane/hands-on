package com.thinkinginjava.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class GenericMethodApp {

	public static void main(String[] args) {
		GenericMethodApp genericMethodApp = new GenericMethodApp();
		printClass("");
		printClass('C');
		printClass(1);
		printClass(2L);
		printClass(1.0);
		printClass(0.0F);
		printClass(genericMethodApp);
		
		Map<String, String> map = map();
		List<Integer> list = list();
		
		printClass(map);
		printClass(list);
		printClass(map());
		printClass(set());
		printClass(queue());
		printClass(lList());
		
		System.out.println(makeList('C'));
		System.out.println(makeList("ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("")));
		
	}
	
	static <T> void printClass(T t) {
		System.out.println(t.getClass().getName());
	}
	
	static <K, V> Map<K, V> map() {
		return new HashMap<K, V>();
	}
	
	static <E> List<E> list() {
		return new ArrayList<E>();
	}
	
	static <E> LinkedList<E> lList() {
		return new LinkedList<E>();
	}
	
	static <E> Set<E> set() {
		return new HashSet<E>();
	}
	
	static <E> Queue<E> queue() {
		return new LinkedList<E>();
	}
	
	@SafeVarargs
	static <T> List<T> makeList(T...varargs) {
		List<T> list = new ArrayList<>();
		for(T t : varargs) {
			list.add(t);
		}
		
		return list;
	}
}
