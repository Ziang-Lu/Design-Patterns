package myself.adapter.correction_tape_adapter;

import friend.CorrectionTape;
import myself.Eraser;

/**
 * Concrete CorrectionTapeAsEraser class that works as "Adapter".
 *
 * Note that in this implementations, we uses Object Adapter:
 * - Since we cannot change the "Target" interface, in order to keep the
 *   original API, we create an "Adapter" class that implements the "Target"
 *   interface.
 * - In order to make the "Target" interface and the "Adaptee" work together, in
 *   the "Adapter" class, we simply keep a referent to the "Adaptee" object, and
 *   delegate the request from the client to this "Adaptee" object.
 *
 * @author Ziang Lu
 */
class CorrectionTapeAsEraser implements Eraser {

    /**
     * Reference to the adaptee object.
     */
    private CorrectionTape adaptee;

    /**
     * Constructor with parameter.
     * @param correctionTape correction tape to adapt
     */
    CorrectionTapeAsEraser(CorrectionTape correctionTape) {
        adaptee = correctionTape;
    }

    @Override
    public void erase(String text) {
        adaptee.dashOut(text);
    }

}
