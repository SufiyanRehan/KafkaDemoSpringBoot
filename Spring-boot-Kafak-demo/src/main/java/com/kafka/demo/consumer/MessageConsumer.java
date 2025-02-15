package com.kafka.demo.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.kafka.demo.repository.MessageRepository;

@Component
public class MessageConsumer {

	private Logger  log= LoggerFactory.getLogger(MessageConsumer.class);
	
	
	@Autowired
	private MessageRepository messageRepository;
	
	@KafkaListener(topics= "${myapp.kafka.topic}",groupId="xyz")
	public void consume(String message) {
		log.info("Message Recived at Consumer***:"+message);
		messageRepository.addMessage(message);
		
	}
}
