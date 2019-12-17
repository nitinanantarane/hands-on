package com.nitin.quickstart.design.pattern.builder;

import java.util.ArrayList;
import java.util.List;

public class BuilderPatternDemo {

	public static void main(String[] args) {
		System.out.println("**********RANE Restaurant******");
		
		Meal vegMeal = MealBuilder.prepareVegMeal();
		vegMeal.showItems();
		vegMeal.totalCost();
		
		System.out.println("----------------------------------");
		
		Meal nonVegMeal = MealBuilder.prepareNonVegMeal();
		nonVegMeal.showItems();
		nonVegMeal.totalCost();
	}
}

class MealBuilder {
	
	static Meal prepareVegMeal() {
		Meal meal = new Meal();
		meal.add(new VegBurger());
		meal.add(new Coke());
		
		return meal;
	}
	
	static Meal prepareNonVegMeal() {
		Meal meal = new Meal();
		meal.add(new NonVegBurger());
		meal.add(new Pepsi());
		
		return meal;
	}
}

class Meal {
	List<Item> itemList = new ArrayList<>();
	
	void add(Item item) {
		itemList.add(item);
	}
	
	void showItems() {
		itemList.forEach(item -> {
			System.out.print("Name: " + item.name());
			System.out.print(", Price: " + item.price());
			System.out.println(", Packing: " + item.pack().pack());
		});
	}
	
	void totalCost() {
		System.out.println("Total: " + itemList.stream().map(i -> i.price())
				.reduce(0.0F, (a, b) -> a + b));
	}
}
interface Item {
	String name();
	Packing pack();
	float price();
}

interface Packing {
	String pack();
}

class Wrapper implements Packing {

	@Override
	public String pack() {
		return "Wrapper";
	}
}

class Bottle implements Packing {
	
	@Override
	public String pack() {
		return "Bottle";
	}
}

abstract class Burger implements Item {
	@Override
	public Packing pack() {
		return new Wrapper();
	}
}

class VegBurger extends Burger {

	@Override
	public String name() {
		return "Veg Burger";
	}

	@Override
	public float price() {
		return 5.25F;
	}
	
}

class NonVegBurger extends Burger {

	@Override
	public String name() {
		return "Non-veg burger";
	}

	@Override
	public float price() {
		return 10.50F;
	}
	
}

abstract class ColdDrinks implements Item {
	@Override
	public Packing pack() {
		return new Bottle();
	}
}

class Coke extends ColdDrinks {

	@Override
	public String name() {
		return "Coke";
	}

	@Override
	public float price() {
		return 12.50F;
	}
	
}

class Pepsi extends ColdDrinks {

	@Override
	public String name() {
		return "Pepsi";
	}

	@Override
	public float price() {
		return 10.25F;
	}
	
}