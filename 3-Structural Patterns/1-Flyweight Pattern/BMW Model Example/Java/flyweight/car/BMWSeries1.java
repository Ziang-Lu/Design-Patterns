package flyweight.car;

import flyweight.customization.BMWCarCustomization;

/**
 * Concrete BMWSeries1 class.
 * This class first works as "ConcreteFlyweight", pre-defines all the intrinsic
 * states (which are constant and context-independent).
 * After customized with the given extrinsic states (which are NOT constant,
 * context-dependent and needs to be calculated on the fly), this class would
 * work as "UnsharedConcreteFlyweight".
 *
 * @author Ziang Lu
 */
public class BMWSeries1 extends FlyweightBMWCar {

    @Override
    public int calcPrice(BMWCarCustomization customization) {
        // Base Series1 price
        int price = getBasePrice();

        // Add the additional price due to tire size specific to Series1
        if (customization.tireSize() == 19) {
            price += 1200;
        } else {
            price += 2100;
        }

        // Add the additional price due to laser signature length specific to Series1
        if (customization.laserSignature().length() > 0) {
            price += 987;
        }
        return price;
    }

    @Override
    protected int getBasePrice() {
        return 25000;
    }

}
