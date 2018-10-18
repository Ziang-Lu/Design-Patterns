package folder;

import user.User;

/**
 * SharedFolder class that works as "RealSubject".
 * This class should be protected by a proxy to limit access to it.
 *
 * @author Ziang Lu
 */
class SharedFolder implements Folder {

    @Override
    public void performReadOrWriteOperation(User user) {
        System.out.println("In SharedFolder: " + user.designation() + " is performing read/write operation.");
    }

}
