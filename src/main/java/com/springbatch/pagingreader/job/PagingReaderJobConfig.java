package com.springbatch.pagingreader.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.pagingreader.listener.ClienteJobListener;

@EnableBatchProcessing
@Configuration
public class PagingReaderJobConfig {
	
	@Autowired
	private JobBuilderFactory factory;

	@Autowired
	private ClienteJobListener listener;
	
	@Bean
	public Job job(Step step) {
		return factory
				.get("pagingReaderJob")
				.start(step)
				.incrementer(new RunIdIncrementer())
				.listener(listener)
				.build();
	}
}
