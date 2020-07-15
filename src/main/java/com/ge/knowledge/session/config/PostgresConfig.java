package com.ge.knowledge.session.config;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import com.opentable.db.postgres.embedded.EmbeddedPostgres;

@Configuration
public class PostgresConfig {

    public PostgresConfig() {
    }

    @Configuration
    @Profile("local")
    @EnableJpaRepositories(entityManagerFactoryRef = "postgresEntityManagerFactory", basePackages = "com.ge.knowledge.session.ras.postgres")
    static class PostgresLocalConfig {

        @Bean
        @Primary
        LocalContainerEntityManagerFactoryBean postgresEntityManagerFactory(EntityManagerFactoryBuilder builder)
                throws IOException {
            return builder.dataSource(postgresDataSource()).packages("com.ge.knowledge.session.domain")
                    .persistenceUnit("postgres").build();
        }

       /* @Bean
        @Primary
        @ConfigurationProperties(prefix = "datasource.postgres")
        DataSource postgresDataSource() throws IOException {
            EmbeddedPostgres pg = EmbeddedPostgres.builder().setPort(58586).start();
            return pg.getPostgresDatabase();
        }*/

        @Bean
        @Primary
        @ConfigurationProperties(prefix = "spring.datasource")
        DataSource postgresDataSource() throws IOException {
            return DataSourceBuilder.create().build();
        }
    }
    
    @Configuration
    @Profile("docker")
    @EnableJpaRepositories(entityManagerFactoryRef = "postgresEntityManagerFactory", basePackages = "com.ge.knowledge.session.ras.postgres")
    static class DockerPostgresConfig {

        @Bean
        @Primary
        LocalContainerEntityManagerFactoryBean postgresEntityManagerFactory(EntityManagerFactoryBuilder builder)
                throws IOException {

            Map<String, String> properties = new HashMap<>();
            return builder.dataSource(postgresDataSource()).packages("com.ge.knowledge.session.domain")
                    .persistenceUnit("postgres").properties(properties).build();
        }

        @Bean
        @Primary
        @ConfigurationProperties(prefix = "spring.datasource")
        DataSource postgresDataSource() throws IOException {
            return DataSourceBuilder.create().build();
        }
      
    }

    @Configuration
    @Profile("aws")
    @EnableJpaRepositories(entityManagerFactoryRef = "postgresEntityManagerFactory", basePackages = "com.ge.knowledge.session.ras.postgres")
    static class ServerPostgresConfig {

        @Bean
        @Primary
        LocalContainerEntityManagerFactoryBean postgresEntityManagerFactory(EntityManagerFactoryBuilder builder)
                throws IOException {

            Map<String, String> properties = new HashMap<>();
            return builder.dataSource(postgresDataSource()).packages("com.ge.knowledge.session.domain")
                    .persistenceUnit("postgres").properties(properties).build();
        }

        @Bean
        @Primary
        @ConfigurationProperties(prefix = "spring.datasource")
        DataSource postgresDataSource() throws IOException {
            return DataSourceBuilder.create().build();
        }
        
    }

}
