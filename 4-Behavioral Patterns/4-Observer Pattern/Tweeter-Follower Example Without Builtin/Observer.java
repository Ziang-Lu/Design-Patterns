/**
 * Abstract Obverser class.
 *
 * @author Ziang Lu
 */
public abstract class Observer {

    /**
     * Name of this observer.
     */
    protected final String name;

    /**
     * Constructor with parameter.
     * @param name name of the observer
     */
    public Observer(String name) {
        this.name = name;
    }

    public abstract void update();

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Observer)) {
            return false;
        }
        Observer anotherObserver = (Observer) o;
        return name.equals(anotherObserver.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

}
