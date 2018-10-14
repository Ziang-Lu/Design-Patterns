package myself.adapter.ink_pen_adapter;

import friend.InkPen;
import myself.Pen;

/**
 * Concrete InkPenAsPen class that works as "Adapter".
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
class InkPenAsPen implements Pen {

    /**
     * Reference to the adaptee object.
     */
    private InkPen adaptee;

    /**
     * Constructor with parameter.
     * @param inkPen ink pen to adapt
     */
    InkPenAsPen(InkPen inkPen) {
        adaptee = inkPen;
    }

    @Override
    public void write(String text) {
        adaptee.ink(text);
    }

}
