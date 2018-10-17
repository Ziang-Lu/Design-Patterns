package car;

import visitor.CarPartVisitor;

/**
 * Concrete Engine class that works as "ConcreteElement".
 *
 * @author Ziang Lu
 */
public class Engine extends CarPart {

    /**
     * Horsepower of this engine.
     */
    private int horsepower;

    /**
     * Constructor with parameter.
     * @param color color of this engine
     */
    Engine(Color color) {
        super(color);
        horsepower = 200;
    }

    @Override
    public void upgrade() {
        horsepower += 50;
    }

    @Override
    public void accept(CarPartVisitor visitor) {
        visitor.visitEngine(this);
    }

    @Override
    public String toString() {
        return "Engine{color=" + color + ", horsepower=" + horsepower + "}";
    }

}
