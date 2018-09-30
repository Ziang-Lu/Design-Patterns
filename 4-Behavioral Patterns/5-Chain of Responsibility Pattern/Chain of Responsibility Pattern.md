# Chain of Responsibility Pattern (责任链模式)

## Applicability



<br>

## Definition & Explanation

The Chain of Responsibility of a **behavioral pattern** that **chains the receiving objects and pass the request from the sender along the chain**, giving more than one receiver objects a chance to handle the request.

=> <u>Each receiver object contains reference to another receiver object. If one receiver object cannot handle the request, then it passes the request to the next receiver object, and so on.</u>

*(有点像一个linked-list of receiver objects)*

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/4-Behavioral%20Patterns/5-Chain%20of%20Responsibility%20Pattern/chain_of_responsibility_pattern_illustration.png?raw=true">

*Chain of Responsibility Pattern实际上应用了Delegation Pattern的思想, 因为它像将需要时, 将receiver object的handle行为delegate给一个receiver object.*

<br>

## Usage

* **Only 1 receiver object** in the chain handles the request.

  One receiver object in the chain can handle the request,

  * Stop here and return.

  <img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/4-Behavioral%20Patterns/5-Chain%20of%20Responsibility%20Pattern/Usage%201-Only%20One%20Receiver%20Handles%20Request/only_one_receiver_handles_request.png?raw=true" width="600px">

* **>= 1 receiver objects** in the chain handle the request.

  One receiver object in the chain can handle the request,

  * Check whether the request needs further processing
    * If yes, pass the request to the next receiver object for further processing
    * If no, stop here and return.

  <img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/4-Behavioral%20Patterns/5-Chain%20of%20Responsibility%20Pattern/Usage%202-One%20or%20More%20Receiver%20Handle%20Request/one_or_more_receivers_handle_request.png?raw=true"><br>

## Benefit

Decouples the sender of the request and the receiving objects (as a chain)