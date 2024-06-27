import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
/**
 * This class performs all the actions when the user creates an input
 */
public class VendingMachineController {

    private VendingMachineView VendingView;
    private VendingMachineModel VendingModel;
    
    /**
     * A constructor that takes in the VendingMachineView to see actionListeners and VendingMachineModel for methods
     * @param VendingView is the instance of the View the user sees and contains the actionListeners
     * @param VendingModel contains the methods that support this class
     */
    public VendingMachineController (VendingMachineView VendingView, VendingMachineModel VendingModel){

        this.VendingView = VendingView;
        this.VendingModel = VendingModel;

    // FIRST MENU
    //lalagyan pa ba to ng javadoc
    this.VendingView.setRegVendBtnListener(new ActionListener(){
        @Override
        public void actionPerformed (ActionEvent e){

          
        if(VendingModel.getVendingMachine() == null){
           
           VendingModel.setRegularVendingMachine();
           VendingView.FirstMenuStatus(false);
           VendingView.RegularItemCreate(true);

           
        }else{
           
           VendingView.FirstMenuStatus(false); // remove first menu
           VendingView.createRegAgainStatus(true); // display create again menu (yes or no)
           
        }
           


        }


    });

    this.VendingView.setSpecVendBtnListener(new ActionListener(){
        @Override
        public void actionPerformed (ActionEvent e){


         if(VendingModel.getVendingMachine() == null){

           VendingModel.setSpecialVendingMachine();
           VendingView.FirstMenuStatus(false);
           VendingView.SpecialItemCreate(true);
           
        }else{
           
           VendingView.FirstMenuStatus(false); // remove first menu
           VendingView.createSpecAgainStatus(true); // display create again menu (yes or no)
           
           
        }

        }


    });


    this.VendingView.setTestVendBtnListener(new ActionListener(){
        @Override
        public void actionPerformed (ActionEvent e){


        if(VendingModel.getVendingMachine() == null){
           



        }else{

           VendingView.FirstMenuStatus(false);

           VendingView.SecondMenuStatus(true);
            
        }

        }



    });




     this.VendingView.setRegSubmitListener(new ActionListener() {
        @Override
        public void actionPerformed (ActionEvent a){
            
            VendingView.SubmitItemStatus(false);
            
            try{

            String name = VendingView.getNameTF();
            int price = Integer.parseInt(VendingView.getPriceTF());
            int quantity = Integer.parseInt(VendingView.getQuantityTF());
            float calories = Float.parseFloat(VendingView.getCaloriesTF());
            boolean result;

            if(quantity >= 10){

            result = VendingModel.addRegItem(name, price, quantity, calories);
            
            VendingView.clearItemTF();

            
           
            if(VendingModel.getItemList().size() >= 8){ 

            VendingView.SubmitItemStatus(true); 

            }

        } else{

            VendingView.clearItemTF();
            VendingView.errorMessagePane(false);

        }

        }catch(NumberFormatException e){

            VendingView.errorMessagePane(false);

        }

        }
    });
    

    this.VendingView.setSpecSubmitListener(new ActionListener() {
        @Override
        public void actionPerformed (ActionEvent a){
            try{
            String name = VendingView.getNameTF();
            int price = Integer.parseInt(VendingView.getPriceTF());
            int quantity = Integer.parseInt(VendingView.getQuantityTF());
            float calories = Float.parseFloat(VendingView.getCaloriesTF());
            String category = (String)VendingView.getCategoryDrop();
            
            if(quantity >= 10){
                VendingModel.addSpecItem(name, price, quantity, calories, category);
                VendingView.clearItemTF();

             if(VendingModel.getItemList().size() >= 8){
                
                VendingView.SubmitItemStatus(true);
             }

            }else{
                
                VendingView.clearItemTF();
                VendingView.errorMessagePane(false);

            }

            }
            catch (NumberFormatException e){
                VendingView.errorMessagePane(false);
             }

            


        }
    });


    this.VendingView.setSubmitBtnListener(new ActionListener() {
        @Override
        public void actionPerformed (ActionEvent a){

            VendingView.RegularItemCreate(false);
            VendingView.SpecialItemCreate(false);
            VendingView.SubmitItemStatus(false);
            
            VendingView.FirstMenuStatus(true);

          
  
        }
    });
    

    // TEST MENU CHOICES

    this.VendingView.setVendListener(new ActionListener(){
        @Override
        public void actionPerformed (ActionEvent ab){

            VendingView.SecondMenuStatus(false);
            VendingView.VendingMenuStatus(true);
            VendingView.displaynewItemListState(true);
            VendingView.backButtonsState(false);

            if(VendingModel.getVendingMachine() instanceof SpecialVendingMachine){

                VendingView.updateSpecialItemListTable(VendingModel.getItemList());

            }else{

                VendingView.updateRegularItemListTable(VendingModel.getItemList());

            }

                VendingView.setMoneyLabel("Inserted Cash:" + VendingModel.totalAmount(VendingModel.getPaymentList()));
            

        }   
    });

    this.VendingView.setMaintListener(new ActionListener(){
        @Override
        public void actionPerformed (ActionEvent ab){
            VendingView.SecondMenuStatus(false);
            VendingView.MaintMenuStatus(true);
        }
    });

    // VENDING FEATURES

    this.VendingView.setInsertCashBtn(new ActionListener (){
        @Override
        public void actionPerformed (ActionEvent ab){

            VendingView.VendingMenuStatus(false);
            VendingView.insertCashState(true);

        }
    });

    this.VendingView.setCustomInsertCashBtn(new ActionListener (){
        @Override
        public void actionPerformed (ActionEvent ab){

            VendingView.customizeProductState(false);
            VendingView.custominsertCashState(true);

            

        }
    });
    
    this.VendingView.insertCashBtns(new ActionListener (){
        @Override
        public void actionPerformed (ActionEvent ab){

            int value = Integer.parseInt((String)VendingView.getDenominations());
            

            VendingModel.insertCash(value);
            VendingView.setMoneyLabel("Inserted Cash:" + VendingModel.totalAmount(VendingModel.getPaymentList()));
            VendingView.insertCashState(false);
            VendingView.VendingMenuStatus(true);

        }
    });


    this.VendingView.setCancelTransactionBtn (new ActionListener(){
        @Override
        public void actionPerformed (ActionEvent ab){
            VendingView.VendingMenuStatus(false);
            VendingView.customizeProductState(false);
            VendingView.FirstMenuStatus(true);
            int returnTotal = VendingModel.cancelTransaction(VendingModel.getPaymentList());
            VendingView.cancelTransactionPane(returnTotal);
            VendingView.displaynewItemListState(false);
            VendingModel.getChosenItems().clear();
            
        }
    });




    this.VendingView.setCustomConfirmCashBtn(new ActionListener (){
        @Override
        public void actionPerformed (ActionEvent ab){

            int value = Integer.parseInt((String)VendingView.getDenominations());
        
            VendingModel.insertCash(value);
            VendingView.setMoneyLabel("Inserted Cash:" + VendingModel.totalAmount(VendingModel.getPaymentList()));
            VendingView.custominsertCashState(false);
            VendingView.customizeProductState(true);
            

            
        }
    });
    

    this.VendingView.setProceedTransactionBtn(new ActionListener (){

        @Override
        public void actionPerformed (ActionEvent ab){

         if(VendingModel.totalAmount(VendingModel.getPaymentList()) > VendingModel.computePrice(VendingModel.getChosenItems())){  // if amount inserted is greater than price of customized product
                

                if (VendingModel.verifyChange(VendingModel.totalAmount(VendingModel.getPaymentList()))){ // verify if there is change
                    
                    
                        
                    int change = VendingModel.totalAmount(VendingModel.produceChange((VendingModel.totalAmount(VendingModel.getPaymentList()) - VendingModel.computePrice(VendingModel.getChosenItems()))));      
                    int i = 0, j = 0;
                    

                    VendingModel.storePayment(VendingModel.getPaymentList());
                    
                    VendingView.customizeProductState(false);
                    VendingView.VendingMenuStatus(true);
                    //VendingView.displaynewItemListState(true);
                    VendingView.updateSpecialItemListTable(VendingModel.getItemList());
                    VendingView.processDispensePane(VendingModel.dispenseCustomizedProduct());
                    VendingView.updateSpecialItemListTable(VendingModel.getItemList());
                    

                    VendingView.dispenseCustomizedPane(change, true);

                    VendingModel.getChosenItems().clear();
                    VendingView.setMoneyLabel("Inserted Cash:" + VendingModel.totalAmount(VendingModel.getPaymentList()));
                     // give out the change, update change list

                    
        
                  }else{

                   
                    
                    int value = VendingModel.cancelTransaction(VendingModel.getPaymentList());
                    VendingView.dispenseCustomizedPane(value, false);
                    VendingView.customizeProductState(false);
                    VendingView.VendingMenuStatus(true);
                     VendingModel.getChosenItems().clear();
                    
                    

                  }
                  

            }else if(VendingModel.totalAmount(VendingModel.getPaymentList()) == VendingModel.computePrice(VendingModel.getChosenItems())){


                    int change = VendingModel.totalAmount(VendingModel.produceChange((VendingModel.totalAmount(VendingModel.getPaymentList()) - VendingModel.computePrice(VendingModel.getChosenItems()))));      
                    int i = 0, j = 0;
                    

                    VendingModel.storePayment(VendingModel.getPaymentList());
                    
                    VendingView.customizeProductState(false);
                    VendingView.VendingMenuStatus(true);
                    //VendingView.displaynewItemListState(true);
                    VendingView.updateSpecialItemListTable(VendingModel.getItemList());
                    VendingView.processDispensePane(VendingModel.dispenseCustomizedProduct());
                    VendingView.updateSpecialItemListTable(VendingModel.getItemList());
                    

                    VendingView.dispenseCustomizedPane(change, true);

                    VendingModel.getChosenItems().clear();
                    VendingView.setMoneyLabel("Inserted Cash:" + VendingModel.totalAmount(VendingModel.getPaymentList()));

                
            } else{
                    
                    VendingView.setVendingMenuLabel("Not enough cash inserted.");

  
          }


        
            

            
        }
    });


    this.VendingView.setCustomizeProductBtn(new ActionListener (){
        @Override
        public void actionPerformed (ActionEvent ab){

            int i;
            boolean sinker = false;
            boolean teabase = false;
            boolean flavoring = false;
            boolean milk = false; 


            if(VendingModel.getVendingMachine() instanceof SpecialVendingMachine){

                    for(i = 0; i < VendingModel.getItemList().size(); i++){

                            if(VendingModel.getItemList().get(i).get(0).getCategory().equals("Sinker")){

                                sinker = true;

                            }else if(VendingModel.getItemList().get(i).get(0).getCategory().equals("Tea Base")){

                                teabase = true;


                            }else if(VendingModel.getItemList().get(i).get(0).getCategory().equals("Flavoring")){

                                flavoring = true;

                            }else if(VendingModel.getItemList().get(i).get(0).getCategory().equals("Milk")){

                                milk = true;

                            }

                    }


                    if(sinker == true && teabase == true && flavoring == true && milk == true){

                        VendingView.updateSpecialItemListTable(VendingModel.getItemList());
                        VendingView.VendingMenuStatus(false);
                        VendingView.chooseSinkerState(true);
                        VendingView.specialVendItemSubmitState (true);

                    }else{

                    VendingView.setVendingMenuLabel("One or more category of items do not exist, unable to customize product");

                    }
            
            }else{

                VendingView.setVendingMenuLabel("The vending machine is not a special vending machine, unable to customize product");

            }
            
            
        }
    });

    this.VendingView.setAddSinkerBtn(new ActionListener (){
        @Override
        public void actionPerformed (ActionEvent ab){


 

            int index = Integer.parseInt(VendingView.getItemTF()) - 1;

             if (VendingModel.getItemList().get(index).get(0).getCategory().equals("Sinker")){
                VendingView.updateSpecialItemListTable(VendingModel.getItemList());
                VendingModel.getChosenItems().add(index);
                VendingView.addCategoryPane(VendingModel.getItemList().get(index).get(0).getName());

             }

             else{
                VendingView.errorMessagePane(false);
            }
                //VendingView.errorMessagePane(false);

            if(VendingModel.getChosenItems().size() == 3){

                VendingView.addSinkerState(false);

            }
            
            if(VendingModel.getChosenItems().size() > 0){

            VendingView.submitSinkerState(true);

            }
            
            
            
            
        }
    });

    this.VendingView.setSubmitSinkerBtn(new ActionListener (){
        @Override
        public void actionPerformed (ActionEvent ab){

                VendingView.chooseTeaBaseState(true);
                VendingView.updateSpecialItemListTable(VendingModel.getItemList());
                VendingView.chooseSinkerState(false);
           
            
        }
    });


    
    this.VendingView.setSubmitTeaBaseBtn(new ActionListener (){
        @Override
        public void actionPerformed (ActionEvent ab){


            int index = Integer.parseInt(VendingView.getItemTF()) - 1;
            
            if (VendingModel.getItemList().get(index).get(0).getCategory().equals("Tea Base")){

            VendingView.updateSpecialItemListTable(VendingModel.getItemList());
            VendingView.chooseTeaBaseState(false);
            VendingView.chooseFlavoringState(true);
            VendingModel.getChosenItems().add(index);
            VendingView.addCategoryPane(VendingModel.getItemList().get(index).get(0).getName());

            }
             else{
                VendingView.errorMessagePane(false);
            }

            
        }
    });


    
    this.VendingView.setSubmitFlavoringBtn(new ActionListener (){
        @Override
        public void actionPerformed (ActionEvent ab){

            int index = Integer.parseInt(VendingView.getItemTF()) - 1;
            
            if (VendingModel.getItemList().get(index).get(0).getCategory().equals("Flavoring")){

           // VendingModel.getChosenItems().add(index);
            VendingView.updateSpecialItemListTable(VendingModel.getItemList());
            VendingView.chooseFlavoringState(false);
            VendingView.chooseMilkState(true);
            VendingModel.getChosenItems().add(index);
            VendingView.addCategoryPane(VendingModel.getItemList().get(index).get(0).getName());

            }
             else{
                VendingView.errorMessagePane(false);
            }

            
        }
    });


    
    this.VendingView.setSubmitMilkBtn(new ActionListener (){
        @Override
        public void actionPerformed (ActionEvent ab){

             int index = Integer.parseInt(VendingView.getItemTF()) - 1;
             
            if (VendingModel.getItemList().get(index).get(0).getCategory().equals("Milk")){

            VendingModel.getChosenItems().add(index);
            VendingView.addCategoryPane(VendingModel.getItemList().get(index).get(0).getName());
            VendingView.updateSpecialItemListTable(VendingModel.getItemList());
            VendingView.chooseMilkState(false);
            VendingView.displaynewItemListState(false);
            VendingView.backButtonsState(false);
            VendingView.customizeProductState(true);
            VendingView.specialVendItemSubmitState (false);
            VendingView.setCustomizedPrice("Total price is: " + VendingModel.computePrice(VendingModel.getChosenItems()));
            VendingView.setCustomizedCalories("Total calories is:" + VendingModel.computeCalories(VendingModel.getChosenItems()));
            
            }
             else{
                VendingView.errorMessagePane(false);
            }
            
        
            
        }
    });




    this.VendingView.setPrintReceiptBtn(new ActionListener (){
        @Override
        public void actionPerformed (ActionEvent ab){

            VendingView.VendingMenuStatus(false);
            VendingView.displaynewItemListState(false);
            VendingView.backButtonsState(false);
            VendingView.FirstMenuStatus(true);
            
        }
    });
    
    // MAINTENANCE FEATURES

        this.VendingView.setDisplayItemListBtn(new ActionListener (){
        @Override
        public void actionPerformed (ActionEvent a){

            VendingView.MaintMenuStatus(false);
            VendingView.displaynewItemListState(true);
            VendingView.updateRegularItemListTable(VendingModel.getItemList());

            

        }
    });
    this.VendingView.endItemDisplay(new ActionListener (){
        @Override
        public void actionPerformed (ActionEvent a){

            VendingView.MaintMenuStatus(true);
            VendingView.displaynewItemListState(false);            
            VendingView.replenishItemState(false);   

        }
    });

        this.VendingView.setDisplayChangeListBtn(new ActionListener (){
        @Override
        public void actionPerformed (ActionEvent a){


            VendingView.MaintMenuStatus(false); 
            VendingView.displaynewChangeListState(true);
            VendingView.updateChangeListTable(VendingModel.getChangeList(), VendingModel.getDenomList());
            
            
            
        }
    });
    this.VendingView.endChangeDisplay(new ActionListener (){
        @Override
        public void actionPerformed (ActionEvent a){


            VendingView.MaintMenuStatus(true); 
            VendingView.displaynewChangeListState(false);            
            
        }
    });

        this.VendingView.setReplenishItemBtn(new ActionListener (){
        @Override
        public void actionPerformed (ActionEvent a){

            
            VendingView.MaintMenuStatus(false);
            VendingView.displaynewItemListState(true);

            if(VendingModel.getVendingMachine() instanceof SpecialVendingMachine){

            VendingView.updateSpecialItemListTable(VendingModel.getItemList());

            }else{
            
            VendingView.updateRegularItemListTable(VendingModel.getItemList());

            }

            VendingView.replenishItemState(true);
            VendingView.updateItemsComboBox(VendingModel.getItemNames(VendingModel.getItemList()));
            

            // replenish item

        }
    });


        this.VendingView.setReplenishItemConfirmBtn(new ActionListener(){
        @Override

        public void actionPerformed (ActionEvent a){

            String value = VendingView.getItem();

            int amount = Integer.parseInt(VendingView.getReplenishAmountTF());

            VendingModel.replenishQuantity(value, amount);
            VendingView.displaynewItemListState(false);
            VendingView.replenishItemState(false);
            VendingView.MaintMenuStatus(true);



        }
    });


 
    
        this.VendingView.setReplenishChangeBtn(new ActionListener (){
        @Override
        public void actionPerformed (ActionEvent a){

            

            VendingView.MaintMenuStatus(false); 
            VendingView.displaynewChangeListState(true);
            VendingView.updateChangeListTable(VendingModel.getChangeList(), VendingModel.getDenomList());
            VendingView.replenishChangeState(true);
            
            
            
            
        }
    });


       this.VendingView.setReplenishChangeConfirmBtn(new ActionListener (){

        @Override
        public void actionPerformed (ActionEvent ab){

            int value = Integer.parseInt((String)VendingView.getDenominations());
            int amount = Integer.parseInt(VendingView.getReplenishAmountTF());

            VendingModel.replenishChange(value, amount);
            VendingView.displaynewChangeListState(false);
            VendingView.replenishChangeState(false);
            VendingView.MaintMenuStatus(true);


        }
    });

        
        this.VendingView.setAddNewItemBtn(new ActionListener (){
        @Override
        public void actionPerformed (ActionEvent a){


            VendingView.MaintMenuStatus(false);
            

            if(VendingModel.getVendingMachine() instanceof SpecialVendingMachine){

            
            VendingView.SpecialItemCreate(true);

           }else{

            VendingView.RegularItemCreate(true);


           }

           

           
        }
    });


        this.VendingView.setSetPriceBtn(new ActionListener (){
        @Override
        public void actionPerformed (ActionEvent a){

            VendingView.MaintMenuStatus(false);
            VendingView.displaynewItemListState(true);
            VendingView.updateRegularItemListTable(VendingModel.getItemList());
            VendingView.setPriceState(true);
            VendingView.updateItemsComboBox(VendingModel.getItemNames(VendingModel.getItemList()));
           

        }
    });


        this.VendingView.setSetPriceConfirmBtn(new ActionListener (){ // modify this
        
        @Override
        public void actionPerformed (ActionEvent ab){

            String value = VendingView.getItem();

            int amount = Integer.parseInt(VendingView.getReplenishAmountTF());
            
            VendingView.itemMaintenanceState(false);
            VendingModel.setItemPrice(value, amount);
            VendingView.displaynewItemListState(false);
            VendingView.setPriceState(false);
            VendingView.MaintMenuStatus(true);
                

        }
    });


        this.VendingView.setCollectPaymentBtn(new ActionListener (){
        @Override
        public void actionPerformed (ActionEvent a){

            VendingView.MaintMenuStatus(true);

            VendingModel.storePayment(VendingModel.getPaymentList());
            VendingView.collectPaymentPane(VendingModel.collectPayment(VendingModel.getOwnerPaymentList()));

            
        }
    });

    
        this.VendingView.setPrintSummaryBtn(new ActionListener (){
        @Override
        public void actionPerformed (ActionEvent a){
            
            String setTransaction = VendingModel.getTransactionList().TransactionList(VendingModel.getItemList(), VendingModel.getTotalPurchases());
            VendingView.MaintMenuStatus(false);
            VendingView.setTransactionArea (setTransaction);
            VendingView.transacDisplayState(true);
           
        }
    });

        this.VendingView.endTransactionDisplay(new ActionListener (){
        @Override
        public void actionPerformed (ActionEvent a){
           
        
            VendingView.MaintMenuStatus(true);
            
            VendingView.transacDisplayState(false);
           
        }
     });


        this.VendingView.setEndMaintenanceBtn(new ActionListener (){
        @Override
        public void actionPerformed (ActionEvent a){

            VendingView.MaintMenuStatus(false);
            VendingView.FirstMenuStatus(true);
           
        }
    });

    // CREATE AGAIN (YES OR NO)

        this.VendingView.setRegYesBtn(new ActionListener (){
        @Override
        public void actionPerformed (ActionEvent a){

           VendingView.createRegAgainStatus(false);
           VendingModel.setVendingMachineNull(VendingModel.getVendingMachine());

           VendingModel.getItemList().clear();
           VendingModel.getChosenItems().clear();
           
           VendingModel.setRegularVendingMachine();
           VendingView.RegularItemCreate(true);

           
        }
    });

        this.VendingView.setRegNoBtn(new ActionListener (){
        @Override
        public void actionPerformed (ActionEvent a){

            VendingView.createRegAgainStatus(false);
            VendingView.FirstMenuStatus(true);
           
        }
    });
         
        this.VendingView.setSpecYesBtn(new ActionListener (){
        @Override
        public void actionPerformed (ActionEvent a){


           VendingView.createSpecAgainStatus(false);
           VendingModel.setVendingMachineNull(VendingModel.getVendingMachine());

           VendingModel.getItemList().clear();
           VendingModel.getChosenItems().clear();
        
           
           VendingModel.setSpecialVendingMachine();
           VendingView.SpecialItemCreate(true);
           
           
        }
    });

    
         this.VendingView.setSpecNoBtn(new ActionListener (){
        @Override
        public void actionPerformed (ActionEvent a){

            VendingView.createSpecAgainStatus(false);
            VendingView.FirstMenuStatus(true);
           
        }
    });


        this.VendingView.setSelectItemBtn(new ActionListener(){
        @Override
        public void actionPerformed (ActionEvent i){

            if(VendingModel.totalAmount(VendingModel.getPaymentList()) > 0){
            
            VendingView.selectItemState(true);
            VendingView.VendingMenuStatus(false);
            VendingView.setMoneyLabel("Inserted Cash:" + VendingModel.totalAmount(VendingModel.getPaymentList()));

            }else{

            VendingView.setVendingMenuLabel("You have not inserted any cash");

            }

        }



        });
        
        this.VendingView.confirmItemBtn(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent o){
            
            int purchasedItem = Integer.parseInt(VendingView.getItemTF());

            if(VendingModel.getVendingMachine() instanceof SpecialVendingMachine){

                if(VendingModel.getItemList().get(purchasedItem-1).get(0).getCategory().equals("Sinker")){

                    VendingView.selectItemState(false);
                    VendingView.VendingMenuStatus(true);
                    VendingView.setVendingMenuLabel("Cannot dispense sinker.");


                }else{

                    if(VendingModel.totalAmount(VendingModel.getPaymentList()) > VendingModel.getItemList().get(purchasedItem-1).get(0).getPrice()){  // if amount inserted is greater than price of item selected
                

                if (VendingModel.verifyChange(VendingModel.totalAmount(VendingModel.getPaymentList()))){ // verify if there is change
                    
                    
                    
                    int change = VendingModel.totalAmount(VendingModel.produceChange((VendingModel.totalAmount(VendingModel.getPaymentList()) - VendingModel.getItemList().get(purchasedItem-1).get(0).getPrice())));      
                    
                   // VendingModel.storePayment(VendingModel.getPaymentList());
                    
                    String namePurchased = VendingModel.getItemList().get(purchasedItem-1).get(0).getName();
                    VendingView.dispensePane(change, true, namePurchased); 
                    VendingModel.dispenseItem(purchasedItem - 1);
                    VendingView.selectItemState(false);
                    VendingView.VendingMenuStatus(true);
                    VendingView.displaynewItemListState(true);
                    VendingView.backButtonsState(false);
                    VendingView.updateSpecialItemListTable(VendingModel.getItemList());
                    VendingView.setMoneyLabel("Inserted Cash:" + VendingModel.totalAmount(VendingModel.getPaymentList()));

                     // give out the change, update change list
                    
                    
        
                  }else{
                    
                    int value = VendingModel.cancelTransaction(VendingModel.getPaymentList());
                    String namePurchased = null;
                    VendingView.dispensePane(value, false, namePurchased);
                    VendingView.selectItemState(false);
                    VendingView.VendingMenuStatus(true);
                    
                    

                  }
                  

            }else if(VendingModel.totalAmount(VendingModel.getPaymentList()) == VendingModel.getItemList().get(purchasedItem-1).get(0).getPrice()){

                    int change = VendingModel.totalAmount(VendingModel.produceChange((VendingModel.totalAmount(VendingModel.getPaymentList()) - VendingModel.getItemList().get(purchasedItem-1).get(0).getPrice())));
                    String namePurchased = VendingModel.getItemList().get(purchasedItem-1).get(0).getName();
                    VendingView.dispensePane(change, true, namePurchased); 
                    VendingModel.dispenseItem(purchasedItem - 1);
                    VendingView.selectItemState(false);
                    VendingView.VendingMenuStatus(true);
                    VendingView.backButtonsState(false);
                    VendingView.updateSpecialItemListTable(VendingModel.getItemList());

                
            } else{
  
                    VendingView.selectItemState(false);
                    VendingView.VendingMenuStatus(true);
  
            }

                }


            }else{

            if(VendingModel.totalAmount(VendingModel.getPaymentList()) > VendingModel.getItemList().get(purchasedItem-1).get(0).getPrice()){  // if amount inserted is greater than price of item selected
                

                if (VendingModel.verifyChange(VendingModel.totalAmount(VendingModel.getPaymentList()))){ // verify if there is change
                    
                    
                    
                    int change = VendingModel.totalAmount(VendingModel.produceChange((VendingModel.totalAmount(VendingModel.getPaymentList()) - VendingModel.getItemList().get(purchasedItem-1).get(0).getPrice())));      
                    
                  //  VendingModel.storePayment(VendingModel.getPaymentList());
                    
                    String namePurchased = VendingModel.getItemList().get(purchasedItem-1).get(0).getName();
                    VendingView.dispensePane(change, true, namePurchased); 
                    VendingModel.dispenseItem(purchasedItem - 1);
                    VendingView.selectItemState(false);
                    VendingView.VendingMenuStatus(true);
                    VendingView.displaynewItemListState(true);
                    VendingView.updateRegularItemListTable(VendingModel.getItemList());
                    VendingView.backButtonsState(false);
                    VendingView.setMoneyLabel("Inserted Cash:" + VendingModel.totalAmount(VendingModel.getPaymentList()));

                     // give out the change, update change list
                    
                    
        
                  }else{
                    
                    int value = VendingModel.cancelTransaction(VendingModel.getPaymentList());
                    String namePurchased = null;
                    VendingView.dispensePane(value, false, namePurchased);
                    VendingView.selectItemState(false);
                    VendingView.VendingMenuStatus(true);
                    VendingView.backButtonsState(false);
                    

                  }
                  

            }else if(VendingModel.totalAmount(VendingModel.getPaymentList()) == VendingModel.getItemList().get(purchasedItem-1).get(0).getPrice()){

                    int change = VendingModel.totalAmount(VendingModel.produceChange((VendingModel.totalAmount(VendingModel.getPaymentList()) - VendingModel.getItemList().get(purchasedItem-1).get(0).getPrice())));
                    String namePurchased = VendingModel.getItemList().get(purchasedItem-1).get(0).getName();
                    VendingView.dispensePane(change, true, namePurchased); 
                    VendingModel.dispenseItem(purchasedItem - 1);
                    VendingView.selectItemState(false);
                    VendingView.VendingMenuStatus(true);
                    VendingView.updateRegularItemListTable(VendingModel.getItemList());
                    VendingView.backButtonsState(false);

                
            } else{
  
                    VendingView.selectItemState(false);
                    VendingView.VendingMenuStatus(true);
  
          }

        }
        }
        });

    
        

    }



}

