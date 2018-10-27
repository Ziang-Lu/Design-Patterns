package atm;

import card.Card;

/**
 * ATM machine class that actually uses State Pattern.
 *
 * @author Ziang Lu
 */
public class AtmMachine {

    /**
     * Single instance for NoCardState.
     */
    static final AtmState NO_CARD_STATE = new NoCardState();
    /**
     * Single instance for HasCardState.
     */
    static final AtmState HAS_CARD_STATE = new HasCardState();
    /**
     * Single instance for HasCorrectPinState.
     */
    static final AtmState HAS_CORRECT_PIN_STATE = new HasCorrectPinState();

    /**
     * Internal state of this ATM that controls the actual behaviors of this
     * ATM.
     */
    private AtmState myState;
    /**
     * Cash in this ATM.
     */
    private int cash;
    /**
     * Inserted card in this ATM.
     */
    private Card insertedCard;

    /**
     * Default constructor.
     */
    public AtmMachine() {
        myState = NO_CARD_STATE;
        cash = 2000;
        insertedCard = null;
    }

    /**
     * Accessor of cash.
     * @return cash
     */
    int getCash() {
        return cash;
    }

    /**
     * Accessor of insertedCard.
     * @return inserted card
     */
    Card getInsertedCard() {
        return insertedCard;
    }

    /**
     * Mutator of myState.
     * @param state state to set
     */
    void setState(AtmState state) {
        myState = state;
    }

    /**
     * Mutator of cash.
     * @param cash cash to set
     */
    void setCash(int cash) {
        this.cash = cash;
    }

    /**
     * Mutator of inserted card
     * @param card inserted card
     */
    void setCard(Card card) {
        this.insertedCard = card;
    }

    /**
     * Inserts a card.
     * @param card inserted card
     */
    public void insertCard(Card card) {
        myState.insertCard(this, card);
    }

    /**
     * Enters the PIN.
     * @param pinEntered entered pin
     */
    public void enterPin(int pinEntered) {
        myState.enterPin(this, pinEntered);
    }

    /**
     * Checks the balance in the inserted card.
     */
    public void checkBalance() {
        myState.checkBalance(this);
    }

    /**
     * Requests cash from this ATM.
     * @param amount amount of cash to request
     */
    public void requestCash(int amount) {
        myState.requestCash(this, amount);
    }

    /**
     * Deposits cash.
     * @param amount amount of cash to deposit
     */
    public void depositCash(int amount) {
        myState.depositCash(this, amount);
    }

    /**
     * Ejects the card.
     */
    public void ejectCard() {
        myState.ejectCard(this);
    }

}
