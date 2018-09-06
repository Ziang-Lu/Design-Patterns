package atm;

import card.Card;

/**
 * Concrete NoCardState that corresponds to the state of the ATM that a card
 * has been inserted and the correct PIN is provided.
 *
 * @author Ziang Lu
 */
public class HasCorrectPinState implements AtmState {

    @Override
    public void loadCash(AtmMachine atm, int amount) {
        System.out.println("Cannot load cash during usage of this ATM");
    }

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
            System.out.println("No enough balance in the card!");
            return;
        }

        int currCash = atm.getCash();
        if (currCash == 0) {
            System.out.println("There is no cash in this ATM");
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
