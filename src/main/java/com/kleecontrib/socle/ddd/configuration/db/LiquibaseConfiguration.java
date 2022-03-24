package com.kleecontrib.socle.ddd.configuration.db;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import liquibase.integration.spring.SpringLiquibase;

@Configuration
public class LiquibaseConfiguration {

	private static SpringLiquibase springLiquibase(DataSource dataSource, LiquibaseProperties properties) {
		final SpringLiquibase liquibase = new SpringLiquibase();
		liquibase.setDataSource(dataSource);
		liquibase.setChangeLog(properties.getChangeLog());
		liquibase.setContexts(properties.getContexts());
		liquibase.setDefaultSchema(properties.getDefaultSchema());
		liquibase.setDropFirst(properties.isDropFirst());
		liquibase.setShouldRun(properties.isEnabled());
		liquibase.setLabels(properties.getLabels());
		liquibase.setChangeLogParameters(properties.getParameters());
		liquibase.setRollbackFile(properties.getRollbackFile());
		return liquibase;
	}

	@Bean("liquibase")
	public SpringLiquibase liquibase(DataSource mainDataSource) {
		return springLiquibase(mainDataSource, liquibaseProperties());
	}

	@Bean
	public LiquibaseProperties liquibaseProperties() {
		return new LiquibaseProperties();
	}
}