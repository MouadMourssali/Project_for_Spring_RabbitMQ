package org.sid.project_for_spring_rabbitmq.publisher;

import org.sid.project_for_spring_rabbitmq.dtos.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQjsonProducer {
    @Value("${rabbitmq.exchange.name}")
    private  String exchange;
    @Value("${rabbitmq.routing.json.name}")
    private String json_routingKey;
    private static final Logger LOGGER= LoggerFactory.getLogger(RabbitMQjsonProducer.class);
    private RabbitTemplate rabbitTemplate;

    public RabbitMQjsonProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
   public void sendJsonMessage(User user){
        LOGGER.info(String.format("Json Message sent -> %s",user.toString()));
        rabbitTemplate.convertAndSend(exchange,json_routingKey,user);

   }
}
