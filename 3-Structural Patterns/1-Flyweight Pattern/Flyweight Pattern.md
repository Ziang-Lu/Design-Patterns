# Flyweight Pattern (享元模式/轻量级模式)

## Applicability

* When we <u>need to create a large number of objects of almost similar nature</u>

  => These large number of objects <u>consume a large amount of memory and decrease the performance</u>.

<br>

## Definition & Explanation

The Flyweight Pattern is a **structural pattern** that <u>when you need to create a large number of objecs of almost similar nature (which consume a large amount of memory and decrease the performance)</u>, the Flyweight Pattern **stores already existing similar objects in a cache, so that they can easily be reused, and creates a new object only when no matching object is found**.

<u>=> In this way, the load on memory is reduced and the performance is increased.</u>

In Flyweight Pattern, the **states in the objects to be created** can be classifies as:

* **Intrinsic states (固有状态)**

  States that are **constant**, and thus are **stored in memory**

* **Extrinsic states (外部状态)**

  States that are **NOT constant**, and **needs to be calculated on the fly**, and thus are **NOT stored in memory**

***

Example:

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/3-Structural%20Patterns/1-Flyweight%20Pattern/flyweight_pattern_illustration.png?raw=true">

在此例中, 我们需要创建大量的Circle objects:

- 如果我们无脑创建, 则会消耗大量的memory, 并降低程序性能

- 因此, 我们可以使用Flyweight Pattern, 把一个Circle object先存入memory中, 然后通过复制该对象来得到我们想要的对象

  => 这样就可以减少memory的使用, 并提升程序性能

states:

* 由于shape(圆形)是constant的, 因此它是intrinstic state, 被存在memory里
* color(可能为绿色、紫色、橙色、黑色)不是constant的, 因此它是extrinsic state, 不被存在memory里

***

*(从某种角度上说, Flyweight Pattern也可以算是Creational pattern中的Prototype Pattern的一种变体, 只不过Prototype Pattern是从缓存的对象中直接复制, 而Flyweight Pattern则是从缓存中找到类似的对象、复制、再为extrinsic states赋值.)*

<br>

## Benefit

<u>Reduces the load on memory and improves performance</u>

<br>

## Drawback

需要了解一下所要创建的对象: 需要提前区分好intrinsic states和extrinsic states