package runner;

import model.FormatAndroid;
import model.IPhone;
import model.IPhoneToFormatAndroidAdapter;

/**
 * Application that actually uses Adapter Pattern.
 *
 * @author Ziang Lu
 */
public class IPhoneRechargeUsingAndroidMicroUsb {

    /**
     * Main driver.
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        IPhone iPhone = new IPhone();

        FormatAndroid androidRecharger = new IPhoneToFormatAndroidAdapter(iPhone);
        androidRecharger.useMicroUsb();
        androidRecharger.recharge();

        /*
         * Output:
         * iPhone connected to micro USB recharger
         * iPhone connected to lightning recharger
         * Recharging iPhone via lightning recharger
         */
    }

}
