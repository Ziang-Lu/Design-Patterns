package shape;

/**
 * ShapeInRed class that works as one kind of "ConcreteDecorator".
 * This class decorates red color to a Shape ("Component") object.
 *
 * @author Ziang Lu
 */
public class ShapeInRed extends ShapeDecorator {

    /**
     * Constructor with parameter.
     * @param shape shape to decorate
     */
    public ShapeInRed(Shape shape) {
        super(shape);
    }

    @Override
    public void draw() {
        shapeToDecorate.draw();
        System.out.println("Color: Red has been applied to " + shapeToDecorate + ".");
    }

}
