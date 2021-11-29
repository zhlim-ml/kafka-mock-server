Feature: Kafka Test  

  Scenario: kafka Test

    # Send request to kafka consumer
    * def topic = 'test_topic'
    * def consumer = Java.type('util.kafka.Consumers')
    * def kafkaEvent = new consumer(topic)

    * def kafkaValue = kafkaEvent.readValue()
    * print kafkaValue