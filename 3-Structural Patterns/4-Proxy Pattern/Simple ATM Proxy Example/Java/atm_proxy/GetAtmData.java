package atm_proxy;

/**
 * Abstract GetAtmData interface that works as "Subject".
 *
 * In order to let the "Proxy" controls the access to its hiding "RealSubject"
 * behind the scene, the "Proxy" needs to provide similar API as the
 * "RealSubject".
 * Therefore, we simply let this step be done via letting "RealSubject"
 * and "Proxy" share a common super class "Subject", in which we define only the
 * methods that we want the "Proxy" to provide access to.
 *
 * @author Ziang Lu
 */
public interface GetAtmData {

    /**
     * Gets the current state of the ATM.
     * @return current state of the ATM
     */
    String getAtmState();

    /**
     * Gets the current amount of cash in the ATM.
     * @return current amount of cash in the ATM
     */
    int getCashInAtm();

}
