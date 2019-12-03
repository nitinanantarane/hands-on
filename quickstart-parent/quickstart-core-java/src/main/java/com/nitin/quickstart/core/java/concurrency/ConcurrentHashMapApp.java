package com.nitin.quickstart.core.java.concurrency;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapApp {

	public static void main(String[] args) {
		Map<String, String> concurrentMap = new ConcurrentHashMap<>();
		concurrentMap.put("1" , "1");
		concurrentMap.put("2" , "2");
		concurrentMap.put("3" , "3");
		concurrentMap.put("4" , "4");
		concurrentMap.put("5" , "5");
		concurrentMap.put("6" , "6");
		concurrentMap.put("7" , "7");
		
		System.out.println("Before mod concurrentMap => " + concurrentMap);
		Iterator<String> iterator = concurrentMap.keySet().iterator();
		
		while(iterator.hasNext()) {
			String key = iterator.next();
			
			if("3".equalsIgnoreCase(key)) {
				concurrentMap.put(key + "new", "new");
			}
			
		}
		
		System.out.println("After mod concurrentMap => " + concurrentMap);
		
		Map<String, String> simpleMap = new HashMap<>();
		simpleMap.put("1" , "1");
		simpleMap.put("2" , "2");
		simpleMap.put("3" , "3");
		simpleMap.put("4" , "4");
		simpleMap.put("5" , "5");
		simpleMap.put("6" , "6");
		simpleMap.put("7" , "7");
		
		System.out.println("Before mod => " + simpleMap);
		Iterator<String> iterator1 = simpleMap.keySet().iterator();
		while(iterator1.hasNext()) {
			String key = iterator1.next();
			
			if("3".equalsIgnoreCase(key)) {
				simpleMap.put(key + "new", "new");
				// if dont want to use the concurrent hashmap
				 break; 
			}
		}
		System.out.println("After mod => " + simpleMap);
		
		
		Map<String, String> simpleMap2 = new HashMap<>();
		simpleMap2.put("1" , "1");
		simpleMap2.put("2" , "2");
		simpleMap2.put("3" , "3");
		simpleMap2.put("4" , "4");
		simpleMap2.put("5" , "5");
		simpleMap2.put("6" , "6");
		simpleMap2.put("7" , "7");
		
		System.out.println("Before mod simpleMap2 => " + simpleMap2);
		Iterator<String> iterator2 = simpleMap.keySet().iterator();
		while(iterator2.hasNext()) {
			String key = iterator2.next();
			
			if("3".equalsIgnoreCase(key)) {
				simpleMap2.put(key, "new");
			}
		}
		System.out.println("After mod simpleMap2 => " + simpleMap2);
	}
	
}
