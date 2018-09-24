#!usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Image module.
"""

__author__ = 'Ziang Lu'

import time
from abc import ABC, abstractmethod


class Image(ABC):
    """
    Abstract Image class that works as "Subject".

    In order to let the "Proxy" controls the access to its hiding "RealSubject"
    behind the scene, the "Proxy" needs to provide similar API as the
    "RealSubject".
    Therefore, we simply let this step be done via letting "RealSubject" and
    "Proxy" share a common super class "Subject", in which we define only the
    methods that we want the "Proxy" to provide access to.
    """
    __slots__ = []

    @abstractmethod
    def display_image(self) -> None:
        """
        Displays this image.
        :return: None
        """
        pass


class RealImage(Image):
    """
    RealImage class that works as "RealSubject".
    Since the creation of a RealImage object is expensive, this class should be
    cached by a proxy.
    """
    __slots__ = ['_filename']

    def __init__(self, filename: str):
        """
        Constructor with parameter.
        :param filename: str
        """
        self._filename = filename
        self._load_image_from_disk()

    def _load_image_from_disk(self) -> None:
        """
        Private helper function to load the image file from disk.
        :return: None
        """
        # Sleep 3 seconds to simulate the expensive loading process
        print(f'Loading {self._filename} from disk... This may take around 3 '
              f'seconds.')
        time.sleep(3)

    def display_image(self):
        print(f'Displaying {self._filename}')


class ImageProxy(Image):
    """
    ImageProxy class that works as "Proxy".
    An ImageProxy object acts as a cache that controls the access its hiding
    "expensive-to-create" RealImage object behind the scene. In this way, the
    "Proxy" will work on behalf of the "RealSubject", or the "Proxy" represents
    the "RealSubject".
    The "expensive-to-create" RealImage object is created only when a client
    first requests/accesses that object. Afterwards, the "Proxy" acts as a cache
    for that "expensive-to-create" RealImage object. In this way, we can avoid
    multiple loadings of the RealImage object.
    """
    __slots__ = ['_filename', '_real_image']

    def __init__(self, filename: str):
        """
        Constructor with parameter.
        :param filename: str
        """
        self._filename = filename
        self._real_image = None

    def display_image(self):
        # The "expensive-to-create" RealImage object is created only when a
        # client first requests/accesses that object.
        # Afterwards, the "Proxy" acts as a cache for that "expensive-to-create"
        # RealImage object.
        # In this way, we can avoid multiple loadings of the RealImage object.
        if not self._real_image:
            self._real_image = RealImage(self._filename)
        self._real_image.display_image()
