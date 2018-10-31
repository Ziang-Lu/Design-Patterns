package runner;

import folder.Folder;
import folder.FolderProxy;
import user.User;

/**
 * Application that actually uses Protection Proxy of Proxy Pattern.
 *
 * @author Ziang Lu
 */
public class ProtectionProxyTest {

    /**
     * Main driver.
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        System.out.println("A CEO tries to perform a read/write operation on a shared folder.");
        Folder folderProxy = new FolderProxy();
        folderProxy.performReadOrWriteOperation(new User("John", "John123", "CEO"));
        System.out.println();
        System.out.println("A developer tries to perform a read/write operation on a shared folder.");
        folderProxy.performReadOrWriteOperation(new User("Raj", "Raj123", "Developer"));

        /*
         * Output:
         * A CEO tries to perform a read/write operation on a shared folder.
         * FolderProxy: 'FolderProxy will forward the request to the real SharedFolder object.'
         * In SharedFolder: CEO is performing read/write operation.
         *
         * A developer tries to perform a read/write operation on a shared folder.
         * FolderProxy: 'You don't have permission to the shared folder.'
         */
    }

}
