package atm;

import card.Card;

/**
 * Concrete NoCardState that corresponds to the state of the ATM that no card
 * has been inserted yet.
 *
 * @author Ziang Lu
 */
class NoCardState implements AtmState {

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
