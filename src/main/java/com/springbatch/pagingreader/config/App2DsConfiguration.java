package com.springbatch.pagingreader.config;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = "app2EntityManagerFactory",
        transactionManagerRef = "app2TransactionManager",
        basePackages = "com.springbatch.pagingreader.repository.app2"
)
@EnableTransactionManagement
public class App2DsConfiguration {

	@Primary
    @Bean(name = "app2EntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean app2EntityManagerFactory(final EntityManagerFactoryBuilder builder,
                                                                            final @Qualifier("app2DataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("com.springbatch.pagingreader.dominio.app2")
                .persistenceUnit("app2DataSource")
                .build();
    }

	@Primary
    @Bean(name = "app2TransactionManager")
    public PlatformTransactionManager app2TransactionManager(@Qualifier("app2EntityManagerFactory") EntityManagerFactory app2EntityManagerFactory) {
        return new JpaTransactionManager(app2EntityManagerFactory);
    }
}