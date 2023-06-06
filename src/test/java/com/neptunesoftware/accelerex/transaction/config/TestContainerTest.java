package com.neptunesoftware.accelerex.transaction.config;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestContainerTest extends AbstractTestcontainers{
    @Test
    void canStartPostgresDB() {
        assertThat(oracleContainer.isRunning()).isTrue();
        assertThat(oracleContainer.isCreated()).isTrue();
    }

}
