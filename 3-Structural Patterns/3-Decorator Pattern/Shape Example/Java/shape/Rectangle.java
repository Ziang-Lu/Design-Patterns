package shape;

/**
 * Rectangle class that works as one kind of "ConcreteComponent".
 *
 * @author Ziang Lu
 */
public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Shape: Rectangle has been drawn.");
    }

    @Override
    public String toString() {
        return "Shape: Rectangle";
    }

}
