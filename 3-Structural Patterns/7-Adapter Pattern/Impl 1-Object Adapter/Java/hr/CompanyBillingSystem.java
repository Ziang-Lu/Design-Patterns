package hr;

/**
 * CompanyBillingSystem class that works as "Target".
 *
 * By comparing the signatures of processEmployeesSalary() method and the
 * ThirdPartyBillingSystem.processSalary() method, we can find that this
 * interface and the ThirdPartyBillingSystem are independent or incompatible
 * systems.
 *
 * This class is implemented as a singleton class.
 *
 * @author Ziang Lu
 */
class CompanyBillingSystem {

    /**
     * Singleton instance.
     */
    private volatile static CompanyBillingSystem instance = null;

    /**
     * Gets the singleton instance.
     * This implementation utilizes Lazy Initialization Pattern and double-check
     * locking mechanism.
     * @return singleton instance
     */
    static CompanyBillingSystem getInstance() {
        if (instance == null) {
            synchronized (CompanyBillingSystem.class) {
                if (instance == null) {
                    instance = new CompanyBillingSystem();
                }
            }
        }
        return instance;
    }

    private BillingSystemAdapter billingSystemAdapter = BillingSystemAdapter.getInstance();

    /**
     * Protected default constructor.
     * This has to be protected so that the class instances cannot be created
     * outside of the class, but can be accessed from subclasses.
     */
    protected CompanyBillingSystem() {}

    /*
     * Calculates the salary of the given employees, and credit it to their
     * corresponding bank account.
     * @param employeesInfo employee information
     */
    public void processEmployeesSalary(String[][] employeesInfo) {
        billingSystemAdapter.processEmployeesSalary(employeesInfo);
    }

}
