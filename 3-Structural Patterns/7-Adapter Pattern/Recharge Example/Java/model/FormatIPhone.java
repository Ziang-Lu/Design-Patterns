package model;

/**
 * FormatIPhone interface that defines recharging an iPhone-format device.
 *
 * @author Ziang Lu
 */
public interface FormatIPhone extends Rechargeable {

    /**
     * Connects this device to iPhone lightning recharger.
     */
    void useLightning();

}
