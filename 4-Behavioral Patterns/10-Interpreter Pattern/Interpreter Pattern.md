# Interpreter Pattern (解释器模式)

## Applicability

* <u>A grammar for a language should be defined, so that sentences in this language can be interpreted.</u>

  *比如"I am hungry."这句话: 这句话本身是纯文本, 因此我们必须要先定义好English的grammar, 然后才能根据English来interpret这句话.*

* When a problem occurs very often, we could consider representing this problem as a sentence in a simple language (domain-specific language), so that we can create an interpreter to in the future interpret the sentence (understand the problem) and then solve it.

<br>

## Definition & Explanation

The Interpreter Pattern is a **behaviral pattern** that **provides a way to interpret grammer or expression for a well-defined language (i.e., working as a language interpreter)**.

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/4-Behavioral%20Patterns/10-Interpreter%20Pattern/interpreter_pattern_illustration.png?raw=true">

* `Context`: <u>Contains the data to be interpreted</u>

  *Note: Since `Context` contains the data to be interpreted, this class is <u>project-specific</u>.*

* `Client`

  * **Construct the abstract syntax tree for a language whose grammar should be well-defined**

    **我们构建syntax tree的过程就是为语言定义grammar的过程.**

    * `AbstractExpression`: <u>An interface declaring an abstract `interpret(Context)` method that is common to all the nodes (expression instances) in the syntax tree</u>, i.e., this is the highest level in the abstract syntax tree hierarchy

    * Concrete expression classes:

      Implements `AbstractExpression` interface, and provide implementation of `interpret(Context)` method, which <u>does its own interpretation work on the `Context`, and then forwards the interpret request on the `Context` to its children nodes (expression instances) in the syntax tree for further interpretation (only for `NonterminalExpression`)</u>.

      * `TerminalExpression/LeafExpression`: Represents elements in the grammar that do not get replaced, and <u>do not contain a reference to another expression</u>
      * `NonterminalExpression/CompositeExpression`: Represents elements in the grammar that will be replaced during evaluation, and <u>contains references to other expression instances (children nodes in the syntax tree)</u>

    <img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/4-Behavioral%20Patterns/10-Interpreter%20Pattern/abstract_syntax_tree.png?raw=true">

    **然而, 这个构建syntax tree的过程本身并不属于Interpreter Pattern的范畴, 而是可以由其他的工具来做好.**

  * <u>Builds the `Context` object for interpretation</u>

  * <u>Invokes `interpret(Context)` method on the entry expression in the abstract syntax tree, passing in a reference to the `Context`</u>

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/4-Behavioral%20Patterns/10-Interpreter%20Pattern/interpreter_pattern.png?raw=true">

*(We could notice that the structure of an abstract syntax tree is very similar to Composite Pattern.)*
