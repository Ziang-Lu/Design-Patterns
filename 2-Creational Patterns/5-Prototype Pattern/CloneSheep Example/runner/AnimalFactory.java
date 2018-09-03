package runner;

import prototype.Animal;

/**
 * AnimalFactory class that clones abstract animals.
 *
 * @author Ziang Lu
 */
public class AnimalFactory {

    /**
     * Clones the given animal prototype and stores it in its own location in
     * memory.
     * @param prototype animal prototype to clone
     * @return cloned animal
     * @throws CloneNotSupportedException if Animal is not cloneable
     */
    public Animal getClone(Animal prototype) throws CloneNotSupportedException {
        return prototype.clone();
    }

}
