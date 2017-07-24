package com.howtoprogram.kafka;

import java.util.Properties;
import kafka.producer.*;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

//import kafka.producer.ProducerConfig;

public class ProducerTest {

  public static void main(String[] args) {
    Properties props = new Properties();
   
    props.put("bootstrap.servers", "localhost:9092");
    props.put("acks", "all");
    props.put("retries", 0);
    props.put("batch.size", 16384);
    props.put("linger.ms", 1);
    props.put("max.block.ms", 1000);
   // props.put("offset.store.sync.interval.ms", 1000);
    props.put("buffer.memory", 33554432);
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
   // System.out.println();
    Producer<String, String> producer = null;
   // System.out.println();
    try {
      producer = new KafkaProducer<String, String>(props);
      for (int i = 0; i < 10; i++) {
        String msg = "Message " + i;
        producer.send(new ProducerRecord<String, String>("HelloKafkaTopic", msg));
        System.out.println("Sent:" + msg);
      }
    } catch (Exception e) {
      e.printStackTrace();

    } finally {
      producer.close();
   /* Producer<String, String> producer = new KafkaProducer<>(props);
    for(int i = 0; i < 5; i++)
        producer.send(new ProducerRecord<String, String>("my-topic", Integer.toString(i), Integer.toString(i)));

    producer.close();*/
  }
    }

  

}
