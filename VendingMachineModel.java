import java.util.ArrayList;
import java.util.Scanner;
/**
 * This class contains the supporting methods that VendingMachineController uses
 */
public class VendingMachineModel extends RegularVendingMachine{

// Regular Vending Machine Object

private RegularVendingMachine vendingMachine = null;

// Regular Vending Machine Attributes


private ArrayList <ArrayList<Item>> ItemList = new ArrayList <ArrayList<Item>>();
private Transaction TransactionList = new Transaction();

private ArrayList <Integer> totalPurchase = new ArrayList<>();



// Special Vending Machine Attributes

private ArrayList <Integer> ChosenItems = new ArrayList<>();

/**
 * A constructor to make an instance of VendingMachineModel
 */
public VendingMachineModel(){




}

/**
 * gets and returns the itemlist
 * @return ItemList 2d array list of item
 */
public ArrayList <ArrayList<Item>> getItemList(){

  return ItemList;

}

/**
 * gets the arraylist of chosen items for customized product
 * @return arraylist of chosen items
 */

public ArrayList <Integer> getChosenItems(){

  return ChosenItems;
  
}

/**
 * adds an item to the regular vending machine
 * @param item_name is the item's name
 * @param item_price is the price for it to be sold
 * @param item_quantity is how many instances of the item there would be
 * @param item_calories is its calorie value
 * @return true
 */

public boolean addRegItem(String item_name, int item_price, int item_quantity, float item_calories){
  
  ArrayList <Item> temp = new ArrayList<>();
  int i;  
  Item item = new Item(item_name, item_price, item_calories);
  
  for (i = 0; i < item_quantity; i++){
    temp.add(item);
   }

  this.totalPurchase.add(0);
  ItemList.add(temp);
    return true;
  
  

 
//   The method add(String) in the type ArrayList<String> is not applicable for the arguments (Item)
// The method add(ArrayList<Item>) in the type ArrayList<ArrayList<Item>> is not applicable for the arguments (ArrayList<String>)
   

}
/**
 * adds an item to the special vending machine
 * @param item_name is the item's name
 * @param item_price is the price for it to be sold
 * @param item_quantity is how many instances of the item there would be
 * @param item_calories is its calorie value
 * @param item_category is the item's category
 * 
 */
public void addSpecItem(String item_name, int item_price, int item_quantity, float item_calories, String item_category){

    
  Item item = new Item(item_name, item_price, item_calories, item_category);
   
  ArrayList <Item> temp = new ArrayList<>();
  int i;  

   for (i = 0; i < item_quantity; i++){

    temp.add(item);

   }
  
  ItemList.add(temp);


  this.totalPurchase.add(0);
   

}


/**
 * gets the array of totalPurchase, which holds the number of items purchased overall
 * @return arraylist of total purchase
 */
public ArrayList<Integer> getTotalPurchases(){
  return this.totalPurchase;
}
/**
 * sets an instance of Regular Vending Machine
 */

public void setRegularVendingMachine(){

  vendingMachine = new RegularVendingMachine();

}
/**
 * sets an instance of Special Vending Machine
 */
public void setSpecialVendingMachine(){

  vendingMachine = new SpecialVendingMachine();

}
/**
 * gets the RegularVendingMachine
 * @return instance of vending machine
 */
public RegularVendingMachine getVendingMachine(){


  return vendingMachine;

}
/**
 * sets the instance of a vending machine to null 
 * @param vendingMachine is the instance of the vending machine
 */
public void setVendingMachineNull(RegularVendingMachine vendingMachine){

  vendingMachine = null;

}


  /**
     * allows the admin to refill the amount of change inside the vending machine
     * @param denom is the denomination of the bill to be refilled
     * @param nAmount is the amount of bills
     * 
     */

public void replenishChange (int denom, int nAmount){

  int i = 0;

  while (i <= 8){

    if (denom == denomList[i]){

      changeList[i] += nAmount;

    }

    i++;

  }


}

/**
 * Replenishes the an item's quantity
 * @param name is the name of the item
 * @param amount is the amount of items to replenish
 * 
 */
public void replenishQuantity(String name, int amount){

  int i = 0;
  int j;

  while(i < ItemList.size()){
    
    if(name.equals(ItemList.get(i).get(0).getName())){

      Item item = ItemList.get(i).get(0);

      for(j = 0; j < amount; j++)
      ItemList.get(i).add(item);


    }

    i++;

  }


}
/**
 * sets the price for the items
 * @param name is the name of the price
 * @param price is the new price for the item
 */
public void setItemPrice(String name, int price){ 

  int i = 0;
  int j = 0;

while(i < ItemList.size()){

if(name.equals(ItemList.get(i).get(0).getName())){
    for (j = 0; j < ItemList.get(i).size(); j++){
      ItemList.get(i).get(j).setPrice(price);
    }
  }

  i++;

}

}


 

 

  
/**
 * Dispenses an item from the vending machine, removes the last instance of the ItemList 
 * @param select is the index used to search for the chosen item within the ItemList ArrayList
 */

public void dispenseItem(int select){

  // remove the last instance of the itemlist array of a certain item
  
  int i;

  
  ItemList.get(select).remove(ItemList.size() - 1);
  
  
 
  Integer value2 = this.totalPurchase.get(select);
  value2 = value2 + 1;
  

  this.totalPurchase.set(select, value2);

 

  for (i = 0; i <= 8; i++){
      
      ownerPaymentList[i] = paymentList[i];

    }

  for (i = 0; i <= 8; i++){
      
      paymentList[i] = 0;

    }
    
  
}

/**
 * takes a bill and puts it in the current payment array corresponding to its denomination
 * @param payment is the inserted bill
 */
public void insertCash(int payment){

  int i = 0;
  
  while (i <= 8){

    if (payment == denomList[i]){
      
      paymentList[i] += 1;

  }

  i++;

}

}




   
  
  /**
   * gets the list of item names
   * @param ItemList is the adjacency list of items
   * @return an array of items
   */
  public String[] getItemNames(ArrayList <ArrayList<Item>> ItemList){

    int i;

    String[] items = new String[ItemList.size()];

    for(i = 0; i < ItemList.size(); i++){

      items[i] = ItemList.get(i).get(0).getName();

    }

    return items;

  }

 /**
  * gets the transaction list
  * @return an instance of transaction
  */
  public Transaction getTransactionList(){
    
    return this.TransactionList;

  }

/**
 * dispenses the Customized product
 * @return an array of strings with the processing commands
 */
  public String dispenseCustomizedProduct(){

    //String[] processes = new String[ChosenItems.size()];

    int i;
    int j;
    String processes = "";
    
    for(i = 0; i < ChosenItems.size(); i++){ // arraylist of chosen item integers



          if(ItemList.get(ChosenItems.get(i)).get(0).getCategory().equals("Sinker")){

            processes += "Adding " + ItemList.get(ChosenItems.get(i)).get(0).getName() + "...\n";
           
            Integer value = this.totalPurchase.get(ChosenItems.get(i)); 
            value = value + 1;
            this.totalPurchase.set(ChosenItems.get(i), value);

          }else if(ItemList.get(ChosenItems.get(i)).get(0).getCategory().equals("Tea Base")){

            processes += "Brewing " + ItemList.get(ChosenItems.get(i)).get(0).getName() + "...\n";
          
            Integer value = this.totalPurchase.get(ChosenItems.get(i)); 
            value = value + 1;
            this.totalPurchase.set(ChosenItems.get(i), value);
            
          }else if(ItemList.get(ChosenItems.get(i)).get(0).getCategory().equals("Flavoring")){
            processes += "Mixing " + ItemList.get(ChosenItems.get(i)).get(0).getName() + "...\n";
            //processes[i] += "Mixing... " + ChosenItems.get(i);
            
            Integer value = this.totalPurchase.get(ChosenItems.get(i)); 
            value = value + 1;
            this.totalPurchase.set(ChosenItems.get(i), value);

          }else if((ItemList.get(ChosenItems.get(i)).get(0).getCategory().equals("Milk"))){
            processes += "Pouring " + ItemList.get(ChosenItems.get(i)).get(0).getName() + "...\n";
            //processes[i] += "Pouring... " + ChosenItems.get(i);
     
            Integer value = this.totalPurchase.get(ChosenItems.get(i)); 
            value = value + 1;
            this.totalPurchase.set(ChosenItems.get(i), value);


          }


          ItemList.get(ChosenItems.get(i)).remove(ItemList.get(ChosenItems.get(i)).size() - 1);

      

    }

    return processes;

  }

  /**
   * computes and returns the total calories of the customized product
   * @param ChosenItems is an arraylist of the chosen items for customization
   * @return total calories
   */
  public float computeCalories(ArrayList<Integer> ChosenItems){

 

    int i;
    float calories = 0;
    
    for(i = 0; i < ChosenItems.size(); i++){
      
         calories += ItemList.get(ChosenItems.get(i)).get(0).getCalories();

    }
  
    return calories;
  
  }
  
  /**
   * computes and returns the total price of the customized item
   * @param ChosenItems is the arraylist of items chosen during customization
   * @return total price
   */
    public int computePrice(ArrayList<Integer> ChosenItems){

    int i;
    int price = 0;
    
    for(i = 0; i < ChosenItems.size(); i++){
      
         price += ItemList.get(ChosenItems.get(i)).get(0).getPrice();

    }
  
    return price;
  
  
  }





  

}
