package com.epam.demo.spring.dbaccess;

import com.epam.demo.spring.dbaccess.config.SpringDataConfig;
import com.epam.demo.spring.dbaccess.entities.Session;
import com.epam.demo.spring.dbaccess.entities.User;
import com.epam.demo.spring.dbaccess.repo.SessionRepo;
import com.epam.demo.spring.dbaccess.repo.UserRepo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.Arrays;

public class SpringDataJpaDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringDataConfig.class);

        UserRepo userRepo = context.getBean(UserRepo.class);
        SessionRepo sessionRepo = context.getBean(SessionRepo.class);

        Arrays.stream("Jin Suga J-Hope RM Jimin V Jungkook".split(" "))
                .map(name -> new User(name, name.toLowerCase()))
                .forEach(userRepo::save);

        userRepo.findAll().forEach(System.out::println);
        System.out.println("-----------");

        sessionRepo.save(new Session(LocalDateTime.now(), userRepo.findByUserName("Suga")));
        sessionRepo.save(new Session(LocalDateTime.now().minusDays(1), userRepo.findByUserName("Jin")));
        sessionRepo.save(new Session(LocalDateTime.now().minusHours(1), userRepo.findByUserName("Jungkook")));

        userRepo.findAll(Sort.by("userName")).forEach(System.out::println);
        System.out.println("-----------");

        userRepo.findAll(PageRequest.of(1, 3, Sort.by(Sort.Order.asc("userName"))))
                .forEach(System.out::println);
        System.out.println("-----------");


    }

}