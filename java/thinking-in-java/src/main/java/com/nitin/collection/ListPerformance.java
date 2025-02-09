package com.nitin.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListPerformance {

	public static void main(String[] args) {
		List<Integer> arrayList = new ArrayList<>();
		List<Integer> linkedList = new LinkedList<>();
		
		long arrayListAdd = add(arrayList);
		long linkedListAdd = add(linkedList);
		System.out.println("ArrayList add: " + arrayListAdd);
		System.out.println("LinkedList add: " + linkedListAdd);
		assert linkedListAdd < arrayListAdd;
		
		long arrayListGet = get(arrayList);
		long linkedListGet = get(linkedList);
		System.out.println("Arraylist get: " + arrayListGet);
		System.out.println("LinkedList get: " + linkedListGet);
		assert arrayListGet < linkedListGet;
		
		long arrayListRemove = remove(arrayList);
		long linkedListRemove = remove(linkedList);
		System.out.println("Arraylist remove: " + arrayListRemove);
		System.out.println("LinkedList remove: " + linkedListRemove);
		assert linkedListRemove < arrayListRemove;
	}

	private static long remove(List<Integer> list) {
		long startTime = System.nanoTime();
		for (int i = 99999 ; i >=0; i--) {
			list.remove(i);
		}
		long endTime = System.nanoTime();
		long duration = endTime - startTime;
		return duration;
	}

	private static long get(List<Integer> list) {
		long startTime = System.nanoTime();
		for (int i = 0 ; i < 100000; i++) {
			list.get(i);
		}
		long endTime = System.nanoTime();
		long duration = endTime - startTime;
		return duration;
	}

	private static long add(List<Integer> list) {
		long startTime = System.nanoTime();		
		for (int i = 0 ; i < 100000; i++) {
			list.add(i);
		}
		long endTime = System.nanoTime();
		long duration = endTime - startTime;
		return duration;
	}
}
