package com.kdu.spring2;

import com.kdu.spring2.ipl.Player;
import com.kdu.spring2.ipl.Team;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class AppConfiguration {
		@Bean
		public Player player() {
		 return new Player();
		}
		@Bean
		public Team team() {
			return new Team(player());
		}
}
