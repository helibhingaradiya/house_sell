package com.House.House;

import com.House.House.Model.House;
import com.House.House.Repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HouseApplication  {

	public static void main(String[] args) {
		SpringApplication.run(HouseApplication.class, args);
	}

}
