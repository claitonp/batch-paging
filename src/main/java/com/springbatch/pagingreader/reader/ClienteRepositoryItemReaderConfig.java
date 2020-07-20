package com.springbatch.pagingreader.reader;

import java.util.Map;

import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.batch.item.data.builder.RepositoryItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort.Direction;

import com.springbatch.pagingreader.dominio.app.ClienteApp;
import com.springbatch.pagingreader.repository.app.ClienteRepository;

@Configuration
public class ClienteRepositoryItemReaderConfig {
	
	@Bean(name="clienteRepositoryItemReader")
	public RepositoryItemReader<ClienteApp> clienteRepositoryItemReader(ClienteRepository clienteRepository) {
		return new RepositoryItemReaderBuilder<ClienteApp>()
				.name("clienteRepositoryItemReader")
				.repository(clienteRepository)
				.methodName("findAll")
				.pageSize(2)
				.sorts(Map.of("email", Direction.ASC))	
				.build();
	}

}
