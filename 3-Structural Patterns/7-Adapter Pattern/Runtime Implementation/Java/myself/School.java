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
        Adapter inkPenAdapter = adapterFactory.getAdapterFromTo(InkPen.class, Pen.class);
        // Adapts an InkPen object from a friend to a Pen object
        Pen inkPenAsPen = (Pen) inkPenAdapter.adapt(new InkPen());

        assignment.setPen(inkPenAsPen);

        // AT RUNTIME looks up and gets the adapter which is able to adapt a CorrectionTape object to an Eraser object
        Adapter correctionTapeAdapter = adapterFactory.getAdapterFromTo(CorrectionTape.class, Eraser.class);
        // Adapts a CorrectionTape object from a friend to an Eraser object
        Eraser correctionTapeAsEraser = (Eraser) correctionTapeAdapter.adapt(new CorrectionTape());

        assignment.setEraser(correctionTapeAsEraser);

        assignment.doAssignment("This is the first line.");
        assignment.eraseContent("Erase redundant contents");

        /*
         * Output:
         * 'This is the first line.' is written in Ink Pen.
         * 'Erase redundant contents' is dashed out by Correction Tape.
         */
    }

}
