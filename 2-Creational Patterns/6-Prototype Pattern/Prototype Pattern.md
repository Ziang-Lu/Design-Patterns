# Prototype Pattern (原型模式)

## Applicability

* How can objects be created so that which objects to create can be specified at runtime?

  *即如何才能在runtime时再决定创建哪种具体类型的object*

  *(有点像在Prototype的factory中, 存储一个type String -> Prototype的map, 然后在runtime根据给定的type String来确定从哪个Prototype来clone出新instance)*

* How can dynamically loaded classes be instantiated?

  i.e., when there are numerous potential classes that you want to only use if needed at runtime

* Avoid the inherent cost/complexity of creating a new object in the standard way (using the `new` operator), when it is prohibitively expensive for a given application

  i.e., when creation of object directly is costly or complex

  *即正常用new创建object的成本过高或过于复杂以至于application中无法承担*

  -> Performance

* When instances of a class can have only a few different combinations of states, it may be more convenient to install a corresponding number of prototypes and clone them rather than instantiating the objects manually.

  *(e.g., YouTube tutorial中pizza的例子: 一共只有几种不同类型的pizza (食材不同))*

<br>

## Definition & Explanation

Prototype Pattern is a **creational pattern** that **creates objects whose type is determined by a protytypical instance, which is cloned to produce new objects**.

*即由现有的某个prototype通过clone的方式创建新的object*

* The Prototype Pattern describes how to solve such problems:
  * Define a `Prototype` object, acting as a cache, that is able to return copies of itself
  * Create new objects by copying a `Prototype` object

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/2-Creational%20Patterns/6-Prototype%20Pattern/prototype_pattern.png?raw=true">

<br>

## Benefits

* Avoid subclasses of an object creator in the client application

  *类似于Factory Method Pattern + Abstract Factory Pattern*

***

* **Relationship with Factory Method Pattern + Abstract Factory Pattern**

  * There are cases when either prototype or abstract factory would be appropriate.

  * At other times, they complement each other:

    Abstract factory might store a set of prototypes from which to clone and return product objects.

* **Relationship with Singleton Pattern**

  * Similar to Singleton Pattern
  * However, Singleton Pattern keeps only one singleton instance, and return it every time an instance is requested. Instead, Prototype Pattern also keeps only one prototype, but clones and returns a new instance every time an instance is requested.

***

## Drawback

Requires creating prototypes before create other objects