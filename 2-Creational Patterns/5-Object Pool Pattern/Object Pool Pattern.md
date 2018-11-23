# Object Pool Pattern (对象池模式) / N-ton Pattern (N例模式)

## Applicability

* When we need to create a large number of same objects that are expensive to create

  => Repeatedly allocating and freeing these objects individually would be too expensive operations, and thus decrease the performance

  => Creating these large number of objects should be avoided

* At the same time, the time of these objects being used by the clients is low.

<br>

## Definition & Explanation

The Object Pool Pattern is a **structural pattern** that expands on the singleton concept, and <u>when you need to create a large number of objects that are expensive to create (repeatedly allocating and freeing these objects individually would be too expensive operations, and thus decrease the performance)</u>, the Object Pool Pattern **uses a pool (即下文中的`ReusablePool`) to limit the number of instances created (即下文中的`poolSize`) and manage them**. In this way, we can **reuse and share objects (即下文中的`Reusable` objects) that are expensive to create**.

* `ReusablePool`: Managing a pool (with a size) of `Reusable` objects for the `Client`s to use

* `Reusable`: Class that is expensive to instantiate

* `Client`: Uses `Reusable` objects

  ***

  **Workflow:**

  When the `ReusablePool` receives a request for a `Reusable` object by a `Client`, it will first check if there is any `Reusable` object in the pool:

  * If YES, it will simply return an available `Reusable` object in the pool
  * If NO, it will check if the pool has reached its maximum size:
    * If NO, it will create a new `Reusable` object, and return it
    * If YES, it will wait for a previous created, currently using by a previous client `Reusable` object to be released back to the pool, and then return that `Reusable` object

  ***

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/2-Creational%20Patterns/5-Object%20Pool%20Pattern/class_diagram.png?raw=true">

Important note: Always remember to clean up the `Reusable` object when it is returned back to the pool, so that it can be ready for the next use

## Typical Usages

* Connection pool (连接池)

  Check out `SQL Connection Example`

* Thread pool (线程池)

  Check out Thread Pool Pattern separately

<br>

## Benefit

Greatly avoids the repeated expensive instantiation process, and thus improves performance

=> The benefits are mostly true for objects that are expensive w.r.t. time, such as database connections, socket connections, threads and large graphic objects like fonts or bitmaps.

## Criticism

The Object Pool Pattern may not help in modern languages with garbage collectors, such as Java, because object allocation is relatively fast in this case.

- Most garbage collectors scan "live" object references, but not the memory that these objects use for their content.

  => This means that any number of "dead" objects without references can be discarded with little cost.

- In contrast, keeping a large number of "live" but unused objects increase the duraction of garbage collection.