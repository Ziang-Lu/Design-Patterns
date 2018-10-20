package runner;

import flyweight.FlyweightBMWCarFactory;
import flyweight.car.FlyweightBMWCar;
import flyweight.customization.BMWCarCustomization;

/**
 * Application that actually uses Flyweight Pattern.
 *
 * @author Ziang Lu
 */
public class FlyweightPatternTest {

    /**
     * Main driver.
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        FlyweightBMWCarFactory flyweightBMWCarFactory = FlyweightBMWCarFactory.getInstance();

        /*
         * In real-world production, we need to create a large number of objects of similar nature, which would have
         * consumed a large, unaccepted amount of memory and decrease the performance.
         *
         * By using Flyweight Pattern, we first get the shared "ConcreteFlyweight" from the "FlyweightFactory", and then
         * customize it to get the "UnsharedConcreteFlyweight" we desire.
         * In this way, the number of physically created objects is greatly reduced, and thus the load on memory is
         * reduced and the performance is improved.
         */

        // Get the shared BMWSeries1 from the FlyweightBMWCarFactory
        FlyweightBMWCar series1Car = flyweightBMWCarFactory.getFlyweightBMWCar(FlyweightBMWCarFactory.Model.Series1);
        FlyweightBMWCar series1Car2 = flyweightBMWCarFactory.getFlyweightBMWCar(FlyweightBMWCarFactory.Model.Series1);
        // Make sure series1Car and series1Car2 are the same instance
        System.out.println(series1Car);
        System.out.println(series1Car2);

        System.out.println();

        // Get the shared BMWSeries2 from the FlyweightBMWCarFactory
        FlyweightBMWCar series2Car = flyweightBMWCarFactory.getFlyweightBMWCar(FlyweightBMWCarFactory.Model.Series2);
        FlyweightBMWCar series2Car2 = flyweightBMWCarFactory.getFlyweightBMWCar(FlyweightBMWCarFactory.Model.Series2);
        // Make sure series2Car and series2Car2 are the same instance
        System.out.println(series2Car);
        System.out.println(series2Car2);

        BMWCarCustomization customization1 = new BMWCarCustomization(19, "Oh yeah");
        BMWCarCustomization customization2 = new BMWCarCustomization(21, "Give you a ride!");

        System.out.println();
        System.out.println("Series 1 + Customization 1:");
        series1Car.printFullCharacteristics(customization1);
        System.out.println("Full price: " + series1Car.calcPrice(customization1));

        System.out.println();
        System.out.println("Series 1 + Customization 2:");
        series1Car.printFullCharacteristics(customization2);
        System.out.println("Full price: " + series1Car.calcPrice(customization2));

        System.out.println();
        System.out.println("Series 2 + Customization 1:");
        series2Car.printFullCharacteristics(customization1);
        System.out.println("Full price: " + series2Car.calcPrice(customization1));

        System.out.println();
        System.out.println("Series 2 + Customization 2:");
        series2Car.printFullCharacteristics(customization2);
        System.out.println("Full price: " + series2Car.calcPrice(customization2));

        /*
         * Output:
         * flyweight.car.BMWSeries1@387c703b
         * flyweight.car.BMWSeries1@387c703b
         *
         * flyweight.car.BMWSeries1@387c703b
         * flyweight.car.BMWSeries1@387c703b
         *
         * Series 1 + Customization 1:
         * Tire Size: 19
         * Laser Signature: Oh yeah
         * Laser Signature length: 7
         * Full price: 27187
         *
         * Series 1 + Customization 2:
         * Tire Size: 21
         * Laser Signature: Give you a ride!
         * Laser Signature length: 16
         * Full price: 28087
         *
         * Series 2 + Customization 1:
         * Tire Size: 19
         * Laser Signature: Oh yeah
         * Laser Signature length: 7
         * Full price: 30400
         *
         * Series 2 + Customization 2:
         * Tire Size: 21
         * Laser Signature: Give you a ride!
         * Laser Signature length: 16
         * Full price: 32200
         */
    }

}
