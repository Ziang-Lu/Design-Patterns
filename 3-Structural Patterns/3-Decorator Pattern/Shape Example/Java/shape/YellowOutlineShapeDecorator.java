package shape;

/**
 * YellowOutlineShapeDecorator class that works as one kind of
 * "ConcreteDecorator".
 * This class decorates yellow outline to a Shape ("Component") object.
 *
 * @author Ziang Lu
 */
public class YellowOutlineShapeDecorator extends ShapeDecorator {

    /**
     * Constructor with parameter.
     * @param shape shape to decorate
     */
    public YellowOutlineShapeDecorator(Shape shape) {
        super(shape);
    }

    @Override
    public void draw() {
        shapeToDecorate.draw();
        System.out.println("Outline: Yellow has been applied to " + shapeToDecorate + ".");
    }

}
