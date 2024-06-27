/**
 * The class Item is a template for an item for the vending machine.
 * 
 * It has a constructor wherein it constructs the item based on its name, price, initial quantity, and calories.
 * 
 * 
 */

public class Item {
  
  private String name;
  private int price;

  private float calories;
  private String category;

/**
 * A constructor that takes in the item name, item price, and item calories to create a regular item.
 * @param name is the name of the item
 * @param price is the price of the item
 * @param calories is the number of calories of the item
 */
public Item(String name, int price, float calories){

  this.name = name;
  this.price = price;
  this.calories = calories;

}

/**
 * A constructor that takes in the item name, item price, item calories, and item category to create a special item.
 * @param name is the name of the item
 * @param price is the price of the item
 * @param calories is the number of calories of the item
 * @param category is the category of the item.
 */
public Item(String name, int price, float calories, String category){

  this.name = name;
  this.price = price;
  this.calories = calories;
  this.category = category;
 
  }


/**
 * Gets the item's name
 * @return name of String type
 */
public String getName(){

  return name;

}
/**
 * Gets the item's price
 * @return price of int type
 */
public int getPrice(){


  return price;

}
/**
 * Gets the item's calorie value
 * @return calories of float type
 */
public float getCalories(){


  return calories;

}

/**
 * Gets the item's category
 * @return the category of the item
 */
public String getCategory(){

  return category;

}


/**
 * sets a new value for price
 * @param price the new value price will take
 */

public void setPrice(int price){


  this.price = price;
  
}

}
