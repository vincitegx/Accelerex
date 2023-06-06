package com.neptunesoftware.accelerex.transaction.config;

import com.github.javafaker.Faker;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeAll;
import org.slf4j.LoggerFactory;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.OracleContainer;
import org.testcontainers.containers.output.Slf4jLogConsumer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import javax.sql.DataSource;
import java.time.Duration;

@Testcontainers
public abstract class AbstractTestcontainers {
    @BeforeAll
    static void beforeAll() {
        Flyway flyway = Flyway
                .configure()
//                .defaultSchema("test")
                .dataSource(
                        oracleContainer.getJdbcUrl(),
                        oracleContainer.getUsername(),
                        oracleContainer.getPassword()
                ).load();
        flyway.migrate();
    }

    @Container
    protected static final OracleContainer oracleContainer
            = new OracleContainer("gvenzl/oracle-xe:21-slim-faststart")
            .withDatabaseName("test")
            .withUsername("test")
            .withPassword("test")
            .withStartupTimeout(Duration.ofSeconds(60))
            .withExposedPorts(1521)
            .withReuse(true)
            .withLogConsumer(new Slf4jLogConsumer(LoggerFactory.getLogger("Oracle")));;

    @DynamicPropertySource
    private static void registerDataSourceProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url",oracleContainer::getJdbcUrl);
        registry.add("spring.datasource.username",oracleContainer::getUsername);
        registry.add("spring.datasource.password",oracleContainer::getPassword);
    }

    private static DataSource getDataSource() {
        return DataSourceBuilder.create()
                .driverClassName(oracleContainer.getDriverClassName())
                .url(oracleContainer.getJdbcUrl())
                .username(oracleContainer.getUsername())
                .password(oracleContainer.getPassword())
                .build();
    }

    protected static final Faker FAKER = new Faker();
    public static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        @Override
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            TestPropertyValues.of(
                    "spring.datasource.url=" + oracleContainer.getJdbcUrl(),
                    "spring.datasource.username=" + oracleContainer.getUsername(),
                    "spring.datasource.password=" + oracleContainer.getPassword()
            ).applyTo(configurableApplicationContext.getEnvironment());
        }
    }
}