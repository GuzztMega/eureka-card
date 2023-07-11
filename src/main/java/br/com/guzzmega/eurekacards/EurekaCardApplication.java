package br.com.guzzmega.eurekacards;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EurekaCardApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaCardApplication.class, args);
	}

}
