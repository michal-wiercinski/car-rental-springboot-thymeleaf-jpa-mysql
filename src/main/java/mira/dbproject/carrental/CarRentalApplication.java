package mira.dbproject.carrental;

import javax.annotation.PostConstruct;
import mira.dbproject.carrental.repository.dao.BrandDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarRentalApplication {


	public static void main(String[] args) {
		SpringApplication.run(CarRentalApplication.class, args);
	}

}
