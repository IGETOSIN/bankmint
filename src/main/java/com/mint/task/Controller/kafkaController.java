package com.mint.task.Controller;

import com.mint.task.Model.kafta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class kafkaController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/message")
    public void sendMessage(@RequestBody kafta kfta) {
        kafkaTemplate.send("Kafka Message", kfta.toString());
    }

    @GetMapping("/listen")
    public void listen(String message) {
        System.out.println("Received Message in group-id: " + message);
    }

}
