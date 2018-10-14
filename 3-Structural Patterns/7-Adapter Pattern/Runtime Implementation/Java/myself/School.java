package myself;

import friend.CorrectionTape;
import friend.InkPen;
import friend.PilotPen;
import friend.Tape;
import myself.adapter.Adapter;
import myself.adapter.AdapterFactory;
import myself.adapter.correction_tape_adapter.CorrectionTapeToEraserAdapter;
import myself.adapter.ink_pen_adapter.InkPenToPenAdapter;
import myself.adapter.pilot_pen_adapter.PilotPenToPenAdapter;
import myself.adapter.tape_adapter.TapeToEraserAdapter;

/**
 * Application that actually uses Adapter Pattern.
 *
 * @author Ziang Lu
 */
public class School {

    /**
     * Main driver.
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        AssignmentWork assignment = new AssignmentWork();

        // Get the adapter factory, and register the adapters in the factory
        AdapterFactory adapterFactory = AdapterFactory.getInstance();
        adapterFactory.registerAdapter(InkPen.class, Pen.class, InkPenToPenAdapter.class);
        adapterFactory.registerAdapter(PilotPen.class, Pen.class, PilotPenToPenAdapter.class);
        adapterFactory.registerAdapter(CorrectionTape.class, Eraser.class, CorrectionTapeToEraserAdapter.class);
        adapterFactory.registerAdapter(Tape.class, Eraser.class, TapeToEraserAdapter.class);

        // AT RUNTIME looks up and get the adapter which is able to adapt an InkPen object to a Pen object
        Adapter inkPenToPenAdapter = adapterFactory.getAdapterFromTo(InkPen.class, Pen.class);
        // Adapts an InkPen object from a friend to a Pen object
        Pen inkPenAsPen = (Pen) inkPenToPenAdapter.adapt(new InkPen());

        assignment.setPen(inkPenAsPen);

        // AT RUNTIME looks up and gets the adapter which is able to adapt an CorrectionTape object to a Eraser object
        Adapter correctionTapeToEraserAdapter = adapterFactory.getAdapterFromTo(CorrectionTape.class, Eraser.class);
        // Adapts an CorrectionTape object from a friend to a Eraser object
        Eraser correctionTapeAsEraser = (Eraser) correctionTapeToEraserAdapter.adapt(new CorrectionTape());

        assignment.setEraser(correctionTapeAsEraser);

        assignment.doAssignment("This is the first line.");
        assignment.eraseAssignment("Erase redundant lines");

        /*
         * Output:
         * 'This is the first line.' is written in Ink Pen.
         * 'Erase redundant lines' is dashed out by Correction Tape.
         */
    }

}
