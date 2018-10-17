package car;

import visitor.CarPartVisitor;

/**
 * Concrete Light class that works as "ConcreteElement".
 *
 * @author Ziang Lu
 */
public class Light extends CarPart {

    /**
     * Lightness of this light.
     */
    private int lightness;

    /**
     * Constructor with parameter.
     * @param color color of the light
     */
    Light(Color color) {
        super(color);
        lightness = 1;
    }

    @Override
    public void upgrade() {
        ++lightness;
    }

    @Override
    public void accept(CarPartVisitor visitor) {
        visitor.visitLight(this);
    }

    @Override
    public String toString() {
        return "Light{color=" + color + ", lightness=" + lightness + "}";
    }

}
