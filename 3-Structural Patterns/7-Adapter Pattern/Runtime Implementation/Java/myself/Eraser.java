package myself;

/**
 * Abstract Eraser interface that works as "Target".
 *
 * By comparing the signatures of erase() method and the
 * CorrectionTape.dashOut()/Tape.stickOut() method, we can find that this
 * interface and the CorrectionTape/Tape are independent or incompatible
 * systems.
 *
 * @author Ziang Lu
 */
public interface Eraser {

    /**
     * Erases the given text using this eraser.
     * @param text text to erase
     */
    void erase(String text);

}
