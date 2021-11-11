package com.example.demo;

import com.example.demo.model.entity.Principal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;




@SpringBootApplication
public class DemoApplication {

	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);




	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);

		Principal[] vectorPrincipal = new Principal[5];


		for (int i = 0; i< vectorPrincipal.length; i++) {
			vectorPrincipal[i] = new Principal(i+1);
			vectorPrincipal[i].start();
		}

		try {
			for (int i = 0; i< vectorPrincipal.length; i++) {
				vectorPrincipal[i].join();
			}
		}catch (Exception e) {

		}

		log.info("Thread principal");


	}

}

