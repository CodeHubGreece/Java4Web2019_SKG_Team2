package org.regeneration.efkajpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EfkaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EfkaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
	}
}
