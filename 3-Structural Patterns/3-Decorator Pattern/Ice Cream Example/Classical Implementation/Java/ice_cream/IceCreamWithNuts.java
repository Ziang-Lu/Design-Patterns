package ice_cream;

/**
 * IceCreamWithNuts class that works as one kind of "ConcreteDecorator".
 * This class adds (decorates) nuts to an IceCream ("Component") object.
 *
 * @author Ziang Lu
 */
public class IceCreamWithNuts extends IceCreamDecorator {

    /**
     * Constructor with parameter.
     * @param iceCream ice cream to decorate
     */
    public IceCreamWithNuts(IceCream iceCream) {
        super(iceCream);
    }

    @Override
    public IceCream makeIceCream() {
        IceCream original = iceCreamToDecorate.makeIceCream();
        System.out.println("Adding Nuts");
        original.addTopping("Nuts");
        return original;
    }

}
