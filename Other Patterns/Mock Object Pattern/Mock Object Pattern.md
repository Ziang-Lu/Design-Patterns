# Mock Object Pattern (模拟对象模式)

## Applicability

* In **unit test**, when we need to **test the behaviors of some real complex object**, but it is **impractical or impossible to be incorporated into unit tests**

  These real complex objects might be:

  * Does not exist yet, or may change behavior later

  * Slow (e.g., a complete database, which would have to be initialized before the test)

<br>

## Definition & Explanation

**Mock objects** are **simulated objects that mimic the behavior of real complex objects in controlled ways**.

=> In this way, we can use a mock object to simulate the behavior of a real complex object that is impractical or impossible to be incorporated into unit tests.

*例如, 在汽车设计中, 我们想要测试真实人类在被汽车冲撞时的动态behavior, 但是我们不能真的使用真实人类来进行测试.*

*因此, 我们使用一个mock假人傀儡来模拟真实人类的behavior......*

<br>

## Technical Details

Mock objects must have the same interface as the real objects.

