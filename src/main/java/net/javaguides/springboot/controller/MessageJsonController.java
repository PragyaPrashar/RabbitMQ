package net.javaguides.springboot.controller;

import net.javaguides.springboot.dto.User;
import net.javaguides.springboot.publisher.RabbitMQJsonProducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MessageJsonController {
  @Autowired
  private RabbitMQJsonProducer rabbitMQJsonProducer;

//  public MessageJsonController(RabbitMQJsonProducer rabbitMQJsonProducer) {
//    this.rabbitMQJsonProducer = rabbitMQJsonProducer;
//  }
  @PostMapping("/publish")
  public ResponseEntity<String> sendJsonMessage(@RequestBody User user){
    rabbitMQJsonProducer.sendJsonMessage(user);
    return ResponseEntity.ok("Json message sent to RabbitMQ...");
  }
}
