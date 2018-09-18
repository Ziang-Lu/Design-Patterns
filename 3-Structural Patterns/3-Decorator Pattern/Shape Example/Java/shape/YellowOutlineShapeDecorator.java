package shape;

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
        System.out.println("Outline: Yellow has been applied to " + shapeToDecorate);
    }

}
