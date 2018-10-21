#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Application module.
"""

__author__ = 'Ziang Lu'

from flyweight.customization import BMWCarCustomization
from flyweight.flyweight_car_factory import FlyweightBMWCarFactory, Model


def main():
    flyweight_bmw_car_factory = FlyweightBMWCarFactory()

    # In real-world application, we need to create a large number of objects of
    # similar nature, which would have consumed a large, unaccepted amount of
    # memory and decrease the performance.
    #
    # By using Flyweight Pattern, we first get the shared  "ConcreteFlyweight"
    # from the "FlyweightFactory", and then customize it to get the
    # "UnsharedConcreteFlyweight" we desire.
    # In this way, the number of physically created objects is greatly reduced,
    # and thus the load on memory is reduced and the  performance is improved.

    # Get the shared BMWSeries1 from the FlyweightBMWCarFactory
    series1car = flyweight_bmw_car_factory.get_flyweight_bmw_car(Model.Series1)
    series1car2 = flyweight_bmw_car_factory.get_flyweight_bmw_car(Model.Series1)
    # Make sure series1Car and series1Car2 are the same instance
    print(series1car)
    print(series1car2)

    print()

    # Get the shared BMWSeries2 from the FlyweightBMWCarFactory
    series2car = flyweight_bmw_car_factory.get_flyweight_bmw_car(Model.Series2)
    series2car2 = flyweight_bmw_car_factory.get_flyweight_bmw_car(Model.Series2)
    # Make sure series2Car and series2Car2 are the same instance
    print(series2car)
    print(series2car2)

    customization1 = BMWCarCustomization(tire_size=19,
                                         laser_signature='Oh yeah')
    customization2 = BMWCarCustomization(tire_size=21,
                                         laser_signature='Give you a ride!')

    print()
    print('Series 1 + Customization 1:')
    series1car.print_full_characteristics(customization1)
    print(f'Full price: {series1car.calc_price(customization1)}')

    print()
    print('Series 1 + Customization 2:')
    series1car.print_full_characteristics(customization2)
    print(f'Full price: {series1car.calc_price(customization2)}')

    print()
    print('Series 2 + Customization 1:')
    series2car.print_full_characteristics(customization1)
    print(f'Full price: {series2car.calc_price(customization1)}')

    print()
    print('Series 2 + Customization 2:')
    series2car.print_full_characteristics(customization2)
    print(f'Full price: {series2car.calc_price(customization2)}')


if __name__ == '__main__':
    main()

# Output:
# <flyweight.car.BMWSeries1 object at 0x108b52af0>
# <flyweight.car.BMWSeries1 object at 0x108b52af0>
#
# <flyweight.car.BMWSeries2 object at 0x108b52b00>
# <flyweight.car.BMWSeries2 object at 0x108b52b00>
#
# Series 1 + Customization 1:
# Tire Size: 19
# Laser Signature: Oh yeah
# Laser Signature: 7
# Full price: 27187
#
# Series 1 + Customization 2:
# Tire Size: 21
# Laser Signature: Give you a ride!
# Laser Signature: 16
# Full price: 28087
#
# Series 2 + Customization 1:
# Tire Size: 19
# Laser Signature: Oh yeah
# Laser Signature: 7
# Full price: 30400
#
# Series 2 + Customization 2:
# Tire Size: 21
# Laser Signature: Give you a ride!
# Laser Signature: 16
# Full price: 32200
