#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Application that actually uses Mediator Pattern.
"""

__author__ = 'Ziang Lu'

from model import MemberPhoneCustomer, NormalPhoneCustomer, PhoneExchange


def main():
    phone_exchange = PhoneExchange()
    steve = NormalPhoneCustomer(name='Steve', phone_exchange=phone_exchange)
    print(steve)
    tony = MemberPhoneCustomer(name='Tony', phone_exchange=phone_exchange)
    print(tony)
    bruce = NormalPhoneCustomer(name='Bruce', phone_exchange=phone_exchange)
    print(bruce)

    print()

    steve_phone_number = steve.phone_number
    tony.call(recipient_number=steve_phone_number, msg='Come back.')
    print()
    bruce.call(recipient_number=steve_phone_number, msg='Tony needs you.')


if __name__ == '__main__':
    main()

# Output:
# NormalPhoneCustomer[name=Steve, phone_number=381-622-2946 with 50 calls per month]
# MemberPhoneCustomer[name=Tony, phone_number=960-265-8658 with unlimited calls per month
# NormalPhoneCustomer[name=Bruce, phone_number=670-355-4820 with 50 calls per month]
#
# Tony calling 381-622-2946 with the message: Come back. ...
# Successful!
# Steve received a call from 960-265-8658 with message: Come back.
#
# Bruce calling 381-622-2946 with the message: Tony needs you. ...
# Successful!
# Steve received a call from 670-355-4820 with message: Tony needs you.
