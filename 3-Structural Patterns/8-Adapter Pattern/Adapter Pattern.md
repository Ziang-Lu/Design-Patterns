# Adapter Pattern (适配器模式)

## Applicability:

* When we <u>want a class (即下文中的`Adaptee` class) that does not have a client-required interface (即下文中的`Target` interface) to be reused</u>

  *(Often an already existing class (即下文中的`Adaptee` class) can't be reused only because its interface doesn't conform to the client-required interface (即下文中的`Target` interface).)*

* When we <u>need two independent or incompactible interfaces (即下文中的`Adaptee` class和`Target` interface) to work together</u> (and don't want to change the source code for the two independent or incompatible interfaces)

<br>

## Definition & Explanation

The Adapter Pattern is a **structural pattern** that **involves a single class called `Adapter` which is responsible for communication between two independent or incompatible interfaces** (即下文中的`Adaptee` class和`Target` interface), so that we don't have to change their source code.

=> <u>Work through an `Adapter` class to reuse classes (即下文中的`Adaptee` class) that do not have the client-required interface (即下文中的`Target` interface)</u>

=> Adapter Pattern可以消除由于接口不匹配所导致的兼容性问题.

*(Sometimes the `Adapter` can also validate the data to be transfered, making sure that only the correct data with the correct format goes into the application (即下文中的`Client`) from the external application (即下文中的`Adaptee` class).)*

<br>

*Note that in the following illustration, the existing HR system and the third-party billing system independent or incompatible*

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/3-Structural%20Patterns/8-Adapter%20Pattern/adapter_pattern_illustration.png?raw=true">

<br>

## Implementations

*Note that in the following UML diagrams, the`Target` interface and the `Adaptee` class are independent or incompatible*

* **Object Adapter (对象适配器)**

  <img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/3-Structural%20Patterns/8-Adapter%20Pattern/object_adapter.png?raw=true" width="600px">

  * Since we cannot change the `Target`interface, in order to keep the original API, we create an `Adapter` class that implements the `Target` interface.
  * In order to make the `Target` interface and the `Adaptee` work together, in the `Adapter` class, we simply keep a referent to the `Adaptee` object, and delegate the request from the client to this `Adaptee` object.

<br>

* **Class Adapter (类适配器)**

  <img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/3-Structural%20Patterns/8-Adapter%20Pattern/class_adapter.png?raw=true" width="500px">

  * Since we cannot change the `Target` interface, in order to keep the original API, we create an `Adapter` class that implements the `Target` interface.
  * In order to make the `Target` interface and the `Adaptee` work together, we let `Adapter` class inherit the `Adaptee` class, and thus inheriting the methods in the `Adaptee` class, so it can forward the request from the client to the correct `Adaptee` class method.

<u>In the `Adapter`, some necessary conversions is made to properly</u>

* <u>send the request from the client to the `Adaptee`;</u>
* <u>return the response from the `Adaptee` back to the client.</u>

***

**Runtime implementation**:

We could use an adapter factory to achieve runtime implementation of the adaption behavior:

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/3-Structural%20Patterns/8-Adapter%20Pattern/Runtime%20Implementation/runtime_implementation.png?raw=true">

<br>

## Benefits

* <u>Successfully integrates two indepenent or incompatible systems</u>
* Since the adapter helps keeping the codes for parsing information separated, we <u>avoid the codes for parsing information to be part of the core application</u>.
* <u>Whenever there is a change in the outside interface, all we need to modify is the Adapter Pattern module, and the rest of the application won't be affected.</u>

