package living_room;

/**
 * LivingRoom class that works as "Originator".
 *
 * @author Ziang Lu
 */
public class LivingRoom {

    /**
     * Memento class.
     * This class holds a snapshot of the internal state of the "Originator".
     * This is like a wrapper (a packing box) for the internal state of the
     * "Originator" to be stored.
     */
    private static class Memento implements IMemento {
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

    /**
     * LED TV in this living room.
     */
    private LedTV ledTV;
    /**
     * Sofa in this living room.
     */
    private Sofa sofa;

    /**
     * Mutator of ledTV.
     * @param ledTV LED TV to set
     */
    public void setLedTV(LedTV ledTV) {
        this.ledTV = ledTV;
    }

    /**
     * Mutator of sofa.
     * @param sofa sofa to set
     */
    public void setSofa(Sofa sofa) {
        this.sofa = sofa;
    }

    /**
     * Creates a memento containing a snapshot of the internal state of this
     * living room.
     * @return created memento
     */
    public Memento createMemento() {
        Memento memo = null;
        try {
            memo = new Memento(ledTV.clone(), sofa.clone());
        } catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
        }
        System.out.println("Created a memento for Living Room: " + memo);
        return memo;
    }

    /**
     * Restores the internal state of this living room from the given memento.
     * @param memo memento to restore from
     */
    public void restore(IMemento memo) {
        Memento memento = (Memento) memo;
        this.ledTV = memento.getLedTV();
        this.sofa = memento.getSofa();
    }

    @Override
    public String toString() {
        return "LivingRoom{ledTV=" + ledTV + ", sofa=" + sofa + "}";
    }

}
