package com.example.luv2code.config;

import com.example.luv2code.coach.Coach;
import com.example.luv2code.coach.SwimCoach;
import com.example.luv2code.fortuneService.FortuneService;
import com.example.luv2code.fortuneService.HappyFortuneService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan("com.example.luv2code")
@PropertySource("classpath:sport.properties")
public class SportConfig {
	
	// add support to resolve ${...} properties
	//
	// NOTE: THIS IS ONLY REQUIRED FOR OLD VERSIONS OF SPRING: v4.2 and lower
	//
	// This is NOT required if using Spring v4.3+
	//
	@Bean
	public static PropertySourcesPlaceholderConfigurer
					propertySourcesPlaceHolderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	// define bean for our sad fortune service
	@Bean
	public FortuneService happyFortuneService() {
		return new HappyFortuneService();
	}
	
	// define bean for our swim coach AND inject dependency
	@Bean
	public Coach swimCoach() {
		SwimCoach mySwimCoach = new SwimCoach(happyFortuneService());
		
		return mySwimCoach;
	}
	
}








