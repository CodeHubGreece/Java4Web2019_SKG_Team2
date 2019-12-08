package org.regeneration.efkajpa;

import org.regeneration.efkajpa.entity.CitizenJpa;
import org.regeneration.efkajpa.entity.UsersJpa;
import org.regeneration.efkajpa.repository.CitizenJpaRepository;
import org.regeneration.efkajpa.repository.UsersJpaRepository;
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

	@Autowired
	private UsersJpaRepository usersJpaRepository;

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
		Integer userId = 0;
		List<UsersJpa> usersJpa = new ArrayList<>();
		usersJpa.add(new UsersJpa("username", "1234", 'C'));
		//citizenJpa.add(new CitizenJpa(amka, lastName, firstName, phone, email, username, password));
		usersJpaRepository.saveAll(usersJpa);
		for(UsersJpa user : usersJpaRepository.findAll()){
			logger.info(user.toString());
			userId = user.getId();
		}

		List<CitizenJpa> citizenJpa = new ArrayList<>();
		citizenJpa.add(new CitizenJpa(Long.valueOf("52751"), "Μακρόπουλους", "Ιωάννης", "964541", "makpet", userId));
		//citizenJpa.add(new CitizenJpa(amka, lastName, firstName, phone, email, username, password));
		citizenJpaRepository.saveAll(citizenJpa);

		for(CitizenJpa citizen : citizenJpaRepository.findAll()){
			logger.info(citizen.toString());
		}
	}
}
