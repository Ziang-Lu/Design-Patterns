# Visitor Pattern (访问者模式)

## Applicability

* When you have distinct and unrelated operations to perform across an object structure

<br>

### Definition & Explanation

Visitor Pattern is a **behavioral pattern** that **separates an algorithm (an operation) from the object structure it operates on, and the executing algorithm (operation) is encapsulated in a visitor object**. <u>The elements in the object structure has to accept the visitor object, and let the visitor object perform the algorithm (handle the operation) on them.</u>

=> In this way, we can <u>change the executing algorithm (operation) on each element in the object structure</u>, by simply <u>varying the visitor object</u>, without needing to modify the object structure itself.

<br>

## Benefit

* <u>Gains ability to modify operations and add new operations to existing object structure without modifying the object structure itself</u>

