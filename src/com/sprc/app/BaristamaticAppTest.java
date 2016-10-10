package com.sprc.app;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BaristamaticAppTest {
	
	@Before
	public void setUp() throws Exception{
		System.out.println("---------------------------");
	}
	
	// Create a coffee by adding the ingredients to the recipe
	@Test
	public void test1() {
		System.out.println("Test 1");
		Drink coffee = new Drink("Coffee");
		coffee = (new Coffee()).addTo(coffee);
		coffee = (new Coffee()).addTo(coffee);
		coffee = (new Coffee()).addTo(coffee);		
		coffee = (new Sugar()).addTo(coffee);
		coffee = (new Cream()).addTo(coffee);
		assertTrue(coffee.getDescription().equals("Coffee") && (coffee.cost() == 275));		
	}
	
	 // To test whether drink is dispensing
    @Test
    public void test2() {
    	System.out.println("Test 2");
        Inventory inventory = new Inventory();
        Recipe coffeeMaker = new CoffeeRecipe(inventory);
        Drink coffee = coffeeMaker.makeDrink();
        assertTrue(coffee.getDescription().equals("Coffee"));
    }
    
    // Display the inventory, select drink, display "Out of Stock : drink_name",
    // restock the machine and select a drink
    @Test
    public void test3() {
    	System.out.println("Test 3");
        Inventory inventory = new Inventory();
        inventory.display();
        Recipe coffeeMaker = new CoffeeRecipe(inventory);
        coffeeMaker.makeDrink();
        inventory.display();
        coffeeMaker.makeDrink();
        coffeeMaker.makeDrink();
        coffeeMaker.makeDrink();
        inventory.restock();
        coffeeMaker.makeDrink();
    }
    
    // Display inventory, display menu, dispense drink, display updated inventory,
    // make drink till "Out of Stock: drink_name" , display menu, restock and 
    // dispense drink
    @Test
    public void test4() {
    	System.out.println("Test 4");
        Inventory inventory = new Inventory();
        Menu menu = new Menu(inventory);
        inventory.display();
        menu.display();
        menu.makeDrink(4);
        inventory.display();
        menu.makeDrink(4);
        menu.makeDrink(4);
        menu.makeDrink(4);
        menu.display();
        inventory.restock();
        menu.makeDrink(2);
    }
    
 // Create a new drink, add it to the menu, and prepare it
    @Test
    public void test5() {
    	System.out.println("Test 5");
        Inventory inventory = new Inventory();
        Menu menu = new Menu(inventory);
        class DecafCappuccinoRecipe extends Recipe {

            public DecafCappuccinoRecipe(Inventory inventory) {
                super("Decaf Cappuccino", inventory);
            }
            
            @Override
            public void setRecipe() {
                addIngredient("Decaf Coffee", 1);
                addIngredient("Espresso", 2);
                addIngredient("Steamed Milk", 1);
                addIngredient("Foamed Milk", 1);
            }
        }
        menu.addRecipe(new DecafCappuccinoRecipe(inventory));
        inventory.display();
        menu.display();
        menu.makeDrink(6);
        inventory.display();
        menu.display();
    }
}
