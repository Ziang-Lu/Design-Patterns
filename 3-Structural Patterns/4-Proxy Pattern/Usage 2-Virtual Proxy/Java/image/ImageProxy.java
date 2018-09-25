package image;

/**
 * ImageProxy class that works as "Proxy".
 * An ImageProxy object acts as a cache that controls the access its hiding
 * "expensive-to-create" RealImage object behind the scene. In this way, the
 * "Proxy" will work on behalf of the "RealSubject", or the "Proxy" represents
 * the "RealSubject".
 * ImageProxy delays the instantiation of the real "expensive-to-create"
 * RealImage object until its behavior is called for.
 * Afterwards, the "Proxy" acts as a cache for that "expensive-to-create"
 * RealImage object. In this way, we can avoid multiple loadings of the
 * RealImage object.
 *
 * @author Ziang Lu
 */
public class ImageProxy implements Image {

    /**
     * Image filename.
     */
    private final String filename;
    /**
     * Cached "expensive-to-create" RealImage object.
     */
    private RealImage realImage;

    /**
     * Constructor with parameter.
     * @param filename image filename
     */
    public ImageProxy(String filename) {
        this.filename = filename;
    }

    @Override
    public void displayImage() {
        // The "expensive-to-create" RealImage object is created only when a client first requests/accesses that object.
        // Afterwards, the "Proxy" acts as a cache for that "expensive-to-create" RealImage object.
        // In this way, we can avoid multiple loadings of the RealImage object.
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.displayImage();
    }

}
