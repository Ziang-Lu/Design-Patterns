# Decorator Pattern (装饰器模式)

## Applicability



<br>

## Definition & Explanation

The Decorator Pattern is a **structural pattern** that is **a wrapper that adds new functionality to an existing class**, without impacting existing structure and functionality of the objects.

=> <u>Decorator is an object that adds feature to another object.</u>

* Take a class `SampleClass`
* Build a class that wraps `SampleClass`: `WrapperClass`
* Reproduce the functionality of the original class, but also add some more functionalities

**Stackable: You can add decorators on decorators on decorators …… to further increase the provided functionalities.**

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/3-Structural%20Patterns/3-Decorator%20Pattern/decorator_pattern.png?raw=true" witdh="500px">

<br>

