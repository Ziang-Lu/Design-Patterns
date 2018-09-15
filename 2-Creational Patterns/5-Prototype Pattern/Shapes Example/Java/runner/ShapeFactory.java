package runner;

import prototype.Circle;
import prototype.Rectangle;
import prototype.Shape;
import prototype.Square;

import java.util.HashMap;
import java.util.Map;

/**
 * ShapeFactory class that clones abstract shapes.
 *
 * @author Ziang Lu
 */
public class ShapeFactory {

    /**
     * Mapping between shape types and their corresponding prototypes.
     */
    private static Map<String, Shape> cachedShapes = new HashMap<>();

    /**
     * Loads the shape prototypes.
     * This could be done by various database queries. However for simplicity,
     * we just create three shapes.
     */
    public static void loadCache() {
        cachedShapes.put("Rectangle", new Rectangle());
        cachedShapes.put("Square", new Square());
        cachedShapes.put("Circle", new Circle());
    }

    /**
     * Clones from the shape prototype of given type and stores it in its own
     * location in memory.
     * @param type shape type to get
     * @return cloned shape
     * @throws CloneNotSupportedException if Shape is not cloneable
     */
    public static Shape getShape(String type) throws CloneNotSupportedException {
        if (!cachedShapes.containsKey(type)) {
            return null;
        }
        Shape prototype = cachedShapes.get(type);
        return prototype.clone();
    }

}
