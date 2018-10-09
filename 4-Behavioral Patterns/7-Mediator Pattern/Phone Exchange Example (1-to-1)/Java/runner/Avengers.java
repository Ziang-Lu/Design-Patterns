package runner;

import model.MemberPhoneCustomer;
import model.NormalPhoneCustomer;
import model.PhoneCustomer;
import model.PhoneExchange;

/**
 * Application that actually uses Mediator Pattern.
 *
 * @author Ziang Lu
 */
public class Avengers {

    /**
     * Main driver.
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        PhoneExchange phoneExchange = new PhoneExchange();
        PhoneCustomer steve = new NormalPhoneCustomer("Steve", phoneExchange);
        System.out.println(steve);
        PhoneCustomer tony = new MemberPhoneCustomer("Tony", phoneExchange);
        System.out.println(tony);
        PhoneCustomer bruce = new NormalPhoneCustomer("Bruce", phoneExchange);
        System.out.println(bruce);

        System.out.println();

        String stevePhoneNumber = steve.getNumber();
        tony.call(stevePhoneNumber, "Come back.");
        System.out.println();
        bruce.call(stevePhoneNumber, "Tony needs you.");

        /*
         * Output:
         * NormalPhoneCustomer{name=Steve, phoneNumber=855-665-7169} with 50 calls per month
         * MemberPhoneCustomer{name=Tony, phoneNumber=434-316-8721} with unlimited calls per month
         * NormalPhoneCustomer{name=Bruce, phoneNumber=439-606-6158} with 50 calls per month
         *
         * Tony calling 855-665-7169 with message: Come back. ...
         * Successful!
         * Steve received a call from 434-316-8721 with message: Come back.
         *
         * Bruce calling 855-665-7169 with message: Tony needs you. ...
         * Successful!
         * Steve received a call from 439-606-6158 with message: Tony needs you.
         */
    }

}
