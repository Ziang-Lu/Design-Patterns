package phone;

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
     * @param os operating system of the phone
     * @param processor processor brand of the phone
     * @param ram RAM of the phone measured in MB
     * @param screenSize screen size of the phone
     * @param battery battery capacity of the phone measured in mAh
     */
    public Phone(String os, String processor, int ram, double screenSize, int battery) {
        this.os = os;
        this.processor = processor;
        this.ram = ram;
        this.screenSize = screenSize;
        this.battery = battery;
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
