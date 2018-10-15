#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Interpreter Module.
"""

__author__ = 'Ziang Lu'

from abc import ABC, abstractmethod


class AbstractExpression(ABC):
    """
    AbstractExpression class.
    This abstract class declares interpret(Context) method that is common to all
    the nodes (expression instances) in the syntax tree, i.e., this is the
    highest level in the abstract syntax tree hierarchy.
    """
    __slots__ = []

    @abstractmethod
    def interpret(self, context) -> None:
        """
        Interprets the data in the given context.
        :param context: Context
        :return: None
        """
        pass


class NonterminalExpression(AbstractExpression):
    """
    NonterminalExpression (CompositeExpression) class.
    This class should contain references to other expression instances (children
    nodes) in the syntax tree.
    The interpret(Context) method in this class and its subclasses should do its
    own interpretation work on the given "Context", and then forwards the
    interpret request on the "Context" to its children nodes (expression
    instances) in the syntax tree for further interpretation.

    Note that for this particular application, the nodes (expression instances)
    in the syntax tree should be connected like a chain or linked-list, rather
    than a tree structure.
    Therefore, this can be viewed as an implementation of Chain of
    Responsibility Pattern.
    """
    __slots__ = ['_next_expr']

    def __init__(self, expr: AbstractExpression):
        """
        Constructor with parameter.
        :param expr: AbstractExpression
        """
        self._next_expr = expr
        # Next expression.
        # This works as the next receiver (handler) in the chain of
        # responsibility.

    def interpret(self, context):
        super().__init__(context)

    def _forward_interpret(self, context) -> None:
        """
        Protected helper function to forward the interpret request to the next
        expression instance in the syntax tree for further interpretation.
        In terms of Chain of Responsibility Pattern, pass the request to the
        next receiver in the chain of responsibility.
        :param context: Context
        :return: None
        """
        if self._next_expr:
            self._next_expr.interpret(context)


class YearExpression(NonterminalExpression):
    """
    Concrete YearExpression class that works as a "NonterminalExpression".
    This class is responsible for interpreting the year expression (YYYY) of a
    date.
    """
    __slots__ = []

    def __init__(self, expr: AbstractExpression):
        """
        Constructor with parameter.
        :param expr: AbstractExpression
        """
        super().__init__(expr)

    def interpret(self, context):
        # Interpret the "year" part
        year = context.date.year
        new_result = context.result.replace('YYYY', str(year))
        print(f'After interpretation by YearExpression: {new_result}')
        context.result = new_result

        # Forward the interpret request to the children expression instances in
        # the syntax tree for further interpretation
        self._forward_interpret(context)


class MonthExpression(NonterminalExpression):
    """
    Concrete MonthExpression class that works as a "NonterminalExpression".
    This class is responsible for interpreting the month expression (MM) of a
    date.
    """
    __slots__ = []

    def __init__(self, expr: AbstractExpression):
        """
        Constructor with parameter.
        :param expr: AbstractExpression
        """
        super().__init__(expr)

    def interpret(self, context):
        # Interpret the "month" part
        month = context.date.month
        new_result = context.result.replace('MM', str(month))
        print(f'After interpretation by YearExpression: {new_result}')
        context.result = new_result

        # Forward the interpret request to the children expression instances in
        # the syntax tree for further interpretation
        self._forward_interpret(context)


class DayExpression(NonterminalExpression):
    """
    Concrete DayExpression class that works as a "NonterminalExpression".
    This class is responsible for interpreting the day expression (DD) of a
    date.
    """
    __slots__ = []

    def __init__(self, expr: AbstractExpression):
        """
        Constructor with parameter.
        :param expr: AbstractExpression
        """
        super().__init__(expr)

    def interpret(self, context):
        # Interpret the "day" part
        day = context.date.day
        new_result = context.result.replace('DD', str(day))
        print(f'After interpretation by YearExpression: {new_result}')
        context.result = new_result

        # Forward the interpret request to the children expression instances in
        # the syntax tree for further interpretation
        self._forward_interpret(context)
