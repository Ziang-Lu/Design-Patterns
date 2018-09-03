package builder;

import phone.Phone;

/**
 * PhoneBuilder class that works as a factory, a blueprint, that defines the
 * construction process for a phone, i.e., how to build a phone by creating and
 * assembling all of its parts.
 *
 * @author Ziang Lu
 */
public class PhoneBuilder {

    /**
     * Operating system of this phone.
     */
    private String os;
    /**
     * Processor brand of this phone.
     */
    private String processor;
    /**
     * RAM of this phone, measured in GB.
     */
    private int ram;
    /**
     * Screen size of this phone.
     */
    private double screenSize;
    /**
     * Battery capacity of this phone, measured in mAh.
     */
    private int battery;

    /**
     * Sets the operating system for a phone.
     * @param os operating system to set
     * @return this phone builder after operating system being set
     */
    public PhoneBuilder setOS(String os) {
        this.os = os;
        return this;
    }

    /**
     * Sets the processor for a phone.
     * @param processor processor to set
     * @return this phone builder after process being set
     */
    public PhoneBuilder setProcessor(String processor) {
        this.processor = processor;
        return this;
    }

    /**
     * Sets the RAM for a phone.
     * @param ram RAM to set
     * @return this phone builder after RAM being set
     */
    public PhoneBuilder setRAM(int ram) {
        this.ram = ram;
        return this;
    }

    /**
     * Sets the screen size for a phone.
     * @param screenSize screen size to set
     * @return this phone builder after screen size being set
     */
    public PhoneBuilder setScreenSize(double screenSize) {
        this.screenSize = screenSize;
        return this;
    }

    /**
     * Sets the battery for a phone.
     * @param battery battery to set
     * @return this phone builder after battery being set
     */
    public PhoneBuilder setBattery(int battery) {
        this.battery = battery;
        return this;
    }

    /**
     * Returns a finished phone built by this phone builder.
     * @return finished phone
     */
    public Phone getPhone() {
        return new Phone(os, processor, ram, screenSize, battery);
    }

}
