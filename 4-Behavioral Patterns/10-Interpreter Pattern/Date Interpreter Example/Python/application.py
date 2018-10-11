#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Application that actually uses Interpreter Pattern.
"""

__author__ = 'Ziang Lu'

from datetime import datetime

from interpreter import (
    AbstractExpression, DayExpression, MonthExpression, YearExpression
)


class Context(object):
    """
    Context class.
    This class contains the data to be interpreted.
    """
    __slots__ = ['_date', '_curr_result']

    def __init__(self, date: datetime, template: str):
        """
        Constructor with parameter.
        :param date: datetime object
        :param template: str
        """
        self._date = date
        self._curr_result = template

    @property
    def date(self) -> datetime:
        """
        Accessor of date.
        :return: datetime object
        """
        return self._date

    @property
    def result(self) -> str:
        """
        Accessor of curr_result.
        :return: str
        """
        return self._curr_result

    @result.setter
    def result(self, result: str) -> None:
        """
        Mutator of curr_result.
        :param result: str
        :return: None
        """
        self._curr_result = result


def _construct_syntax_tree(format_: str) -> AbstractExpression:
    """
    Constructs the abstract syntax tree for the given format, which essentially
    specifies a language whose grammar should be well-defined.

    Note that for this particular application, the nodes (expression instances)
    in the syntax tree should be connected like a chain or linked-list, rather
    than a tree structure.
    :param format_: str
    :return: AbstractExpression
    """
    parts = format_.split('-')
    prev_expr, curr_expr = None, None
    for part in reversed(parts):
        if part == 'YYYY':
            curr_expr = YearExpression(prev_expr)
        elif part == 'MM':
            curr_expr = MonthExpression(prev_expr)
        elif part == 'DD':
            curr_expr = DayExpression(prev_expr)
        prev_expr = curr_expr
    return curr_expr


def main():
    # Get user input for the date format to use
    format_ = input("Please enter the format you want to convert to: "
                    "'MM-DD-YYYY' or 'YYYY-MM-DD': ")
    # Here, the format is a pure text, but essentially specifies a "language"
    # whose grammar should be well-defined.
    # Only after we defined the grammar for this "language" are we able to
    # interpret a "sentence" (a Date object) according to this "language".

    # Construct the abstract syntax tree for this language, which essentially is
    # the process of defining grammar for this language
    entry_expr = _construct_syntax_tree(format_)

    # Build the context object for interpretation
    context = Context(date=datetime.now(), template=format_)

    # Interpret the data in the context
    entry_expr.interpret(context)
    print(f'Final output: {context.result}')


if __name__ == '__main__':
    main()

# Output:
# Please enter the format you want to convert to: 'MM-DD-YYYY' or 'YYYY-MM-DD': MM-DD-YYYY
# After interpretation by YearExpression: 10-DD-YYYY
# After interpretation by YearExpression: 10-10-YYYY
# After interpretation by YearExpression: 10-10-2018
# Final output: 10-11-2018
#
# Please enter the format you want to convert to: 'MM-DD-YYYY' or 'YYYY-MM-DD': YYYY-MM-DD
# After interpretation by YearExpression: 2018-MM-DD
# After interpretation by YearExpression: 2018-10-DD
# After interpretation by YearExpression: 2018-10-10
# Final output: 2018-10-11
