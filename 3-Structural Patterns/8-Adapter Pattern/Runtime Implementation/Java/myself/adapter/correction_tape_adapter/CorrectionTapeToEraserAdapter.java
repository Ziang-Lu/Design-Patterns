package myself.adapter.correction_tape_adapter;

import friend.CorrectionTape;
import myself.Eraser;
import myself.adapter.Adapter;

/**
 * Concrete CorrectionTapeToEraserAdapter class.
 * This class adapts a CorrectionTape object to an Eraser object, where
 * CorrectionTape and Eraser are otherwise independent or incompatible systems.
 *
 * @author Ziang Lu
 */
public class CorrectionTapeToEraserAdapter implements Adapter {

    @Override
    public Eraser adapt(Object correctionTape) {
        return new CorrectionTapeAsEraser((CorrectionTape) correctionTape);
    }

}
