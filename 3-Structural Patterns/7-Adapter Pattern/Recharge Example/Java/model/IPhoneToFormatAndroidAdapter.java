package model;

/**
 * Concrete IPhoneToFormatAndroidAdapter class that works as "Adapter".
 *
 * Note that in this implementations, we uses Object Adapter:
 * - Since we cannot change the "Target" interface, in order to keep the
 *   original API, we create an "Adapter" class that implements the "Target"
 *   interface.
 * - In order to make the "Target" interface and the "Adaptee" work together, in
 *   the "Adapter" class, we simply keep a referent to the "Adaptee" object, and
 *   delegate the request from the client to this "Adaptee" object.
 *
 * @author Ziang Lu
 */
public class IPhoneToFormatAndroidAdapter implements FormatAndroid {

    /**
     * Reference to the adaptee object.
     */
    private IPhone adaptee;

    /**
     * Constructor with parameter.
     * @param iPhone iPhone to be adapted
     */
    public IPhoneToFormatAndroidAdapter(IPhone iPhone) {
        adaptee = iPhone;
    }

    @Override
    public void useMicroUsb() {
        // Perform the necessary conversion to make the two independent or incompatible systems work together
        System.out.println("iPhone connected to micro USB recharger");

        // Delegate the request to the adaptee object
        adaptee.useLightning();
    }

    @Override
    public void recharge() {
        // Delegate the request to the adaptee object
        adaptee.recharge();
    }

}
