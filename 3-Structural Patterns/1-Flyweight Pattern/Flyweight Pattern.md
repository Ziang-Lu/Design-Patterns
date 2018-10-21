# Flyweight Pattern (享元模式/轻量级模式)

## Applicability

* When we <u>need to create a large number of objects of almost similar nature</u>

  => These large number of objects <u>consume a large, unaccepted amount of memory and decrease the performance</u>.

  => <u>Creating these large number of objects should be avoided</u>

* When you think the same bulky data is repeating for every object

<br>

## Definition & Explanation

The Flyweight Pattern is a **structural pattern** that <u>when you need to create a large number of objecs of almost similar nature (which consume a large amount of memory and decrease the performance)</u>, the Flyweight Pattern **stores already existing similar objects (即下文中的`ConcreteFlyweight`) in a cache, so that they can easily be reused (shared), and creates a new object only when no matching object is found**.

<u>=> In this way, the load on memory is reduced and the performance is improved.</u>

In Flyweight Pattern, the **states in the objects to be created** can be classifies as:

* **Intrinsic states (固有状态) / Invariant states (不可变状态)**

  States that are **constant (context-independent)**, and thus are **stored in memory**

* **Extrinsic states (外部状态) / Variant states (可变状态)**

  States that are **NOT constant (context-dependent)**, and **needs to be calculated on the fly**, and thus are **NOT stored in memory**

  => We can hold the extrinsic states in an external data structure, and temporarily pass them to the `ConcreteFlyweight` when they are used.

***

Example:

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/3-Structural%20Patterns/1-Flyweight%20Pattern/flyweight_pattern_illustration.png?raw=true">

在此例中, 我们需要创建大量的Circle objects:

- 如果我们无脑创建, 则会消耗大量的memory, 并降低程序性能

- 因此, 我们可以使用Flyweight Pattern, 把一个Circle object (`ConcreteFlyweight`)先存入memory中, 然后通过customize该对象来得到我们想要的对象

  => 这样就可以减少memory的使用, 并提升程序性能

states:

* 由于shape(圆形)是constant的, 因此它是intrinstic state, 被存在memory里
* color(可能为绿色、紫色、橙色、黑色)不是constant的, 因此它是extrinsic state, 不被存在memory里

***

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/3-Structural%20Patterns/1-Flyweight%20Pattern/flyweight_pattern.png?raw=true">

***

从某种角度上说, Flyweight Pattern很像Creational pattern中的

* Multiton Pattern, 二者都是用一个缓存来缓存一些不同类型的对象
  * Multiton Pattern是当再次请求该对象时, 直接从缓存中拿到该对象并返回
  * Flyweight Pattern是当再次请求类似的对象时, 从缓存中找到该类似的对象, 再通过`operation(extrinsicState)`来为extrinsic states赋值 或进行customization

* Prototype Pattern, 二者都是从一个缓存中找到类似的对象
  * Prototype Pattern是直接复制它, 来创建新对象
  * Flyweight Pattern是通过`operation(extrinsicState)`来为extrinsic states赋值或进行customization (但并没有创建新对象, 而是reuse该类似对象).

<br>

## Benefit

<u>Greatly reduces the number of physically created objects, and thus reduces the load on memory and improves performance</u>

<br>

## Drawback

* Since for Flyweight Pattern we are sharing an instance (with the same identity), <u>this pattern can only be used when the code does not depend on the object identity</u>.
* 需要了解一下所要创建的对象: 需要提前区分好intrinsic states和extrinsic states