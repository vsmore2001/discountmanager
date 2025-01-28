package com.vasyerp.discountmanager;

import org.springframework.boot.SpringApplication;

public class TestDiscountmanagerApplication {

	public static void main(String[] args) {
		SpringApplication.from(DiscountmanagerApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
