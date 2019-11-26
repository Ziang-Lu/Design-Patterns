# Observer Pattern (观察者模式)

## Applicability

* A one-to-many dependency between objects should be defined, without making the objects tightly coupled.

  Defining a one-to-many dependency between objects by defininig one object (subject) that directly updates the state of dependent objects is inflexible, because it commits the subject to particular dependent objects, and introduces tight couple.

  *即: The subject has to know how to update some particular dependent object, which could implement different interfaces. => Tight couple*

* It should be ensured that when one object changes state, an open-ended number of dependent objects are automatically updated.

<br>

## Definition & Explanation

-> Observer Pattern is a **behaviral pattern** that is an OO solution for **interaction between one object and one or more objects**.

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/4-Behavioral%20Patterns/11-Observer%20Pattern/observer_pattern.png?raw=true">

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/4-Behavioral%20Patterns/11-Observer%20Pattern/observer_pattern_uml.png?raw=true">

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/4-Behavioral%20Patterns/11-Observer%20Pattern/Java_Observable_Observer.png?raw=true">

<br>

## Implementation Detail

In the `Subject` itself, we keep track of the `Observer`s.

-> When there is no other reference on that specific `Observer`, we won't need that `Observer` anymore and want GC to collect it.

-> However, due to the fact that the `Subject` still holding an extra (strong) reference on that `Observer`, it won't be collected by GC.

Thus, we can use **weak references** to keep track of the `Observer`s, so that when there is no other reference on that specific `Observer`, GC will feel free to collect it.

<br>

## Drawbacks

* Although the `Subject` (`Publisher`) doesn't need to know anything about the `Observer` (`Subscriber`), it still has to be aware of the existence of the `Observer` (`Subscriber`), i.e., has the reference of the `Observer` (`Subscriber`), which leads to tight-coupling

  => If the `Observer` (`Subscriber`) only needs to know the message itself, but not the `Subject` (`Publisher`) who publishes it, we can resolve the above tight-coupling issue by:

  * Introduce a message queue server between the `Subject` (`Publiser`) and the `Observer` (`Substriber`)
  * The `Observer` (`Subscriber`) registers itself with the message queue server, and specify what kinds of messages it wants to receive.
  * Whenever the state of the `Subject` (`Publisher`) changes, it sends the update to the message queue server, and let the message queue server publishes the message to all the interested `Observer` (`Subscriber`)

  In this way, the `Subject` (`Publisher`) and the `Observer` (`Subscriber`) may know nothing about each other, and thus decreasing the coupling.

* The `Subject` (`Publisher`) may send updates that don't matter to the `Observer` (`Subsciber`), e.g., some useless system messages.

