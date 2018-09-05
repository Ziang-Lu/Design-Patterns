package vending_machine;

/**
 * Abstract VendingMachineState interface that defines the handlers for
 * different requests for the vending machine.
 * Different concrete states implementing this interface will provide different
 * implementations to these handlers to achieve different behaviors of the
 * vending machine based on its state.
 *
 * @author Ziang Lu
 */
public interface VendingMachineState {

    /**
     * Displays this state.
     */
    void displayState();

    /**
     * Lets the user inserts some money and select a product.
     * @param vendingMachine vending machine to operate on
     * @param amount money to insert
     * @param product product to select
     */
    void selectProductAndInsertMoney(VendingMachine vendingMachine, int amount, String product);

    /**
     * Dispenses selected the product, and returns balance if any.
     * @param vendingMachine vending machine to operate on
     */
    void dispenseProduct(VendingMachine vendingMachine);

}
