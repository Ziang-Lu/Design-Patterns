package car;

import visitor.CarPartVisitor;

/**
 * Concrete Wheel class that works as "ConcreteElement".
 *
 * @author Ziang Lu
 */
public class Wheel extends CarPart {

    /**
     * Level of this wheel.
     */
    private int level;

    /**
     * Constructor with parameter.
     * @param color color of the wheel
     */
    Wheel(Color color) {
        super(color);
        level = 1;
    }

    @Override
    public void upgrade() {
        ++level;
    }

    @Override
    public void accept(CarPartVisitor visitor) {
        visitor.visitWheel(this);
    }

    @Override
    public String toString() {
        return "Wheel{color=" + color + ", level=" + level + "}";
    }

}
