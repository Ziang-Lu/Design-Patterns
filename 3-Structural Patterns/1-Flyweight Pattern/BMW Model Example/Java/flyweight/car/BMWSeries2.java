package flyweight.car;

import flyweight.customization.BMWCarCustomization;

/**
 * Concrete BMWSeries2 class.
 * This class first works as "ConcreteFlyweight", pre-defines all the intrinsic
 * states (which are constant and context-independent).
 * After customized with the given extrinsic states (which are NOT constant,
 * context-dependent and needs to be calculated on the fly), this class would
 * work as "UnsharedConcreteFlyweight".
 *
 * @author Ziang Lu
 */
public class BMWSeries2 extends FlyweightBMWCar {

    @Override
    public int calcPrice(BMWCarCustomization customization) {
        // Base Series2 price
        int price = getBasePrice();

        // Add the additional price due to tire size specific to Series2
        if (customization.tireSize() == 19) {
            price += 2000;
        } else {
            price += 3000;
        }

        // Add the additional price due to laser signature length specific to Series2
        int laserSignatureLength = customization.laserSignature().length();
        if (laserSignatureLength > 10) {
            price += 1200;
        } else if (laserSignatureLength > 0) {
            price += 400;
        }
        return price;
    }

    @Override
    protected int getBasePrice() {
        return 28000;
    }

}
