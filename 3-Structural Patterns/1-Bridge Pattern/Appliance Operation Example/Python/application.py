#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Application that actually uses Bridge Pattern.
"""

__author__ = 'Ziang Lu'

from appliance_implementor import FloorLamp, TV
from turn_on_and_off import OnOffSwitch, PullCord


def main():
    floor_lamp = FloorLamp()
    pull_cord = PullCord(appliance=floor_lamp)

    pull_cord.turn_on()
    pull_cord.turn_off()

    tv = TV()
    on_off_switch = OnOffSwitch(appliance=tv)

    on_off_switch.turn_on()
    on_off_switch.turn_off()


if __name__ == '__main__':
    main()

# Output:
# Floor Lamp is turned on.
# Floor Lamp is turned off.
# TV is turned on.
# TV is turned off.
