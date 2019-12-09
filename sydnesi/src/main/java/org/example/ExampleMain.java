package org.example;

import org.example.domain.Citizen;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExampleMain {

    public static void main(String[] args) {
        SpringApplication.run(ExampleMain.class, args);

        //TODO ftiakse sto domain mia class giatroi , appointments

        Citizen citizen = new Citizen();
        //citizen -> anafora sto object pou dhmiourgithike
        //citizen.setAmka("");
        citizen.setFirstName("fwef");

        //controller pairnei thn pliroforia apo front. thn dinei sto service gia epeksergasia klp . to service sto repository gia apothikeusi sth vasi.

        System.out.println(citizen.getFirstName());
    }
}
