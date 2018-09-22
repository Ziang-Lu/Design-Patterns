# Proxy Pattern (代理模式)

## Applicability

<br>

## Definition & Explanation

The Proxy Pattern is a **structural pattern** that **allows for controlling how an object is accessed, where a surrogate (the proxy) controls the access to that object**.

=> The <u>proxy is the object being called by the client</u> to <u>access the real object behind the scene</u>.

**=> The proxy works on behalf of the real object, or the proxy represents the real object.**

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/3-Structural%20Patterns/4-Proxy%20Pattern/proxy_pattern_illustration.png?raw=true">

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/3-Structural%20Patterns/4-Proxy%20Pattern/proxy_pattern.png?raw=true">

*本质上, Proxy Pattern有点像一个特殊的Decorator Pattern: 即`Proxy`作为一个decorator来wrap某个class, 完成了对该class的access control, 同时在`Proxy` (decorator)中进行一些必要的操作 (对应decorator中的"add new functionality/behavior").*

<br>

## Usage Scenarios

1. Protection Proxy
2. Remote Proxy
3. Virtual Proxy
4. Smart Proxy

<br>