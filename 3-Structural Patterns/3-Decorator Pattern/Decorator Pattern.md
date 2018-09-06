# Decorator Pattern (装饰器模式)

### Definition & Explanation

The Decorator Pattern is a **structural pattern** that is **a wrapper that adds functionality to a class**.

* Take a class `SampleClass`
* Builder a class that wraps `SampleClass`: `WrapperClass`
* Reproduce the functionality of the original class, but also add some more functionalities

**Stackable**: You can add decorators on decorators on decorators …… to further increase the provided functionalities.