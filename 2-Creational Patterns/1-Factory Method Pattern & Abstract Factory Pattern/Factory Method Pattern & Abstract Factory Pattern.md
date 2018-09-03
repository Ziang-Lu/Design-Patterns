# Factory Method Pattern (工厂方法模式) & Abstract Factory Pattern (抽象工厂模式)

### Applicability (of Factory Method Pattern and Abstract Factory Pattern combined)

- How can an application be independent of how its objects are created?

- How can a class be independent of how the objects it requires are created?

- <u>The class can't anticipate the type of objects it must create</u>, i.e., the type of the object is unknown at compile time.

  *即当前class并不知道自己将创建的object的实际具体type是什么.*

- <u>The class wants its subclasses to specify the type of objects it creates.</u>

  *即当前class刻意想让其subclass来指定将创建什么实际具体type的object.*

- The class needs control over the creation of its objects.

  *e.g., when there is a limit on the number of objects that can be created*

- How can families of related or dependent objects be created?

<br>

### Definition & Explanation

***

* **Factory**:

  -> <u>Location of a concrete class at which objects are constructed</u>

***

=> Factory Method Pattern is a **creational pattern** that uses factory methods to deal with the problem of **creating objects without having to specify the exact class of the object that will be created**.

This is done by calling a factory method — **either specified in an interface and implemented by child classes, or implemented in a base class and optionally overriden by derived classes** — rather than calling a constructor.

*(=> Abstract Factory Pattern)*

- The Factory Method Pattern describes how to solve such problems:
  - Define a separate operation (factory method) for creating an object
  - Create an object by calling a factory method
- This enables writing of subclasses to change the way an object is created (to redefine which class to instantiate).

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/2-Creational%20Patterns/1-Factory%20Method%20Pattern%20&%20Abstract%20Factory%20Pattern/factory_method_pattern.png?raw=true">

=> **By separating the objects creation process from the client code that actually use the abstract interface instances, the classes (both the factory, product and client classes) become more reusable.**

=> Adding new concrete types is done by modifying the client code to use a different factory, a modification that is typically one line in one file.

e.g.,

```java
DocumentCreator newCreator = new NewDocumentCreator();
```


