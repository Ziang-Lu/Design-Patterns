/**
 * Concrete Tweeter class working as "Subject".
 *
 * @author Ziang Lu
 */
public class Tweeter extends Subject {

    /**
     * Constructor with parameter.
     * @param name name of the tweeter
     */
    public Tweeter(String name) {
        super(name);
    }

    /**
     * Writes a new Tweeter.
     */
    public void writeTweeter() {
        System.out.println(name + " -> I wrote a new Tweeter!");
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : myObservers) {
            observer.update();
        }
    }

}
