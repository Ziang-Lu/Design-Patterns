#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Application that actually uses Adapter Pattern.
"""

__author__ = 'Ziang Lu'

from model import IPhone, IPhoneToFormatAndroidAdapter


def main():
    iphone = IPhone()

    android_recharger = IPhoneToFormatAndroidAdapter(iphone)
    android_recharger.use_micro_usb()
    android_recharger.recharge()


if __name__ == '__main__':
    main()

# Output:
# iPhone connected to micro USB recharger
# iPhone connected to lightning recharger
# Recharging iPhone via lightning recharger
