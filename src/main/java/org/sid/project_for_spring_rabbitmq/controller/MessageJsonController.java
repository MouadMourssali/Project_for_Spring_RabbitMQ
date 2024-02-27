package org.sid.project_for_spring_rabbitmq.controller;

import org.sid.project_for_spring_rabbitmq.dtos.User;
import org.sid.project_for_spring_rabbitmq.publisher.RabbitMQjsonProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class MessageJsonController {
    private RabbitMQjsonProducer rabbitMQjsonProducer;

    public MessageJsonController(RabbitMQjsonProducer rabbitMQjsonProducer) {
        this.rabbitMQjsonProducer = rabbitMQjsonProducer;
    }
    @PostMapping("/publish")
    public ResponseEntity<String>sendJsonmessage(@RequestBody User user){
        rabbitMQjsonProducer.sendJsonMessage(user);
        return ResponseEntity.ok("Json message sent to RabbitMq . . .");
    }
}
