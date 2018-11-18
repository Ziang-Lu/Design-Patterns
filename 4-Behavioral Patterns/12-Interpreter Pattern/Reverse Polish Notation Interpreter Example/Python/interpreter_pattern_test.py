#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Application that actually uses Interpreter Pattern.
"""

__author__ = 'Ziang Lu'

from typing import Dict

from interpreter import (
    AbstractExpression, AddOperation, MinusOperation, NumberExpression,
    VariableExpression
)


class Context:
    """
    Context class.
    This class contains the data to be interpreted.
    """
    __slots__ = ['_actual_variables']

    def __init__(self):
        """
        Default constructor.
        """
        self._actual_variables = {}

    def add_actual_variable(self, name: str, val: NumberExpression) -> None:
        """
        Adds the given actual variable to this context.
        :param name: str
        :param val: NumberExpression
        :return: None
        """
        self._actual_variables[name] = val

    @property
    def actual_variables(self) -> Dict[str, NumberExpression]:
        """
        Accessor of actual_variables.
        :return: dict{str: NumberExpression}
        """
        return self._actual_variables


def _construct_syntax_tree(reverse_polish_notation_expr: str) -> AbstractExpression:
    """
    Constructs the syntax tree for the given Reverse Polish Notation expression.
    :param reverse_polish_notation_expr: str
    :return: AbstractExpression
    """
    tokens = reverse_polish_notation_expr.split(' ')
    stack = []
    for token in tokens:
        if token == '+':
            right_operand = stack.pop()
            left_operand = stack.pop()
            stack.append(AddOperation(left_operand, right_operand))
        elif token == '-':
            subtrahend = stack.pop()
            minuend = stack.pop()
            stack.append(MinusOperation(minuend, subtrahend))
        else:
            stack.append(VariableExpression(token))
    return stack.pop()


def main():
    reverse_polish_notation_expr = 'w x z - +'
    # Here, this Reverse Polish Notation expression is a pure text, but follows
    # the grammar of a well-defined language, which in the case is the Reverse
    # Polish Notation.

    # Construct the syntax tree for this specific Reverse Polish Notation
    # expression
    entry_expr = _construct_syntax_tree(reverse_polish_notation_expr)
    # Only after we built the syntax tree for this specific expression are we
    # able to interpret a "sentence" (containing the variables to be placed into
    # this specific expression)

    # Build the context object for interpretation
    context = Context()
    context.add_actual_variable('w', NumberExpression(5))
    context.add_actual_variable('x', NumberExpression(10))
    context.add_actual_variable('z', NumberExpression(42))

    # Interpret the data in the context
    print(f'Evaluated result: {entry_expr.interpret(context)}')


if __name__ == '__main__':
    main()

# Output:
# Evaluated result -27
