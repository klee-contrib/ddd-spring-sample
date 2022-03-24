package com.kleecontrib.socle.ddd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

//Auto configuration spring boot
@SpringBootApplication
// Permet d'utiliser des Aspects
@EnableAspectJAutoProxy
// Permet de gérer le lancement récurrent de traitements (<=> CRON quartz)
@EnableScheduling
@ComponentScan(basePackages = { "com.kleecontrib.socle.ddd" })
public class Application extends SpringBootServletInitializer {

	public static void main(final String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
