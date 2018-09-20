package card;

/**
 * Card class.
 *
 * @author Ziang Lu
 */
public class Card {

    /**
     * PIN of this card.
     */
    private int pin;
    /**
     * Balance of this card.
     */
    private int balance;

    /**
     * Constructor with parameter.
     * @param pin PIN of the card
     * @param balance balance of the card
     */
    public Card(int pin, int balance) {
        if (String.valueOf(pin).length() != 4) {
            throw new RuntimeException("The PIN should be exactly 4 digits.");
        }
        this.pin = pin;
        this.balance = balance;
    }

    /**
     * Checks whether the entered PIN is correct.
     * @param pinEntered entered pin
     * @return whether the entered PIN is correct
     */
    public boolean checkPin(int pinEntered) {
        return pinEntered == pin;
    }

    /**
     * Accessor of balance.
     * @return balance
     */
    public int checkBalance() {
        return balance;
    }

    /**
     * Withdraws the given amount of cash.
     * @param amount amount of cash to withdraw
     */
    public void withdraw(int amount) {
        // Assumption: amount <= balance
        balance -= amount;
    }

    /**
     * Deposits the given amount of cash.
     * @param amount amount of cash to deposit
     */
    public void deposit(int amount) {
        balance += amount;
    }

}
