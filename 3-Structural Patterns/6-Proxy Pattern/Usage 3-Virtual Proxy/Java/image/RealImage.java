package image;

/**
 * RealImage class that works as "RealSubject".
 * Since the creation of a RealImage object is expensive, this class should be
 * cached by a proxy.
 *
 * @author Ziang Lu
 */
class RealImage implements Image {

    /**
     * Image filename.
     */
    private final String filename;

    /**
     * Constructor with parameter.
     * The creation process of a RealImage object is expensive.
     * @param filename image filename
     */
    RealImage(String filename) {
        System.out.print("Creating a RealImage object: ");
        this.filename = filename;
        loadImageFromDisk();
    }

    /**
     * Private helper method to load the image file from disk.
     */
    private void loadImageFromDisk() {
        // Sleep 3 seconds to simulate the expensive loading process
        System.out.println("Loading " + filename + " from disk... This may take around 3 seconds.");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void displayImage() {
        System.out.println("Displaying " + filename);
    }

}
