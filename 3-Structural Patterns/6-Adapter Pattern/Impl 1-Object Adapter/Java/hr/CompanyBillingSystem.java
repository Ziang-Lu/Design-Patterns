package hr;

/**
 * Abstract CompanyBillingSystem interface that works as "Target".
 *
 * By comparing the signatures of processEmployeesSalary() method and the
 * ThirdPartyBillingSystem.processSalary() method, we can find that this
 * interface and the ThirdPartyBillingSystem are independent or incompatible
 * systems.
 *
 * @author Ziang Lu
 */
interface CompanyBillingSystem {

    /*
     * Calculates the salary of the given employees, and credit it to their
     * corresponding bank account.
     * @param employeesInfo employee information
     */
    void processEmployeesSalary(String[][] employeesInfo);

}
