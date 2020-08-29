package com.blog;

import com.blog.entities.Tag;
import com.blog.entities.TopicEnum;
import com.blog.repositories.TagRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class LearningPathApplication {



    public static void main(String[] args) {
        SpringApplication.run(LearningPathApplication.class, args);
    }

//    @Autowired TagRepo tagRepo;
//
//    @Bean
//    public ApplicationRunner initTopics(){
//        return (args) -> {
//
//            Stream.of(TopicEnum.values()).forEach(topic -> {
//                tagRepo.save(new Tag(topic.name().toLowerCase().replace('_', ' ')));
//            });
//
//        };
//    }

}
