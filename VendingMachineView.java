import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Component;
import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;

/**
 * class that serves as the view for the GUI
 */

public class VendingMachineView{

    private JFrame mainFrame;
	private JLabel nameLbl, Items, ilName, ilPrice, ilQuantity, ilCalories, ilCategory, VendMenu, CreateRegAgainMenu, CreateSpecAgainMenu;
	private JTextField iName, iPrice, iQuantity, iCalories, iCategory;

    // FIRST MENU

	private JButton RegVend, SpecVend, TestVend, RegSubmit, SpecSubmit, SubmitItem;

    // TEST MENU

    private JButton VendFeatures, MaintFeatures;

    // VENDING MENU

    private JComboBox<String> denominations, category;
    private JLabel vendingMenuLabel, chooseItemLabel, moneyLabel, customizedPrice, customizedCalories;
    private JButton insertCash, selectItem, cancelTransaction, customizeProduct, printReceipt;
    private JButton confirmCash, confirmItem;
    private JTextField itemSelect, itemMaintenance;


    // CUSTOMIZE PRODUCT

    private JButton submitSinker, submitTeaBase, submitMilk, submitFlavoring, proceedTransaction, customconfirmcash, custominsertcash, addSinker;

    // MAINTENANCE MENU 
    
    private JComboBox<String> items; // unadded to UML
    private JLabel maintenanceMenuLabel;
    private JButton displayItemList, displayChangeList, replenishItem, replenishChange, replenishChangeConfirm, replenishItemConfirm, setPriceConfirm, addNewItem, 
    setPrice, collectPayment, printSummary, endMaintenance, endItemDisplay, endChangeDisplay, endTransactionDisplay;

    // replenishchangeconfirm unadded to UML
    // replenishitemconfirm unadded to UML
    // setpriceconfirm unadded to UML

    private JTextField replenishAmount; // unadded to UML
    private JTextArea changeListTextArea, transacListArea;   

    // NEW ITEM LIST

    private JTable itemListTable;//unadded to UML
    private JScrollPane itemListScrollPane; // unadded to UML
    
    // NEW CHANGE LIST

    private JTable changeListTable; // unadded to UML
    private JScrollPane changeListScrollPane; // unadded to UML

    // CREATE AGAIN MENU

    private JButton regyes, regno, specyes, specno;
	   
    /**
     *  constructor to create an instance of VendingMachineView
     */
    public VendingMachineView(){
        
        
        mainFrame = new JFrame ("Vending Machine Factory");

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        JPanel buttonpanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); 
        
        mainFrame.setLayout(new BorderLayout());

        mainFrame.add(panel, BorderLayout.CENTER);



       // Set the mainFrame's size

       mainFrame.setSize(500, 700);
       panel.setSize(700,800);
        

       mainFrame.setLocationRelativeTo(null);
       mainFrame.setVisible(true);
       
       
       

        // FIRST MENU
        
        nameLbl = new JLabel("Vending Machine Factory");
        nameLbl.setPreferredSize(new Dimension(300,100));
        nameLbl.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(nameLbl);
        
        customizedPrice = new JLabel ("Total price is: ");
        customizedPrice.setVisible(false);
        customizedPrice.setPreferredSize(new Dimension(100,100));
        customizedPrice.setAlignmentX(Component.CENTER_ALIGNMENT);
        customizedCalories = new JLabel("Customized Calories");
        customizedCalories.setVisible(false);
        customizedCalories.setPreferredSize(new Dimension(100,100));
        customizedCalories.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        panel.add(customizedPrice);
        panel.add(customizedCalories);

        panel.add(buttonpanel);
        

        RegVend = new JButton ("Create a Regular Vending Machine");
        SpecVend = new JButton ("Create a Special Vending Machine");
        TestVend = new JButton ("Test Vending Machine");
        

        buttonpanel.add(RegVend);
        buttonpanel.add(SpecVend);
        buttonpanel.add(TestVend);
        
        

        // TEST MENU (VENDING AND MAINTENANCE)

        VendMenu = new JLabel("Choose a mode: ");
        buttonpanel.add(VendMenu);
        VendMenu.setVisible(false);

        VendFeatures = new JButton("Test Vending Features");
        MaintFeatures = new JButton("Test Maintenance Features");

        VendFeatures.setBounds(10, 10, 75, 75);
        MaintFeatures.setBounds(10, 10, 75, 75);
        
        buttonpanel.add(VendFeatures);
        buttonpanel.add(MaintFeatures);
        
        VendFeatures.setVisible(false);
        MaintFeatures.setVisible(false);
        VendFeatures.setEnabled(false);
        MaintFeatures.setEnabled(false);
        
        //CREATE ITEMS PART

        Items = new JLabel("Create at least 8 items for your vending machine");
        ilName = new JLabel("Name: ");
        ilPrice = new JLabel("Price: ");
        ilQuantity = new JLabel("Quantity: ");
        ilCalories = new JLabel("Calories: ");
        ilCategory = new JLabel("Category: ");
        


        panel.add(Items);
        panel.add(ilName);
        
        Items.setVisible(false);
        ilName.setVisible(false);
        ilPrice.setVisible(false);
        ilQuantity.setVisible(false);
        ilCalories.setVisible(false);
        ilCategory.setVisible(false);
        

        iName = new JTextField();
		iName.setColumns(10);
        iPrice = new JTextField();
		iPrice.setColumns(10);
        iQuantity = new JTextField();
		iQuantity.setColumns(10);
        iCalories = new JTextField();
		iCalories.setColumns(10);
        iCategory = new JTextField();
		iCategory.setColumns(10);
  
        String[] categoryOptions = {"Sinker", "Tea Base", "Flavoring", "Milk"};
        category = new JComboBox<String>(categoryOptions);
        category.setMaximumSize(category.getPreferredSize());
        category.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        


        panel.add(iName);
        panel.add(ilPrice);
        panel.add(iPrice);
        panel.add(ilQuantity);
        panel.add(iQuantity);
        panel.add(ilCalories);
        panel.add(iCalories);
        panel.add(ilCategory);
        panel.add(category);


        iName.setVisible(false);
        iName.setEnabled(false);
        iPrice.setVisible(false);
        iPrice.setEnabled(false);
        iQuantity.setVisible(false);
        iQuantity.setEnabled(false);
        iCalories.setVisible(false);
        iCalories.setEnabled(false);
        category.setVisible(false);
        category.setEnabled(false);


        RegSubmit = new JButton("Add Regular Item");
        SpecSubmit = new JButton("Add Special Item");
        SubmitItem = new JButton("Submit");

        RegSubmit.setBounds(10, 10, 60, 60);
        SpecSubmit.setBounds(10, 10, 60, 60);
        SubmitItem.setBounds(10, 10, 60, 60);
        
        RegSubmit.setEnabled(false);
        RegSubmit.setVisible(false);
        SpecSubmit.setEnabled(false);
        SpecSubmit.setVisible(false);
        SubmitItem.setEnabled(false);
        SubmitItem.setVisible(false);

        panel.add(RegSubmit);
        panel.add(SpecSubmit);
        panel.add(SubmitItem);

        RegVend.setAlignmentX(Component.CENTER_ALIGNMENT);
        SpecVend.setAlignmentX(Component.CENTER_ALIGNMENT);
        TestVend.setAlignmentX(Component.CENTER_ALIGNMENT);
        RegSubmit.setAlignmentX(Component.CENTER_ALIGNMENT);
        SpecSubmit.setAlignmentX(Component.CENTER_ALIGNMENT);
        SubmitItem.setAlignmentX(Component.CENTER_ALIGNMENT);
       
        
        // VENDING MENU

        vendingMenuLabel = new JLabel("Vending Features Testing");
        vendingMenuLabel.setVisible(false);
        vendingMenuLabel.setPreferredSize(new Dimension(100,100));
        vendingMenuLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(vendingMenuLabel);

        insertCash = new JButton("Insert Cash");
        selectItem = new JButton("Select Item");
        cancelTransaction = new JButton("Cancel Transaction");
        customizeProduct = new JButton("Customize Product");
        printReceipt = new JButton("Exit");


        insertCash.setVisible(false);
        insertCash.setEnabled(false);
        selectItem.setVisible(false);
        selectItem.setEnabled(false);
        cancelTransaction.setVisible(false);
        cancelTransaction.setEnabled(false);
        customizeProduct.setVisible(false);
        customizeProduct.setEnabled(false);
        printReceipt.setVisible(false);
        printReceipt.setEnabled(false);

        insertCash.setBounds(10, 10, 60, 60);
        selectItem.setBounds(10, 10, 60, 60);
        cancelTransaction.setBounds(10, 10, 60, 60);
        customizeProduct.setBounds(10, 10, 60, 60);
        printReceipt.setBounds(10, 10, 60, 60);
        buttonpanel.add(insertCash);
        buttonpanel.add(selectItem);
        buttonpanel.add(cancelTransaction);
        buttonpanel.add(customizeProduct);
        buttonpanel.add(printReceipt);
        
        // INSERT CASH

        moneyLabel = new JLabel();
        moneyLabel.setVisible(false);
        buttonpanel.add(moneyLabel);
        
        String[] cashChoice = {"1000", "500", "200", "100", "50", "20", "10", "5", "1"};
        denominations = new JComboBox<String>(cashChoice);
        denominations.setMaximumSize(denominations.getPreferredSize());
        denominations.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonpanel.add(denominations);
        denominations.setVisible(false);
        denominations.setEnabled(false);

        confirmCash = new JButton("Insert denomination");
        confirmCash.setVisible(false);
        confirmCash.setEnabled(false);
        buttonpanel.add(confirmCash);
        
        // REPLENISH CHANGE

        replenishAmount = new JTextField();
        replenishAmount.setColumns(10);
        replenishChangeConfirm = new JButton("Replenish denomination");
        replenishChangeConfirm.setVisible(false);
        replenishChangeConfirm.setEnabled(false);
        replenishAmount.setVisible(false);
        replenishAmount.setEnabled(false);
        buttonpanel.add(replenishAmount);
        buttonpanel.add(replenishChangeConfirm);

        // REPLENISH ITEM   
        
        items = new JComboBox<String>();
        items.setMaximumSize(items.getPreferredSize());
        items.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonpanel.add(items);
        items.setVisible(false);
        items.setEnabled(false);

        
        replenishItemConfirm = new JButton("Replenish item");
        replenishItemConfirm.setVisible(false);
        replenishItemConfirm.setEnabled(false);

        buttonpanel.add(replenishItemConfirm);
        
        // SET PRICE

        setPriceConfirm = new JButton("Set Price");
        setPriceConfirm.setVisible(false);
        setPriceConfirm.setEnabled(false);

        buttonpanel.add(setPriceConfirm);

        // NEW ITEM LIST


        String[] columnINames = {"Item Name", "Price", "Quantity", "Calories", "Category"};
        
        Object[][] data = new Object[0][columnINames.length];
        
        DefaultTableModel tableModel = new DefaultTableModel(data, columnINames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Set all cells to non-editable
            }
        };
        
        itemListTable = new JTable(tableModel);
        itemListTable.getTableHeader().setReorderingAllowed(false);
        itemListScrollPane = new JScrollPane(itemListTable);
        panel.add(itemListScrollPane);

        itemListScrollPane.setVisible(false);


            
        // NEW CHANGE LIST

        String[] columnCNames = {"Denomination", "Amount"};
        Object[][] data2 = new Object[0][columnCNames.length];
        DefaultTableModel tableModel2 = new DefaultTableModel(data2, columnCNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Set all cells to non-editable
            }
        };
        changeListTable = new JTable(tableModel2);
        changeListTable.getTableHeader().setReorderingAllowed(false);
        changeListScrollPane = new JScrollPane(changeListTable);
        panel.add(changeListScrollPane);

        changeListScrollPane.setVisible(false);

        // SELECT ITEM
        

        chooseItemLabel = new JLabel("Input item number");
        buttonpanel.add(chooseItemLabel);
        chooseItemLabel.setVisible(false);
        confirmItem = new JButton ("Confirm");
        itemSelect = new JTextField();
        itemSelect.setColumns(10);
        panel.add(itemSelect);
        panel.add(confirmItem);
        itemSelect.setVisible(false);
        itemSelect.setEnabled(false);
        confirmItem.setVisible(false);
        confirmItem.setEnabled(false);
        
        // CUSTOMIZE PRODUCT

        
        custominsertcash = new JButton("Insert Cash");
        custominsertcash.setVisible(false);
        custominsertcash.setEnabled(false);

        customconfirmcash = new JButton("Insert denomination");
        customconfirmcash.setVisible(false);
        customconfirmcash.setEnabled(false);

        buttonpanel.add(custominsertcash);
        buttonpanel.add(customconfirmcash);

        proceedTransaction = new JButton("Proceed and Buy");
        proceedTransaction.setEnabled(false);
        proceedTransaction.setVisible(false);
        buttonpanel.add(proceedTransaction);
        
            // SINKERS

        
        addSinker = new JButton("Add Sinker");
        addSinker.setEnabled(false);
        addSinker.setVisible(false);

        submitSinker = new JButton("Confirm Sinker/s");
        submitSinker.setEnabled(false);
        submitSinker.setVisible(false);

        buttonpanel.add(addSinker);
        buttonpanel.add(submitSinker);
        

            // TEABASES

        submitTeaBase = new JButton("Confirm Teabase");
        submitTeaBase.setEnabled(false);
        submitTeaBase.setVisible(false);

        buttonpanel.add(submitTeaBase);

            // MILKS

        submitMilk = new JButton("Confirm Milk");
        submitMilk.setEnabled(false);
        submitMilk.setVisible(false);

        buttonpanel.add(submitMilk);


            // FLAVORINGS

  

        submitFlavoring = new JButton("Confirm Flavoring");
        submitFlavoring.setEnabled(false);
        submitFlavoring.setVisible(false);

        buttonpanel.add(submitFlavoring);
        

        // MAINTENANCE MENU

        maintenanceMenuLabel = new JLabel("Vending Features Testing");
        maintenanceMenuLabel.setVisible(false);
        maintenanceMenuLabel.setPreferredSize(new Dimension(100,100));
        maintenanceMenuLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(maintenanceMenuLabel);

        displayItemList = new JButton("Display Item List");
        endItemDisplay = new JButton ("Back");
        displayChangeList = new JButton("Display Change List");
        endChangeDisplay = new JButton ("Back");
        replenishItem = new JButton("Replenish Item");
        replenishChange = new JButton("Replenish Change");
        addNewItem = new JButton("Add New Item");
        setPrice = new JButton("Set Price");
        collectPayment = new JButton("Collect Payment");
        printSummary = new JButton("Print Summary");
        endTransactionDisplay = new JButton ("Back");
        endMaintenance = new JButton("End Maintenance Features Test");

        transacListArea = new JTextArea ("");
        transacListArea.setPreferredSize(new Dimension(300,300));
        itemMaintenance = new JTextField();
        itemMaintenance.setColumns(10);
        transacListArea.setEditable(false);
        transacListArea.setVisible(false);

        displayItemList.setVisible(false);
        displayItemList.setEnabled(false);
        endItemDisplay.setVisible(false);
        endItemDisplay.setEnabled(false);

        displayChangeList.setVisible(false);
        displayChangeList.setEnabled(false);
        endChangeDisplay.setVisible(false);
        endChangeDisplay.setEnabled(false);


        replenishItem.setVisible(false);
        replenishItem.setEnabled(false);

        replenishChange.setVisible(false);
        replenishChange.setEnabled(false);

        addNewItem.setVisible(false);
        addNewItem.setEnabled(false);

        setPrice.setVisible(false);
        setPrice.setEnabled(false);
        itemMaintenance.setEnabled(false);
        itemMaintenance.setVisible(false);


        collectPayment.setVisible(false);
        collectPayment.setEnabled(false);

        printSummary.setVisible(false);
        printSummary.setEnabled(false);
        endTransactionDisplay.setVisible(false);
        endTransactionDisplay.setEnabled(false);

        endMaintenance.setVisible(false);
        endMaintenance.setEnabled(false);

        displayItemList.setBounds(10, 10, 60, 60);
        endItemDisplay.setBounds(10, 10, 60, 60);
        displayChangeList.setBounds(10, 10, 60, 60);
        endChangeDisplay.setBounds(10, 10, 60, 60);
        replenishItem.setBounds(10, 10, 60, 60);
        replenishChange.setBounds(10, 10, 60, 60);
        addNewItem.setBounds(10, 10, 60, 60);
        setPrice.setBounds(10, 10, 60, 60);
        collectPayment.setBounds(10, 10, 60, 60);
        printSummary.setBounds(10, 10, 60, 60);
        endTransactionDisplay.setBounds(10, 10, 60, 60);
        endMaintenance.setBounds(10, 10, 60, 60);

        buttonpanel.add(displayItemList);
        buttonpanel.add(endItemDisplay);
        buttonpanel.add(displayChangeList);
        buttonpanel.add(endChangeDisplay);
        buttonpanel.add(replenishItem);
        buttonpanel.add(replenishChange);
        buttonpanel.add(addNewItem);
        buttonpanel.add(setPrice);
        buttonpanel.add(itemMaintenance);
        buttonpanel.add(collectPayment);
        buttonpanel.add(printSummary);
        buttonpanel.add(transacListArea);
        buttonpanel.add(endTransactionDisplay);
        buttonpanel.add(endMaintenance);
        
        // CREATE AGAIN MENU
        
        CreateRegAgainMenu = new JLabel("<html>You have an existing vending machine, do you want to create again? XD <br/></html>");
        CreateSpecAgainMenu = new JLabel("<html>You have an existing vending machine, do you want to create again? XD <br/></html>");
        regyes = new JButton("Yes");
        regno = new JButton("No");
        
        specyes = new JButton("Yes");
        specno = new JButton("No");

        regyes.setVisible(false);
        regyes.setEnabled(false);

        specyes.setVisible(false);
        specyes.setEnabled(false);

        regno.setVisible(false);
        regno.setEnabled(false);

        specno.setVisible(false);
        specno.setEnabled(false);

        CreateRegAgainMenu.setVisible(false);
        CreateSpecAgainMenu.setVisible(false);
  
        

        regyes.setBounds(10, 10, 60, 60);
        regno.setBounds(10, 10, 60, 60);
        specyes.setBounds(10, 10, 60, 60);
        specno.setBounds(10, 10, 60, 60);
        CreateRegAgainMenu.setPreferredSize(new Dimension(300,100));
        CreateSpecAgainMenu.setPreferredSize(new Dimension(300,100));
        
        buttonpanel.add(CreateRegAgainMenu);
        buttonpanel.add(CreateSpecAgainMenu);
        buttonpanel.add(regyes);
        buttonpanel.add(regno);
        buttonpanel.add(specyes);
        buttonpanel.add(specno);
        
        
        

    }

    // FIRST MENU LISTENERS CREATORS

    /**
     * sets an actionlistener for creating regular vending machine
     * @param actionListener is the actionlistener instance for the button
     */
    public void setRegVendBtnListener(ActionListener actionListener) {

		RegVend.addActionListener(actionListener);
        
        
	}
    /**
     * sets an actionlistener for creating special vending machine
     * @param actionListener is the actionlistener instance for the button
     */
    public void setSpecVendBtnListener(ActionListener actionListener) {

	
        SpecVend.addActionListener(actionListener);
        
	}
    /**
     *  sets an actionlistener for testing a vendingmachine
     * @param actionListener is the actionlistener instance for the button
     */

    public void setTestVendBtnListener(ActionListener actionListener) {

		TestVend.addActionListener(actionListener);
        
        
	}

    // TEST MENU LISTENERS CREATORS
    /**
     *  sets an actionlistener for entering the vending options menu
     * @param actionListener is the actionlistener instance for the button
     */

    public void setVendListener(ActionListener actionListener) {

	 VendFeatures.addActionListener(actionListener);
        
        
	}
    /**
     *  sets an actionlistener for entering the maintenance option menu
     * @param actionListener is the actionlistener instance for the button
     */

    public void setMaintListener(ActionListener actionListener) {

		MaintFeatures.addActionListener(actionListener);
        
        
	}
    
    // SUBMIT ITEMS LISTENERS CREATORS
    /**
     *  sets an actionlistener for submitting items in the regular vending machine
     * @param actionListener is the actionlistener instance for the button
     */

    public void setRegSubmitListener(ActionListener actionListener) {

		RegSubmit.addActionListener(actionListener);
        
        
	}
    /**
     *  sets an actionlistener for submitting items in the special vending machine
     * @param actionListener is the actionlistener instance for the button
     */

    public void setSpecSubmitListener(ActionListener actionListener) {

		SpecSubmit.addActionListener(actionListener);
        
        
	}

    /**
     *  sets an actionlistener for exiting the item create menu and entering the first menu
     * @param actionListener is the actionlistener instance for the button
     */
    public void setSubmitBtnListener(ActionListener actionListener){

        SubmitItem.addActionListener(actionListener);

    }

    // VENDING FEATURES LISTENERS CREATORS
    /**
     *  sets an actionlistener for entering the insert cash menu
     * @param actionListener is the actionlistener instance for the button
     */
    public void setInsertCashBtn(ActionListener actionListener){

        
        insertCash.addActionListener(actionListener);
        
    }
    /**
     *  sets an actionlistener for entering the select item menu
     * @param actionListener is the actionlistener instance for the button
     */
    
    public void setSelectItemBtn(ActionListener actionListener){


        selectItem.addActionListener(actionListener);
        
    }
    /**
     *  sets an actionlistener for cancelling a transaction
     * @param actionListener is the actionlistener instance for the button
     */
    public void setCancelTransactionBtn(ActionListener actionListener){


        cancelTransaction.addActionListener(actionListener);
        
    }
    /**
     *  sets an actionlistener for customizing product menu
     * @param actionListener is the actionlistener instance for the button
     */

    public void setCustomizeProductBtn(ActionListener actionListener){


        customizeProduct.addActionListener(actionListener);
        
    }
/**
     *  sets an actionlistener for proceeding with transaction
     * @param actionListener is the actionlistener instance for the button
     */
    public void setProceedTransactionBtn(ActionListener actionListener){


        proceedTransaction.addActionListener(actionListener);
        
    }
    /**
     *  sets an actionlistener for confirming cash during customized item creation
     * @param actionListener is the actionlistener instance for the button
     */

    public void setCustomConfirmCashBtn(ActionListener actionListener){


        customconfirmcash.addActionListener(actionListener);
        
    }

    /**
     *  sets an actionlistener for adding a sinker
     * @param actionListener is the actionlistener instance for the button
     */

    public void setAddSinkerBtn(ActionListener actionListener){


        addSinker.addActionListener(actionListener);
        
    }

    /**
     *  sets an actionlistener for submitting the chosen sinkers
     * @param actionListener is the actionlistener instance for the button
     */
    public void setSubmitSinkerBtn(ActionListener actionListener){


        submitSinker.addActionListener(actionListener);
        
    }
    /**
     *  sets an actionlistener for exiting item display in maintenance
     * @param actionListener is the actionlistener instance for the button
     */
    public void endItemDisplay(ActionListener actionListener){


        endItemDisplay.addActionListener(actionListener);
        
    }
    /**
     *  sets an actionlistener for exiting change display in maintenance
     * @param actionListener is the actionlistener instance for the button
     */
    public void endChangeDisplay(ActionListener actionListener){


        endChangeDisplay.addActionListener(actionListener);
        
    }
    /**
     *  sets an actionlistener for exiting transaction display in maintenance 
     * @param actionListener is the actionlistener instance for the button
     */
    public void endTransactionDisplay(ActionListener actionListener){


        endTransactionDisplay.addActionListener(actionListener);
        
    }
    
    /**
     *  sets an actionlistener for submitting the chosen tea base
     * @param actionListener is the actionlistener instance for the button
     */
    public void setSubmitTeaBaseBtn(ActionListener actionListener){


        submitTeaBase.addActionListener(actionListener);
        
    }
    /**
     *  sets an actionlistener for submitting the chosen flavoring
     * @param actionListener is the actionlistener instance for the button
     */
    public void setSubmitFlavoringBtn(ActionListener actionListener){


        submitFlavoring.addActionListener(actionListener);
        
    }
    /**
     *  sets an actionlistener for submitting the chosen milk
     * @param actionListener is the actionlistener instance for the button
     */
    public void setSubmitMilkBtn(ActionListener actionListener){


        submitMilk.addActionListener(actionListener);
        
    }
    

    /**
     *  sets an actionlistener for printing a receipt
     * @param actionListener is the actionlistener instance for the button
     */
    public void setPrintReceiptBtn(ActionListener actionListener){
            

        printReceipt.addActionListener(actionListener);
        
    }
    


    // MAINTENANCE FEATURES LISTENERS CREATORS
    /**
     *  sets an actionlistener to enter the display item list menu
     * @param actionListener is the actionlistener instance for the button
     */

    public void setDisplayItemListBtn(ActionListener actionListener){

        displayItemList.addActionListener(actionListener);

    }
    /**
     *  sets an actionlistener to enter the display change list menu
     * @param actionListener is the actionlistener instance for the button
     */ 
    public void setDisplayChangeListBtn(ActionListener actionListener){

        displayChangeList.addActionListener(actionListener);

    }
    /**
     *  sets an actionlistener for entering the replenish item menu
     * @param actionListener is the actionlistener instance for the button
     */

    public void setReplenishItemBtn(ActionListener actionListener){

        replenishItem.addActionListener(actionListener);

    }
    /**
     *  sets an actionlistener for entering the replenish change menu
     * @param actionListener is the actionlistener instance for the button
     */

    public void setReplenishChangeBtn(ActionListener actionListener){

        replenishChange.addActionListener(actionListener);

    }
    /**
     *  sets an actionlistener for confirming the change replenish
     * @param actionListener is the actionlistener instance for the button
     */
    public void setReplenishChangeConfirmBtn(ActionListener actionListener){ // unadded to uml, needs javadoc

        replenishChangeConfirm.addActionListener(actionListener);

    }
    /**
     *  sets an actionlistener for confirming the item replenish
     * @param actionListener is the actionlistener instance for the button
     */
    public void setReplenishItemConfirmBtn(ActionListener actionListener){ // unadded to uml, needs javadoc

        replenishItemConfirm.addActionListener(actionListener);

    }
    /**
     *  sets an actionlistener for confirming the item repricing
     * @param actionListener is the actionlistener instance for the button
     */

    public void setSetPriceConfirmBtn(ActionListener actionListener){ // unadded to uml, needs javadoc

        setPriceConfirm.addActionListener(actionListener);

    }

    /**
     *  sets an actionlistener for entering the add new item menu
     * @param actionListener is the actionlistener instance for the button
     */
    
    public void setAddNewItemBtn(ActionListener actionListener){

        addNewItem.addActionListener(actionListener);

    }
    /**
     *  sets an actionlistener for entering the set price me
     * @param actionListener is the actionlistener instance for the button
     */

    public void setSetPriceBtn(ActionListener actionListener){

        setPrice.addActionListener(actionListener);

    }
    /**
     *  sets an actionlistener for collecting money inside vending machine
     * @param actionListener is the actionlistener instance for the button
     */

    public void setCollectPaymentBtn(ActionListener actionListener){

        collectPayment.addActionListener(actionListener);

    }
    /**
     *  sets an actionlistener for printing a summary of purchased items
     * @param actionListener is the actionlistener instance for the button
     */

    public void setPrintSummaryBtn(ActionListener actionListener){

        printSummary.addActionListener(actionListener);

    }
    /**
     *  sets an actionlistener for exiting the maintenance menu and returning to second menu
     * @param actionListener is the actionlistener instance for the button
     */

    public void setEndMaintenanceBtn(ActionListener actionListener){

        endMaintenance.addActionListener(actionListener);

    }
    /**
     *  sets an actionlistener for when yes is clicked when prompted to create a new regular vending machine
     * @param actionListener is the actionlistener instance for the button
     */

    public void setRegYesBtn(ActionListener actionListener){

        regyes.addActionListener(actionListener);

    
    }
    /**
     *  sets an actionlistener for when no is clicked when prompted to create a new regular vending machine
     * @param actionListener is the actionlistener instance for the button
     */
    public void setRegNoBtn(ActionListener actionListener){

        regno.addActionListener(actionListener);

    }
    /**
     *  sets an actionlistener for when yes is clicked when prompted to create a new special vending machine
     * @param actionListener is the actionlistener instance for the button
     */

    public void setSpecYesBtn(ActionListener actionListener){

        specyes.addActionListener(actionListener);

    }
    /**
     *  sets an actionlistener for when yes is clicked when prompted to create a new special vending machine
     * @param actionListener is the actionlistener instance for the button
     */

    public void setSpecNoBtn(ActionListener actionListener){

        specno.addActionListener(actionListener);

    }
    /**
     *  sets an actionlistener for when inserting cash of the chosen denomination
     * @param actionListener is the actionlistener instance for the button
     */

    public void insertCashBtns (ActionListener actionListener){

        confirmCash.addActionListener(actionListener);
        
    }

    public void setCustomInsertCashBtn (ActionListener actionListener){

        custominsertcash.addActionListener(actionListener);
        
    }

   /**
     *  sets an actionlistener for when confirming to purchase the selected item
     * @param actionListener is the actionlistener instance for the button
     */
    public void confirmItemBtn (ActionListener actionListener){
        confirmItem.addActionListener(actionListener);
    }

    /**
     * sets the status of the submit item button
     * @param status determines if they are visible/enabled or not (T/F) 
     */

    public void SubmitItemStatus(boolean status){

        SubmitItem.setEnabled(status);
        SubmitItem.setVisible(status);

    }
    /**
     * sets the status of the first menu
     * @param status determines if they are visible/enabled or not (T/F) 
     */
    public void FirstMenuStatus (boolean status){

        RegVend.setEnabled(status);
        RegVend.setVisible(status);
        SpecVend.setEnabled(status);
        SpecVend.setVisible(status);
        TestVend.setEnabled(status);
        TestVend.setVisible(status);
        nameLbl.setVisible(status);
        
    }
    /**
     * sets the status of the second menu
     * @param status determines if they are visible/enabled or not (T/F) 
     */

    
    public void SecondMenuStatus (boolean status){

        VendMenu.setVisible(status);
        VendFeatures.setVisible(status);
        MaintFeatures.setVisible(status);
        VendFeatures.setEnabled(status);
        MaintFeatures.setEnabled(status);


    }

    /**
     * sets the status of the vending menu
     * @param status determines if they are visible/enabled or not (T/F) 
     */

    
    public void VendingMenuStatus(boolean status){

        vendingMenuLabel.setVisible(status);

        insertCash.setEnabled(status);
        insertCash.setVisible(status);
        
        selectItem.setEnabled(status);
        selectItem.setVisible(status);

        cancelTransaction.setEnabled(status);
        cancelTransaction.setVisible(status);

        customizeProduct.setEnabled(status);
        customizeProduct.setVisible(status);

        printReceipt.setEnabled(status);
        printReceipt.setVisible(status);



    }   


    /**
     * sets the status of the maintenance menu
     * @param status determines if they are visible/enabled or not (T/F) 
     */

    public void MaintMenuStatus(boolean status){

        maintenanceMenuLabel.setVisible(status);

        displayItemList.setEnabled(status);
        displayItemList.setVisible(status);

        displayChangeList.setEnabled(status);
        displayChangeList.setVisible(status);

        replenishItem.setEnabled(status);
        replenishItem.setVisible(status);

        replenishChange.setEnabled(status);
        replenishChange.setVisible(status);

        addNewItem.setEnabled(status);
        addNewItem.setVisible(status);

        setPrice.setEnabled(status);
        setPrice.setVisible(status);

        collectPayment.setEnabled(status);
        collectPayment.setVisible(status);

        printSummary.setEnabled(status);
        printSummary.setVisible(status);

        endMaintenance.setEnabled(status);
        endMaintenance.setVisible(status);

    }

    /**
     * sets the status of the create a regular vending machine again menu
     * @param status determines if they are visible/enabled or not (T/F) 
     */

    public void createRegAgainStatus(boolean status){

        regyes.setEnabled(status);
        regyes.setVisible(status);
        regno.setEnabled(status);
        regno.setVisible(status);
        CreateRegAgainMenu.setVisible(status);

    }

    /**
     * sets the status of the create a special vending machine again menu
     * @param status determines if they are visible/enabled or not (T/F) 
     */

    public void createSpecAgainStatus(boolean status){

        specyes.setEnabled(status);
        specyes.setVisible(status);
        specno.setEnabled(status);
        specno.setVisible(status);
        CreateSpecAgainMenu.setVisible(status);

    }
    /**
     * sets the status of the item submitting menu for regular vending machine
     * @param status determines if they are visible/enabled or not (T/F) 
     */

    public void RegularItemCreate(boolean status){

        Items.setVisible(status);
        ilName.setVisible(status);
        ilPrice.setVisible(status);
        ilQuantity.setVisible(status);
        ilCalories.setVisible(status);
        iName.setVisible(status);
        iName.setEnabled(status);
        iPrice.setVisible(status);
        iPrice.setEnabled(status);
        iQuantity.setVisible(status);
        iQuantity.setEnabled(status);
        iCalories.setVisible(status);
        iCalories.setEnabled(status);
        RegSubmit.setEnabled(status);
        RegSubmit.setVisible(status);
        
    }

    /**
     * sets the status of the item submitting for special vending machine
     * @param status determines if they are visible/enabled or not (T/F) 
     */

    public void SpecialItemCreate(boolean status){

        Items.setVisible(status);
        ilName.setVisible(status);
        ilPrice.setVisible(status);
        ilQuantity.setVisible(status);
        ilCalories.setVisible(status);
        ilCategory.setVisible(status);
        iName.setVisible(status);
        iName.setEnabled(status);
        iPrice.setVisible(status);
        iPrice.setEnabled(status);
        iQuantity.setVisible(status);
        iQuantity.setEnabled(status);
        iCalories.setVisible(status);
        iCalories.setEnabled(status);
        category.setVisible(status);
        category.setEnabled(status);
        SpecSubmit.setEnabled(status);
        SpecSubmit.setVisible(status);

    }

    /**
     * sets the status of the insert cash menu
     * @param status determines if they are visible/enabled or not (T/F) 
     */
    
    public void insertCashState(boolean status){

        confirmCash.setVisible(status);
        confirmCash.setEnabled(status);
        denominations.setVisible(status);
        denominations.setEnabled(status);
        moneyLabel.setVisible(status);
        
    }

    /**
     * sets the status of the insert cash menu in customize product
     * @param status determines if they are visible/enabled or not (T/F) 
     */

    public void custominsertCashState(boolean status){
        
        customconfirmcash.setVisible(status);
        customconfirmcash.setEnabled(status);
        denominations.setVisible(status);
        denominations.setEnabled(status);
        moneyLabel.setVisible(status);
        
    }

    /**
     * sets the status of the replenish change menu
     * @param status determines if they are visible/enabled or not (T/F) 
     */

    public void replenishChangeState(boolean status){ // need javadoc

        replenishAmount.setVisible(status);
        replenishAmount.setEnabled(status);
        replenishChangeConfirm.setVisible(status);
        replenishChangeConfirm.setEnabled(status);
        denominations.setVisible(status);
        denominations.setEnabled(status);
        
    }

    /**
     * sets the status of the replenish item menu
     * @param status determines if they are visible/enabled or not (T/F) 
     */

    public void replenishItemState(boolean status){ // need javadoc

        replenishAmount.setVisible(status);
        replenishAmount.setEnabled(status);
        replenishItemConfirm.setVisible(status);
        replenishItemConfirm.setEnabled(status);
        items.setVisible(status); 
        items.setEnabled(status); 

        

    }
    /**
     * sets the status of the set price menu
     * @param status determines if they are visible/enabled or not (T/F) 
     */

    public void setPriceState(boolean status){ // need javadoc

        replenishAmount.setVisible(status);
        replenishAmount.setEnabled(status);
        setPriceConfirm.setVisible(status);
        setPriceConfirm.setEnabled(status);
        items.setVisible(status); 
        items.setEnabled(status); 
        
        
    }


    /**
     * sets the state for the maintenance feature item text field
     */
    public void itemMaintenanceState (boolean status){
        
        itemMaintenance.setEnabled(status);
        itemMaintenance.setVisible(status);

    }
    /**
     * sets the state for the text field to submit items in
     */
    public void itemSelectState (boolean status){
        itemSelect.setEnabled(status);
        itemSelect.setVisible(status);
    }
    /**
     * sets the status of the select item menu
     * @param status determines if they are visible/enabled or not (T/F) 
     */
    
    public void selectItemState (boolean status){

        chooseItemLabel.setVisible(status);
        itemListScrollPane.setVisible(status);
        itemSelect.setVisible(status);
        itemSelect.setEnabled(status);
        confirmItem.setVisible(status);
        confirmItem.setEnabled(status);
        moneyLabel.setVisible(status);

    }
    /**
     * sets the status for the display transaction list
     * @param status determines if they are visible/enabled or not (T/F)
     */

    public void transacDisplayState (boolean status){
        transacListArea.setVisible (status);
        transacListArea.setEnabled (status);
        endTransactionDisplay.setVisible(status);
        endTransactionDisplay.setEnabled(status);
    }

    /**
     * sets the status of the back buttons
     * @param status determines if they are visible/enabled or not (T/F) 
     */

    public void backButtonsState(boolean status){

        endChangeDisplay.setVisible(status);
        endChangeDisplay.setEnabled(status);
        endItemDisplay.setVisible(status);
        endItemDisplay.setEnabled(status);
        endTransactionDisplay.setVisible(status);
        endTransactionDisplay.setEnabled(status);

    }


    /**
     * sets the status of the item list display
     * @param status determines if they are visible/enabled or not (T/F) 
     */

    public void displaynewItemListState(boolean status){

        itemListScrollPane.setVisible(status);
        endItemDisplay.setVisible(status);
        endItemDisplay.setEnabled(status);

    }

    /**
     * sets the status of the new changelist display
     * @param status determines if they are visible/enabled or not (T/F) 
     */

    public void displaynewChangeListState(boolean status){

        changeListScrollPane.setVisible(status);
        endChangeDisplay.setVisible(status);
        endChangeDisplay.setEnabled(status);
        
    }

    /**
     * sets the status of the new venditemsubmit for special items
     * @param status determines if they are visible/enabled or not (T/F) 
     */

    public void specialVendItemSubmitState (boolean status){
        itemSelect.setVisible(status);
        itemSelect.setEnabled(status);
        itemListScrollPane.setVisible(status);
    }

    /**
     * sets the status of the buttons, and display box for sinkers
     * @param status determines if they are visible/enabled or not (T/F) 
     */
    public void chooseSinkerState(boolean status){
        
        addSinker.setVisible(status);
        addSinker.setEnabled(status);
        submitSinker.setVisible(status); 
        submitSinker.setEnabled(status); 
        
    }
    
    /**
     * sets the status of the buttons, and display box for tea base
     * @param status determines if they are visible/enabled or not (T/F) 
     */
    public void chooseTeaBaseState(boolean status){
        
        submitTeaBase.setVisible(status); 
        submitTeaBase.setEnabled(status);
        itemSelect.setText(""); 
    
        
    }
    /**
     * sets the status of the buttons, and display box for flavorings
     * @param status determines if they are visible/enabled or not (T/F) 
     */
    public void chooseFlavoringState(boolean status){


        submitFlavoring.setVisible(status); 
        submitFlavoring.setEnabled(status); 
        itemSelect.setText(""); 
        itemListScrollPane.setVisible(status);

    }
    /**
     * sets the status of the buttons, and display box for milk
     * @param status determines if they are visible/enabled or not (T/F) 
     */
    public void chooseMilkState(boolean status){

        submitMilk.setVisible(status); 
        submitMilk.setEnabled(status); 
        itemSelect.setText(""); 
        itemSelect.setVisible(status);
        itemSelect.setEnabled(status);
       // jtextfield
        itemListScrollPane.setVisible(status);

    }

    /**
     * sets the state for the customize product menu
     */
    public void customizeProductState(boolean status){
        
        vendingMenuLabel.setVisible(status);
        custominsertcash.setEnabled(status); 
        custominsertcash.setVisible(status);
        cancelTransaction.setEnabled(status);
        cancelTransaction.setVisible(status);
        proceedTransaction.setEnabled(status);
        proceedTransaction.setVisible(status);
        customizedPrice.setVisible(status);
        customizedCalories.setVisible(status);
        
    }

        /**
     * sets the state for the submit sinker button
     */

    public void submitSinkerState(boolean status){
        
        submitSinker.setVisible(status);
        submitSinker.setEnabled(status);
        
    }


    public void addSinkerState(boolean status){
        
        addSinker.setVisible(status);
        addSinker.setEnabled(status);
        
    }



    /**
     * gets the name written in the item submit textfield
     */
    public String getNameTF(){
        return iName.getText();
    }
    /**
     * gets the price written in the item submit textfield
     */
    public String getPriceTF(){
        return iPrice.getText();
    }
    /**
     * gets the quanitity written in the item submit textfield
     */
    public String getQuantityTF(){
        return iQuantity.getText();
    }
    /**
     * gets the calories written in the item submit textfield
     */
    public String getCaloriesTF(){
        return iCalories.getText();
    }
    
    /**
     * gets the amount to be replenished written in the textfield
     */
    public String getReplenishAmountTF(){ // unadded to UML

        return replenishAmount.getText();

    }


    /**
     * clears all the text fields in the submit item menus
     */
    public void clearItemTF (){
        
        iName.setText("");
        iPrice.setText("");
        iQuantity.setText("");
        iCalories.setText("");
        iCategory.setText("");
  

    }
    /**
     * sets the label for the amount of money inserted display
     */
    public void setMoneyLabel(String text){

        moneyLabel.setText(text);

    }
    /**
     * gets the written selected item name in the select item menu
     * @return the selected item name
     */

    public String getItemTF(){

        return itemSelect.getText();

    }

    /**
     * gets the written selected maintenance value in the select item menu
     * @return the selected maintenance value
     */

    public String getItemMaintenanceTF(){

        return itemMaintenance.getText();

    }
    
    /**
     * updates the item combo box
     *
     */

    public void updateItemsComboBox(String[] itemNames) {

        items.removeAllItems();

        for (String itemName : itemNames) {

            items.addItem(itemName);
        }

    }

    
    /**
     * gets the selected denomination value from the drop down menu
     * @return the denomination value
     */

    public String getDenominations(){
         
        String value = String.valueOf(denominations.getSelectedItem());
        
        return value;
        
    }
    /**
     * gets the selected category from the drop down menu
     * 
     * @return the category value
     */
    public String getCategoryDrop(){
         
        String value = String.valueOf(category.getSelectedItem());
        
        return value;
        
    }

    
    /**
     * gets the selected item from the drop down menu
     * 
     * @return the selected item
     */
    public String getItem(){
         
        String value = String.valueOf(items.getSelectedItem());
        
        return value;
        
    }

    /**
     * creates an option pane that says if an item has been dispensed or if transaction has failed
     * @param change is the amount of change returned
     * @param state determines if transaction was successful
     * @param itemName is the dispensed item
     */

    public void dispensePane(int change, boolean state, String itemName){

        if (state == true){
        JOptionPane.showMessageDialog(mainFrame, itemName +" Dispensed!\n Change: " + change);  
        }
        else if (state == false){
        JOptionPane.showMessageDialog(mainFrame,"There is not enough change inside the vending machine.\n Cancelling Transaction...\n Returned: " +change);
        }


    }

    /**
     * creates an option pane that dispenses the customized product
     * @param change is the amount of change returned
     * @param state determines if the transaction was successful
     */
    public void dispenseCustomizedPane(int change, boolean state){

        if (state == true){
        JOptionPane.showMessageDialog(mainFrame, "Milk Tea Dispensed!\n Change: " + change);  
        }
        else if (state == false){
        JOptionPane.showMessageDialog(mainFrame,"There is not enough change inside the vending machine.\n Cancelling Transaction...\n Returned: " + change); 
        }


    }

    /**
     * Shows a popup dialogue box when there is an error input
     * @param result
     */
    public void errorMessagePane(boolean result){
        if (result == false){
            JOptionPane.showMessageDialog(mainFrame, "Add Failed");
        }
    }

    /**
     * Shows a popup dialogue box when collecting payment from vending machine
     * @param total
     */
    public void collectPaymentPane (int total){

        if (total > 0){
            JOptionPane.showMessageDialog(mainFrame, "Collected P" +total);
        }
        else {
            JOptionPane.showMessageDialog(mainFrame, "There is no money in the vending machine yet.");
        }
    }

    /**
     * Shows a popup dialogue box when adding an item for the customizable milk tea
     * @param item
     */

    public void addCategoryPane (String item){

    JOptionPane.showMessageDialog(mainFrame, "Added " + item);

    }

    /**
     * Shows a popup dialogue box when cancelling transaction from vending machine
     * @param total
     */

    public void cancelTransactionPane (int total){

        JOptionPane.showMessageDialog(mainFrame, "Transaction cancelled. \n" +total+ " Returned.");
        
    }
    /**
     * updates the display table that contains the regular item list
     * @param ItemList is an arraylist of Item
     */

    public void updateSpecialItemListTable(ArrayList <ArrayList<Item>> ItemList) {

        DefaultTableModel tableModel = (DefaultTableModel) itemListTable.getModel();

        
        Object[][] data = new Object[ItemList.size()][6];

        for (int i = 0; i < ItemList.size(); i++) {
        
        Item item = ItemList.get(i).get(0);
            

        int quantity = ItemList.get(i).size();

        data[i][0] = i + 1;
        data[i][1] = item.getName();
        data[i][2] = item.getPrice();
        data[i][3] = quantity;
        data[i][4] = item.getCalories();
        data[i][5] = item.getCategory();

        
    }


        tableModel.setDataVector(data, new String[]{"Item Number", "Item Name", "Price", "Quantity", "Calories", "Category"});

    }
    /**
     * updates the display table that contains the special item list
     * 
     * @param ItemList is an arraylist of item
     */
        public void updateRegularItemListTable(ArrayList <ArrayList<Item>> ItemList) {

        DefaultTableModel tableModel = (DefaultTableModel) itemListTable.getModel();

        
        Object[][] data = new Object[ItemList.size()][5];

        for (int i = 0; i < ItemList.size(); i++) {
        
        Item item = ItemList.get(i).get(0);
        
        int quantity = ItemList.get(i).size();

        data[i][0] = i + 1;
        data[i][1] = item.getName();
        data[i][2] = item.getPrice();
        data[i][3] = quantity;
        data[i][4] = item.getCalories();
        
        
        
    }

    

        tableModel.setDataVector(data, new String[]{"Item Number", "Item Name", "Price", "Quantity", "Calories"});

    }


    /**
     * updates the display table holding the amount of change
     * @param changeList is an array of that has the amount of bills per given denomination
     * @param denomList is an array that states the denominations
     */
    

        public void updateChangeListTable(int [] changeList, int [] denomList) {

        DefaultTableModel tableModel = (DefaultTableModel) changeListTable.getModel();

    
        Object[][] data = new Object[changeList.length][2];

        for (int i = 0; i < changeList.length; i++) {

            data[i][0] = denomList[i];
            data[i][1] = changeList[i];


    }

        
        tableModel.setDataVector(data, new String[]{"Denomination", "Amount"});

    }


    /**
     * sets the text inside the transaction list display
     * @param setText is the new text 
     */

    public void setTransactionArea (String setText){
        transacListArea.setText(setText);
    }

    /**
     * sets the text of the total price label
     * @param text is the new text 
     */

    public void setCustomizedPrice (String text){
        customizedPrice.setText(text);
    }

    /**
     * sets the text of the total calories label
     * @param text is the new text 
     */

    public void setCustomizedCalories (String text){

        customizedCalories.setText(text);

    }

    /**
     * sets the text of the vending menu label
     * @param text is the new text 
     */

    public void setVendingMenuLabel (String text){

        vendingMenuLabel.setText(text);

    }

    /**
     * sets the text of the maintenance menu label
     * @param text is the new text 
     */

    public void setMaintenanceMenuLabel(String text){

        maintenanceMenuLabel.setText(text);

    }

    /**
     * dispenses for customized order
     * @param processes is the string that holds all the processes for the customizable product
     */

    public void processDispensePane(String processes){
        
        JOptionPane.showMessageDialog(mainFrame, processes);

    }


}
