package runner;

import prototype.AnimalFactory;
import prototype.Sheep;

/**
 * Application that actually makes use of Prototype Pattern.
 *
 * @author Ziang Lu
 */
public class Application {

    /**
     * Main driver.
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        AnimalFactory animalFactory = new AnimalFactory();
        Sheep sally = new Sheep();

        Sheep clonedSally = null;
        try {
            clonedSally = (Sheep) animalFactory.getClone(sally);
        } catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
        }

        System.out.println(sally);
        System.out.println(clonedSally);

        // Check their hash codes, which usually hash from the corresponding memory location, to make sure the two
        // objects are in different memory locations
        System.out.println("Sally's hash code: " + System.identityHashCode(sally));
        System.out.println("Cloned Sally's hash code: " + System.identityHashCode(clonedSally));

        /*
         * Output:
         * A sheep is made.
         * A cloned sheep is made.
         * Hi! I'm a sheep!
         * Hi! I'm a sheep!
         * Sally's hash code: 959447386
         * Cloned Sally's hash code: 757108857
         */
    }

}
