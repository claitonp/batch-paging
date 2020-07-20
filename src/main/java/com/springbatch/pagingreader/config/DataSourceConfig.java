package com.springbatch.pagingreader.config;

import javax.sql.DataSource;

import org.springframework.batch.core.configuration.annotation.BatchConfigurer;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DataSourceConfig {
	
	@Primary
	@Bean(name="batchDataSource")
	@ConfigurationProperties(prefix = "batch.datasource")
	public DataSource springDataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean
	BatchConfigurer configurer(@Qualifier("batchDataSource") DataSource dataSource){
	    return new DefaultBatchConfigurer(dataSource);
	}
	
	
	@Bean(name="appDataSource")
	@ConfigurationProperties(prefix = "app.datasource")
	public DataSource appDataSource() {
		return DataSourceBuilder.create().build();
	}

	
	@Bean(name="app2DataSource")
	@ConfigurationProperties(prefix = "app2.datasource")
	public DataSource app2DataSource() {
		return DataSourceBuilder.create().build();
	}
}
