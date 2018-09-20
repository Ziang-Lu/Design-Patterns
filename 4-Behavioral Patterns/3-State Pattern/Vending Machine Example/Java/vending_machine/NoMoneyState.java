package vending_machine;

/**
 * Concrete NoMoneyState that corresponds to the state of the vending machine
 * that no money has been inserted and no product has been selected yet.
 * This class is implemented as a singleton class.
 *
 * @author Ziang Lu
 */
class NoMoneyState implements VendingMachineState {

    /**
     * Singleton instance.
     */
    private volatile static NoMoneyState instance;

    /**
     * Gets the singleton instance.
     * This implementation utilizes Lazy Initialization Pattern and double-check
     * locking mechanism.
     * @return singleton instance
     */
    static NoMoneyState getInstance() {
        if (instance == null) {
            synchronized (NoMoneyState.class) {
                if (instance == null) {
                    instance = new NoMoneyState();
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
    private NoMoneyState() {}

    @Override
    public void displayState() {
        System.out.println("Current state: No Product Selected & No Money Inserted");
    }

    @Override
    public void insertMoneyAndSelectProduct(VendingMachine vendingMachine, int amount, String product) {
        vendingMachine.setBalance(amount);
        vendingMachine.setSelectedProduct(product);
        System.out.println("$" + amount + " has been inserted and " + product + " has been selected...");

        // Change state to HasMoneyState
        vendingMachine.setState(HasMoneyState.getInstance());
    }

    @Override
    public void dispenseProduct(VendingMachine vendingMachine) {
        System.out.println(
                "Vending machine cannot dispense product because no money is inserted and no product is selected.");
    }

}
