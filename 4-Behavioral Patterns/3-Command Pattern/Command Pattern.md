# Command Pattern (命令模式)

## Applicability

* When we need to avoid the coupling between the invoker of a request (即下文中的`Invoker`) and a particular request (即下文中的`Command`)

* When we need to decouple the object that needs actions to be performed (即下文中的`Invoker`) from the objects that actually perform those actions (即下文中的`Receiver`).

* When we want a list of codes to be encapsulated (即下文中的`Command`) so that it can be run at a later time or many times

  (=> Whenever we want that `Command` to run, we simply let the `Invoker` call that specific `Command`'s `execute()` method.)

<br>

## Definition & Explanation

The Visitor Pattern is a **behavioral pattern** that **encapsulates a request inside a `Command`, which contains a reference to a `Receiver`, and an `execute()` method, in which we let the `Receiver` perform some actions and thus handle the request**; this `Command` object will be passed to an `Invoker`: **the `Invoker` does not know how to handle the request, but simply invoke the `Command`'s `execute()` method, and let the internal correct `Receiver` handle the request**.

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/4-Behavioral%20Patterns/3-Command%20Pattern/command_pattern_illustration.png?raw=true">

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/4-Behavioral%20Patterns/3-Command%20Pattern/command_pattern.png?raw=true" width="400px">

<br>

## Code Example

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/4-Behavioral%20Patterns/3-Command%20Pattern/Word%20App%20Menu%20Example/class_diagram.png?raw=true">

<br>

## Benefits

* When the `Client` needs to perform some action, it doesn't need to be concerned about its details.

  *Hides details about how to perform the action from the client*

  (=> Instead, the `Client` just create a `Command` (request) by specifying its `Receiver`, pass the `Command` to the `Invoker`, and wait for the `Invoker` to execute it.)

* Since the `Invoker` is no longer coupled with any specific `Command` (request), we can dynamically specify request at runtime

  => The `Invoker` doesn't need to be concerned about the details, either.

  (=> Instead, the `Invoker` just execute the `Command` (by calling `command.execute()` method), and let its internal correct `Receiver` handle the request.)

* Allows you to set aside a list of `Command`s for later use

<br>

## Drawback

说实话我觉得这个Command Pattern很不好用:

* 对于每种不同的`Command`都需要实现一个`ReceiverCommandX`, 由于可能存在非常多的不同的`Command`, 代码变得非常多且复杂

