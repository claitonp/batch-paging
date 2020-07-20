package com.springbatch.pagingreader.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.pagingreader.dominio.Cliente;

@Configuration
public class JdbcPagingReaderWriterConfig {
	@Bean
	public ItemWriter<Cliente> writer() {
		return clientes -> clientes.forEach(System.out::println);
	}
}
