package com.example.mock;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
class MockApplicationTests {

	public static void main(String[] args) {
		SpringApplication.run(MockApplicationTests.class, args);
	}

}
