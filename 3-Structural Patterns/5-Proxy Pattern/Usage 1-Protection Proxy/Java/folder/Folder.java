package folder;

import user.User;

/**
 * Abstract Folder interface that works as "Subject".
 *
 * In order to let the "Proxy" controls the access to its hiding "RealSubject"
 * behind the scene, the "Proxy" needs to provide similar API as the
 * "RealSubject".
 * Therefore, we simply let this step be done via letting "RealSubject" and
 * "Proxy" share a common super class "Subject", in which we define only the
 * methods that we want the "Proxy" to provide access to.
 */
public interface Folder {

    /**
     * The given user tries to perform a read/write operation on a shared
     * folder.
     * @param user given user
     */
    void performReadOrWriteOperation(User user);

}
