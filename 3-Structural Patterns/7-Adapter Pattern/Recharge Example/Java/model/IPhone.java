package model;

/**
 * IPhone class.
 *
 * @author Ziang Lu
 */
public class IPhone implements FormatIPhone {

    /**
     * Whether this iPhone has been connected to a recharger.
     */
    private boolean connection = false;

    @Override
    public void useLightning() {
        System.out.println("iPhone connected to lightning recharger");
        connection = true;
    }

    @Override
    public void recharge() {
        if (!connection) {
            System.out.println("Please connect to the recharger first");
            return;
        }
        System.out.println("Recharging iPhone via lightning recharger");
    }

}
