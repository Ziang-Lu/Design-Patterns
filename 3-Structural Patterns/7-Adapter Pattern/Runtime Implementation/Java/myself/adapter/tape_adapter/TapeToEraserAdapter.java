package myself.adapter.tape_adapter;

import friend.Tape;
import myself.Eraser;
import myself.adapter.Adapter;

/**
 * Concrete TapeToEraserAdapter class.
 * This class adapts an Tape object to an Eraser object, where Tape and Eraser
 * are otherwise independent or incompatible systems.
 *
 * @author Ziang Lu
 */
public class TapeToEraserAdapter implements Adapter {

    @Override
    public Eraser adapt(Object tape) {
        return new TapeAsEraser((Tape) tape);
    }

}
