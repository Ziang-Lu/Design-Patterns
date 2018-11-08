# Command Pattern (命令模式)

## Definition & Explanation

The Visitor Pattern is a **behavioral pattern** that **encapsulates a request inside a `Command`, which contains a reference to a `Receiver`, and an `execute()` method, in which we let the `Receiver` perform some actions and thus handle the request**; this `Command` object will be passed to an `Invoker`: **the `Invoker` does not know how to handle the request, but simply invoke the `Command`'s `execute()` method, and let the internal correct `Receiver` handle the request**.

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/4-Behavioral%20Patterns/6-Command%20Pattern/command_pattern_illustration.png?raw=true">

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/4-Behavioral%20Patterns/6-Command%20Pattern/command_pattern.png?raw=true">

<br>

## Code Example

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/4-Behavioral%20Patterns/6-Command%20Pattern/Restaurant%20Example/class_diagram.png?raw=true">

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/4-Behavioral%20Patterns/6-Command%20Pattern/Restaurant%20Example/sequence_diagram.png?raw=true" width="500px">