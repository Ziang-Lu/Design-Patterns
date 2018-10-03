# iMemento Pattern (备忘录模式)

## Definition & Explanation

The Memento Pattern is a **behavioral pattern** that **can restore an object to its previous state, which is like a "undo" or "rollback" operation**.

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/4-Behavioral%20Patterns/5-Memento%20Pattern/memento_pattern_illustration.png?raw=true">

* `Memento`: <u>Holds a snapshot of the internal state of the `Originator`</u>

  *(This is like a wrapper (a packing box) for the internal state of the `Originator` to be stored.)*

* `Orginator`: <u>Creates a `Memento` containing a snapshot of its current internal state, and uses the `Memento` to restore its internal state</u>

* `Caretaker`: <u>Responsible for keeping  a collection of `Memento`</u>, but never examines or operates on the contents of a `Memento`

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/4-Behavioral%20Patterns/5-Memento%20Pattern/memento_pattern.png?raw=true">

