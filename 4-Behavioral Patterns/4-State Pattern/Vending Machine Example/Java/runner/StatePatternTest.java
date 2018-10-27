package runner;

import vending_machine.VendingMachine;

/**
 * Application.
 *
 * @author Ziang Lu
 */
public class StatePatternTest {

    /**
     * Main driver.
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();

        vendingMachine.dispenseProduct();
        System.out.println();

        vendingMachine.insertMoneyAndSelectProduct(3, "Pepsi");
        System.out.println();

        vendingMachine.insertMoneyAndSelectProduct(3, "Fanta");
        System.out.println();
        vendingMachine.dispenseProduct();

        /*
         * Output:
         * Current state: No Product Selected & No Money Inserted
         * Vending machine cannot dispense product because no money is inserted and no product is selected.
         *
         * Current state: No Product Selected & No Money Inserted
         * $3 has been inserted and Pepsi has been selected...
         *
         * Current state: Product Selected & Money Inserted
         * Money already inserted and product already selected.
         * Please wait till it finishes the current dispensing process.
         *
         * Current state: Product Selected & Money Inserted
         * Vending machine dispensing product Pepsi...
         */
    }

}
