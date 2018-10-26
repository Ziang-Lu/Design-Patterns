package phone;

import builder.PhoneBuilder;

/**
 * My own modular phone class.
 *
 * @author Ziang Lu
 */
public class Phone {

    /**
     * Operating system of this phone.
     */
    private final String os;
    /**
     * Processor brand of this phone.
     */
    private final String processor;
    /**
     * RAM of this phone, measured in MB.
     */
    private final int ram;
    /**
     * Screen size of this phone.
     */
    private final double screenSize;
    /**
     * Battery capacity of this phone, measured in mAh.
     */
    private final int battery;

    /**
     * Constructor with parameter.
     * This single constructor makes sure that phone creation can only be done
     * through a phone builder.
     * @param builder PhoneBuilder used to build this phone
     */
    public Phone(PhoneBuilder builder) {
        this.os = builder.getOS();
        this.processor = builder.getProcessor();
        this.ram = builder.getRAM();
        this.screenSize = builder.getScreenSize();
        this.battery = builder.getBattery();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Phone [");
        s.append("os=").append(os).append(", ");
        s.append("processor=").append(processor).append(", ");
        s.append("ram=").append(ram).append(", ");
        s.append("screenSize=").append(screenSize).append(", ");
        s.append("battery=").append(battery);
        s.append("]\n");
        return s.toString();
    }

}
