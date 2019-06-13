# Immutable Object Pattern (不可变对象模式)

## Applicability

When we have **multiple threads concurrently accessing a shared object's states**, we have the **data consistency problem**:

* The states of the shared object don't change very frequently.

  *(当被建模对象的状态变更比较频繁时, 也不是不能使用Immutable Object模式, 只是这意味着频繁地创建和销毁新的immutable object, 因此会增加GC的负担和CPU消耗, 有可能会得不偿失.)*

<br>

## Definition & Explanation

We can use **objects whose states that are visible to the world are immutable ("Immutable Objects")**, so that these shared objects are "in nature" thread-safe.

<br>

## Code Example

```java
/**
 * Immutable MMSC class.
 * Mark this class as "final" to avoid its potential subclasses overriding its
 * behavior
 *
 * @author Ziang Lu
 */
public final class MMSC {

    // All data fields need to be "final".
    /**
     * Device ID of this MMSC.
     */
    private final String deviceID;
    /**
     * URL of this MMSC.
     */
    private final String url;
    /**
     * Maximum attachment size in Bytes allowed by this MMSC.
     */
    private final int maxAttachmentSizeInBytes;

    /**
     * Constructor with parameter.
     * @param deviceID device ID of the MMSC
     * @param url URL of the MMSC
     * @param maxAttachmentSizeInBytes maximum attachment size in bytes allowed
     */
    public MMSC(String deviceID, String url, int maxAttachmentSizeInBytes) {
        this.deviceID = deviceID;
        this.url = url;
        this.maxAttachmentSizeInBytes = maxAttachmentSizeInBytes;
    }

    /**
     * Accessor of deviceID.
     * @return deviceID
     */
    public String getDeviceID() {
        return deviceID;
    }

    /**
     * Accessor of URL.
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Accessor of maxAttachmentSizeInBytes.
     * @return maxAttachmentSizeInBytes
     */
    public int getMaxAttachmentSizeInBytes() {
        return maxAttachmentSizeInBytes;
    }

}
```

```java
import java.util.HashMap;
import java.util.Map;

/**
 * Immutable MMSCRouter class.
 * Mark this class as "final" to avoid its potential subclasses overriding its
 * behavior
 *
 * @author Ziang Lu
 */
public final class MMSCRouter {

    /**
     * Singleton instance.
     */
    private volatile static MMSCRouter instance;

    /**
     * Gets the singleton instance.
     * This implementation utilizes Lazy Initialization Pattern and double-check
     * locking mechanism.
     * @return singleton instance
     */
    public static MMSCRouter getInstance() {
        if (instance == null) {
            synchronized (MMSCRouter.class) {
                if (instance == null) {
                    instance = new MMSCRouter();
                }
            }
        }
        return instance;
    }

    /**
     * Private static helper method to retrieve the route map from DB.
     * @return retrieved route map
     */
    private static Map<String, MMSC> retrieveRouteMapFromDB() {
        Map<String, MMSC> routeMap = new HashMap<>();
        // TODO implementation: retrieve from DB
        return routeMap;
    }

    /**
     * Private static helper method to make a deep copy of the given map.
     * @param map map to deep copy
     * @return deep copy of the given map
     */
    private Map<String, MMSC> deepCopy(Map<String, MMSC> map) {
        Map<String, MMSC> copy = new HashMap<>();
        for (Map.Entry<String, MMSC> entry : map.entrySet()) {
            String msisdnPrefix = entry.getKey();
            MMSC mmsc = entry.getValue();
            copy.put(msisdnPrefix, new MMSC(mmsc.getDeviceID(), mmsc.getUrl(), mmsc.getMaxAttachmentSizeInBytes()));
        }
        return copy;
    }

    /**
     * Route map in this MMSC Router.
     */
    private final Map<String, MMSC> routeMap;

    /**
     * Private default constructor.
     * This has to be private so that the class instances cannot be created
     * outside of the class.
     */
    private MMSCRouter() {
        routeMap = retrieveRouteMapFromDB();
    }

    /**
     * Returns the MMSC corresponding to the given MSISDN prefix.
     * @param msisdnPrefix given MSISDN prefix
     * @return corresponding MMSC
     */
    public MMSC getMMSCInfo(String msisdnPrefix) {
        return routeMap.get(msisdnPrefix);
    }

    /**
     * Accessor of route map.
     * @return defensive copy of route map
     */
    public Map<String, MMSC> getRouteMap() {
        // Since HashMap class is mutable, if we return routeMap directly, it is possible that it got modified from
        // outside of this class.
        // Thus, we need to make a defensive copy first, and then return the defensive copy.
        return Map.copyOf(deepCopy(routeMap));
    }

}
```

<br>

## Benefit

* No additional synchronization access control
  * Guarantees data consistency
  * Avoids the extra overhead and pitfalls brought by synchronization access control
