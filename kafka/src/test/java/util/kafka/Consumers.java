package util.kafka;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.serialization.LongDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.*;

public class Consumers {

    private static String topic;
    private final static String BOOTSTRAP_SERVERS =
            "localhost:9093";
    private Consumer<String, String> consumer;

    public Consumers(String topic) {
        this.topic = topic;
        this.consumer = createConsumer();

    }

    private static Consumer<String, String> createConsumer() {
        final Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
                BOOTSTRAP_SERVERS);
       props.put(ConsumerConfig.GROUP_ID_CONFIG,
               "KarateTestConsumer");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
        StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class.getName());
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");

        // Create the consumer using props.
        KafkaConsumer<String, String> consumer =
                new KafkaConsumer<String, String>(props);

        // Subscribe to the topic.
        consumer.subscribe(Arrays.asList(topic));
        
        return consumer;
    }

    public List<String> readValue() {
        List<String> valueList = new ArrayList<String>();
        
        //for(int i = 0; i <= 10; i++){
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(20000));
            for (ConsumerRecord<String, String> record : records) {
                valueList.add(record.value());
            }
        //}
        consumer.close();
        return valueList;
    }


}
