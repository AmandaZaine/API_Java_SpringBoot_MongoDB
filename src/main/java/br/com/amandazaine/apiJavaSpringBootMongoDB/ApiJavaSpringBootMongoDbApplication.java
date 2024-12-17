package br.com.amandazaine.apiJavaSpringBootMongoDB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ApiJavaSpringBootMongoDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiJavaSpringBootMongoDbApplication.class, args);
	}

}
