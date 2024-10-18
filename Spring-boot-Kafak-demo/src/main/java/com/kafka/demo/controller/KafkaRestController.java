package com.kafka.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.demo.producer.MessageProducer;
import com.kafka.demo.repository.MessageRepository;

@RestController
public class KafkaRestController {

	@Autowired
	private MessageProducer producer;
	
	
	@Autowired
	private MessageRepository repository;
	
	
	@GetMapping("/send")
	public String sendMsg(@RequestParam ("msg") String message)  {
		producer.sendMessage(message);
        return "" +"+message +" + " sent successfully!";
	}
	
	
	@GetMapping("/getAll")
	public String getAllMessage() {
		return repository.getAllMessage();
	}
	
}
