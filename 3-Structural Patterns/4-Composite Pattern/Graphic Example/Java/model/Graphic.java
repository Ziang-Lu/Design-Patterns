package model;

/**
 * Abstract Graphic class that works as "Component".
 * Note that this implementation uses Design-for-Type-Safety, i.e., defining
 * child-related operations only in "Composite"
 *
 * @author Ziang Lu
 */
abstract class Graphic {

    /**
     * Name of this graphic.
     */
    protected final String name;

    /**
     * Protected constructor with parameter.
     * @param name name of the graphic
     */
    protected Graphic(String name) {
        this.name = name;
    }

    /**
     * Draws this graphic.
     */
    public abstract void draw();

    /**
     * Protected helper method to draw this graphic.
     */
    protected void drawHelper() {
        System.out.println("Drawing " + name);
    }

    /**
     * Translates this graphic by the given amount of translations.
     * @param x horizontal amount of translation
     * @param y vertical amount of translation
     */
    public abstract void translate(int x, int y);

    /**
     * Protected helper method to translate this graphic.
     * @param x horizontal amount of translation
     * @param y vertical amount of translation
     */
    protected void translateHelper(int x, int y) {
        System.out.println("Translating " + name + " by x=" + x + ", y=" + y);
    }

    /**
     * Resize this graphic by the given amount of times.
     * @param times amount of times to resize
     */
    public abstract void resize(double times);

    /**
     * Protected helper method to resize this graphic.
     * @param times amount of times to resize
     */
    protected void resizeHelper(double times) {
        System.out.println("Resizing " + name + " by " + times + " times");
    }

}
