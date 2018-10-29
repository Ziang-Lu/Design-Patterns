# Observer Pattern (观察者模式)

## Applicability

* A one-to-many dependency between objects should be defined, without making the objects tightly coupled.

  Defining a one-to-many dependency between objects by defininig one object (subject) that directly updates the state of dependent objects is inflexible, because it commits the subject to particular dependent objects, and introduces tight couple.

  *即: The subject has to know how to update some particular dependent object, which could implement different interfaces. => Tight couple*

* It should be ensured that when one object changes state, an open-ended number of dependent objects are automatically updated.

<br>

## Definition & Explanation

-> Observer Pattern is a **behaviral pattern** that is an OO solution for **interaction between one object and one or more objects**.

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/4-Behavioral%20Patterns/10-Observer%20Pattern/observer_pattern.png?raw=true">

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/4-Behavioral%20Patterns/10-Observer%20Pattern/observer_pattern_uml.png?raw=true">

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/4-Behavioral%20Patterns/10-Observer%20Pattern/Java_Observable_Observer.png?raw=true">

***

The Observer Pattern is also known as the **Publish-Subscribe Pattern**.

Jargons/concepts mapping:

| Observer Pattern                      | Publish-Subscribe Pattern                    |
| ------------------------------------- | -------------------------------------------- |
| `Subject`                             | `Publisher`                                  |
| `Observer`                            | `Subscriber`                                 |
| `Subject.register(Observer observer)` | `Publisher.subscribe(Subscriber normalUser)` |
| `Subject.notifyObservers()`           | `Publisher.notifySubscribers()`              |
| `Observer.update()`                   | `Subscriber.update()`                        |

***

<br>

## Benefit

Loose coupling

=> The `Subject` (`Publisher`) doesn't need to know anything about the `Observer` (`Subscriber`).

## Drawback

The `Subject` (`Publisher`) may send updates that don't matter to the `Observer` (`Subsciber`), e.g., some useless system messages.

