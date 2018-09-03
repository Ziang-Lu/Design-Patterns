package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Topic class working as "Composite".
 *
 * @author Ziang Lu
 */
public class Topic extends Module {

    /**
     * Genre of this module.
     */
    private static final String GENRE = "Topic - ";

    /**
     * Submodules of this topic.
     */
    private final List<Module> submodules;

    /**
     * Constructor with parameter.
     * @param name name of the topic
     */
    public Topic(String name) {
        super(name);
        submodules = new ArrayList<>();
    }

    /**
     * Accessor of name.
     * @return name
     */
    public String getName() {
        return name;
    }

    @Override
    public void display(String indentLevel) {
        System.out.println(indentLevel + GENRE + " " + name);
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
