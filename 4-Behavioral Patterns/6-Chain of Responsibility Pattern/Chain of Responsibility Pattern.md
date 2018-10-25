# Chain of Responsibility Pattern (责任链模式)

## Applicability

* When we need to<u> avoid the coupling between the sender of a request and its receiver</u>
* When <u>it should be possible that more than one receiver can handle the request</u>, and new handlers can be added dynamically into the code
* When the order in which the request is handled is important

*=> Implementing a request directly within the class that sends it is inflexible, because it couples the class to a particular receiver, and makes it impossible to support multiple receivers.*

<br>

## Definition & Explanation

The Chain of Responsibility of a **behavioral pattern** that **chains the receivers and pass the request from the sender along the chain**, giving more than one receivers a chance to handle the request.

=> **Each receiver contains reference to another receiver. If one receiver cannot handle the request, then it passes the request to the next receiver (if any), and so on.**

*(有点像一个linked-list of receivers)*

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/4-Behavioral%20Patterns/6-Chain%20of%20Responsibility%20Pattern/chain_of_responsibility_pattern_illustration.png?raw=true">

*(从某种意义上讲: The Chain of Responsibility Pattern is an object-oritented version of the `if ... else if ... else if ... else ... endif` idiom, with the benefit that the condition-action blocks can be dynamically rearranged and reconfigured at runtime.)*

*(A typical example of Chain of Responsibility Pattern is that in a typical `try...catch` code block, there could be multiple `catch` blocks: here every `catch` block is kind of a handler to handle one particular kind of exception, so that when any exception occurs in the `try` block, it is sent to the first `catch` block to be handled; if the first `catch` block is not able to handle it, that `catch` block forwards the exception to the next `catch` block in the chain.)*

<br>

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/4-Behavioral%20Patterns/6-Chain%20of%20Responsibility%20Pattern/chain_of_responsibility_pattern.png?raw=true">

***

**Reason to let `ConcreteHandler` inherit from the abstract `Handler` class**:

In order to let different `ConcreteHandler` be able to process the same request, we need them to have similar `API`. 

Therefore, we simply let this step be done via letting different `ConcreteHandler`  share a common super class `Handler`, in which we define the API to processs a request.

=> This enables to send a request to a chain of receivers, without having to know which one actually handles the request.

***

<br>

## Usage

* **Only 1 receiver** in the chain handles the request.

  One receiver in the chain can handle the request,

  * Stop here and return.

  <img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/4-Behavioral%20Patterns/6-Chain%20of%20Responsibility%20Pattern/Usage%201-Only%20One%20Receiver%20Handles%20Request/only_one_receiver_handles_request.png?raw=true" width="600px">

* **>= 1 receivers** in the chain handle the request.

  One receiver in the chain can handle the request,

  * Check whether the request needs further processing
    * If yes, pass the request to the next receiver for further processing
    * If no, stop here and return.

  <img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/4-Behavioral%20Patterns/6-Chain%20of%20Responsibility%20Pattern/Usage%202-One%20or%20More%20Receivers%20Handle%20Request/one_or_more_receivers_handle_request.png?raw=true"><br>

## Benefit

Since the sender simply sends the request to a chain of receivers without having to know which one actually handles the request,  <u>the sender is no longer coupled to a particular receiver</u> (the sender is independent of which receiver actually handles the request).