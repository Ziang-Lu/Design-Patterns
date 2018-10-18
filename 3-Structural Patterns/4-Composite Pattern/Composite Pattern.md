# Composite Pattern (复合模式)

## Applicability

* <u>Many things in the world are self-referential, as in they can contain themselves in their inherent structure.</u>

  e.g., branches may contain branches and leaves, folders may contain folders and files...

* When defining `Part` objects and `Whole` objects that act as container for `Part` objects, clients must treat them separately, which complicates the client code.

  => A part-whole hierarchy should be represented so that clients can <u>treat part and whole objects uniformly</u>.

* => A part-whole hierarchy should be represented <u>as a tree structure</u>.

<br>

## Definition & Explanation

-> Composite Pattern is a **structural pattern** that is an OO solution for a **hierarchical structure**.

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/3-Structural%20Patterns/4-Composite%20Pattern/composite_pattern.png?raw=true">

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/3-Structural%20Patterns/4-Composite%20Pattern/composite_pattern_uml.png?raw=true" width="500px">

*Note that since for `Composite`, we are forwarding the request from the client to its sub-components, we are actually in some sense using Delegation Pattern here*

<br>

## Design for Uniformity vs. Design for Type Safety

There are two design variants for defining and implementing child-related operations like adding/removing a child component to/from the container (`addChild(child)/removeChild(child)`) and accessing a child component (`getChild()`):

* Design for Uniformity

  <u>Child-related operations are defined in the `Component` interface.</u>

  <u>=> This enables the client to treat `Composite` and `Leaf` objects uniformly.</u>

  * By type safety is lost because <u>clients can perform child-related operations on `Leaf` objects, which is not approapriate</u>.

* Design for Type Safety

  Child-related operations are defined only in the `Composite` class.

  => In this way, clients must treat `Composite` and `Leaf` objects differently.

  * But type safety is gained because <u>client cannot perform child-related operations on `Leaf` objects, which is a desired design</u>.

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/3-Structural%20Patterns/4-Composite%20Pattern/design_for_type_safety_vs_design_for_uniformity.png?raw=true">

*这里有点tricky: 根据Applicability, 为了能让client uniformly地使用`Composite`和`Leaf`对象, 应该使用Design for Uniformity的实现; 然而在UML diagram中, 却使用了Design for Type Safety的实现.*

*=> 看来还是需要根据需求, 具体情况具体分析.*