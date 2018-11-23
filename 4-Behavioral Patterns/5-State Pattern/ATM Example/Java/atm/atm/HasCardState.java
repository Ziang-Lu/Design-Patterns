package atm;

import card.Card;

/**
 * Concrete HasCardState that corresponds to the state of the ATM that a card
 * has been inserted.
 * This class is implemented as a singleton class.
 *
 * @author Ziang Lu
 */
class HasCardState implements AtmState {

    /**
     * Singleton instance.
     */
    private volatile static HasCardState instance = null;

    /**
     * Gets the singleton instance.
     * This implementation utilizes Lazy Initialization Pattern and double-check
     * locking mechanism.
     * @return singleton instance
     */
    static HasCardState getInstance() {
        HasCardState localRef = instance;
        if (localRef == null) {
            synchronized (HasCardState.class) {
                if (localRef == null) {
                    instance = localRef = new HasCardState();
                }
            }
        }
        return localRef;
    }

    /**
     * Private default constructor.
     * This has to be private so that class instances cannot be created outside
     * of the class.
     */
    private HasCardState() {}

    @Override
    public void insertCard(AtmMachine atm, Card card) {
        System.out.println("There is already a card inserted in this ATM");
    }

    @Override
    public void enterPin(AtmMachine atm, int pinEntered) {
        boolean correctPin = atm.getInsertedCard().checkPin(pinEntered);
        if (!correctPin) {
            System.out.println("Incorrect PIN!");
            return;
        }

        // Change to HasCorrectPinState
        atm.setState(AtmMachine.HAS_CORRECT_PIN_STATE);
    }

    @Override
    public void checkBalance(AtmMachine atm) {
        System.out.println("Please first correctly enter the PIN");
    }

    @Override
    public void requestCash(AtmMachine atm, int amount) {
        System.out.println("Please first correctly enter the PIN");
    }

    @Override
    public void depositCash(AtmMachine atm, int amount) {
        System.out.println("Please first correctly enter the PIN");
    }

    @Override
    public void ejectCard(AtmMachine atm) {
        atm.setCard(null);
        System.out.println("Thanks for using.");

        // Change to NoCardState
        atm.setState(AtmMachine.NO_CARD_STATE);
    }

}
