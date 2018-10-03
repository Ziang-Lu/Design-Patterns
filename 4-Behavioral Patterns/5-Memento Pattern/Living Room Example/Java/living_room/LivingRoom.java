package living_room;

/**
 * LivingRoom class that works as "Originator".
 *
 * @author Ziang Lu
 */
public class LivingRoom {

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
        System.out.println("Created a memento for Living Room: " + memento);
        return memo;
    }

    /**
     * Restores the internal state of this living room from the given memento.
     * @param memo memento to restore from
     */
    public void restore(Memento memo) {
        this.ledTV = memo.getLedTV();
        this.sofa = memo.getSofa();
    }

    @Override
    public String toString() {
        return "LivingRoom{ledTV=" + ledTV + ", sofa=" + sofa + "}";
    }

}
