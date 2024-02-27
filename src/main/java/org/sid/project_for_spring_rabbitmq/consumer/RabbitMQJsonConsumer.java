package org.sid.project_for_spring_rabbitmq.consumer;

import org.sid.project_for_spring_rabbitmq.dtos.User;
import org.sid.project_for_spring_rabbitmq.publisher.RabbitMQjsonProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQJsonConsumer {
    private static final Logger LOGGER= LoggerFactory.getLogger(RabbitMQJsonConsumer.class);
    @RabbitListener(queues = {"${rabbitmq.queue.json.name}"})
    public void consumeJsonMessage(User user){
        LOGGER.info(String.format("received Json message -> %s",user.toString()));

    }
}
