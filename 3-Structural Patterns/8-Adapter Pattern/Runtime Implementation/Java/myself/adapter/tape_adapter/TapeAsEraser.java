package myself.adapter.tape_adapter;

import friend.Tape;
import myself.Eraser;

/**
 * Concrete TapeAsEraser class that works as "Adapter".
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
class TapeAsEraser implements Eraser {

    /**
     * Reference to the adaptee object.
     */
    private Tape adaptee;

    /**
     * Constructor with parameter.
     * @param tape tape to adapt
     */
    TapeAsEraser(Tape tape) {
        adaptee = tape;
    }

    @Override
    public void erase(String text) {
        adaptee.stickOut(text);
    }

}
