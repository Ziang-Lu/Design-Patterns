package vending_machine;

/**
 * Vending machine class that actually uses State Pattern.
 *
 * @author Ziang Lu
 */
public class VendingMachine {

    /**
     * Internal state of this vending machine that controls the actual behaviors
     * of this vending machine.
     */
    private VendingMachineState myState;
    /**
     * Current balance in this vending machine.
     */
    private int balance;
    /**
     * Selected product in this vending machine.
     */
    private String selectedProduct;

    /**
     * Default constructor.
     */
    public VendingMachine() {
        myState = NoMoneyState.getInstance();
        balance = 0;
        selectedProduct = null;
    }

    /**
     * Accessor of selectedProduct.
     * @return selectedProduct
     */
    String getSelectedProduct() {
        return selectedProduct;
    }

    /**
     * Mutator of myState.
     * @param state state to set
     */
    void setState(VendingMachineState state) {
        myState = state;
    }

    /**
     * Mutator of balance.
     * @param balance balance to set
     */
    void setBalance(int balance) {
        this.balance = balance;
    }

    /**
     * Mutator of selectedProduct.
     * @param selectedProduct selected product
     */
    void setSelectedProduct(String selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    /**
     * Lets the user inserts some money and select a product.
     * @param amount money to insert
     * @param product product to select
     */
    public void insertMoneyAndSelectProduct(int amount, String product) {
        myState.displayState();
        myState.selectProductAndInsertMoney(this, amount, product);
    }

    /**
     * Dispenses the selected product, and returns balance if any.
     */
    public void dispenseProduct() {
        myState.displayState();
        myState.dispenseProduct(this);
    }

}
