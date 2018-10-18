package myself.adapter.pilot_pen_adapter;

import friend.PilotPen;
import myself.Pen;
import myself.adapter.Adapter;

/**
 * Concrete PilotPenToPenAdapter class.
 * This class adapts a PilotPen object to a Pen object, where PilotPen and Pen
 * are otherwise independent or incompatible systems.
 *
 * @author Ziang Lu
 */
public class PilotPenToPenAdapter implements Adapter {

    @Override
    public Pen adapt(Object pilotPen) {
        return new PilotPenAsPen((PilotPen) pilotPen);
    }

}
