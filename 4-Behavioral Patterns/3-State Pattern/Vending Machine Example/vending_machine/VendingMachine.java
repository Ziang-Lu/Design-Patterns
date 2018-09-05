package vending_machine;

/**
 * Vending machine class that actually uses State Pattern.
 *
 * @author Ziang Lu
 */
public class VendingMachine {

    /**
     * ID of this vending machine.
     */
    private int id;
    /**
     * Internal state of this vending machine that controls the actual behaviors
     * of this vending machine.
     */
    private VendingMachineState myState;

    /**
     * Constructor with parameter.
     * @param id ID of the vending machine
     */
    public VendingMachine(int id) {
        this.id = id;
        myState = NoMoneyState.getInstance();
    }

    /**
     * Mutator of myState.
     * @param state state to set
     */
    public void setState(VendingMachineState state) {
        myState = state;
    }

    /**
     * Lets the user inserts some money and select a product.
     * @param amount money to insert
     * @param product product to select
     */
    public void insertMoneyAndSelectProduct(int amount, String product) {
        myState.displayState();

        this.myState.selectProductAndInsertMoney(amount, product);
        setState(HasMoneyState.getInstance());
    }

    /**
     * Dispenses the selected product, and returns balance if any.
     */
    public void dispenseProduct() {
        myState.displayState();

        this.myState.dispenseProduct();
        setState(NoMoneyState.getInstance());
    }

}
