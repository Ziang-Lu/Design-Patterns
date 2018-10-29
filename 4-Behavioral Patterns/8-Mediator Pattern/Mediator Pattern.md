# Mediator Pattern (中介者模式)

## Applicability

* A lot of objects want to communicate to each other.

  => By letting them directly communicate to each other, there would be too tight coupling and the code would be extremely difficult to maintain.

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/4-Behavioral%20Patterns/8-Mediator%20Pattern/mediator_pattern_problem.png?raw=true">

* It should be possible to independently change the interaction between a set of objects.

<br>

## Definition & Explanation

The Mediator Pattern is a **behavioral pattern** that provides a mediator object which acts as the communication center for objects: **when an object needs to communicate to another object, it does not directly call on the other object; instead, it calls the mediator object** whose main duty is to control and coordinate the communication.

**These objects don't need to know anything about each other, but they communicate through the mediator object, and the communication between these objects are encapsulated within the mediator object.**

=> This design pattern can reduce the communication complexity between multiple objects.

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/4-Behavioral%20Patterns/8-Mediator%20Pattern/mediator_pattern_illustration.png?raw=true">

*The idea of a central controller (the mediator) is one of the key aspects of the Mediator Pattern.*

*=> When there are too many relationships between objects in your code, it's time to think of having such a centrol point of control (the mediator).*

<br>

## Benefits

* Reduce the communication complexity between multiple objects
* => Reduce the dependency (coupling) between these objects in the system

