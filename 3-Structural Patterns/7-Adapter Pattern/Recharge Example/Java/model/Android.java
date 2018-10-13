package model;

/**
 * Android phone class.
 *
 * @author Ziang Lu
 */
public class Android implements FormatAndroid {

    /**
     * Whether this Android phone has been connected to a recharger.
     */
    private boolean connection = false;

    @Override
    public void useMicroUsb() {
        System.out.println("i");
        connection = true;
    }

    @Override
    public void recharge() {
        if (!connection) {
            System.out.println("Please connect to the recharger first");
            return;
        }
        System.out.println("Recharging Android phone via micro USB recharger");
    }

}
