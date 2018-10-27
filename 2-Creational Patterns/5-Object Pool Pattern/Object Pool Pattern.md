# Object Pool Pattern (对象池模式) / N-ton Pattern (N例模式)

## Applicability

* When we <u>need to create a large number of same objects that are expensive to create</u>

  => These large number of objects <u>consume a large, unaccepted amount of memory and decrease the performance</u>.

  => <u>Creating these large number of objects should be avoided</u>

* At the same time, <u>the time of these objects being used by the clients is low</u>.

<br>

## Definition & Explanation

The Object Pool Pattern is a **structural pattern** that expands on the singleton concept, and <u>when you need to create a large number of objects that are expensive to create (which consume a large amount of memory and decrease the performance)</u>, the Object Pool Pattern **uses a pool (即下文中的`ReusablePool`) to limit the number of instances created (即下文中的`poolSize`) and manage them**. In this way, we can **reuse and share objects (即下文中的`Reusable` objects) that are expensive to create**.

<u>=> In this way, the load on memory is reduced and the performance is improved.</u>

* `ReusablePool`: <u>Managing a pool (with a size) of `Reusable` objects</u> for the `Client`s to use

* `Reusable`: Class that is <u>expensive to instantiate</u>

* `Client`: <u>Uses `Reusable` objects</u>

  ***

  **Workflow:**

  When the `ReusablePool` receives a request for a `Reusable` object by a `Client`, it will first check if there is any `Reusable` object in the pool:

  * If YES, it will simply return an available `Reusable` object in the pool
  * If NO, it will check if the pool has reached its maximum size:
    * If NO, it will create a new `Reusable` object, and return it
    * If YES, it will wait for a previous created, currently using by a previous client `Reusable` object to be released back to the pool, and then return that `Reusable` object

  ***

Open too many connection to the database   [Open a connection is expensive]   =>   Database overloaded

<br>

## Benefit

<u>Greatly reduces the number of physically created objects, and thus reduces the load on memory and improves performance</u>

=> The benefits are mostly true for objects that are expensive w.r.t. time, such as <u>database connections, socket connections, threads</u> and large graphic objects like fonts or bitmaps.

<br>

## Criticism

The Object Pool Pattern may not help in modern languages with garbage collectors, such as Java, because object allocation is relatively fast in this case.

- Most garbage collectors scan "live" object references, but not the memory that these objects use for their content.

  => This means that any number of "dead" objects without references can be discarded with little cost.

- In contrast, keeping a large number of "live" but unused objects increase the duraction of garbage collection.