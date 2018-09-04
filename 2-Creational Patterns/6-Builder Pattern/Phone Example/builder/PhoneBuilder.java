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
     * Accessor of the operating system.
     * @return operating system
     */
    public String getOS() {
        return os;
    }

    /**
     * Sets the operating system for a phone.
     * @param os operating system to set
     * @return this phone builder after operating system being set
     */
    public PhoneBuilder os(String os) {
        this.os = os;
        return this;
    }

    /**
     * Accessor of processor.
     * @return processor.
     */
    public String getProcessor() {
        return processor;
    }

    /**
     * Sets the processor for a phone.
     * @param processor processor to set
     * @return this phone builder after process being set
     */
    public PhoneBuilder processor(String processor) {
        this.processor = processor;
        return this;
    }

    /**
     * Accessor of RAM.
     * @return RAM
     */
    public int getRAM() {
        return ram;
    }

    /**
     * Sets the RAM for a phone.
     * @param ram RAM to set
     * @return this phone builder after RAM being set
     */
    public PhoneBuilder ram(int ram) {
        this.ram = ram;
        return this;
    }

    /**
     * Accessor of screenSize.
     * @return screenSize
     */
    public double getScreenSize() {
        return screenSize;
    }

    /**
     * Sets the screen size for a phone.
     * @param screenSize screen size to set
     * @return this phone builder after screen size being set
     */
    public PhoneBuilder screenSize(double screenSize) {
        this.screenSize = screenSize;
        return this;
    }

    /**
     * Accessor of battery.
     * @return batter
     */
    public int getBattery() {
        return battery;
    }

    /**
     * Sets the battery for a phone.
     * @param battery battery to set
     * @return this phone builder after battery being set
     */
    public PhoneBuilder battery(int battery) {
        this.battery = battery;
        return this;
    }

    /**
     * Returns a finished phone built by this phone builder.
     * @return finished phone
     */
    public Phone getPhone() {
        if ((os == null) || (ram <= 0)) {
            throw new IllegalStateException();
        }
        return new Phone(this);
    }

}
