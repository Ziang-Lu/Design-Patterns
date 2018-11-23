package atm;

import card.Card;

/**
 * Concrete NoCardState that corresponds to the state of the ATM that no card
 * has been inserted yet.
 * This class is implemented as a singleton class.
 *
 * @author Ziang Lu
 */
class NoCardState implements AtmState {

    /**
     * Singleton instance.
     */
    private volatile static NoCardState instance = null;

    /**
     * Gets the singleton instance.
     * This implementation utilizes Lazy Initialization Pattern and double-check
     * locking mechanism.
     * @return singleton instance
     */
    static NoCardState getInstance() {
        NoCardState localRef = instance;
        if (localRef == null) {
            synchronized (NoCardState.class) {
                if (localRef == null) {
                    instance = localRef = new NoCardState();
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
    private NoCardState() {}

    @Override
    public void insertCard(AtmMachine atm, Card card) {
        atm.setCard(card);

        // Change state to HasCardState
        atm.setState(AtmMachine.HAS_CARD_STATE);
    }

    @Override
    public void enterPin(AtmMachine atm, int pinEntered) {
        System.out.println("Please insert the card first");
    }

    @Override
    public void checkBalance(AtmMachine atm) {
        System.out.println("Please insert the card first");
    }

    @Override
    public void requestCash(AtmMachine atm, int amount) {
        System.out.println("Please insert the card first");
    }

    @Override
    public void depositCash(AtmMachine atm, int amount) {
        System.out.println("Please insert the card first");
    }

    @Override
    public void ejectCard(AtmMachine atm) {
        System.out.println("Please insert the card first");
    }

}
