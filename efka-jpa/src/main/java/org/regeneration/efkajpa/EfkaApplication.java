package org.regeneration.efkajpa;

import org.regeneration.efkajpa.repository.CitizenRepository;
import org.regeneration.efkajpa.repository.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EfkaApplication implements CommandLineRunner {

	private static Long amka;
	private static String lastName;
	private static String firstName;
	private static String phone;
	private static String email;
	private static String username;
	private static String password;

	private static final Logger logger = LoggerFactory.getLogger(EfkaApplication.class);

	@Autowired
	private CitizenRepository citizenRepository;

	@Autowired
	private UsersRepository usersRepository;

	public void createUser(){
		/*
		Users users = new Users("username", "1234", 'C');
		//citizen.add(new Citizen(amka, lastName, firstName, phone, email, username, password));
		usersRepository.save(users);
		Citizens citizens = new Citizens("52751", "Μακρόπουλους", "Ιωάννης", "964541", "makpet", users.getId());
		for(Users user : usersRepository.findAll()){
			logger.info(user.toString());
		}

		//citizen.add(new Citizen(amka, lastName, firstName, phone, email, username, password));
		citizenRepository.save(citizens);

		for(Citizens citizen : citizenRepository.findAll()){
			logger.info(citizen.toString());
		}*/
	}

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
		SpringApplication.run(EfkaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		//createUser();
	}
}
