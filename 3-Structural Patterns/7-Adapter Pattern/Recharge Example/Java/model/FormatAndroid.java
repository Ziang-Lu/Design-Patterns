package model;

/**
 * FormatAndroid interface that defines recharging an Android-format device.
 * This interface works as "Target".
 *
 * By comparing the signatures of useMicroUsb() method and the
 * IPhone.useLightning() method, we can find that this interface and the IPhone
 * are independent or incompatible systems.
 *
 * @author Ziang Lu
 */
public interface FormatAndroid extends Rechargeable {

    /**
     * Connects this device to Android micro USB recharger.
     */
    void useMicroUsb();

}
