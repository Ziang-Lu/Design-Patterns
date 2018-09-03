package prototype;

/**
 * Concrete Sheep animal class.
 *
 * @author Ziang Lu
 */
public class Sheep extends AnimalPrototype {

    /**
     * Default constructor.
     */
    public Sheep() {
        System.out.println("A sheep is made.");
    }

    @Override
    public Sheep clone() throws CloneNotSupportedException {
        System.out.println("A cloned sheep is made.");
        return (Sheep) super.clone();
    }

    @Override
    public String toString() {
        return "Hi! I'm a sheep!";
    }

}
