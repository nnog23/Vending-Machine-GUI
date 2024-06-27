
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The class main is where the program will run.
 * 
 */
public class Main{

/**
  * The method main is responsible in calling the constructors for VendingMachineView, VendingMachineModel and VendingMachineController
  * @param args is the parameter for main
  */
  public static void main (String[] args) {   
    
    VendingMachineView newMachine = new VendingMachineView();
    VendingMachineModel newModel = new VendingMachineModel();
    VendingMachineController vController = new VendingMachineController(newMachine, newModel);
    

    
}


}
