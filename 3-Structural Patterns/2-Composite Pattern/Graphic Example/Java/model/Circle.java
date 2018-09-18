package model;

/**
 * Circle class that works as one kind of "Leaf".
 *
 * @author Ziang Lu
 */
public class Circle extends Graphic {

    /**
     * Constructor with parameter.
     * @param name name of the circle
     */
    public Circle(String name) {
        super(name);
    }

    @Override
    public void draw() {
        drawHelper();
    }

    @Override
    public void translate(int x, int y) {
        translateHelper(x, y);
    }

    @Override
    public void resize(double times) {
        resizeHelper(times);
    }

}
