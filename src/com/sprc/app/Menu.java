package com.sprc.app;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

// To store the different available recipes
public class Menu {
	
	private Map<String, Recipe> recipes;

	public Menu(Inventory inventory) {
		recipes = new TreeMap<String, Recipe>();
		addRecipe(new DecafCoffeeRecipe(inventory));
		addRecipe(new CaffeAmericanoRecipe(inventory));
		addRecipe(new CaffeLatteRecipe(inventory));
		addRecipe(new CaffeMochaRecipe(inventory));
		addRecipe(new CappuccinoRecipe(inventory));
		addRecipe(new CoffeeRecipe(inventory));
	}
	
	// Add a new recipe to the menu
	public void addRecipe(Recipe recipe) {
		if (recipes.containsKey(recipe.name)) {
			throw new RuntimeException();
		}
		else {
			recipes.put(recipe.name, recipe);
		}
	}
	
	// Display the menu items
	public void display() {
		System.out.println("Menu:");
		int i = 0;
		for (Entry<String, Recipe> recipe : recipes.entrySet()) {
			String price = String.format("%.2f", recipe.getValue().getCost());
			System.out.println( (i + 1 ) + "," + recipe.getKey() + "," + "$" + price + "," + recipe.getValue().isInStock() );
			i++;
		}
	}
	
	// Returns a new drink
	public Drink makeDrink(int index) {
		if (index < recipes.size()) {
			Iterator<Recipe> it = recipes.values().iterator();
			for (int i = 0; i < index; i++) {
				it.next();
			}
			return it.next().makeDrink();
		}
		else {
			throw new IndexOutOfBoundsException();
		}
	}

}