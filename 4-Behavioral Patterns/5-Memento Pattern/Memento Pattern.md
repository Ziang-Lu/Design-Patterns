# Memento Pattern (备忘录模式)

## Applicability

* The <u>internal state of an object</u> should be <u>saved externally</u> so that <u>the object can be restored to that state later</u>.

* A well-designed object is encapsulated so that its representation (data structure) is hidden inside the object, and can't be accessed from outside the object.

  => We cannot explicitly save the object's internal representation by ourselves.

<br>

## Definition & Explanation

The Memento Pattern is a **behavioral pattern** that **provides the ability to restore an object to its previous state, which is like a "undo" or "rollback" operation**.

(This is a behavioral pattern because it defines a manner for controlling the communication between classes or entities.)

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/4-Behavioral%20Patterns/5-Memento%20Pattern/memento_pattern_illustration.png?raw=true">

*(有点像打游戏, 打某一关卡之前先存档, 如果失败了再回来读档)*

* `Memento`: <u>Holds a snapshot of the internal state of the `Originator`</u>

  *(This is like a wrapper (a packing box) for the internal state of the `Originator` to be stored.)*

* `Orginator`:

  * `createMemento():Memento` <u>creates a `Memento` containing a snapshot of its current internal state</u>

    注意: 如果某个attribute是一个immutable type, 则可以直接创建`Memento`; <u>如果attribute为一个mutable object, 则需要在创建`Memento`时, 为该mutable object创建深拷贝, 来防止在外部改变该mutable object时, `Memento`中保存的该对象也被改变</u>.

  * `restore(Memento memento)` <u>uses the `Memento` to restore its internal state</u>

* `Caretaker`: <u>Responsible for keeping  a collection of `Memento`</u>, but never examines or operates on the contents of a `Memento`

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/4-Behavioral%20Patterns/5-Memento%20Pattern/memento_pattern.png?raw=true" width="500px">

An better-designed UML diagram of Memento Pattern:

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/4-Behavioral%20Patterns/5-Memento%20Pattern/memento_pattern_improved.png?raw=true">

In this way, a better encapsulation is achieved:

* Only `MementoOriginator` can directly access the `Memento` objects, and thus its stored state information.
* All classes other than `MementoOriginator` can only access `Memento` objects through the mark interface `MementoIF`, so they will know nothing about the actual `Memento` objects.

***

某种程度、某种角度上, Memento Pattern和State Pattern有点相似:

* <u>State Pattern</u>仅仅关注<u>一个对象在各个state下的**behavior**的区别</u>, 即各个method的多态实现

* <u>Memento Pattern</u>则关注与<u>一个对象在各个state下**attributes**的区别</u>, 并<u>可以把他们分别封装保存在相应的`Memento`里</u>:

  每个`Memento`对应一种state保存起来, 其中记录了该state下对象的全部attribute的值

***

<br>

## Benefit

Enables to save and restore the internal state of an `Originator` without violating its encapsulation