package com.ziroom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * SpringBoot 启动程序
 *
 * @author Administratormvn
 * java -jar xx.jar --spring.profiles.active=dev
 */

@SpringBootApplication(exclude = {MongoAutoConfiguration.class})
@EnableTransactionManagement
public class GuantApplication {
	public static void main(String[] args) {
		SpringApplication.run(GuantApplication.class, args);
	}

}



