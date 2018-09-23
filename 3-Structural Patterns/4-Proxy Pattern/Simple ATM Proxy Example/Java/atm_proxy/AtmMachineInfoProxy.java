package atm_proxy;

import atm.AtmMachine;

/**
 * AtmMachineInfoProxy class that works as "Proxy".
 * An AtmMachineInfoProxy object acts as a proxy that controls the access to
 * its hiding AtmMachine object behind the scene. In this way, the "Proxy" will
 * work on behalf of the "RealSubject", or the "Proxy" represents the
 * "RealSubject".
 *
 * @author Ziang Lu
 */
public class AtmMachineInfoProxy implements GetAtmData {

    /**
     * Real ATM to limit access to.
     */
    private AtmMachine realAtm;

    /**
     * Constructor with parameter.
     * @param atm real ATM to limit access to
     */
    public AtmMachineInfoProxy(AtmMachine atm) {
        realAtm = atm;
    }

    @Override
    public String getAtmState() {
        return realAtm.getAtmState();
    }

    @Override
    public int getCashInAtm() {
        return realAtm.getCashInAtm();
    }

}
