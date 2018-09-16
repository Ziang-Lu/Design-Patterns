package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Topic class that works as "Composite".
 * The "Composite" models nodes with children in the hierarchical structure.
 * However, since both "Composite" and "Leaf" inherit from the super class
 * "Component", "Composite" does not need to keep track of its children's actual
 * type, but only need to keep track of a collection of the abstract "Component"
 * as its contents.
 * Without the abstract "Component" super class abstraction, "Component" would
 * have to maintain different lists for each kind of element in its contents,
 * and would need to provide separate method for each kind of element.
 *
 * @author Ziang Lu
 */
public class Topic extends Module {

    /**
     * Submodules of this topic.
     */
    private final List<Module> submodules;

    /**
     * Constructor with parameter.
     * @param title title of the topic
     */
    public Topic(String title) {
        super(title);
        submodules = new ArrayList<>();
    }

    @Override
    public void display(String indentLevel) {
        System.out.println(indentLevel + "Topic - " + title);
        for (Module submodule : submodules) {
            submodule.display(indentLevel + indentLevel);
        }
    }

    /**
     * Adds the given module to the submodules of this topic.
     * @param module given module
     */
    public void addModule(Module module) {
        submodules.add(module);
    }

}
