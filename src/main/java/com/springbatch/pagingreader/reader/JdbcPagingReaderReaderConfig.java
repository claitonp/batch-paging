package com.springbatch.pagingreader.reader;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.PagingQueryProvider;
import org.springframework.batch.item.database.builder.JdbcPagingItemReaderBuilder;
import org.springframework.batch.item.database.support.SqlPagingQueryProviderFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.RowMapper;

import com.springbatch.pagingreader.dominio.app.ClienteApp;

//@Configuration
public class JdbcPagingReaderReaderConfig {
	
	@Autowired
	@Qualifier("appDataSource") 
	DataSource dataSource;

	
//	@Bean
	public JdbcPagingItemReader<ClienteApp> reader(PagingQueryProvider queryProvider) {
		return new JdbcPagingItemReaderBuilder<ClienteApp>()
				.name("jdbcPagingReader")
				.dataSource(dataSource)
				.queryProvider(queryProvider)
				.pageSize(1)
//				.rowMapper(new BeanPropertyRowMapper<Cliente>(Cliente.class))
				.rowMapper(rowMapper())				
				.build();
	}
	
//	@Bean
	public SqlPagingQueryProviderFactoryBean queryProvider() {
		SqlPagingQueryProviderFactoryBean queryProvider = new SqlPagingQueryProviderFactoryBean();
		queryProvider.setDataSource(dataSource);
		queryProvider.setSelectClause("select *");
		queryProvider.setFromClause("from cliente");
//		queryProvider.setWhereClause(whereClause);
		queryProvider.setSortKey("email");
		return queryProvider;
	}		

	private RowMapper<ClienteApp> rowMapper() {
		
		return new RowMapper<ClienteApp>() {

			@Override
			public ClienteApp mapRow(ResultSet rs, int rowNum) throws SQLException {
		        ClienteApp cliente = clienteRowMapper(rs);	
//		        transacoesDoCliente(cliente);
				return cliente;
			}
			
			private ClienteApp clienteRowMapper(ResultSet rs) throws SQLException {
				ClienteApp cliente = new ClienteApp();
				cliente.setNome(rs.getString("nome"));
				cliente.setSobrenome(rs.getString("sobrenome"));
				cliente.setIdade(rs.getString("idade"));
				cliente.setEmail(rs.getString("email"));
				return cliente;
			}

//			private void transacoesDoCliente(Cliente cliente) throws SQLException {
//				Connection conn = dataSource2.getConnection();
//		        PreparedStatement ps = conn.prepareStatement("SELECT * FROM TRANSACAO WHERE EMAIL = ?");
//		        ps.setString(1, cliente.getEmail());  
//		        ResultSet rs2 = ps.executeQuery();
//				while(rs2.next()) {
//					Transacao transacao = new Transacao();
//					transacao.setId(rs2.getString("id"));
//					transacao.setNome(rs2.getString("nome"));
//					cliente.addTransacao(transacao);
//				}
//			}
			
		};
	}	
	
}
