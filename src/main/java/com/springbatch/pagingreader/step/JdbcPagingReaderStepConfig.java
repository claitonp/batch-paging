package com.springbatch.pagingreader.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.pagingreader.dominio.Cliente;
import com.springbatch.pagingreader.dominio.app.ClienteApp;
import com.springbatch.pagingreader.listener.ClienteChunkListener;
import com.springbatch.pagingreader.listener.ClienteWriteListener;
import com.springbatch.pagingreader.listener.ClienteProcessListener;
import com.springbatch.pagingreader.listener.ClienteReadListener;
import com.springbatch.pagingreader.listener.ClienteSkipListener;
import com.springbatch.pagingreader.listener.ClienteStepListener;

@Configuration
public class JdbcPagingReaderStepConfig {
	
	@Autowired
	private StepBuilderFactory factory;
	
	@Bean
	public Step step(@Qualifier("clienteRepositoryItemReader") ItemReader<ClienteApp> reader, 
			         ItemWriter<Cliente> writer, 
			         ItemProcessor<ClienteApp, Cliente> processor) {
		return factory
				.get("jdbcPagingReaderStep")
				.<ClienteApp, Cliente>chunk(2)
				.reader(reader)
				.writer(writer)
				.processor(processor)
				.listener(new ClienteChunkListener())
				.listener(new ClienteStepListener())
				.listener(new ClienteReadListener())
				.listener(new ClienteWriteListener())
				.listener(new ClienteProcessListener())
				.listener(new ClienteSkipListener())
				.build();
	}
	
//	@Bean
//	public ClienteChunkListener chunkListener() {
//	    return new ClienteChunkListener();
//	}
//
//	
//	@Bean
//	public ClienteStepListener stepListener() {
//	    return new ClienteStepListener();
//	}
//	
}
