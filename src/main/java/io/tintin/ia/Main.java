package io.tintin.ia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
	public static void main(String[] args) {
		System.out.println("starting agent...");

		SpringApplication.run(Main.class, args);
	}
}