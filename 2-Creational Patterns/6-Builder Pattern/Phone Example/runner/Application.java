package runner;

import builder.PhoneBuilder;
import phone.Phone;

/**
 * Application that actually makes use of Builder Pattern to create phones.
 *
 * @author Ziang Lu
 */
public class Application {

    /**
     * Main driver.
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        PhoneBuilder phoneBuilder = new PhoneBuilder();
        phoneBuilder = phoneBuilder.setOS("Android").setRAM(2).setBattery(3000);
        // Note that in this way, we don't need to explicitly create phones in a complex way by specifying all the five
        // parameters in the Phone() constructor
        // Instead, we can make use of a phone builder to create and assemble the parts of a phone, and can even omit
        // some parameters, to create a phone
        Phone phone = phoneBuilder.getPhone();
        System.out.print(phone);
    }

}
