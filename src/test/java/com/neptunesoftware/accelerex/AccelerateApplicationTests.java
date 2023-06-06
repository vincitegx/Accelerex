package com.neptunesoftware.accelerex;

import com.neptunesoftware.accelerex.transaction.config.AbstractTestcontainers;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AccelerateApplicationTests extends AbstractTestcontainers {
	@Test
	void contextLoads() {
		assertThat(oracleContainer.isRunning()).isTrue();
		assertThat(oracleContainer.isCreated()).isTrue();
	}

}
