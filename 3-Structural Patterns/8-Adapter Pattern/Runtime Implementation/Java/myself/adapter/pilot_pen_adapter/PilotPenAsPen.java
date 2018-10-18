package myself.adapter.pilot_pen_adapter;

import friend.PilotPen;
import myself.Pen;

/**
 * Concrete PilotPenAsPen class that works as "Adapter".
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
class PilotPenAsPen implements Pen {

    /**
     * Reference to the adaptee object.
     */
    private PilotPen adaptee;

    /**
     * Constructor with parameter.
     * @param pilotPen pilot pen to adapt
     */
    PilotPenAsPen(PilotPen pilotPen) {
        adaptee = pilotPen;
    }

    @Override
    public void write(String text) {
        adaptee.mark(text);
    }

}
