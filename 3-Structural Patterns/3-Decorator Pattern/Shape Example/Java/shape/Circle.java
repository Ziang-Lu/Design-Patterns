package shape;

/**
 * Circle class that works as one kind of "ConcreteComponent".
 *
 * @author Ziang Lu
 */
public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Shape: Circle has been drawn.");
    }

    @Override
    public String toString() {
        return "Shape: Circle";
    }

}
