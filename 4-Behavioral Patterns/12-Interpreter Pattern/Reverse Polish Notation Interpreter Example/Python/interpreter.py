#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Interpreter module.
"""

__author__ = 'Ziang Lu'

from abc import ABC, abstractmethod


class AbstractExpression(ABC):
    """
    Abstract AbstractExpression class.
    This class declares interpret(Context) method that is common to all the
    nodes (expression instances) in the syntax tree, i.e., this is the highest
    level in the abstract syntax tree hierarchy.
    """
    __slots__ = []

    @abstractmethod
    def interpret(self, context) -> int:
        """
        Interprets the data in the given context.
        :param context: Context
        :return: int
        """
        pass


class TerminalExpression(AbstractExpression):
    """
    TerminalExpression (LeafExpression) class.
    This class does not contain references to other expression instances
    (children nodes) in the syntax tree.
    The interpret(Context) method in this class and its subclasses should only
    do its own interpretation work on the given "Context".
    """
    __slots__ = []

    def interpret(self, context):
        super().interpret(self)


class VariableExpression(TerminalExpression):
    """
    Concrete VariableExpression class.
    This class is responsible for interpreting a variable by querying the actual
    variables in the given "Context".
    """
    __slots__ = ['_name']

    def __init__(self, name: str):
        """
        Constructor with parameter.
        :param name: str
        """
        self._name = name

    def interpret(self, context):
        actual_variable = context.actual_variables[self._name]
        if not actual_variable:
            return 0
        return actual_variable.interpret(context)


class NumberExpression(TerminalExpression):
    """
    Concrete NumberExpression class.
    This class is responsible for interpreting the value of a single number.
    """
    __slots__ = ['_number']

    def __init__(self, number: int):
        """
        Constructor with parameter.
        :param number: int
        """
        self._number = number

    def interpret(self, context):
        return self._number


class NonterminalExpression(AbstractExpression):
    """
    NonterminalExpression (CompositeExpression) class.
    This class should contain references to other expression instances (children
    nodes) in the syntax tree.
    The interpret(Context) method in this class and its subclasses should do its
    own interpretation work on the given "Context", and then forwards the
    interpret request on the "Context" to its children nodes (expression
    instances) in the syntax tree for further interpretation.
    """
    __slots__ = []

    def interpret(self, context):
        super().interpret(self)


class Operation(NonterminalExpression):
    """
    Abstract Operation class.
    This class is responsible for interpreting an operation on a left operand
    (AbstractExpression) and a right operand (AbstractExpression).
    """
    __slots__ = ['_left_operand', '_right_operand']

    def __init__(self, left_operand: AbstractExpression,
                 right_operand: AbstractExpression):
        """
        Constructor with parameter.
        :param left_operand: AbstractExpression
        :param right_operand: AbstractExpression
        """
        self._left_operand = left_operand
        self._right_operand = right_operand


class AddOperation(Operation):
    """
    Concrete AddOperation class.
    This class is responsible for interpreting the add operation on a left
    operand (AbstractExpression) and a right operand (AbstractExpression).
    """
    __slots__ = []

    def __init__(self, left_operand: AbstractExpression,
                 right_operand: AbstractExpression):
        """
        Constructor with parameter.
        :param left_operand: AbstractExpression
        :param right_operand: AbstractExpression
        """
        super().__init__(left_operand, right_operand)

    def interpret(self, context):
        return self._left_operand.interpret(context) + \
               self._right_operand.interpret(context)


class MinusOperation(Operation):
    """
    Concrete MinusOperation class.
    This class is responsible for interpreting the minus operation on a minuend
    (AbstractExpression) and a subtrahend (AbstractExpression).
    """
    __slots__ = []

    def __init__(self, minuend: AbstractExpression,
                 subtrahend: AbstractExpression):
        """
        Constructor with parameter.
        :param minuend: AbstractExpression
        :param subtrahend: AbstractExpression
        """
        super().__init__(minuend, subtrahend)

    def interpret(self, context):
        return self._left_operand.interpret(context) - \
               self._right_operand.interpret(context)
