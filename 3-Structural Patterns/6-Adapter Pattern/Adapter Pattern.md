# Adapter Pattern (适配器模式)

## Applicability:

* When we <u>need two independent or incompactible interfaces to work together</u> (and don't want to change the code for the two independent or incompatible interfaces)

<br>

## Definition & Explanation

The Adapter Pattern is a **structural pattern** that **involves a single class called `Adapter` which is responsible for communication between two independent or incompatible interfaces**, so that we don't have to change the code for the two independent or incompatible interfaces.

*=> Adapter Pattern可以消除由于接口不匹配所导致的兼容性问题.*

*Note that in the following illustration, the existing HR system and the third-party billing system independent or incompatible*

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/3-Structural%20Patterns/6-Adapter%20Pattern/adapter_pattern_illustration.png?raw=true">

<br>

## Implementations

*Note that in the following UML diagrams, the`Target` interface and the `Adaptee` class are independent or incompatible*

* **Object Adapter (对象适配器)**

  <img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/3-Structural%20Patterns/6-Adapter%20Pattern/object_adapter.png?raw=true" width="600px">

  * Since we cannot change the `Target`interface, in order to keep the original API, we create an `Adapter` class that implements the `Target` interface.
  * In order to make the `Target` interface and the `Adaptee` work together, in the `Adapter` class, we simply keep a referent to the `Adaptee` object, and delegate the request from the client to this `Adaptee` object.

<br>

* **Class Adapter (类适配器)**

  <img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/3-Structural%20Patterns/6-Adapter%20Pattern/class_adapter.png?raw=true" width="500px">

  * Since we cannot change the `Target` interface, in order to keep the original API, we create an `Adapter` class that implements the `Target` interface.
  * In order to make the `Target` interface and the `Adaptee` work together, we let `Adapter` class inherit the `Adaptee` class, and thus inheriting the methods in the `Adaptee` class, so it can forward the request from the client to the correct `Adaptee` class method.

<u>In the `Adapter`, some necessary conversions is made to properly</u>

* <u>send the request from the client to the `Adaptee`;</u>
* <u>return the response from the `Adaptee` back to the client.</u>

