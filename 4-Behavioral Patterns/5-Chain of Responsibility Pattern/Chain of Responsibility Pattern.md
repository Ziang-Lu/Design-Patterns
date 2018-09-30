# Chain of Responsibility Pattern (责任链模式)

## Applicability



<br>

## Definition & Explanation

The Chain of Responsibility of a **behavioral pattern** that **chains the receiving objects and pass the request from the sender along the chain**, giving more than one receiver objects a chance to handle the request.

=> <u>Each receiver object contains reference to another receiver object. If one receiver object cannot handle the request, then it passes the request to the next receiver object, and so on.</u>

*(有点像一个linked-list of receiver objects)*



*Chain of Responsibility Pattern实际上应用了Delegation Pattern的思想, 因为它像将需要时, 将receiver object的handle行为delegate给一个receiver object.*

<br>

## Usage

* **1 receiver object** in the chain handles the request.

  One receiver object in the chain can handle the request,

  * Stop here and return.

* **>= 1 receiver objects** in the chain handle the request.

  One receiver object in the chain can handle the request,

  * Check whether the request needs further processing
    * If yes, pass the request to the next receiver object for further processing
    * If no, stop here and return.

<br>

## Benefit

Decouples the sender of the request and the receiving objects (as a chain)