# Builder Pattern (建造者模式)

### Applicability

Problem: Creating and assembling the parts of a <u>complex</u> object directly within the class is inflexible. It commits the class to creating a particular representation of the complex object, and makes it impossible to change the representation later independently (without having to change) from the class.

* How can a class (the same contruction process) create different representations of a complex object?

  *即不必在constructor中一次性specify全部的parameter, 而可以somehow (通过builder) 动态地添加field   [1]*

  *又可以认为, 将相同的construction process抽象出来, 但是却somehow可以构造出class的不同的representation, 即不同种的object   [2]*

* How can a class that includes creating a complex object be simplified?

<br>

### Definition & Explanation

The Builder Pattern is a **creational pattern** that **constructs complex objects made up from a bunch of its component objects, and meanwhile keeps the creation of these part objects to be independent from the main object**.

*Builder Pattern <u>builds a complex object using simple objects and using a step-by-step approach</u>.*

*=> The <u>process of constructing an complex object should be generic</u> so that <u>the same process can be used to create different representations of the same complex object</u>.*

* The client <u>delegates object creation to a `Builder` object instead of creating the objects directly</u>.

* Encapsulate creating and assembling <u>the parts of a complex object in a separate `Builder` object</u>

  `Builder` is responsible for defining the construction process for individual parts. `Builder` has those individual processes to initialize and configure the product.

* `Product` is the final output object which is produced from `Builder` and as directed.

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/2-Creational%20Patterns/6-Builder%20Pattern/builder_pattern.png?raw=true">

In this way, we successfuly **separate the representation of a class from its construction process**.

*即正如前面[1]所说, 不必在constructor中一次性specify全部的parameter, 而可以通过builder动态地添加field*

*例如, 在Phone Example中仅仅specify `os` to be "Android"以及`ram` to be 2MB, 可以构造出一部phone; 在另一个情况下, 可以仅仅specify `os` to be "iOS"以及`screenSize` to be 5.5 inch 来构造出另一部phone.*

The client can **delegate to different `Builder` objects to create different representations of a complex object**.

*正如前面[2]所说, 可以相同的construction process抽象出来, 但是却可以构造出class的不同的representation, 即不同种的object*

*例如, 在下面的例子中, `OldRobot`和`NewRobot`构造的过程是相同的, 但是通过`OldRobotBuilder`和`NewRobotBuilder`的不同implementation来实现: 在`RobotBuilder`和`RobotEngineer`中有相同的构造过程, 但是最终却构造出不同种的object.*

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/2-Creational%20Patterns/6-Builder%20Pattern/robot_example.png?raw=true">

<br>

### Benefits

* Encapsulates code for construction and representation (separation)

* Allows you to vary a product's internal representation

  * Also allow for inserting new implementations of how an object is built without disturbing the client code

    *即创建一个新的类型的`ConcreteBuilder`*

* Provides control over steps in the construction process

<br>

### Drawbacks

* Requires creating a separate `ConcreteBuilder` class for each different type of `Product`
* Data members of `Product` aren't guaranteed to be initialized.
* Dependency injection may be less supported.