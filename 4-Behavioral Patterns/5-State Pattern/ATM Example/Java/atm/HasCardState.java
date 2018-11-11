package atm;

import card.Card;

/**
 * Concrete HasCardState that corresponds to the state of the ATM that a card
 * has been inserted.
 *
 * @author Ziang Lu
 */
class HasCardState implements AtmState {

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
