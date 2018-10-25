# Bridge Pattern (桥接模式)

## Applicability

* When you want to hide implementation details from clients

* <u>When both the class itself and what it does vary often</u>

  => The class itself can be thought of as the abstraction, and what the class can do as the implementation.

* When you want to <u>share an implementation among multiple objets</u>

* <u>When an abstraction and its implementation should be defined and extended independently from each other</u>

* When we should <u>avoid compile-time binding between an abstraction and its implementation</u>, so that <u>an implementation can be selected at runtime</u>

=> 将abstraction与其implementation分离开

<br>

## Definition & Explanation

The Bridge Pattern is a **structrual pattern** that **separates the abstraction part and its implementation part in two different layers, so that they can be developed independently: change in one part will not affect the functionality or development of the other part**.

<u>=> The client can only access the abstraction, without being concerned about its implementation</u>.

*("Bridge Pattern is all about preferring aggregation over inheritance.")*

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/3-Structural%20Patterns/2-Bridge%20Pattern/bridge_pattern.png?raw=true">

<br>

## Benefit

* <u>The abstraction of a class and its implementation can be defined and extended independently from each other.</u>
* We can achieve <u>dynamically binding an implementation to an abstraction at runtime</u>.

