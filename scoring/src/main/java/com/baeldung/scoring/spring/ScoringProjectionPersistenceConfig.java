package com.baeldung.scoring.spring;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(basePackages = "com.baeldung.scoring.persistence.repo", entityManagerFactoryRef = "scoringEntityManager", transactionManagerRef = "scoringTransactionManager")
// @EntityScan({ "com.baeldung.scoring.persistence.model" })
public class ScoringProjectionPersistenceConfig {

    @Autowired
    private Environment env;

    public ScoringProjectionPersistenceConfig() {
        super();
    }

    //

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "scoring.datasource")
    public DataSource scoringDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean scoringEntityManager() {
        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(scoringDataSource());
        em.setPackagesToScan(new String[] { "com.baeldung.scoring.persistence.model" });

        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        final HashMap<String, Object> properties = new HashMap<String, Object>();
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("spring.jpa.hibernate.ddl-auto"));
        properties.put("hibernate.dialect", env.getProperty("spring.jpa.properties.hibernate.dialect"));
        em.setJpaPropertyMap(properties);

        return em;
    }

    @Bean
    @Primary
    public PlatformTransactionManager scoringTransactionManager() {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(scoringEntityManager().getObject());
        return transactionManager;
    }

}
