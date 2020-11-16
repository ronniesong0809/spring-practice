package com.ronsong.accessingdatamongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccessingDataMongodbApplication implements CommandLineRunner {

    @Autowired
    private CustomerRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataMongodbApplication.class, args);
    }

    public void run(String... args) {
        repository.save(new Customer("Ronnie", "Song"));
        repository.save(new Customer("John", "Smith"));

        System.out.println("Customer found with findAll()\n-----------------------------");

        for (Customer customer: repository.findAll()) {
            System.out.println(customer);
        }

        System.out.println("Customer found with findByLastName()\n-----------------------------");

        for (Customer customer: repository.findByLastName("Song")) {
            System.out.println(customer);
        }
    }
}
