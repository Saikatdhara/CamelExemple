package com.example.mock;

import com.github.tomakehurst.wiremock.common.ClasspathFileSource;
import com.github.tomakehurst.wiremock.core.Options;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.cloud.contract.wiremock.WireMockSpring;
import org.springframework.context.annotation.Bean;

import java.net.URL;

import static java.lang.Thread.currentThread;

@SpringBootApplication
@AutoConfigureWireMock
public class MockApplication {

	public static void main(String[] args) {
		SpringApplication.run(MockApplication.class, args);
	}
	@Bean
	public Options wiremockOptions() {
		URL stubsURL = currentThread().getContextClassLoader().getResource("wiremock");
		assert stubsURL != null;
		String stubsPath = stubsURL.toString().contains("BOOT-INF/classes") ? "BOOT-INF/classes/wiremock" : "wiremock";

		final WireMockConfiguration options = WireMockSpring.options();
		options.port(9092);
		options.fileSource(new ClasspathFileSource(stubsPath));
		return options;
	}

}
