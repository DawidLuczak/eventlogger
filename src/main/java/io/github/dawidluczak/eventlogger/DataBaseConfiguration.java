package io.github.dawidluczak.eventlogger;

import org.h2.tools.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

@Configuration
public class DataBaseConfiguration {
	
	@Bean
	public Server h2Server() throws SQLException {
		return Server.createTcpServer("-tcp");
	}
}
