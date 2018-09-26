# Null Object Pattern (空对象模式)

## Definition & Explanation

A **null object** is **an oject** with no referenced value (`null`) or **with defined neutral (null) behavior (`NullObject`) (that does nothing or some default behavior), to indicate that an object does not exist**.

=> The Null Object Pattern describes the usage of such objects and their behaviors.

*This pattern can be viewed as a special case of State Pattern: it's like a class having a special state "EmptyState".*

<br>

## Example Usage

For example, a function may retrieve a list of files in a folder and perform some action on each. In the case of an empty folder, one response may be to <u>throw an exception or return a null reference</u>. Thus, <u>the code which expects a list must verify that it in fact has one before proceeding</u>, which can complicate the design.

By <u>returning a null object (i.e., an empty list)</u> instead, there is <u>no need to verify that the return value is in fact a list. The calling function may simply go ahead and iterate the list as normal</u>, effectively doing nothing.

<br>

## Benefit

A null object is <u>very predictable and has no side effects: it does nothing</u>.

<br>

## Drawback

* <u>A special null class must be created for each class hierarchy that may require a null object.</u>
* Since this pattern neither throw an exception nor does null check, it <u>can make errors/bugs appear as normal program execution</u>.