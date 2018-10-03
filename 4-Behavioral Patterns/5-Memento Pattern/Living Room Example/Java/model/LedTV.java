package model;

/**
 * LED TV class.
 *
 * @author Ziang Lu
 */
public class LedTV {

    /**
     * Size of this LED TV in inch.
     */
    private final int size;
    /**
     * Whether this LED TV supports USB.
     */
    private final boolean usbSupport;
    /**
     * Price of this LED TV.
     */
    private final double price;

    /**
     * Constructor with parameter.
     * @param size size of the LED TV
     * @param usbSupport whether the LED TV supports USB
     * @param price price of the LED TV
     */
    public LedTV(int size, boolean usbSupport, double price) {
        this.size = size;
        this.usbSupport = usbSupport;
        this.price = price;
    }

    @Override
    public String toString() {
        return "LedTV{size=" + size + ", usbSupport=" + usbSupport + ", price=$" + price + "}";
    }

}
