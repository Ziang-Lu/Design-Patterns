# State Pattern (状态模式)

## Applicability

* An object should <u>change its behavior when its internal state changes</u>.

* State-specific behaviors should be defined independently. That is, the behavior of existing states should be changed and new states should be added independently.

  Implementing state-specific behavior directly within a calss is inflexible because it commits the class to a particular behavior and makes it impossible to change the behavior of an existing state or add a new state later independently from (without having to change) the class.

<br>

## Definition & Explanation

The State Pattern is a **behavioral pattern** that **allows an object to alter its behavior when its internal state changes.**

*本质上就是某个对象的当前状态不同, 会导致其不同的**行为***

* Define an `State` interface for performing some behaviors

* Define a separate `ConcreteState` classes that implements `State` interface for each state, and encapsulate state-specific behaviors

* Let the class delegate state-specific behavior to its current `State` object, rather than simply implement the state-specific behaviors directly within the class

  => <u>A class can change its behavior at runtime by changing its current state</u>.

  => *In doing so, the object will appear to have changed its class.*

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/4-Behavioral%20Patterns/3-State%20Pattern/state_pattern.png?raw=true">

*State Pattern can be interpreted as a Stategy Pattern which is able to switch the current strategy through invocations of methods defined in the pattern's interface.*

*有点像Strategy Pattern, 只不过将一组一组algorithms封装成不同的state,在不同的state中specify完成某个task的一组组algorithms.*

***

Note:

Another implementation would be `Context implements State`. This makes sure that `Context` class itself requires implementations for all the behaviors. In the implementations of the behaviors, `Context` simply delegate to its `State` to perform the state-specific behaviors.

***

<br>

## Benefits

* Makes a class independent of how state-specific behaviors are implemented
* Cleaner way for an object to <u>change its behavior at runtime without resorting to large monolithic conditional statements</u>, and thus improve maintainability   *(非常类似于Strategy Pattern)*

<br>

## Drawback

通过implement了几个例子, 说实话我觉得这个State Pattern很不好用......因为每个state都要考虑全部的behavior的implementation, 而由于很多state对于某个request的behavior是类似的, 实际上还是会有很多重复代码.

