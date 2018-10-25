package model;

import java.util.ArrayList;
import java.util.List;

/**
 * GraphicComposite class that works as "Composite".
 * The "Composite" models nodes with children in the hierarchical structure.
 * However, since both "Composite" and "Leaf" inherit from the common super
 * class "Component", "Composite" does not need to keep track of its children's
 * actual type, but only need to keep track of a collection of the abstract
 * "Component" as its contents.
 * Without the abstract "Component" super class abstraction, "Component" would
 * have to maintain different lists for each kind of element in its contents,
 * and would need to provide separate method for each kind of element.
 *
 * @author Ziang Lu
 */
public class GraphicComposite extends Graphic {

    /**
     * Sub-graphics of this shape composite.
     */
    private List<Graphic> subGraphics;

    /**
     * Constructor with parameter.
     * @param name name of the graphic composite
     */
    public GraphicComposite(String name) {
        super(name);
        subGraphics = new ArrayList();
    }

    @Override
    public void draw() {
        System.out.println("Drawing " + name + " as follows:");
        for (Graphic subGraphic : subGraphics) {
            subGraphic.draw();
        }
    }

    @Override
    public void translate(int x, int y) {
        System.out.println("Translating " + name + " as follows:");
        for (Graphic subGraphic : subGraphics) {
            subGraphic.translate(x, y);
        }
    }

    @Override
    public void resize(double times) {
        System.out.println("Resizing " + name + " as follows:");
        for (Graphic subGraphic : subGraphics) {
            subGraphic.resize(times);
        }
    }

    /**
     * Adds the given graphic to the sub-graphics of this graphic composite.
     * @param graphic given graphic
     */
    public void addGraphic(Graphic graphic) {
        subGraphics.add(graphic);
    }

}
