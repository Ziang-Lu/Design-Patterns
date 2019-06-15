#!usr/bin/env python3
# -*- coding: utf-8 -*-

__author__ = 'Ziang Lu'


class Client:
    """
    Client class that can work both as the role of publisher and receiver.
    """
    __slots__ = ['_name', '_server']

    def __init__(self, name: str, server):
        """
        Constructor with parameter.
        :param name: str
        :param server: PubSubServer
        """
        self._name = name
        self._server = server

    def subscribe(self, channel: str) -> None:
        """
        Subscribes to the given channel.
        :param channel: str
        :return: None
        """
        print(f'{self._name} starts subscribing to channel-[{channel}]')
        self._server.register(self, channel)

    def publish(self, channel: str, content: str) -> None:
        """
        Publishes the given message to the given channel.
        :param channel: str
        :param content: str
        :return: None
        """
        print(f"{self._name} publishes message '{content}' to "
              f"channel-[{channel}]")
        self._server.route(channel, content)

    def receive_message(self, channel: str, message: str) -> None:
        """
        Receives the given message from the given channel.
        :param channel: str
        :param message: str
        :return: None
        """
        print(f"{self._name} receives message {message} from "
              f"channel-[{channel}]")


class PubSubServer:
    """
    Pub/Sub server class.
    """
    __slots__ = ['_channels_to_subscribers']

    def __init__(self):
        """
        Default constructor.
        """
        self._channels_to_subscribers = {}

    def register(self, cli: Client, channel: str) -> None:
        """
        Registers that the given client subscribes to the given channel.
        :param cli: Client
        :param channel: str
        :return: None
        """
        subscribers = self._channels_to_subscribers.get(channel, [])
        subscribers.append(cli)
        self._channels_to_subscribers[channel] = subscribers

    def route(self, channel: str, message: str) -> None:
        """
        Routes the given message to the given channel.
        :param channel: str
        :param message: str
        :return: None
        """
        if channel not in self._channels_to_subscribers:
            return
        for receiver in self._channels_to_subscribers[channel]:
            receiver.receive_message(channel, message)
