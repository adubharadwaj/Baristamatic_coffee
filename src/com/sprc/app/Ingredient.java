package com.sprc.app;

public abstract class Ingredient extends Drink {

	private Drink drink;
	private int price;

	public Ingredient(String name, int price) {
		super(name);
		this.price = price;
	}

	/**
	 * Returns the name of the drink
 	 */
	public String getDescription() {
		return drink.getDescription();
	}

	/**
	 * Returns the name of the ingredient
 	 */
	public String getName() {
		return super.getDescription();
	}

	/**
	 * Add this ingredient to a drink
 	 */
	public Drink addTo(Drink drink) {
		this.drink = drink;
		return this;
	}

	/**
	 * If the ingredient is part of a drink returns the price of the whole drink.
	 *
	 * If it is not assigned to any drink, it will return the price of the ingredient.
	 */
	@Override
	public int cost() {
		if (drink != null) {
			return price + drink.cost();
		} else {
			return price;
		}
	}

	/**
	 * Returns a copy of the ingredient
 	 */
	public abstract Ingredient clone();

}

class Coffee extends Ingredient {

	public Coffee() {
		super("Coffee", 75);
	}

	@Override
	public Ingredient clone() {
		return new Coffee();
	}

}

class DecafCoffee extends Ingredient {

	public DecafCoffee() {
		super("Decaf Coffee", 75);
	}

	@Override
	public Ingredient clone() {
		return new DecafCoffee();
	}

}

class Sugar extends Ingredient {

	public Sugar() {
		super("Sugar", 25);
	}

	@Override
	public Ingredient clone() {
		return new Sugar();
	}

}

class Cream extends Ingredient {

	public Cream() {
		super("Cream", 25);
	}

	@Override
	public Ingredient clone() {
		return new Cream();
	}

}

class SteamedMilk extends Ingredient {

	public SteamedMilk() {
		super("Steamed Milk", 35);
	}

	@Override
	public Ingredient clone() {
		return new SteamedMilk();
	}

}

class FoamedMilk extends Ingredient {

	public FoamedMilk() {
		super("Foamed Milk", 35);
	}

	@Override
	public Ingredient clone() {
		return new FoamedMilk();
	}

}

class Espresso extends Ingredient {

	public Espresso() {
		super("Espresso", 110);
	}

	@Override
	public Ingredient clone() {
		return new Espresso();
	}

}

class Cocoa extends Ingredient {

	public Cocoa() {
		super("Cocoa", 90);
	}

	@Override
	public Ingredient clone() {
		return new Cocoa();
	}

}

class WhippedCream extends Ingredient {

	public WhippedCream() {
		super("Whipped Cream", 100);
	}

	@Override
	public Ingredient clone() {
		return new WhippedCream();
	}

}
