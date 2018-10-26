package prototype;

/**
 * Concrete Square class.
 *
 * @author Ziang Lu
 */
public class Square extends Shape {

    /**
     * Default constructor.
     */
    public Square() {
        super("Square");
    }

    @Override
    public void draw() {
        System.out.println("In Square.draw() method");
    }

    @Override
    public Square clone() throws CloneNotSupportedException {
        return (Square) super.clone();
    }

}
