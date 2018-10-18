package model;

/**
 * Rectangle class that works as one kind of "Leaf".
 *
 * @author Ziang Lu
 */
public class Rectangle extends Graphic {

    /**
     * Constructor with parameter.
     * @param name name of the rectangle
     */
    public Rectangle(String name) {
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
