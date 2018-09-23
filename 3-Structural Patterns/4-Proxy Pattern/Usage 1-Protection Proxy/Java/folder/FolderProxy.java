package folder;

import user.User;

/**
 * FolderProxy class that works as "Proxy".
 * An FolderProxy object acts as a proxy that controls the access to its hiding
 * SharedFolder object behind the scene, performing protection-related
 * operations. In this way, the "Proxy" will work on behalf of the
 * "RealSubject", or the "Proxy" represents the "RealSubject".
 *
 * @author Ziang Lu
 */
public class FolderProxy implements Folder {

    /**
     * Protected real shared folder to limit access to.
     */
    private SharedFolder realSharedFolder = new SharedFolder();

    @Override
    public void performReadOrWriteOperation(User user) {
        // Before we forward the request to the real shared folder, perform protection-related operations
        // In this case, this would be checking the designation of the user, and see if the user has the permission to
        // perform a read/write operation on a shared folder
        if (user.designation().equalsIgnoreCase("CEO") ||
                (user.designation().equalsIgnoreCase("Manager"))) {
            System.out.println("FolderProxy: 'FolderProxy will forward the request to the real SharedFolder object.'");
            realSharedFolder.performReadOrWriteOperation(user);
        } else {
            System.out.println("FolderProxy: 'You don't have permission to the shared folder.'");
        }
    }

}
