package org.regeneration.efkajpa;

import org.regeneration.efkajpa.entity.CitizenJpa;
import org.regeneration.efkajpa.repository.CitizenJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class EfkaJpaApplication implements CommandLineRunner {

	private static Long amka;
	private static String lastName;
	private static String firstName;
	private static String phone;
	private static String email;
	private static String username;
	private static String password;

	private static final Logger logger = LoggerFactory.getLogger(EfkaJpaApplication.class);

	@Autowired
	private CitizenJpaRepository citizenJpaRepository;

	public static void main(String[] args) {
		/*Scanner in = new Scanner(System.in);
		System.out.println("Give ΑΜΚΑ");
		amka = in.nextLine();
		System.out.println("Give surname");
		lastName = in.nextLine();
		System.out.println("Give name");
		firstName = in.nextLine();
		System.out.println("Give phone");
		phone = in.nextLine();
		System.out.println("Give email");
		email = in.nextLine();
		System.out.println("Give username");
		username = in.nextLine();
		System.out.println("Give password");
		password = in.nextLine();*/
		SpringApplication.run(EfkaJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		List<CitizenJpa> citizenJpa = new ArrayList<>();
		citizenJpa.add(new CitizenJpa(Long.valueOf("52751"), "Μακρόπουλους", "Ιωάννης", "964541", "makpet", "makpet123", "fdgfdgg"));
		//citizenJpa.add(new CitizenJpa(amka, lastName, firstName, phone, email, username, password));
		citizenJpaRepository.saveAll(citizenJpa);

		for(CitizenJpa citizen : citizenJpaRepository.findAll()){
			logger.info(citizen.toString());
		}
	}
}
