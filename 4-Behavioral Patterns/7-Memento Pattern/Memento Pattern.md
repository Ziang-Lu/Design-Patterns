# Memento Pattern (备忘录模式)

## Applicability

* The internal state of an object should be saved externally so that the object can be restored to that state later.

* A well-designed object is encapsulated so that its representation (data structure) is hidden inside the object, and can't be accessed from outside the object.

  => We cannot explicitly save the object's internal representation by ourselves.

<br>

## Definition & Explanation

The Memento Pattern is a **behavioral pattern** that **provides the ability to restore an object to its previous state, which is like a "undo" or "rollback" operation**.

(This is a behavioral pattern because it defines a manner for controlling the communication between classes or entities.)

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/4-Behavioral%20Patterns/7-Memento%20Pattern/memento_pattern_illustration.png?raw=true">

*(有点像打游戏, 打某一关卡之前先存档, 如果失败了再回来读档)*

* `Memento`: Holds a snapshot of the internal state of the `Originator`

  *(This is like a wrapper (a packing box) for the internal state of the `Originator` to be stored.)*

* `Orginator`:

  * `createMemento():Memento` creates a `Memento` containing a snapshot of its current internal state

    注意: 如果某个attribute是一个immutable type, 则可以直接创建`Memento`; 如果attribute为一个mutable object, 则需要在创建`Memento`时, 为该mutable object创建深拷贝, 来防止在外部改变该mutable object时, `Memento`中保存的该对象也被改变.

  * `restore(Memento memento)` uses the `Memento` to restore its internal state

* `Caretaker`: Responsible for keeping  a collection of `Memento`, but never examines or operates on the contents of a `Memento`

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/4-Behavioral%20Patterns/7-Memento%20Pattern/memento_pattern.png?raw=true" width="500px">

An better-designed UML diagram of Memento Pattern:

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/4-Behavioral%20Patterns/7-Memento%20Pattern/memento_pattern_improved.png?raw=true">

In this way, a better encapsulation is achieved:

* Only `MementoOriginator` can directly access the `Memento` objects, and thus its stored state information.
* All classes other than `MementoOriginator` can only access `Memento` objects through the mark interface `MementoIF`, so they will know nothing about the actual `Memento` objects.

<br>

## Benefit

Enables to save and restore the internal state of an `Originator` without violating its encapsulation