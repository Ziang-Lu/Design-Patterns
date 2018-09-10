# Facade Pattern (外观模式/门面模式)

## Applicability:

* When a <u>system is very complex or difficult to understand</u> because the <u>system has a large number of sub-components</u> or because its source code is unavailable.

* When the <u>client that access a complex subsystem directly refer to many different objects having different interfaces (tight coupling)</u>, which makes the client hard to implement, change, test and reuse

  => The client's dependency on the sub-components should be minimized.

* When an entry point is needed to each level of layered software

<br>

## Definition & Explanation

*(是一种非常自然, 非常common sense的做法)*

The Facade Pattern is a **structural pattern** that **decouples the client from the sub-components needed to perform some operations by creating a simplified interface (the facade) that performs many other actions behind the scenes, and thus hiding the complexities **.

*This pattern hides the complexities of the larger system, and provides a simpler interface (the facade) to the client. These hidden sub-components access the system on behalf of the client.*

*Facade Pattern实际上应用了Delegation Pattern的思想, 因为它像是一个wrapper把sub-components包起来, 但是又在内部将它的行为delegate给sub-components.*

* A `Facade` is an object that serves as a <u>front-facing interface masking more complex underlying or structural code</u>.

  The `Facade` implements a simple interface in terms of the interfaces of the sub-components.

* The `Facade` may perform additional functionality before/after forwarding a request.

  *(此时`Facade`起到一个wrapper class的作用, 也有点像一个decorator.)*

*即用一个总的`Facade`把许多sub-components封装起来, 简化client的使用过程.*

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/3-Structural%20Patterns/4-Facade%20Pattern/facade_pattern.png?raw=true" width="400px">

In this way, the client will depend only on the simple `Facade`, and thus the client's dependency on the sub-components is greatly minimized.

*(<u>The client doesn't necessarily to know the complex logic and implementation details in the sub-components, but only need to interact with the `Facade`.</u>)*

<br>

## Benefits

* Provide a context-specific interface to more generic functionalities
* When used in some software library, can greatly improve the usability and readability by <u>masking interaction with more complex components behing a single API</u>
* Serves as a launching point for a broader refactor of monolithic or tightly-coupled systems