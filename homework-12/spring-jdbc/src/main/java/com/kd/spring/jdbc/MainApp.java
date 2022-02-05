package com.kd.spring.jdbc;

import com.kd.spring.jdbc.service.ActorService;
import com.kd.spring.jdbc.service.FilmService;
import com.kd.spring.jdbc.utils.ObjectUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ActorService actorService = context.getBean(ActorService.class);

        System.out.println("\n =============================================== \n");
        System.out.println(ObjectUtils.convertToJson(actorService.getActorById(10L)));
        System.out.println("\n =============================================== \n");
        System.out.println(ObjectUtils.convertToJson(actorService.getActorByFirstName("%leo%")));
        System.out.println("\n =============================================== \n");
        System.out.println(ObjectUtils.convertToJson(actorService.getActorByLastName("%lo%")));
        System.out.println("\n =============================================== \n");
        System.out.println(ObjectUtils.convertToJson(actorService.getFilmByActorName("%aco%")));

    }
}
