# Proxy Pattern (代理模式)

## Applicability

* When we <u>want to do something more about the original object which is not in the scope of the original object</u>

  * <u>Control access to the original object</u>
  * <u>Additional functionality should be provided when accessing the original object</u>


<br>

## Definition & Explanation

The Proxy Pattern is a **structural pattern** that **allows for controlling how an object is accessed, where a surrogate (the proxy) controls the access to that object**.

=> The <u>proxy is the object being called by the client</u> to <u>access the real object behind the scene</u>.

**=> The proxy works on behalf of the real object, or the proxy represents the real object.**

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/3-Structural%20Patterns/5-Proxy%20Pattern/proxy_pattern_illustration.png?raw=true">

<br>

Define a separate `Proxy` object that

* can be used as a substitute for another object (`RealSubject`) and
* implements additional functionality to control access to the `RealSubject`

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/3-Structural%20Patterns/5-Proxy%20Pattern/proxy_pattern.png?raw=true" width="400px">

***

**Reason to let `RealSubject` and `Proxy` to both inherit from the abstract `Subject` class:**

In order to let the `Proxy` controls the access to its hiding `RealSubject` behind the scene, the `Proxy` needs to provide similar API as the `RealSubject`.

Therefore, we simply let this step be done via letting `RealSubject` and `Proxy` share a common super class `Subject`, in which we define only the methods that we want the `Proxy` to provide access to.

=> In this way, the clients can't tell whether they are working with a `RealSubject` or its `Proxy`.

***

*本质上, Proxy Pattern有点像一个特殊的Decorator Pattern: 即 `Proxy`作为一个decorator来wrap某个class, 完成了对该class的access control, 同时在`Proxy` (decorator)中进行一些必要的操作 (对应decorator中的"add new functionality/behavior").*

<br>

## Usage Scenarios

### 1. Protection Proxy (保护代理)

<u>In `Proxy`: perform protection-related operations</u>, e.g., filtering out users without enough permission, or invalid method calls

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/3-Structural%20Patterns/5-Proxy%20Pattern/Usage%201-Protection%20Proxy/protection_proxy.png?raw=true">

### 2. Virtual Proxy (虚拟代理) / Caching Proxy (缓存代理)

* A virtual proxy is <u>a placeholder for "expensive-to-create" objects</u>.

* The `Proxy` delays the instantiation of the real "expensive-to-create" object until its behavior is called for.

  => If its behavior is never called for, then the real "expensive-to-create" class is never instantiated.

  Afterwards, the `Proxy` acts as <u>a cache for that "expensive-to-create" object</u>.

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/3-Structural%20Patterns/5-Proxy%20Pattern/Usage%202-Virtual%20Proxy/virtual_proxy.png?raw=true">

### 3. Remote Proxy (远程代理)

Scenario: <u>The proxy resides in the same network as the actual user, but the `RealSubject` does not.</u>

=> A remote proxy provides <u>a local representative for an object that resides in a different network</u>.

=> The proxy can contain the networking, piping, or other logic required to access the `RealSubject` across the barrier (different network).

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/3-Structural%20Patterns/5-Proxy%20Pattern/Usage%203-Remote%20Proxy/remote_proxy.png?raw=true">

<br>

## Typical Usage: Proxy Server (代理服务器)

- **Internet Service Provider (ISP) access control (filtering)**

  Usually a company will limit the sites that its employees can or cannot access. For example, the employees are not allowed to access gaming sites during work time.

  This can be achieved by using Proxy Pattern: the company simply adds a `CompanyProxyInternet` between the browser and the real ISP, and all of the requests to the real ISP must go through the `CompanyProxyInternet` first.

  In `CompanyProxyInternet`, we can perform the filtering based on the requested site. In this way, the company is able to limit the browser's access to sites with the real ISP.

- **Cache contents and improve performance (as a Virtual Proxy)**

  In `CompanyProxyInternet`, the proxy can cache the responses of the requested sites for some time, so that next time another user under the same proxy requests the same site, `CompanyProxyInternet` will not forward the request again to the site, but simply return the response it previously cached.

  Since the proxy is usually in the same network as the actual user, by caching the operations can be much faster, which dramatically improve the performance for the actual user (client).

* **Make the actual user anonymous**

  The company server can also make the actual user anonymous to the real ISP, e.g., by replacing the actual user's IP address with the company proxy's IP address, so that the real ISP will only know the request comes from the company proxy.

<br>