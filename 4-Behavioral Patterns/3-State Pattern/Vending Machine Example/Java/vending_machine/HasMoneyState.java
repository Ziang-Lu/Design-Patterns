package vending_machine;

/**
 * Concrete HasMoneyState that corresponds to the state of the vending machine
 * that some money has been inserted and a product has been selected.
 * This class is implemented as a singleton class.
 *
 * @author Ziang Lu
 */
class HasMoneyState implements VendingMachineState {

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
        System.out.println("Current state: Product Selected & Money Inserted");
    }

    @Override
    public void insertMoneyAndSelectProduct(VendingMachine vendingMachine, int amount, String product) {
        System.out.println("Money already inserted and product already selected.");
        System.out.println("d");
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
