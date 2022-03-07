package com.kdu.spring2;

import com.kdu.spring2.ipl.Player;
import com.kdu.spring2.ipl.Team;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.LocalDate;
import java.util.Set;


public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        Player player = context.getBean(Player.class);
        player.setName("");
        player.setDateOfBirth(LocalDate.now());
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Player>> violations = validator.validate(player);
        for (ConstraintViolation<Player> violation : violations) {
            System.out.println(violation.getMessage());
        }

        System.out.println(player);

        Team team = context.getBean(Team.class);
        //team.setTeamName("RCB");
//        team.setPlayer(player);
//        System.out.println(team);
    }
}
