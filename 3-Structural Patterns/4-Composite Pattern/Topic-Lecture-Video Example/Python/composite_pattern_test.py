#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Application that actually uses Composite Pattern.
"""

__author__ = 'Ziang Lu'

from model import Lecture, Topic, Video


def main():
    design_patterns = Topic('Design Patterns')

    patterns_intro = Lecture('Intro to Design Patterns')
    design_patterns.add_module(patterns_intro)

    composite = Topic('Composite Pattern')
    design_patterns.add_module(composite)

    composite_intro = Lecture('Intro to Composite Pattern')
    composite.add_module(composite_intro)
    composite_video = Video("Let's compose!")
    composite.add_module(composite_video)

    observer = Topic('Iterator Pattern')
    design_patterns.add_module(observer)

    observer_intro = Lecture('Intro to Observer Pattern')
    observer.add_module(observer_intro)

    design_patterns.display('\t')


if __name__ == '__main__':
    main()

# Output:
# 	  Topic - Design Patterns
#         Lecture - Intro to Design Patterns
#         Topic - Composite Pattern
#                 Lecture - Intro to Composite Pattern
#                 Video - Let's compose!
#         Topic - Observer Pattern
#                 Lecture - Intro to Observer Pattern
