package shape;

/**
 * ShapeInBlue class that works as one kind of "ConcreteDecorator".
 * This class decorates blue color to a Shape ("Component") object.
 *
 * @author Ziang Lu
 */
public class ShapeInBlue extends ShapeDecorator {

    /**
     * Constructor with parameter.
     * @param shape shape to decorate
     */
    public ShapeInBlue(Shape shape) {
        super(shape);
    }

    @Override
    public void draw() {
        shapeToDecorate.draw();
        System.out.println("Color: Blue has been applied to " + shapeToDecorate + ".");
    }

}
