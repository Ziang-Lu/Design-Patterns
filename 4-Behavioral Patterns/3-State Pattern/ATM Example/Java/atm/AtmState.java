package atm;

import card.Card;

/**
 * Abstract AtmState interface that defines all the handlers for different
 * requests for the ATM machine.
 * Different concrete states implementing this interface will provide different
 * implementations to these handlers to achieve different behaviors of the ATM
 * based on its state.
 *
 * @author Ziang Lu
 */
interface AtmState {

    /**
     * Inserts a card.
     * @param atm ATM to operate on
     * @param card inserted card
     */
    void insertCard(AtmMachine atm, Card card);

    /**
     * Enters the PIN.
     * @param atm ATM to operate on
     * @param pinEntered entered pin
     */
    void enterPin(AtmMachine atm, int pinEntered);

    /**
     * Checks the balance for the inserted card.
     * @param atm ATM to operate on
     */
    void checkBalance(AtmMachine atm);

    /**
     * Requests cash from the given ATM.
     * @param atm ATM to operate on
     * @param amount amount of cash to request
     */
    void requestCash(AtmMachine atm, int amount);

    /**
     * Deposits cash.
     * @param atm ATM to operate on
     * @param amount amount of cash to deposit
     */
    void depositCash(AtmMachine atm, int amount);

    /**
     * Ejects the card.
     * @param atm ATM to operate on
     */
    void ejectCard(AtmMachine atm);

}
