# Decorator Pattern (装饰器模式) / Wrapper Pattern (包装模式)

## Applicability

* <u>Responsibilities should be added to (and removed from) an object dynamically at runtime.</u>

* When using subclassing, different subclasses extend a class in different ways. But <u>an extension is bound to the class at compile-time and can't be changed at runtime</u>.

  *即若想让某个object增加功能A, 然后再增加功能B*:

  * *使用inheritance: 需要在design-time创建`ClassWithAandB`, 然后创建出该object*

    *然而, 很多编程语言不支持在runtime dynamically创建class; 并且, 我们也很难预测出实际情况中仅需哪些feature的组合从而在design-time只创建那些组合的subclass*

    *=> 因此, 我们不得不为每一种feature的组合都创建一个subclass, which is practically infeasible.*

    *此外, 使用inheritance来增加功能B, 会应用于全部该subclass, 而不是只为某个object增加功能*

  * *使用decorator: 可以在design-time创建`DecoratorA`和`DecoratorB`, 再根据需要让其dynamically decorate原object*


<br>

## Definition & Explanation

The Decorator Pattern is a **structural pattern** that **allows behavior to be added to an individual object, dynamically, without affecting the behavior of other objects from the same class**.

*即在decorate时, 我们实际上是在decorate某个具体的object, 而不是在decorate该object的class.*

The Decorator Pattern is a **structural pattern** that is **a wrapper that adds new functionality to an existing class**, without impacting existing structure and functionality of the objects.

=> <u>Decorator is an object that adds feature to another object dynamically.</u>

***

**Stackable: You can add decorators on decorators on decorators …… to further increase the provided functionalities.**

Thus, we let different `ConcreteComponent` classes and the abstract `Decorator` both inherit from the common super class `Component`, so that `Decorator` will only have an abstract `Component` object to decorate, but doe not need to care it will actually decorate a `ConcreteComponent` or another `Decorator`.

***

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/3-Structural%20Patterns/3-Decorator%20Pattern/decorator_pattern.png?raw=true">

*Note that since for `Decorator`, we are forwarding the request from the client to the `Component` it's decorating, we are actually in some sense using Delegation Pattern here*

<br>

The following diagram shows the runtime interaction of a simple example:

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/3-Structural%20Patterns/3-Decorator%20Pattern/runtime_diagram.png?raw=true">

