package com.nitin.quickstart;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Timepass {

	public static void main(String[] args) {
		List<String> fruitList = new ArrayList<>();
		fruitList.add("Mango");
		fruitList.add("Apple");
		fruitList.add("Banana");
		fruitList.add("Pine Apple");
		fruitList.add("Chickoo");
		fruitList.add("Oranges");
		fruitList.add("Papaya");
		fruitList.add("Lemon");
		
		System.out.println("Array List >>>>>>>>>>>>>");
		
		for (int i = 0; i < 10; i++) {
			System.out.println(fruitList);
		}
		
		fruitList = new LinkedList<>(fruitList);
		
		System.out.println("Linked List >>>>>>>>>>>>>");
		for (int i = 0; i < 10; i++) {
			System.out.println(fruitList);
		}		
	}
}
