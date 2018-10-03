package living_room;

/**
 * Memento class.
 * This class holds a snapshot of the internal state of the "Originator".
 * This is like a wrapper (a packing box) for the internal state of the
 * "Originator" to be stored.
 *
 * @author Ziang Lu
 */
public class Memento {

    /**
     * Stored LED TV.
     */
    private LedTV ledTV;
    /**
     * Stored Sofa object.
     */
    private Sofa sofa;

    /**
     * Constructor with parameter.
     * @param ledTV LED TV to store
     * @param sofa sofa to store
     */
    Memento(LedTV ledTV, Sofa sofa) {
        this.ledTV = ledTV;
        this.sofa = sofa;
    }

    /**
     * Accessor of ledTV.
     * @return ledTV
     */
    LedTV getLedTV() {
        return ledTV;
    }

    /**
     * Accessor of sofa.
     * @return sofa
     */
    Sofa getSofa() {
        return sofa;
    }

    @Override
    public String toString() {
        return "Memento [ledTV=" + ledTV + ", sofa=" + sofa + "]";
    }

}
