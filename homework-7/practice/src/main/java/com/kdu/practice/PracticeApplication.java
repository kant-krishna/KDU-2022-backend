package com.kdu.practice;

import com.kdu.practice.ipl.Player;
import com.kdu.practice.ipl.Team;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class PracticeApplication{

	public static void main(String[] args) {
		//SpringApplication.run(PracticeApplication.class, args);


		//for the path, it will directly pick from the resources.
		ConfigurableApplicationContext context = new
				ClassPathXmlApplicationContext( "ipl.xml" );

		Player player = (Player) context.getBean("player");
		Team team = (Team) context.getBean("team");

		player.setName("Sachin");

		System.out.println(player);
		//Team team = ctx.getBean(Team.class);
		
		
		context.close();

		ApplicationContext context1 = new ClassPathXmlApplicationContext("ipl.xml");
		Team team1 = (Team) context1.getBean("team");

		System.out.println(team1);
		System.out.println(context1.getApplicationName());
		System.out.println(context1.getParent()); //null since there is no parent
		System.out.println(context1.getStartupDate());
	}


}
