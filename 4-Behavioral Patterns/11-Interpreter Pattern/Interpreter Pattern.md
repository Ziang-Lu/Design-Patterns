# Interpreter Pattern (解释器模式)

## Applicability

* A grammar for a language should be defined, so that sentences in this language can be interpreted.

  *比如"I am hungry."这句话: 这句话本身是纯文本, 因此我们必须要先定义好English的grammar, 然后才能根据English来interpret这句话.*

* When a problem occurs very often, we could consider representing this problem as a sentence in a simple language (domain-specific language), so that we can create an interpreter to in the future interpret the sentence (understand the problem) and then solve it.

<br>

## Definition & Explanation

The Interpreter Pattern is a **behaviral pattern** that **provides a way to interpret grammer or expression for a well-defined language (i.e., working as a language interpreter)**.

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/4-Behavioral%20Patterns/11-Interpreter%20Pattern/interpreter_pattern_illustration.png?raw=true">

* `Context`: Contains the data to be interpreted

  *Note: Since `Context` contains the data to be interpreted, this class is project-specific.*

* `Client`

  * **Construct the abstract syntax tree for a language whose grammar should be well-defined**

    **我们构建syntax tree的过程就是为语言定义grammar的过程.**

    * `AbstractExpression`: An interface declaring an abstract `interpret(Context)` method that is common to all the nodes (expression instances) in the syntax tree, i.e., this is the highest level in the abstract syntax tree hierarchy

    * Concrete expression classes:

      Implements `AbstractExpression` interface, and provide implementation of `interpret(Context)` method, which does its own interpretation work on the `Context`, and then forwards the interpret request on the `Context` to its children nodes (expression instances) in the syntax tree for further interpretation (only for `NonterminalExpression`).

      * `TerminalExpression/LeafExpression`: Represents elements in the grammar that do not get replaced, and do not contain a reference to another expression
      * `NonterminalExpression/CompositeExpression`: Represents elements in the grammar that will be replaced during evaluation, and contains references to other expression instances (children nodes in the syntax tree)

    <img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/4-Behavioral%20Patterns/11-Interpreter%20Pattern/abstract_syntax_tree.png?raw=true" width="400px">

    **然而, 这个构建syntax tree的过程本身并不属于Interpreter Pattern的范畴, 而是可以由其他的工具来做好.**

  * Builds the `Context` object for interpretation

  * Invokes `interpret(Context)` method on the entry expression in the abstract syntax tree, passing in a reference to the `Context`

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/4-Behavioral%20Patterns/11-Interpreter%20Pattern/interpreter_pattern.png?raw=true">

*(We could notice that the structure of an abstract syntax tree is very similar to Composite Pattern.)*

