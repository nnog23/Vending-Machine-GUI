import java.util.Scanner;
import java.util.ArrayList;

/**
 * The class RegularVendingMachine is a blueprint for a Regular Vending Machine. 
 * 
 * It has a constructor, wherein it constructs the Regular Vending Machine by initializing the first 8 items.
 * The other attributes are initialized.
 * 
 */

public class RegularVendingMachine{


protected int[] denomList = {1000,500,200,100,50,20,10,5,1}; // standard denominations
protected int[] paymentList = {0,0,0,0,0,0,0,0,0}; // payment from customer
protected int[] ownerPaymentList = {0,0,0,0,0,0,0,0,0}; // total payment array
protected int[] changeList = {10,10,10,10,10,10,10,10,10}; // amount of change

/**
 *  The class RegularVendingMachine instance is used to logic in the VendingModel and VendingController
 * 
 */
public RegularVendingMachine(){



}


  /**
     * increments to the paymentList at the index of the chosen bill type
     * @param payment is the bill the user has put into the vending machine 
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
     * returns the summation of an array
     * @param value[] is the array to be summationed
     * @return total value inside int array
     */

     public int totalAmount (int[] value){

      int i, total = 0;
  
      for (i = 0; i < 9; i++){
  
        total = total + (value[i] * denomList[i]);
  
      }

      return total;
  
    }

    /**
     * returns the payment the user has inputted if the transaction is cancelled
     * @param paymentList[] is the array of the payment from the customer
     * @return original amount inserted
     */

     public int cancelTransaction (int [] paymentList){

      int nTotal = 0;
      int i;
  
      nTotal = totalAmount (paymentList);
  
      for (i = 0; i < 9; i++){
            
        this.paymentList[i] = 0;
  
      }
  
      return nTotal;
      
    }
  

    /**
     * verifies if the vending machine has enough change for the transaction
     * @param amount is the amount of money paid
     * @return t/f if enough change
     */


     public boolean verifyChange (int amount){
   
   
      int [] tempChange = new int[changeList.length];
   
      int tempAmount = amount;
      int i;
   
      for(i = 0; i <= 8; i++){
   
   
       tempChange[i] = changeList[i];
   
      }
   
      for (i = 0; i <=8; i++){
      while (tempAmount >= denomList[i] && tempChange[i] > 0){
         tempAmount -= denomList[i];
         tempChange[i] --;
         }
      }
       if (tempAmount == 0){
         return true;
       }
       else 
   
         return false; 
         
     }

  /**
     * returns the denomination array of change that the user will get after buying
     * @param amount is the change amount
     * @return an array of denom for change
     */

     public int[] produceChange (int amount){

      int[] changeDenom = {0, 0, 0, 0, 0, 0, 0, 0, 0};
   
      int i;

      for (i = 0; i < 9; i++){
  
      while (amount >= denomList[i] && changeList[i] > 0){
         
         amount -= denomList[i];
   
         changeList[i]--;
         changeDenom[i]++;

   
         }
   
         
   
      }
   
       return changeDenom;
   
   
   }

/**
 * stores the paymentList array to the ownerPaymentList array
 * @param paymentList is an array of bills that the customer inserted in the vending machine.
 */

 public void storePayment(int[] paymentList){

  int i;
  
  for(i = 0; i < 9; i++){
  
    ownerPaymentList[i] += paymentList[i];
  
    paymentList[i] = 0;
  
  }

  }

/**
 * collects and totals the money stored in the vending machine and returns a whole value
 * @param ownerpaymentList is the array of denominations
 * @return an array for total denom amount
 */
public int collectPayment(int [] ownerpaymentList){
  
  int i;

  int total_payment = totalAmount(ownerpaymentList);

  for (i = 0; i <= 8; i++){

    ownerpaymentList[i] = 0;

  }

  return total_payment;

}

  /**
     * gets the paymentAmount array
     * @return the current payment list array
     */

  public int[] getPaymentList(){

    return paymentList;

  }

  /**
     * gets the changeAmount array
     * @return the change list array
     */

  public int[] getChangeList(){

    return changeList;

  }

  /**
     * gets the denomination array
     * @return the denomination list array
     */
  public int[] getDenomList(){


    return denomList;

  }

  /**
   *  gets the owner payment array
   * @return the owner payment array
   */ 
  public int[] getOwnerPaymentList(){
    

    return ownerPaymentList;
    
  }


}
