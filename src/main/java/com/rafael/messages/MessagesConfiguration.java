package com.rafael.messages;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagesConfiguration {

    public static Logger LOGGER = LoggerFactory.getLogger(MessagesConfiguration.class);
    
    @Bean
    public CommandLineRunner dataTester(MessageRepository messageRepository) {
        return (args)->{
            messageRepository.save(new Message(null,"hello"));

            List<Message> messages = messageRepository.findAll();

            for(Message m : messages) {
                LOGGER.info(m.getContent());
            }
        };
    }
}
