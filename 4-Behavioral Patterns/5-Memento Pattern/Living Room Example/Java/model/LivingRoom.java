package model;

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
     * living room and stores it in the given storage room.
     * @param storageRoom storage room to store memento
     * @param tag tag associated with the created memento
     */
    public void createMementoAndStore(StorageRoom storageRoom, String tag) {
        storageRoom.addMemento(tag, createMemento());
    }

    /**
     * Private helper method to create a memento containing a snapshot of the
     * internal state of this living room.
     * @return created memento
     */
    private Memento createMemento() {
        Memento memento = new Memento(ledTV, sofa);
        System.out.println("Created a memento for Living Room: " + memento);
        return memento;
    }

    /**
     * Restores the internal state of this living room associated with the given
     * tag from the given storage room.
     * @param storageRoom storage room storing the mementos
     * @param tag tag associated with the memento to store
     */
    public void restoreState(StorageRoom storageRoom, String tag) {
        System.out.println("Living Room restoring to " + tag + "...");
        restore(storageRoom.getMemento(tag));
    }

    /**
     * Private helper method to restore the internal state of this living room
     * from the given memento.
     * @param memento memento to restore from
     */
    private void restore(Memento memento) {
        this.ledTV = memento.getLedTV();
        this.sofa = memento.getSofa();
    }

    @Override
    public String toString() {
        return "LivingRoom{ledTV=" + ledTV + ", sofa=" + sofa + "}";
    }

}
