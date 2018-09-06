package vending_machine;

/**
 * Concrete HasMoney that corresponds to the state of the vending machine
 * that some money has been inserted and a product has been selected.
 * This class is implemented as a singleton class.
 *
 * @author Ziang Lu
 */
class HasMoneyState implements VendingMachineState {

    /**
     * Name of this state.
     */
    private static final String STATE_NAME = "Product Selected & Money Inserted";
    /**
     * Singleton instance.
     */
    private volatile static HasMoneyState instance;

    /**
     * Gets the singleton instance.
     * This implementation utilizes Lazy Initialization Pattern and double-check
     * locking mechanism.
     * @return singleton instance
     */
    static HasMoneyState getInstance() {
        if (instance == null) {
            synchronized (HasMoneyState.class) {
                if (instance == null) {
                    instance = new HasMoneyState();
                }
            }
        }
        return instance;
    }

    /**
     * Private default constructor.
     * This has to be private so that the class instances cannot be created
     * outside of the class.
     */
    private HasMoneyState() {}

    @Override
    public void displayState() {
        System.out.println("Current state: " + STATE_NAME);
    }

    @Override
    public void selectProductAndInsertMoney(VendingMachine vendingMachine, int amount, String product) {
        System.out.println("Money already inserted and product already selected.");
        System.out.println("Please wait till it finishes the current dispensing process.");
    }

    @Override
    public void dispenseProduct(VendingMachine vendingMachine) {
        System.out.println("Vending machine dispensing product " + vendingMachine.getSelectedProduct() + "...");
        vendingMachine.setBalance(0);
        vendingMachine.setSelectedProduct(null);

        // Change state to NoMoneyState
        vendingMachine.setState(NoMoneyState.getInstance());
    }

}
