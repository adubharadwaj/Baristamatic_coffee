package com.sprc.app;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

// To describe the different drinks that can be made
public abstract class Recipe {

	private Map<String, Integer> recipe;
	public final String name;
	private double cost;
	private int sum = 0;

	protected Inventory inventory;

	public Recipe(String name, Inventory inventory) {
		this.inventory = inventory;
		this.name = name;
		recipe = new HashMap<String, Integer>();
		setRecipe();
		cost = (double) cost() / 100;
	}

	public double getCost() {
		return cost;
	}

	public void addIngredient(String ingredient, int qty) {
		recipe.put(ingredient, qty);
	}

	// Every new recipe has to specify the ingredients that will be using
	public abstract void setRecipe();

	public void dispenseCoffee() {
		System.err.println("Dispensing: " + name);
	}

	public void outOfStock() {
		System.err.println("Out of Stock: " + name);
	}

	// Returns the drink specified in the recipe or null if there are no enough
	// ingredients in the inventory
	public Drink makeDrink() {
		Drink drink;
		if (isInStock()) {
			drink = new Drink(name);
			recipe.entrySet().forEach(ingredient -> {
				IntStream.range(0, ingredient.getValue()).forEach(i -> inventory.get(ingredient.getKey()).addTo(drink));
			});

			dispenseCoffee();
			return drink;
		} else {
			outOfStock();
			return null;
		}
	}

	// Check the inventory whether the required ingredients are available to
	// make the drink
	public boolean isInStock() {

		return recipe.entrySet().stream().filter(entry -> {
			return inventory.enoughOf(entry.getKey(), entry.getValue());
		}).count() == recipe.entrySet().size();

	}

	// Computes the cost of the drink specified by the recipe
	public int cost() {

		recipe.entrySet().stream().forEach(i -> {
			sum = sum + (i.getValue() * inventory.getCost(i.getKey()));
		});

		return sum;
	}
}

class CoffeeRecipe extends Recipe {

	public CoffeeRecipe(Inventory inventory) {
		super("Coffee", inventory);
	}

	@Override
	public void setRecipe() {
		addIngredient("Coffee", 3);
		addIngredient("Sugar", 1);
		addIngredient("Cream", 1);
	}

}

class DecafCoffeeRecipe extends Recipe {

	public DecafCoffeeRecipe(Inventory inventory) {
		super("Decaf Coffee", inventory);
	}

	@Override
	public void setRecipe() {
		addIngredient("Decaf Coffee", 3);
		addIngredient("Sugar", 1);
		addIngredient("Cream", 1);
	}

}

class CaffeLatteRecipe extends Recipe {

	public CaffeLatteRecipe(Inventory inventory) {
		super("Caffe Latte", inventory);
	}

	@Override
	public void setRecipe() {
		addIngredient("Espresso", 2);
		addIngredient("Steamed Milk", 1);
	}

}

class CaffeAmericanoRecipe extends Recipe {

	public CaffeAmericanoRecipe(Inventory inventory) {
		super("Caffe Americano", inventory);
	}

	@Override
	public void setRecipe() {
		addIngredient("Espresso", 3);
	}

}

class CaffeMochaRecipe extends Recipe {

	public CaffeMochaRecipe(Inventory inventory) {
		super("Caffe Mocha", inventory);
	}

	@Override
	public void setRecipe() {
		addIngredient("Espresso", 1);
		addIngredient("Cocoa", 1);
		addIngredient("Steamed Milk", 1);
		addIngredient("Whipped Cream", 1);
	}

}

class CappuccinoRecipe extends Recipe {

	public CappuccinoRecipe(Inventory inventory) {
		super("Cappuccino", inventory);
	}

	@Override
	public void setRecipe() {
		addIngredient("Espresso", 2);
		addIngredient("Steamed Milk", 1);
		addIngredient("Foamed Milk", 1);
	}

}