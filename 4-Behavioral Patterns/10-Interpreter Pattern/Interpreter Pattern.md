# Interpreter Pattern (解释器模式)

## Definition & Explanation

The Interpreter Pattern is a **behaviral pattern** that **provides a way to interpret language grammer or expression (i.e., working as a language interpreter)**.

* `Context`: Contains the global information (including the data to be interpreted, as well as the expression for the data to be converted to) for interpretation

* `Client`

  * Builds the `Context` object for interpretation
  * Invokes `interpret(Context)` method, passing in a reference to the `Context`

* `AbstractExpression`: An interface declaring an abstract `interpret(Context)` operation that is common to all the nodes in the syntax tree

* Concrete expression interpreter classes:

  Implements `AbstractExpression` interface, and provide implementation of `interpret(Context)` method, which does its own interpretation work, and then propagate the results back up the stack

  * `TerminalExpression`: Represents elements in the grammar that do not get replaced, such as keywords
  * `NonterminalExpression`: Represents elements in the grammar that will be replaced during evaluation, such as variables

