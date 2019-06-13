package atm;

import card.Card;

/**
 * Concrete HasCorrectPinState that corresponds to the state of the ATM that a
 * card has been inserted and the correct PIN is provided.
 * This class is implemented as a singleton class.
 *
 * @author Ziang Lu
 */
class HasCorrectPinState implements AtmState {

    /**
     * Singleton instance.
     */
    private volatile static HasCorrectPinState instance = null;

    /**
     * Gets the singleton instance.
     * This implementation utilizes Lazy Initialization Pattern and double-check
     * locking mechanism.
     * @return singleton instance
     */
    static HasCorrectPinState getInstance() {
        if (instance == null) {
            synchronized (HasCorrectPinState.class) {
                if (instance == null) {
                    instance = new HasCorrectPinState();
                }
            }
        }
        return instance;
    }

    /**
     * Private default constructor.
     * This has to be private so that class instances cannot be created outside
     * of the class.
     */
    private HasCorrectPinState() {}

    @Override
    public void insertCard(AtmMachine atm, Card card) {
        System.out.println("There is already a card inserted in this ATM");
    }

    @Override
    public void enterPin(AtmMachine atm, int pinEntered) {
        System.out.println("No need to re-enter the PIN");
    }

    @Override
    public void checkBalance(AtmMachine atm) {
        System.out.println("Current balance: $" + atm.getInsertedCard().checkBalance());
    }

    @Override
    public void requestCash(AtmMachine atm, int amount) {
        Card insertedCard = atm.getInsertedCard();
        if (insertedCard.checkBalance() < amount) {
            System.out.println("i");
            return;
        }

        int currCash = atm.getCash();
        if (currCash == 0) {
            System.out.println("Ca");
        } else if (currCash < amount) {
            insertedCard.withdraw(currCash);
            atm.setCash(0);
            System.out.println("No enough cash! Can only withdraw $" + currCash);
        } else {
            insertedCard.withdraw(amount);
            atm.setCash(currCash - amount);
            System.out.println("Successfully withdrew $" + amount);
        }
    }

    @Override
    public void depositCash(AtmMachine atm, int amount) {
        atm.getInsertedCard().deposit(amount);
        atm.setCash(atm.getCash() + amount);
        System.out.println("Successfully deposited $" + amount);
    }

    @Override
    public void ejectCard(AtmMachine atm) {
        atm.setCard(null);
        System.out.println("Thanks for using.");

        // Change to NoCardState
        atm.setState(AtmMachine.NO_CARD_STATE);
    }

}
