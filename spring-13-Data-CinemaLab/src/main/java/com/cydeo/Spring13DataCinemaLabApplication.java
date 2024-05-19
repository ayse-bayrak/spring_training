package com.cydeo;

//import org.flywaydb.core.Flyway;
//import org.flywaydb.core.api.output.MigrateResult;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.output.MigrateResult;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class Spring13DataCinemaLabApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring13DataCinemaLabApplication.class, args);
	}


	@Bean // we are working the Spring Core this should be bean
	public MigrateResult migrateResult(DataSource dataSource) {
		return Flyway.configure().baselineOnMigrate(true).dataSource(dataSource).load().migrate();
	}
}
