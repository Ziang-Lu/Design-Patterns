package myself.adapter.ink_pen_adapter;

import friend.InkPen;
import myself.Pen;
import myself.adapter.Adapter;

/**
 * Concrete InkPenToPenAdapter class.
 * This class adapts an InkPen object to a Pen object, where InkPen and Pen are
 * otherwise independent or incompatible systems.
 *
 * @author Ziang Lu
 */
public class InkPenToPenAdapter implements Adapter {

    @Override
    public Pen adapt(Object inkPen) {
        return new InkPenAsPen((InkPen) inkPen);
    }

}
