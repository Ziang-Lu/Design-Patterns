# Visitor Pattern (访问者模式)

## Applicability

* <u>When you have distinct and unrelated operations to perform across an object structure</u>

  *(这当然可以用inheritance实现, 但是那样的话未来如果增添、删除、修改这些operation就很困难: 需要直接修改该object structure的代码. => 违反了Open/Close Principle)*

* When you want an object structure that <u>adding, removing, or mainitaining operations on that objet structrure</u> can be done <u>without changing its code</u>

  => When you want to <u>avoid pollution of concrete classes with many different operations</u>

  => You want to <u>centralize each operation on the object structure into its own class</u>.

<br>

### Definition & Explanation

Visitor Pattern is a **behavioral pattern** that **separates an algorithm (an operation) from the object structure it operates on, and the executing algorithm (operation) is encapsulated in a visitor object**. <u>The elements in the object structure has to accept the visitor object, and let the visitor object perform the algorithm (handle the operation) on them.</u>

=> In this way, we can <u>change the executing algorithm (operation) on each element in the object structure</u> by simply <u>varying the visitor object</u>, without needing to modify the object structure itself.

*(与Strategy Patttern有点类似, 都是把系统的行为和其抽象(结构)本身分离开, 只不过Strategy Pattern使用`AbstractStrategy`对象来实现系统的行为, 而Visitor Pattern使用`Visitor`对象来实现系统的行为.)*

*(由于Visitor Pattern与某一种object structure密切相关, 所以它可以与Iterator Pattern结合起来使用, 即iterate over一个包含某个object structure的对象.)*

* `Element/Visitable`
  * Represents an element in the object structure
  * <u>Can be visited by a `Visitor`, so that the `Visitor` can perform algorithm (handle operation) on this `Element`</u>
* `Visitor`
  * <u>Encapsulates the executing algorithm (operation) on elements in the object structures</u>
  * <u>Can visit each `Element` in the object structure, and perform desired algorithm (handle operation) on that `Element`</u>

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/4-Behavioral%20Patterns/2-Visitor%20Pattern/visitor_pattern.png?raw=true" width="500px">

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/4-Behavioral%20Patterns/2-Visitor%20Pattern/visitor_pattern_sequence_diagram.png?raw=true" width="500px">

In this way, we can <u>centralize a functionality to a single `ConcreteVisitor`</u>, so that <u>an instance of this `ConcreteVisitor` class can visit each `Element` in the object structure, and implement desired functionality on that `Element`</u>.

*(=> Check out the car part example)*

<br>

## Benefit

* <u>Gains ability to modify operations and add new operations to existing object structure without modifying the object structure itself</u>

  => Avoids pollution of concrete classes with many different operations

<br>

## Drawback

* Adding new `ConcreteElement` is difficult, since it requires adding a method in each `ConcreteVisitor`

  => The operational area of Visitor Pattern is limited to only very stable class hierarchies.

