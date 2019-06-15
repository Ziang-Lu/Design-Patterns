# Publish-Subscribe Pattern (发布-订阅模式)

## Definition & Explanation

The Publish-Subscribe Pattern is a messaging pattern where **senders of messages, called publishers, do not program the messages to be sent directly to specific receivers, called subscribers, but instead categorize published messages into classes without knowledge of which subscribers, if any there may be. Similarly, subscribers express interest in one or more classes and only receive messages that are of interest, without knowledge of which publishers, if any, there are**.

<img src="https://github.com/Ziang-Lu/Design-Patterns/blob/master/4-Behavioral%20Patterns/12-Publish-Subscribe%20Pattern/publish-subscribe_pattern.png?raw=true">

<br>

## Benefits

* <u>Low coupling between the sender ("subject") and the receivers ("observer")</u>

  * *The sender only knows the Pub/Sub server and the channel, but not the actual receivers that will receive the message.*

  * *The receiver only knows the channels it subscribes to, but not the actual sender that sends the message.*

* Highly scalable

