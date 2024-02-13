package com.bridgelabz.user.configuartion;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {
	
//	@Bean
//	ConnectionFactoryInitializer initializer(ConnectionFactory connectionFactory) {
//		ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
//		initializer.setConnectionFactory(connectionFactory);
//		initializer.setDatabasePopulator(new ResourceDatabasePopulator(new ClassPathResource("schema.sql")));
//		return initializer;
//	}
	
	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper;
	}


}
