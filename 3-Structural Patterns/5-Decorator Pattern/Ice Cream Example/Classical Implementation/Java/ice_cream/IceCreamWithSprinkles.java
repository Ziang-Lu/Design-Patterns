package ice_cream;

/**
 * IceCreamWithSprinkles class that works as one kind of "ConcreteDecorator".
 * This class adds (decorates) sprinkles to an IceCream ("Component") object.
 *
 * @author Ziang Lu
 */
public class IceCreamWithSprinkles extends IceCreamDecorator {

    /**
     * Constructor with parameter.
     * @param iceCream ice cream to decorate
     */
    public IceCreamWithSprinkles(IceCream iceCream) {
        super(iceCream);
    }

    @Override
    public IceCream makeIceCream() {
        IceCream original = iceCreamToDecorate.makeIceCream();
        System.out.println("Adding Sprinkles");
        original.addTopping("Sprinkles");
        return original;
    }

}
